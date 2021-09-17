package steps.init;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
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


}
