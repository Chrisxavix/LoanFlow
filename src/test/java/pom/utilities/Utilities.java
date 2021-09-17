package pom.utilities;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
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
    protected WebDriver driver = Hook.getDriver();
    protected Global global = new Global();
    private int step = 1;
    private static int countScenario = 0;
    private String mainOfWindow;
    private String secondOfWindow;

    /* Espera Fluida */
    public void waitPass(int time, String nameBox) throws Throwable {
        int timeFinal = time * 5;
        String status = driver.findElement(global.getTxtStatus()).getText();
        System.out.println("STATUS: " + status + "  NAME: " + nameBox);
        int cont = 1;
        System.out.println("timeFinal" + timeFinal);
        while ((status.equalsIgnoreCase("PROCESANDO...")
                || status.equalsIgnoreCase("POR FAVOR ESPERE A QUE EL PROCESO ACTUAL TERMINE.")
                || status.equalsIgnoreCase("CARGANDO FORMULARIO..."))
                && cont < timeFinal) {
            cont++;
            Thread.sleep(200);
            status = driver.findElement(global.getTxtStatus()).getText();
            /*System.out.println("STATUS DEL WHILE: " + status);
            System.out.println("ENTRA AL WHILE: " + cont);*/
        }
        System.out.println("FINAL STATUS: " + status);
        System.out.println(".........................................");
        System.out.println("");
    }

    /* Jugar con las pestañas del navegador */
    public void switchPages(int timeWindow) throws Throwable {
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
                /* Se cierra con el botón de la página de error */
                Thread.sleep(3000);
                driver.switchTo().window(mainWindow);
            } else if (pageTitle.equalsIgnoreCase("")) {
                Thread.sleep(timeWindow);
                driver.switchTo().window(mainWindow);
            } else {
                driver.switchTo().window(mainWindow);
            }
        }
    }

    /* Capturas de pantalla */
    public void screenshot(int screenshot, String transaction) throws IOException {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        String time = dateFormat.format(now);
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./src/test/assets/screenshots/loanflow/scenario" + screenshot + "/" + transaction + "/" + "step" + step++ + "-" + time + ".png"));
    }

    /* Excel */
    public List<String> readExcel() throws IOException {
        /* Datos del Excel */
        String fileName = "testRead.xlsx";
        String sheetName = "Hoja1";
        List<String> dataExcel = new ArrayList<>();
        //File file = new File("./src/test/assets/exceldocuments/testRead.xlsx");
        File file = new File("./src/test/assets/exceldocuments/test062100.xlsx");
        /*File file = new File("./src/test/assets/exceldocuments/testReadTwo.xlsx");*/
        /*File file = new File("./src/test/assets/exceldocuments/testReadFourErrors.xlsx");*/
        /*File file = new File("./src/test/assets/exceldocuments/testReadEightErrors.xlsx");*/
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

    /* Reacción de la página al cambiar de pestaña */
    public void reactPage() throws InterruptedException {
        Thread.sleep(2200);
    }

    /* Reacción al iniciar una transacción */
    public void reactStartTransaction() throws InterruptedException {
        Thread.sleep(2000);
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
    }

    public void timeSaveForm() throws Throwable {
        Thread.sleep(500);
    }
}
