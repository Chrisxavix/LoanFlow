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
    private final By chkCpAntiquity = By.xpath("//*[@id='container_6']/table/tbody/tr/td[1]/table/tbody/tr[3]/td[5]/span[2]/input[2]");
    private final By chkCpCreditHistory = By.xpath("//*[@id='container_6']/table/tbody/tr/td[2]/table/tbody/tr[11]/td[3]/span/input[2]");
    private final By chkCpValidationAnalysis = By.xpath("//*[@id='container_6']/table/tbody/tr/td[2]/table/tbody/tr[13]/td[3]/span/input[2]");
    /* Comentario */
    private final By txtCpComment = By.xpath("//*[@id='container_17']/table/tbody/tr[3]/td[2]/input[1]");
    /* Pestaña de POLÍTICAS ADICIONALES */
    private final By tabCpAditionalPolicies = By.xpath("//*[@id='container_3']/table/tbody/tr/td/ul/li[2]/a");
    private final By chkCpGuaranteePolicy = By.xpath("//*[@id='container_9']/table/tbody/tr[2]/td[3]/span/input[2]");
    private final By chkCpCoverage = By.xpath("//*[@id='container_9']/table/tbody/tr[3]/td[3]/span/input[2]");
    private final By chkCpDocumentaryRequirements = By.xpath("//*[@id='container_10']/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/span/input[2]");
    private final By chkCpPaymentCapacity = By.xpath("//*[@id='container_10']/table/tbody/tr/td[2]/table/tbody/tr[5]/td[3]/span/input[2]");
    private final By chkCpBorrowingLimit = By.xpath("//*[@id='container_10']/table/tbody/tr/td[2]/table/tbody/tr[6]/td[3]/span/input[2]");
    private final By chkCpSubmitApproval = By.xpath("//*[@id='container_21']/table/tbody/tr/td[2]/span[1]/input[2]");

    /* GETTERS */

    /* Cambio de pestaña, Cumplimiento De Políticas */
    public By getTabPolicyCompliance() { return this.tabPolicyCompliance; }
    /* CUMPLIMIENTO DE POLITICAS: Cp*/
    /* Título a validar de Cumplimiento de politicas*/
    public By getLblCpTitle() { return this.lblCpTitle; }
    /* Politícas del Sujeto de Crédito */
    public By getChkCpAntiquity() { return this.chkCpAntiquity; }
    public By getChkCpCreditHistory() { return this.chkCpCreditHistory; }
    public By getChkCpValidationAnalysis() { return this.chkCpValidationAnalysis; }
    /* Comentario */
    public By getTxtCpComment() { return this.txtCpComment; }
    /* Pestaña de POLÍTICAS ADICIONALES */
    public By getTabCpAditionalPolicies() { return this.tabCpAditionalPolicies; }
    public By getChkCpGuaranteePolicy() { return this.chkCpGuaranteePolicy; }
    public By getTxtCpCoverage() { return this.chkCpCoverage; }
    public By getChkCpDocumentaryRequirements() { return this.chkCpDocumentaryRequirements; }
    public By getChkCpPaymentCapacity() { return this.chkCpPaymentCapacity; }
    public By getChkCpBorrowingLimit() { return this.chkCpBorrowingLimit; }
    public By getChkCpSubmitApproval() { return this.chkCpSubmitApproval; }
}
