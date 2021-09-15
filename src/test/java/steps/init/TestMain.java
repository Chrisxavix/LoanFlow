package steps.init;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import steps.pom.tests.Investments;
import java.io.IOException;

public class TestMain {

    Investments investments = new Investments();

    public TestMain() throws IOException {
    }

    @Given("^Abre el web browser Chrome y direcciona a la aplicación$")
    public void openBrowser() throws Throwable {
        investments.openBrowser();
    }

    @When("^Cierro sesiones activas, ingreso el usuario y contraseña$")
    public void closeSessionAndTypeUserPassword() throws Throwable {
        investments.closeSessionAndTypeUserPassword();
    }

    @And("^Ingreso la transaccion$")
    public void typeTransaction() throws Throwable {
        investments.typeTransaction();
    }

    @And("^Ingreso la identificacion del deudor$")
    public void id() throws Throwable {
        investments.idDeudor();;
    }

}
