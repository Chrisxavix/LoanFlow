package pom.pages.transactions;

import org.openqa.selenium.By;

public class Tr062016 {

    /* VARIABLES */

    /* PESTAÑA IMPRIMIR DOCUMENTOS */
    private final By tabMainPrintDocuments = By.xpath("//*[@id='container_1']/table/tbody/tr/td/ul/li[5]");
    /* CHECKLIST: Chkl */
    private final By btnChklReport = By.xpath("//*[@id='container_17']/table/tbody/tr/td[2]/button");
    /* IMPRESIÓN DE DOCUMENTOS */
    /* Orden de Operación */
    private final By btnOperationOrder = By.xpath("//*[@id='container_7']/table/tbody/tr/td[2]/button[4]");

    /* GETTERS */

    /* PESTAÑA IMPRIMIR DOCUMENTOS */
    public By getTabMainPrintDocuments() { return this.tabMainPrintDocuments; }
    /* CHECKLIST: Chkl */
    public By getBtnChklReport() { return this.btnChklReport; }
    /* IMPRESIÓN DE DOCUMENTOS */
    /* Orden de Operación */
    public By getBtnOperationOrder() { return this.btnOperationOrder; }
}
