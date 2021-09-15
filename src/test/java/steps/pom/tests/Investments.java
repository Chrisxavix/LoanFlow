package steps.pom.tests;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import steps.pom.pages.StartPages;
import steps.pom.pages.transactions.Tr062100;

import java.io.IOException;


public class Investments extends StartPages {

    private Tr062100 tr062100 = new Tr062100();

    public Investments() throws IOException { }

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
        driver.findElement(loginPage.getTxtUser()).sendKeys(investments.get(0));
        driver.findElement(loginPage.getTxtPassword()).sendKeys(investments.get(1));
        util.screenshot(caseScreen, caseScreenLogin);
        /*util.screenshot();*/
        driver.findElement(loginPage.getBtnSubmit()).submit();
            /* +Validaciones:
               Compruebo que la pantalla es el entorno FitBank */
        Assert.assertEquals(message.getErrorDataLogin(), message.getTitleFitbank(), driver.getTitle());
    }

    public void typeTransaction() throws Throwable {
        driver.findElement(tr062100.getTxtTransactions()).sendKeys(util.readExcel().get(2) + Keys.ENTER);
    }
}
