package pom.tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pom.pages.StartPages;

import javax.annotation.concurrent.ThreadSafe;
import java.awt.*;
import java.awt.event.InputEvent;
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
        driver.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(2) + Keys.ENTER);
        util.waitPass(timeBase, "typeTransaction");
    }

    public void idDeudor() throws Throwable {
        driver.findElement(tr062100.getTxtId()).sendKeys(loanFlow.get(3) + Keys.ENTER);
        util.waitPass(timeBase, "idDeudor");
        WebElement relation = driver.findElement(tr062100.getTxtRelationsText());
        Assert.assertEquals("Error","DEUDOR",relation.getAttribute("value"));
    }

    public void idCod() throws Throwable {
        driver.findElement(tr062100.getTxtIdCod()).sendKeys(loanFlow.get(4) + Keys.ENTER);
        util.waitPass(timeBase, "idCodeudor");
        driver.findElement(tr062100.getTxtRelationsCod()).sendKeys(loanFlow.get(5));
        util.waitPass(timeBase, "idCodeudor");
        driver.findElement(tr062100.getTxtRelationsCod()).sendKeys(Keys.ENTER);
        util.waitPass(timeBase, "idCodeudor");
        WebElement relation = driver.findElement(tr062100.getTxtRelationsCodText());
        Assert.assertEquals("Error","CODEUDOR",relation.getAttribute("value"));
    }

    public void idGarante() throws Throwable {
        driver.findElement(tr062100.getTxtIdGar()).sendKeys(loanFlow.get(6) + Keys.ENTER);
        util.waitPass(timeBase, "idGarante");
        driver.findElement(tr062100.getTxtRelationsGar()).sendKeys(loanFlow.get(7));
        util.waitPass(timeBase, "idGarante");
        driver.findElement(tr062100.getTxtRelationsGar()).sendKeys(Keys.ENTER);
        util.waitPass(timeBase, "idGarante");
        WebElement relation = driver.findElement(tr062100.getTxtRelationsGarText());
        Assert.assertEquals("Error","GARANTE",relation.getAttribute("value"));
    }

    public void productGroup() throws Throwable {
        driver.findElement(tr062100.getTxtProductGroup()).sendKeys(loanFlow.get(8) + Keys.ENTER);
        util.waitPass(timeBase, "productGroup");
    }

    public void product() throws Throwable {
        driver.findElement(tr062100.getTxtProduct()).sendKeys(loanFlow.get(9) + Keys.ENTER);
    }

    public void idExecutive() throws Throwable {
        driver.findElement(tr062100.getTxtIdExecutive()).sendKeys(loanFlow.get(10));
        WebElement status = driver.findElement(global.getTxtStatus());
        util.waitPass(30, "Esperando OK");
    }

    public void origin() throws Throwable {
        Thread.sleep(2000);
        driver.findElement(tr062100.getTxtOrigin()).sendKeys(loanFlow.get(11) + Keys.ENTER);

    }

    public void destFunds() throws Throwable {
        Thread.sleep(2000);
        driver.findElement(tr062100.getTxtDestinationFunds()).sendKeys(loanFlow.get(12) + Keys.ENTER);
    }

    public void recpActivity() throws Throwable {
        Thread.sleep(2000);
        driver.findElement(tr062100.getTxtReceptorActivity()).sendKeys(loanFlow.get(13) + Keys.ENTER);
    }

    public void amountCred() throws Throwable {
        Thread.sleep(2000);
        driver.findElement(tr062100.getTxtAmountCredit()).sendKeys(loanFlow.get(14) + Keys.ENTER);
    }

    public void capFrecuency() throws Throwable {
        Thread.sleep(2000);
        driver.findElement(tr062100.getTxtCapitalFrequency()).sendKeys(loanFlow.get(15) + Keys.ENTER);
    }

    public void numberQuotas() throws Throwable {
        Thread.sleep(2000);
        driver.findElement(tr062100.getTxtNumberQuotas()).sendKeys(loanFlow.get(16) + Keys.ENTER);
    }

    public void interestRate() throws Throwable {
        Thread.sleep(2000);
        driver.findElement(tr062100.getBtnInterestRate()).click();
        Thread.sleep(2000);
        driver.findElement(tr062100.getBtnCloseInterestRate()).click();
    }

    public void saveForm() throws Throwable {
        Thread.sleep(2000);
        driver.findElement(tr062100.getSaveForm()).sendKeys(Keys.F12);
    }


}
