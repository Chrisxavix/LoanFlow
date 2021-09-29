package steps.init;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pom.tests.loanFlow;

import java.io.IOException;

public class TestMain {

    loanFlow loanFlow = new loanFlow();

    public TestMain() throws IOException {
    }

    @Given("^Abrimos el navegador Chrome con la web de Fitbank$")
    public void openBrowser() throws Throwable {
        loanFlow.openBrowser();
    }

    @And("^Cerramos sesiones activas, ingresamos el usuario y contraseña$")
    public void closeSessionAndTypeUserPassword() throws Throwable {
        loanFlow.closeSessionAndTypeUserPassword();
    }

    @When("^Ingresamos a la transacción 06-2100 e ingresamos los datos del deudor, codeudor y garantes, datos del producto y los datos del préstamo$")
    public void typeDebtorDataProductDataLoan() throws Throwable {
        loanFlow.typeDebtorDataProductDataLoan();
    }

    @When("^Ingresamos a la transacción 06-2000 e ingreso los datos geográficos, datos del préstamo y comentarios$")
    public void typeDataGeographicalDataLoanComment() throws Throwable {
        loanFlow.typeDataGeographicalDataLoanComment();
    }

    @And("^Genero el reporte$")
    public void generateReport() throws Throwable {
        loanFlow.generateReport();
    }

    @Then("^Guardo la transacción$")
    public void saveTransaction() throws Throwable {
        loanFlow.saveTransaction();
    }

    @When("^Nos dirigimos a la pestaña de garantias 06-2008, ingresamos los datos de las garantias propuestas$")
    public void tabWarrantyProposed() throws Throwable {
        loanFlow.tabWarrantyProposed();
    }

    @When("^Nos dirigimos a la pestaña pestaña de impresión de documentos 06-2016$")
    public void tabPrintDocuments() throws Throwable {
        loanFlow.tabPrintDocuments();
    }

    @And("^Genero el reporte de checklist y la orden de operación$")
    public void generateReportCheklistReportOperation() throws Throwable {
        loanFlow.generateReportCheklistReportOperation();
    }

    @And("^Valido que la orden de operación se haya generado en la transacción 00-0267$")
    public void validateOrder() throws Throwable {
        loanFlow.validateOrder();
    }

    @And("^Ingresamos a la transacción 06-3071, marcamos los checklist habilitados y guardamos la verificacion$")
    public void pressChecksAndSave() throws Throwable {
        loanFlow.pressChecksAndSave();
    }

    @And("^Ingresamos al formulario 06-3040 y agregamos un comentario$")
    public void typeComment() throws Throwable {
        loanFlow.typeComment();
    }

    @And("^Nos dirigimos a la pestaña de análisis de crédito 06-3078, ingresamos valores en riesgos y en activos y pasivos$")
    public void typeValuesRiskActivesPasives() throws Throwable {
        loanFlow.typeValuesRiskActivesPasives();
    }

    @And("^Nos dirigimos a la pestaña de cumplimiento de políticas 06-3080, completo las casillas de políticas del sujeto de crédito, agrego un comentario y completo las políticas adicionales$")
    public void pressChecksPoliticsComment() throws Throwable {
        loanFlow.pressChecksPoliticsComment();
    }

    @Given("^Abrimos el navegador en modo incógnito$")
    public void openNewBrowserIncognito() throws Throwable {
        loanFlow.openNewBrowserIncognito();
    }

    @And("^Cierro sesiones activas, ingreso el usuario y contraseña en modo incógnito$")
    public void incognitoCloseSessionAndTypeUserPassword() throws Throwable {
        loanFlow.incognitoCloseSessionAndTypeUserPassword();
    }

    @When("^Ingresamos al buzón de autorizaciones 00-2008 y aprobamos la solicitud 00-2009$")
    public void approveNumberRequest() throws Throwable {
        loanFlow.approveNumberRequest();
    }

    @And("^Aprobamos el número de solicitud en aprobación de análisis 06-3033$")
    public void typeRiskAnalysisApproval() throws Throwable {
        loanFlow.typeRiskAnalysisApproval();
    }

    @And("^Iniciamos la aprobación de solicitud del préstamo 06-2001$")
    public void approveCreditNumber() throws Throwable {
        loanFlow.approveCreditNumber();
    }

    @And("^Ingresamos los datos para generar el número de crédito$")
    public void generateCreditNumber() throws Throwable {
        loanFlow.generateCreditNumber();
    }

    @And("^Abrimos el navegador en modo incógnito para aprobar el número de crédito$")
    public void openBrowserIncognitToApprove() throws Throwable {
        loanFlow.openBrowserIncognitToApprove();
    }

    @And("^Cierro sesiones activas, ingreso el usuario aprobador y contraseña en modo incógnito$")
    public void incognitoTwoCloseSessionAndTypeUserPassword() throws Throwable {
        loanFlow.incognitoTwoCloseSessionAndTypeUserPassword();
    }

    @And("^Ingresamos al buzón de autorizaciones 00-2008 y seleccionamos la trasacción correspondiente en incógnito$")
    public void selectTransactionIncognito() throws Throwable {
        loanFlow.selectTransactionIncognito();
    }

    @And("^Ingresamos los datos para generar el número de crédito en incógnito$")
    public void generateNumberCredit() throws Throwable {
        loanFlow.generateNumberCredit();
    }

    @And("^Guardo la transacción en incógnito$")
    public void saveIncognito() throws Throwable {
        loanFlow.saveIncognito();
    }

    @And("^Capturar el número de crédito$")
    public void getNumberCredit() throws Throwable {
        loanFlow.getNumberCredit();
    }

    @And("^Ahora ingresamos a la transacción 06-3002 e ingresamos el número de préstamos y la cuenta a debitar$")
    public void tr063002() throws Throwable {
        loanFlow.tr063002();
    }

    @And("^Luego ingresamos a la transacción 06-2006 e ingresamos el número de préstamos y las garantías existentes$")
    public void loanWarranty() throws Throwable {
        loanFlow.loanWarranty();
    }

    @And("^Ingresamos a la transacción 06-3005 y llenamos la información del préstamo$")
    public void enablingDocuments() throws Throwable {
        loanFlow.enablingDocuments();
    }
}
