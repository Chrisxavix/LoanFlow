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

    @Given("^Abre el web browser Chrome y direcciona a la aplicación$")
    public void openBrowser() throws Throwable {
        loanFlow.openBrowser();
    }

    @When("^Cierro sesiones activas, ingreso el usuario y contraseña$")
    public void closeSessionAndTypeUserPassword() throws Throwable {
        loanFlow.closeSessionAndTypeUserPassword();
    }

    @And("^Ingreso a la transacción 06-2100 e ingreso los datos del Deudor, Codeudor y Garantes$")
    public void typeTransaction() throws Throwable {
        loanFlow.typeTransaction();
    }

    @And("^Ahora me dirijo a Datos Producto e ingreso los datos respectivos$")
    public void productGroup() throws Throwable {
        loanFlow.productGroup();
    }

    @And("^Procedemos a ingresar los datos del prestamo$")
    public void amountCred() throws Throwable {
        loanFlow.amountCred();
    }

    @And("^Guardamos el formulario para crear el número de solicitud$")
    public void saveForm() throws Throwable {
        loanFlow.saveForm();
    }

    @And("^Ingreso la transacción 06-2000 e ingreso el número de solicitud$")
    public void typeTx062000() throws Throwable {
        loanFlow.typeTx062000();
    }

    @And("^Ingreso los datos geográficos$")
    public void typeGeographicalData() throws Throwable {
        loanFlow.typeGeographicalData();
    }

    @And("^Ingreso los datos del préstamo y comentarios$")
    public void typeLoanDataAndComments() throws Throwable {
        loanFlow.typeLoanDataAndComments();
    }

    @And("^Genero el reporte$")
    public void generateReport() throws Throwable {
        loanFlow.generateReport();
    }

    @And("^Guardo la transacción$")
    public void saveTransaction() throws Throwable {
        loanFlow.saveTransaction();
    }

    @And("^Nos dirigimos a la pestaña de garantias 06-2008$")
    public void tabWarranty() throws Throwable {
        loanFlow.tabWarranty();
    }

    @And("^Ingreso los datos de las garantias propuestas$")
    public void warrantyProp() throws Throwable {
        loanFlow.warrantyProp();
    }

    @And("^Nos dirigimos a la pestaña pestaña de impresión de documentos 06-2016$")
    public void selectPrintDocuments() throws Throwable {
        loanFlow.selectPrintDocuments();
    }

    @And("^Genero el reporte de checklist$")
    public void generateReportCheklist() throws Throwable {
        loanFlow.generateReportCheklist();
    }

    @And("^Genero la orden de operación$")
    public void generateOrder() throws Throwable {
        loanFlow.generateOrder();
    }

    @And("^Valido que la orden de operación se haya generado$")
    public void validateOrder() throws Throwable {
        loanFlow.validateOrder();
    }

    @And("^Consultar la operación 00-0267$")
    public void queryOrder() throws Throwable {
        loanFlow.queryOrder();
    }

    @And("^Ahora nos dirigimos a la transaccion 06-3071 e ingresamos el número de solicitud generado anteriormente$")
    public void typeTr063071() throws Throwable {
        loanFlow.typeTxt063071();
    }

    @And("^Marco los checklist habilitados y guardamos la verificacion$")
    public void checkList() throws Throwable {
        loanFlow.checkList();
    }

    @And("^Ingresamos al formulario 06-3040$")
    public void typeTransaction3040() throws Throwable {
        loanFlow.typeTransaction3040();
    }

    @And("^Ingresamos el numero de solicitud de análisis de crédito y agregamos un comentario$")
    public void typeRequestNumberAnalysis() throws Throwable {
        loanFlow.typeRequestNumberAnalysis();
    }

    @And("^Nos dirigimos a la pestaña de analisis de credito 06-3078, en riesgos ingresamos el valor de cero$")
    public void creditAnalysis() throws Throwable {
        loanFlow.creditAnalysis();
    }

    @And("^Ahora nos dirigimos a la pestaña de activos y pasivos e ingresamos la informacion correspondiente$")
    public void actPasiv() throws Throwable {
        loanFlow.activPasiv();
    }

    @And("^Selecciono la pestaña de cumplimiento de políticas 06-3080$")
    public void selectPolicyCompliance() throws Throwable {
        loanFlow.selectPolicyCompliance();
    }

    @Then("^Completo las casillas de Politícas del Sujeto de Crédito y agrego un comentario$")
    public void completePolicyCompliance() throws Throwable {
        loanFlow.completePolicyCompliance();
    }

    @And("^Completo las políticas adicionales$")
    public void completeAdditionalPolicies() throws Throwable {
        loanFlow.completeAdditionalPolicies();
    }

    @And("^Abrimos el navegador en modo incógnito$")
    public void openNewBrowserIncognito() throws Throwable {
        loanFlow.openNewBrowserIncognito();
    }

    @And("^Cierro sesiones activas, ingreso el usuario y contraseña en modo incógnito$")
    public void incognitoCloseSessionAndTypeUserPassword() throws Throwable {
        loanFlow.incognitoCloseSessionAndTypeUserPassword();
    }

    @And("^Ingresamos al buzón de autorizaciones 00-2008 y aprobamos la solicitud 00-2009$")
    public void authMailBox() throws Throwable {
        loanFlow.authMailBox();
    }

    @And("^Ingresamos a la aprobación de análisis de riesgos para aprobar el número de solicitud 06-3033$")
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
}
