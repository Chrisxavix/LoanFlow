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

    @And("^Ingreso la transaccion$")
    public void typeTransaction() throws Throwable {
        loanFlow.typeTransaction();
    }

    @And("^Ingreso la identificacion del deudor$")
    public void id() throws Throwable {
        loanFlow.idDeudor();;
    }

    @And("^Ingreso la identificacion del codeudor y la descripcion$")
    public void idCod() throws Throwable {
        loanFlow.idCod();
    }
    @And("^Por ultimo ingreso la indentificacion del garante y su descripcion$")
    public void idGar() throws Throwable {
        loanFlow.idGarante();
    }

    @And("^Ahora me dirigo a Datos Producto e ingreso el grupo del producto$")
    public void productGroup() throws Throwable {
        loanFlow.productGroup();
    }

    @And("^Luego ingreso el producto$")
    public void product() throws Throwable {
        loanFlow.product();
    }

    @And("^Despues ingresamos el id del ejecutivo$")
    public void idExecutive() throws Throwable {
        loanFlow.idExecutive();
    }

    @And("^Escojemos el origen$")
    public void origin() throws Throwable {
        loanFlow.origin();
    }

    @And("^Elegimos el destino de fondos$")
    public void destFunds() throws Throwable {
        loanFlow.destFunds();
    }

    @And("^Nos dirigimos a la actividad recepetora e ingresamos la actividad$")
    public void recpActivity() throws Throwable {
        loanFlow.recpActivity();
    }

    @And("^Procedemos a ingresar el monto del credito$")
    public void amountCred() throws Throwable {
        loanFlow.amountCred();
    }

    @And("^Ingresamos la frecuecnia del capital$")
    public void capFrecuency() throws Throwable {
        loanFlow.capFrecuency();
    }

    @And("^Ahora el numero de cuotas$")
    public void numberQuotas() throws Throwable {
        loanFlow.numberQuotas();
    }

    @And("^Por ultimo calculamos la tasa de interes$")
    public void interestRate() throws Throwable {
        loanFlow.interestRate();
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

    @Then("^Guardo la transacción$")
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

    @When("^Selecciono la pestaña de impresión de documentos$")
    public void selectPrintDocuments() throws Throwable {
        loanFlow.selectPrintDocuments();
    }

    @When("^Genero el reporte de checklist$")
    public void generateReportCheklist() throws Throwable {
        loanFlow.generateReportCheklist();
    }

    @When("^Genero la orden de operación$")
    public void generateOrder() throws Throwable {
        loanFlow.generateOrder();
    }


























    @And("^Ahora nos dirigimos a la transaccion 063071 e ingresamos el numero de solicitud generado anteriormente$")
    public void typeTr063071() throws Throwable {
        loanFlow.typeTxt063071();
    }

    @And("^Procedemos a marcar los checklist habilitados para y guardamos la verificacion$")
    public void checkList() throws Throwable {
        loanFlow.checkList();
    }

}
