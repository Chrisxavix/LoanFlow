package pom.utilities;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import steps.hook.Hook;
import pom.pages.global.Global;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Utilities {
    /* Obtener el driver */
    protected WebDriver driver = Hook.getDriver();
    /* Instancia para controlar la barra de status */
    protected Global global = new Global();
    /* Darle numeración a las capturas */
    private int step = 1;
    /* Darle numeración a los escenarios de pruebas */
    private static int countScenario = 0;
    /* Control de pestañas en el navegador */
    private String mainOfWindow;
    private String secondOfWindow;
    /* Navegador Incógnito */
    public WebDriver driverIncognito;
    public ChromeOptions options = new ChromeOptions();

    /* Espera Fluida, cada 200 milisegundos va a obtener el estatus para determinar si continúa
       o sigue en espera, por ello se multiplica por 5.
       Tiene un contador para establecer el tiempo límite de espera antes de dar por terminado el
       proceso con un resultado de Error, Time out*/
    public void waitPass(int time, String nameBox, WebDriver typeDriver) throws Throwable {
        int timeFinal = time * 5;
        String status = typeDriver.findElement(global.getTxtStatus()).getText();
        System.out.println("STATUS: " + status + "  NAME: " + nameBox);
        int cont = 1;
        while ((status.equalsIgnoreCase("PROCESANDO...")
                || status.equalsIgnoreCase("POR FAVOR ESPERE A QUE EL PROCESO ACTUAL TERMINE.")
                || status.equalsIgnoreCase("CARGANDO FORMULARIO...")
                || status.equalsIgnoreCase("CANNOT READ PROPERTIES OF UNDEFINED (READING 'ITEMS')"))
                && cont < timeFinal) {
            cont++;
            Thread.sleep(200);
            status = typeDriver.findElement(global.getTxtStatus()).getText();
        }
        System.out.println("FINAL STATUS: " + status);
        System.out.println(".........................................");
        System.out.println("");
    }

    /* Jugar con las pestañas del navegador entre principal y secundarias */
    public void switchPages(int timeWindow, String print) throws Throwable {
        /* Todas las ventanas abiertas en prueba */
        Set<String> windows = driver.getWindowHandles();
        /* Ventana principal */
        String mainWindow = driver.getWindowHandle();
        mainOfWindow = driver.getWindowHandle();
        for (String handle : windows) {
            driver.switchTo().window(handle);
            String pageTitle = driver.getTitle();
            if (handle != mainWindow) {
                secondOfWindow = handle;
            }
            if (pageTitle.equalsIgnoreCase("Error")) {
                Thread.sleep(3000);
                driver.close();
                driver.switchTo().window(mainOfWindow);
            } else if (pageTitle.equalsIgnoreCase("")) {
                if (print.equalsIgnoreCase("yes")) {
                    Thread.sleep(timeWindow);
                    this.downloadPDF();
                    driver.close();
                }
                driver.switchTo().window(mainOfWindow);
            } else {
                driver.switchTo().window(mainOfWindow);
            }
        }
    }

    /* Capturas de pantalla */
    public void screenshot(int screenshot, String transaction, WebDriver typeDriver) throws IOException {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        String time = dateFormat.format(now);
        File scrFile = ((TakesScreenshot) typeDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./src/test/assets/screenshots/loanflow/scenario" + screenshot + "/" + transaction + "/" + "step" + step++ + "-" + time + ".png"));
    }

    /* Excel */
    public List<String> readExcel() throws IOException {
        /* Datos del Excel */
        String fileName = "ReadData.xlsx";
        String sheetName = "Hoja1";
        List<String> dataExcel = new ArrayList<>();
        File file = new File("./src/test/assets/exceldocuments/ReadData.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        Workbook testCasesDocument = null;
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        /* Creación de objetos para el de tipos de extensiones de Excel*/
        if (fileExtensionName.equals(".xlsx")) {
            testCasesDocument = new XSSFWorkbook(inputStream);
        } else if (fileExtensionName.equals(".xls")) {
            testCasesDocument = new HSSFWorkbook(inputStream);
        } else {
            System.out.println("Agregue la nueva extensión de Excel");
        }
        Sheet sheetDocument = testCasesDocument.getSheet(sheetName);
        /* Obtener el número de columnas del Excel */
        int cellLength = sheetDocument.getRow(0).getPhysicalNumberOfCells();
        /* countScenario: Fila del Excel
           Cuando se invoca al método se interpreta que se quiere leer la siguiente fila, por lo que se incrementa */
        countScenario++;
        System.out.println("Fila del Excel: " + countScenario);
        DataFormatter formatter = new DataFormatter();
        dataExcel.clear();
        /* Lleno la lista con datos del Excel */
        for (int i = 0; i < cellLength; i++) {
            dataExcel.add(formatter.formatCellValue(sheetDocument.getRow(countScenario).getCell(i)));
        }
        /* Visualiza en la consola los datos cargados en el Excel */
        for (int j = 0; j < dataExcel.size(); j++) {
            System.out.println("DataExcel, celda " + j + ": " + dataExcel.get(j));
        }
        return dataExcel;
    }

    /* Cambia a la pestaña secundaria, llama al método de descargar el pdf, cierra la pestaña y regresa a la ventana principal */
    public void switchPDF() throws AWTException {
        driver.switchTo().window(secondOfWindow);
        this.downloadPDF();
        driver.close();
        driver.switchTo().window(mainOfWindow);
    }

    /* Abre la ventana del sistema para guardar el pdf */
    public void downloadPDF() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        robot.setAutoDelay(200);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_S);
        robot.setAutoDelay(200);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.setAutoDelay(200);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.setAutoDelay(200);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.setAutoDelay(500);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    /* La barra de estatus en ocasiones realiza varias validaciones */
    public void multipleValidate(WebDriver typeDriver) throws Throwable {
        Thread.sleep(200);
        int timeSave = 60;
        this.waitPass(timeSave, "validate 1", typeDriver);
        Thread.sleep(200);
        this.waitPass(timeSave, "validate 2", typeDriver);
        Thread.sleep(200);
        this.waitPass(timeSave, "validate 3", typeDriver);
        Thread.sleep(200);
        this.waitPass(timeSave, "validate 4", typeDriver);
    }

    /* Tiempos de Espera */
    /* Abrir modales */
    public void openModal() throws InterruptedException {
        Thread.sleep(400);
    }

    /* Reacción de la página al cambiar de pestaña */
    public void reactPage() throws InterruptedException {
        Thread.sleep(2200);
    }

    public void reactPageOp2() throws InterruptedException {
        Thread.sleep(1000);
    }

    /* Reacción de la página para el ingreso de datos */
    public void reactTypeData() throws InterruptedException {
        Thread.sleep(3000);
    }

    public void reactTypeDataOp2() throws InterruptedException {
        Thread.sleep(3500);
    }
}
