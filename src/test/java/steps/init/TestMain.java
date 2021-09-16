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

    @And("^Ingreso la identificacion del codeudor$")
    public void idCod() throws Throwable {
        loanFlow.idCod();
    }






































    @When("^Ingreso la transacción 06-2000$")
    public void typeTx062000() throws Throwable {
        loanFlow.typeTx062000();
    }

    @Then("^Ingreso el número de solicitud$")
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
}
