package pom.pages.transactions;

import org.openqa.selenium.By;

public class Tr002008 {

    /* VARIABLES */

    /* BUZON DE AUTORIZACIONES: Ba */
    private final By txtTransaction = By.id("c_ctransaccionc_0");
    /* Buscador de solicitud */
    private final By txtBaSearchRequest = By.xpath("//*[@id='container_3']/div/table/thead/tr[1]/td[8]/input");
    /* Enlace de la solicitud */
    private final By linkBaRequest = By.xpath("//*[@id='container_3']/div/table/tbody/tr[1]/td[10]/span/a");

    /* GETTERS */

    /* BUZON DE AUTORIZACIONES: Ba */
    public By getTxtTransaction() { return this.txtTransaction; }
    public By getTxtBaSearchRequest() { return txtBaSearchRequest; }
    public By getLinkBaRequest() { return this.linkBaRequest; }
}
