package pom.pages.transactions;

import org.openqa.selenium.By;

public class Tr062000 {

    /* VARIABLES */

    /* Caja del número de solicitud */
    private final By txtNumberRequest = By.xpath("//*[@id='container_2']/table/tbody/tr[1]/td[2]/input");
    /* DESTINO GEOGRÁFICO FONDOS: Dgf */
    private final By txtDgfCountry = By.xpath("//*[@id='container_12']/table/tbody/tr/td[1]/input[1]");
    private final By txtDgfState = By.xpath("//*[@id='container_12']/table/tbody/tr/td[4]/input[1]");
    private final By txtDgfCanton = By.xpath("//*[@id='container_12']/table/tbody/tr/td[7]/input[1]");
    private final By txtDgfParish = By.xpath("//*[@id='container_12']/table/tbody/tr/td[10]/input[1]");
    /* DATOS DEL PRÉSTAMO: Dp */
    private final By chkDpReadjustment = By.xpath("//*[@id='container_23']/table/tbody/tr/td[1]/table/tbody/tr[5]/td[2]/span[1]/input[2]");
    private final By txtDpWayToPay = By.xpath("//*[@id='container_23']/table/tbody/tr/td[3]/table/tbody/tr[7]/td[2]/input[1]");
    private final By txtDpDebitToAccount = By.xpath("//*[@id='container_23']/table/tbody/tr/td[3]/table/tbody/tr[8]/td[2]/input[1]");
    /* COMENTARIO: Comm */
    private final By txtCommComment = By.xpath("//*[@id='container_32']/table/tbody/tr/td/textarea");
    /* VALIDAR LISTAS DE CONTROL: Vlc */
    private final By btnVlcGenerateReport = By.xpath("//*[@id='container_33']/table/tbody/tr/td/button");
    /* Cambio de pestaña garantías propuestas*/
    private final By tabWarranty = By.xpath("//*[@id='container_1']/table/tbody/tr/td/ul/li[2]/a");

    /* GETTERS */

    /* Caja del número de solicitud */
    public By getTxtNumberRequest() { return this.txtNumberRequest; }
    /* DESTINO GEOGRÁFICO FONDOS: Dgf */
    public By getTxtDgfCountry() { return this.txtDgfCountry; }
    public By getTxtDgfState() { return this.txtDgfState; }
    public By getTxtDgfCanton() { return this.txtDgfCanton; }
    public By getTxtDgfParish() { return this.txtDgfParish; }
    /* DATOS DEL PRÉSTAMO: Dp */
    public By getChkDpReadjustment() { return this.chkDpReadjustment; }
    public By getTxtDpWayToPay() { return this.txtDpWayToPay; }
    public By getTxtDpDebitToAccount() { return this.txtDpDebitToAccount; }
    /* COMENTARIO: Comm */
    public By getTxtCommComment() { return this.txtCommComment; }
    /* VALIDAR LISTAS DE CONTROL: Vlc */
    public By getBtnVlcGenerateReport() { return this.btnVlcGenerateReport; }
    /* Cambio pestaña garantías propuestas */
    public By getTabWarranty() { return this.tabWarranty; }
}
