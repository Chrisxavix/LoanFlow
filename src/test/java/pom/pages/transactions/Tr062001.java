package pom.pages.transactions;

import org.openqa.selenium.By;

public class Tr062001 {
    /* VARIABLES */

    /* APROBACIÓN DE SOLICITUDES PRÉSTAMOS: Asp */
    private final By txtRequestNumber = By.xpath("//*[@id='container_3']/table/tbody/tr[1]/td[2]/input");
    /* DECISIÓN */
    private final By txtAspDecision = By.xpath("//*[@id=\"container_17\"]/table/tbody/tr[2]/td[1]/select");
    private final By txtAspaccountingDate = By.xpath("//*[@id=\"entorno-informacion\"]/div/table/tbody/tr[2]/td[8]/input");
    private final By txtAspaccountingDateValue = By.xpath("//*[@id=\"container_17\"]/table/tbody/tr[2]/td[6]/input[1]");
    /* Caja de préstamo */
    private final By txtBaLoanNumber = By.xpath("//*[@id='container_3']/table/tbody/tr[2]/td[2]/input[1]");

    /* GETTERS */

    /* APROBACIÓN DE SOLICITUDES PRÉSTAMOS: Asp */
    public By getTxtRequestNumber() { return this.txtRequestNumber; }
    /* DECISIÓN */
    public By getTxtAspDecision() { return this.txtAspDecision; }
    public By getTxtAspaccountingDate() { return this.txtAspaccountingDate; }
    public By getTxtAspaccountingDateValue() { return this.txtAspaccountingDateValue; }
    /* Caja de préstamo */
    public By getTxtBaLoanNumber() { return this.txtBaLoanNumber; }
}
