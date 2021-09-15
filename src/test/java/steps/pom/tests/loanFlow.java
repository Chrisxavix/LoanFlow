package steps.pom.tests;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import steps.pom.pages.StartPages;
import steps.pom.pages.transactions.Tr062100;

import java.io.IOException;


public class loanFlow extends StartPages {

    public loanFlow() throws IOException { }

    public void openBrowser() throws Throwable {
        caseScreen++;
        Assert.assertEquals(message.getErrorBrowser(), message.getTitlePageLogin(), driver.getTitle());
        util.screenshot(caseScreen, caseScreenLogin);
    }

    public void closeSessionAndTypeUserPassword() throws Throwable {

        /* Forzar cierre de sesiones */
        driver.findElement(loginPage.getLinkMoreOptions()).click();
        driver.findElement(loginPage.getBtnForceClose()).click();
        /*util.screenshot();*/
        util.screenshot(caseScreen, caseScreenLogin);
        /* Ingreso de usuario y contraseña */
        driver.findElement(loginPage.getTxtUser()).sendKeys(loanFlow.get(0));
        driver.findElement(loginPage.getTxtPassword()).sendKeys(loanFlow.get(1));
        util.screenshot(caseScreen, caseScreenLogin);
        /*util.screenshot();*/
        driver.findElement(loginPage.getBtnSubmit()).submit();
            /* +Validaciones:
               Compruebo que la pantalla es el entorno FitBank */
        Assert.assertEquals(message.getErrorDataLogin(), message.getTitleFitbank(), driver.getTitle());

    }

    public void typeTransaction() throws Throwable {
        System.out.println("---" + util.readExcel().get(1));
        driver.findElement(tr062100.getTxtTransactions()).sendKeys(loanFlow.get(2) + Keys.ENTER);
        Thread.sleep(5000);
    }

    public void idDeudor() throws Throwable {
        util.waitPass(2000, "TR062100");
        driver.findElement(tr062100.getTxtId()).sendKeys(loanFlow.get(3));
    }
    public void idCod() throws Throwable {
        util.waitPass(2000, "TR062100");
        driver.findElement(tr062100.getTxtIdCod()).sendKeys(loanFlow.get(4));
    }
}
