package steps.pom.pages.transactions;

import org.openqa.selenium.By;

public class Tr062000 {

    /* VARIABLES */

    /* DEUDOR-CODEUDOR Y GARANTES: Dcg */
    private final By txtDcgF1Identification = By.xpath("//*[@id='container_5']/div/table/tbody/tr[1]/td[3]/input");
    private final By txtDcgF2Identification = By.xpath("//*[@id='container_5']/div/table/tbody/tr[2]/td[3]/input");
    private final By txtDcgF3Identification = By.xpath("//*[@id='container_5']/div/table/tbody/tr[3]/td[3]/input");
    /* DESTINO GEOGRÁFICO FONDOS: Dgf */
    private final By txtDgfCountry = By.xpath("//*[@id='container_12']/table/tbody/tr/td[1]/input[1]");
    private final By txtDgfState = By.xpath("//*[@id='container_12']/table/tbody/tr/td[4]/input[1]");
    private final By txtDgfCanton = By.xpath("//*[@id='container_12']/table/tbody/tr/td[7]/input[1]");
    private final By txtDgfParish = By.xpath("//*[@id='container_12']/table/tbody/tr/td[10]/input[1]");
    /* DATOS DEL PRÉSTAMO: Dp */
    private final By chkDpReadjustment = By.xpath("//*[@id='container_23']/table/tbody/tr/td[1]/table/tbody/tr[5]/td[2]/span[1]/input[2]");
    private final By txtDpWayToPay = By.xpath("//*[@id='container_23']/table/tbody/tr/td[3]/table/tbody/tr[7]/td[2]/input[1]");
    /* COMENTARIO: Comm */
    private final By txtCommComment = By.xpath("//*[@id='container_32']/table/tbody/tr/td/textarea");
    /* VALIDAR LISTAS DE CONTROL: Vlc */
    private final By btnVlcGenerateReport = By.xpath("//*[@id='container_33']/table/tbody/tr/td/button");

    /* GETTERS */

    /* DEUDOR-CODEUDOR Y GARANTES: Dcg */
    public By getTxtDcgF1Identification() { return this.txtDcgF1Identification; }
    public By getTxtDcgF2Identification() { return this.txtDcgF2Identification; }
    public By getTxtDcgF3Identification() { return this.txtDcgF3Identification; }
    /* DESTINO GEOGRÁFICO FONDOS: Dgf */
    public By getTxtDgfCountry() { return this.txtDgfCountry; }
    public By getTxtDgfState() { return this.txtDgfState; }
    public By getTxtDgfCanton() { return this.txtDgfCanton; }
    public By getTxtDgfParish() { return this.txtDgfParish; }
    /* DATOS DEL PRÉSTAMO: Dp */
    public By getChkDpReadjustment() { return this.chkDpReadjustment; }
    public By getTxtDpWayToPay() { return this.txtDpWayToPay; }
    /* COMENTARIO: Comm */
    public By getTxtCommComment() { return this.txtCommComment; }
    /* VALIDAR LISTAS DE CONTROL: Vlc */
    public By getBtnVlcGenerateReport() { return this.btnVlcGenerateReport; }
}
