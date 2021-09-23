package pom.pages.transactions;

import org.openqa.selenium.By;

public class Tr062000 {

    /* VARIABLES */

    /* Caja del número de solicitud */
    private final By txtNumberRequest = By.xpath("//*[@id='container_2']/table/tbody/tr[1]/td[2]/input");
    /* DEUDOR-CODEUDOR Y GARANTES: Dcg */
    private final By txtDcgF1Ced = By.xpath("//*[@id='container_5']/div/table/tbody/tr[1]/td[1]/input");
    private final By txtDcgF2Ced = By.xpath("//*[@id='container_5']/div/table/tbody/tr[2]/td[1]/input");
    private final By txtDcgF3Ced = By.xpath("//*[@id='container_5']/div/table/tbody/tr[3]/td[1]/input");
    /* DESTINO GEOGRÁFICO FONDOS: Dgf */
    private final By txtDgfCountry = By.xpath("//*[@id='container_12']/table/tbody/tr/td[1]/input[1]");
    private final By txtDgfCountryVal = By.xpath("//*[@id='container_12']/table/tbody/tr/td[1]/input[2]");
    private final By txtDgfState = By.xpath("//*[@id='container_12']/table/tbody/tr/td[4]/input[1]");
    private final By txtDgfStateVal = By.xpath("//*[@id='container_12']/table/tbody/tr/td[4]/input[2]");
    private final By txtDgfCanton = By.xpath("//*[@id='container_12']/table/tbody/tr/td[7]/input[1]");
    private final By txtDgfCantonVal = By.xpath("//*[@id='container_12']/table/tbody/tr/td[7]/input[2]");
    private final By txtDgfParish = By.xpath("//*[@id='container_12']/table/tbody/tr/td[10]/input[1]");
    private final By txtDgfParishVal = By.xpath("//*[@id='container_12']/table/tbody/tr/td[10]/input[2]");
    /* DATOS DEL PRÉSTAMO: Dp */
    private final By chkDpReadjustment = By.xpath("//*[@id='container_23']/table/tbody/tr/td[1]/table/tbody/tr[5]/td[2]/span[1]/input[2]");
    private final By txtDpWayToPay = By.xpath("//*[@id='container_23']/table/tbody/tr/td[3]/table/tbody/tr[7]/td[2]/input[1]");
    private final By txtDpWayToPayVal = By.xpath("//*[@id='c_F4DFPago_0']");
    private final By txtDpDebitToAccount = By.xpath("//*[@id='container_23']/table/tbody/tr/td[3]/table/tbody/tr[8]/td[2]/input[1]");
    private final By txtDpDebitToAccountVal = By.xpath("//*[@id='container_23']/table/tbody/tr/td[3]/table/tbody/tr[8]/td[2]/input[2]");
    /* COMENTARIO: Comm */
    private final By txtCommComment = By.xpath("//*[@id='container_32']/table/tbody/tr/td/textarea");
    /* VALIDAR LISTAS DE CONTROL: Vlc */
    private final By btnVlcGenerateReport = By.xpath("//*[@id='container_33']/table/tbody/tr/td/button");
    /* Cambio de pestaña garantías propuestas*/
    private final By tabWarranty = By.xpath("//*[@id='container_1']/table/tbody/tr/td/ul/li[2]/a");

    /* GETTERS */

    /* Caja del número de solicitud */
    public By getTxtNumberRequest() { return this.txtNumberRequest; }
    /* DEUDOR-CODEUDOR Y GARANTES: Dcg */
    public By getTxtDcgF1Ced() { return this.txtDcgF1Ced; }
    public By getTxtDcgF2Ced() { return this.txtDcgF2Ced; }
    public By getTxtDcgF3Ced() { return this.txtDcgF3Ced; }
    /* DESTINO GEOGRÁFICO FONDOS: Dgf */
    public By getTxtDgfCountry() { return this.txtDgfCountry; }
    public By getTxtDgfCountryVal() { return this.txtDgfCountryVal; }
    public By getTxtDgfState() { return this.txtDgfState; }
    public By getTxtDgfStateVal() { return this.txtDgfStateVal; }
    public By getTxtDgfCanton() { return this.txtDgfCanton; }
    public By getTxtDgfCantonVal() { return this.txtDgfCantonVal; }
    public By getTxtDgfParish() { return this.txtDgfParish; }
    public By getTxtDgfParishVal() { return this.txtDgfParishVal; }
    /* DATOS DEL PRÉSTAMO: Dp */
    public By getChkDpReadjustment() { return this.chkDpReadjustment; }
    public By getTxtDpWayToPay() { return this.txtDpWayToPay; }
    public By getTxtDpWayToPayVal() { return this.txtDpWayToPayVal; }
    public By getTxtDpDebitToAccount() { return this.txtDpDebitToAccount; }
    public By getTxtDpDebitToAccountVal() { return this.txtDpDebitToAccountVal; }
    /* COMENTARIO: Comm */
    public By getTxtCommComment() { return this.txtCommComment; }
    /* VALIDAR LISTAS DE CONTROL: Vlc */
    public By getBtnVlcGenerateReport() { return this.btnVlcGenerateReport; }
    /* Cambio pestaña garantías propuestas */
    public By getTabWarranty() { return tabWarranty; }
}
