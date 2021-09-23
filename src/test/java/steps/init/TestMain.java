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

    @And("^Ingreso a la transaccion e ingresamos los datos del Deudor-Codeudor y Garantes$")
    public void typeTransaction() throws Throwable {
        loanFlow.typeTransaction();
    }

    @And("^Ahora me dirigo a Datos Producto e ingreso los datos respectivos$")
    public void productGroup() throws Throwable {
        loanFlow.productGroup();
    }

    @And("^Procedemos a ingresar los datos del prestamo$")
    public void amountCred() throws Throwable {
        loanFlow.amountCred();
    }

    @And("^Guardamos el formulario para crear el numero de solicitud$")
    public void saveForm() throws Throwable {
        loanFlow.saveForm();
    }

    @And("^Ingreso la transacción 06-2000$")
    public void typeTx062000() throws Throwable {
        loanFlow.typeTx062000();
    }

    @And("^Ingreso el número de solicitud$")
    public void typeRequestNumber() throws Throwable {
        loanFlow.typeRequestNumber();
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

    @And("^Luego de guardar el formulario, nos dirigimos a la pestana de garantias$")
    public void tabWarranty() throws Throwable {
        loanFlow.tabWarranty();
    }

    @And("^Ahora vamos a ingresar los datos de las garantias propuestas$")
    public void warrantyProp() throws Throwable {
        loanFlow.warrantyProp();
    }

    @And("^Selecciono la pestaña de impresión de documentos$")
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

    @And("^Consultar la operación$")
    public void queryOrder() throws Throwable {
        loanFlow.queryOrder();
    }

    @And("^Ahora nos dirigimos a la transaccion 063071 e ingresamos el numero de solicitud generado anteriormente$")
    public void typeTr063071() throws Throwable {
        loanFlow.typeTxt063071();
    }

    @And("^Procedemos a marcar los checklist habilitados y guardamos la verificacion$")
    public void checkList() throws Throwable {
        loanFlow.checkList();
    }

    @And("^Ingresamos al formulario 06-3040$")
    public void typeTransaction3040() throws Throwable {
        loanFlow.typeTransaction3040();
    }

    @And("^Ingresamos el numero de solicitud de análisis de crédito$")
    public void typeRequestNumberAnalysis() throws Throwable {
        loanFlow.typeRequestNumberAnalysis();
    }

    @And("^Agregamos un comentario$")
    public void typeComment() throws Throwable {
        loanFlow.typeComment();
    }

    @And("^Nos dirigimos a la pestaña de analisis de credito, en riesgos ingresamos el valor de cero$")
    public void creditAnalysis() throws Throwable {
        loanFlow.creditAnalysis();
    }

    @And("^Ahora nos dirigimos a la pestaña de activos y pasivos e ingresamos la informacion correspondiente$")
    public void actPasiv() throws Throwable {
        loanFlow.activPasiv();
    }

    @And("^Selecciono la pestaña de cumplimiento de políticas$")
    public void selectPolicyCompliance() throws Throwable {
        loanFlow.selectPolicyCompliance();
    }

    @And("^Completo las casillas de Politícas del Sujeto de Crédito y agrego un comentario$")
    public void completePolicyCompliance() throws Throwable {
        loanFlow.completePolicyCompliance();
    }
}
