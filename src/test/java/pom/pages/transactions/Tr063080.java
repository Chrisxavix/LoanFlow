package pom.pages.transactions;

import org.openqa.selenium.By;

public class Tr063080 {

    /* VARIABLES */

    /* Cambio de pestaña, Cumplimiento De Políticas */
    private final By tabPolicyCompliance = By.xpath("//*[@id='container_0']/table/tbody/tr/td/ul/li[4]/a");
    /* CUMPLIMIENTO DE POLITICAS: Cp*/
    /* Título a validar de Cumplimiento de politicas*/
    private final By lblCpTitle = By.xpath("//*[@id='entorno-formulario']/div[1]");
    /* Politícas del Sujeto de Crédito */
    private final By txtCpAntiquity = By.xpath("//*[@id='container_6']/table/tbody/tr/td[1]/table/tbody/tr[3]/td[5]/span[2]/input[2]");
    private final By txtCpCreditHistory = By.xpath("//*[@id='container_6']/table/tbody/tr/td[2]/table/tbody/tr[11]/td[3]/span/input[2]");
    private final By txtCpValidationAnalysis = By.xpath("//*[@id='container_6']/table/tbody/tr/td[2]/table/tbody/tr[13]/td[3]/span/input[2]");
    /* Comentario */
    private final By txtCpComment = By.xpath("//*[@id=\"container_17\"]/table/tbody/tr[3]/td[2]/input[1]");

    /* GETTERS */

    /* Cambio de pestaña, Cumplimiento De Políticas */
    public By getTabPolicyCompliance() { return this.tabPolicyCompliance; }
    /* CUMPLIMIENTO DE POLITICAS: Cp*/
    /* Título a validar de Cumplimiento de politicas*/
    public By getLblCpTitle() { return this.lblCpTitle; }
    /* Politícas del Sujeto de Crédito */
    public By getTxtCpAntiquity() { return this.txtCpAntiquity; }
    public By getTxtCpCreditHistory() { return this.txtCpCreditHistory; }
    public By getTxtCpValidationAnalysis() { return this.txtCpValidationAnalysis; }
    /* Comentario */
    public By getTxtCpComment() { return this.txtCpComment; }
}
