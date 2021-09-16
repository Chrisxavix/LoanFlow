package pom.tests;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pom.pages.StartPages;

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
    }

    public void idDeudor() throws Throwable {
        //util.waitPass(2000, "TR062100");
        driver.findElement(tr062100.getTxtId()).sendKeys(loanFlow.get(3));
    }
    public void idCod() throws Throwable {
        util.waitPass(10000, "TR062100");
        driver.findElement(tr062100.getTxtIdCod()).sendKeys(loanFlow.get(4));
    }
    /*Test*/



























































































































    public void typeTx062000() throws Throwable {
        driver.findElement(global.getBoxCodeTransaction()).sendKeys( loanFlow.get(17)+ Keys.ENTER);
        util.waitPass(timeBase,"transaction062000");
        /* +Validaciones:
               Compruebo que el título sea: INGRESO Y MANTENIMIENTO DE SOLICITUDES PRÉSTAMOS - FitBank */
        Assert.assertEquals(message.getErrorTx06_2000(), message.getTitleIncoMainLoan(), driver.getTitle());
    }

    public void typeRequestNumber() throws Throwable {
        util.reactStartTransaction();
        driver.findElement(tr062000.getTxtNumberRequest()).sendKeys(requestNumber + Keys.ENTER);
        util.waitPass(timeMedium,"typeRequestNumber Validate 1");
        util.waitPass(timeMedium,"typeRequestNumber Validate 2");
        /* +Validaciones:
               Compruebo que existan los tres usuarios */
        WebElement f1Ced = driver.findElement(tr062000.getTxtDcgF1Ced());
        WebElement f2Ced = driver.findElement(tr062000.getTxtDcgF2Ced());
        WebElement f3Ced = driver.findElement(tr062000.getTxtDcgF3Ced());
        Assert.assertEquals(message.getErrorUser(), message.getCed(), f1Ced.getAttribute("value"));
        Assert.assertEquals(message.getErrorUser(), message.getCed(), f2Ced.getAttribute("value"));
        Assert.assertEquals(message.getErrorUser(), message.getCed(), f3Ced.getAttribute("value"));
    }

    public void typeGeographicalData() throws Throwable {
        /* País */
        driver.findElement(tr062000.getTxtDgfCountry()).sendKeys(loanFlow.get(18) + Keys.ENTER);
        util.waitPass(timeBase,"typeGeographicalData País");
            /* +Validaciones:
               Compruebo que se cargó el país */
        WebElement txtDgfCountryVal = driver.findElement(tr062000.getTxtDgfCountryVal());
        Assert.assertEquals(message.getErrorCountry(), message.getCountry(), txtDgfCountryVal.getAttribute("value"));
        /* Provincia */
        driver.findElement(tr062000.getTxtDgfState()).sendKeys(loanFlow.get(19) + Keys.ENTER);
        util.waitPass(timeBase,"typeGeographicalData Provincia");
            /* +Validaciones:
               Compruebo que se cargó la provincia */
        WebElement txtDgfStateVal = driver.findElement(tr062000.getTxtDgfStateVal());
        Assert.assertEquals(message.getErrorState(), message.getState(), txtDgfStateVal.getAttribute("value"));
        /* Cantón */
        driver.findElement(tr062000.getTxtDgfCanton()).sendKeys(loanFlow.get(20) + Keys.ENTER);
        util.waitPass(timeBase,"typeGeographicalData Cantón");
            /* +Validaciones:
               Compruebo que se cargó la provincia */
        WebElement txtDgfCantonVal = driver.findElement(tr062000.getTxtDgfCantonVal());
        Assert.assertEquals(message.getErrorCanton(), message.getCanton(), txtDgfCantonVal.getAttribute("value"));
        /* Parroquia */
        driver.findElement(tr062000.getTxtDgfParish()).sendKeys(loanFlow.get(21) + Keys.ENTER);
        util.waitPass(timeBase,"typeGeographicalData Parroquia");
            /* +Validaciones:
               Compruebo que se cargó la provincia */
        WebElement txtDgfParishVal = driver.findElement(tr062000.getTxtDgfParishVal());
        Assert.assertEquals(message.getErrorParish(), message.getParish(), txtDgfParishVal.getAttribute("value"));
    }

    public void typeLoanDataAndComments() throws Throwable {
        /* Aplica Reajuste */
        if (loanFlow.get(22).equalsIgnoreCase("No")) {
            driver.findElement(tr062000.getChkDpReadjustment()).click();
        }
        util.waitPass(timeBase,"typeLoanDataAndComments Aplica Reajuste");
            /* +Validaciones:
               Compruebo que esté o no seleccionado el check */
        if (loanFlow.get(22).equalsIgnoreCase("No")) {
            WebElement chkDpReadjustment1 = driver.findElement(tr062000.getChkDpReadjustment());
            Assert.assertFalse("El check de reajuste activado ", chkDpReadjustment1.isSelected());
        } else {
            WebElement chkDpReadjustment2 = driver.findElement(tr062000.getChkDpReadjustment());
            Assert.assertTrue("El check de reajuste está desactivado", chkDpReadjustment2.isSelected());
        }
        /* Forma De Pago */
        driver.findElement(tr062000.getTxtDpWayToPay()).sendKeys(loanFlow.get(23) + Keys.ENTER);
        util.waitPass(timeBase,"typeLoanDataAndComments Forma De Pago");
            /* +Validaciones:
               Compruebo que se cargó la forma de pago de DEBITO CTA */
        WebElement txtDpWayToPayVal = driver.findElement(tr062000.getTxtDpWayToPayVal());
        Assert.assertEquals(message.getErrorWayToPay(), message.getWayToPay(), txtDpWayToPayVal.getAttribute("value"));
        /* Débito A Cuenta */
        driver.findElement(tr062000.getTxtDpDebitToAccount()).sendKeys("0022002430" + Keys.ENTER);
        util.waitPass(timeBase,"typeLoanDataAndComments Débito A Cuenta");
            /* +Validaciones:
               Compruebo que se cargó la forma de pago de DEBITO CTA */
        WebElement txtDpDebitToAccountVal = driver.findElement(tr062000.getTxtDpDebitToAccountVal());
        Assert.assertEquals(message.getErrorDebitToAccount(), message.getDebitToAccount(), txtDpDebitToAccountVal.getAttribute("value"));
        /* Agregar Comentario */
        driver.findElement(tr062000.getTxtCommComment()).sendKeys(loanFlow.get(24));
        util.waitPass(timeBase,"typeLoanDataAndComments Forma De Pago");
        /* +Validaciones:
               Compruebo que se cargó el comentario */
        WebElement txtCommComment = driver.findElement(tr062000.getTxtCommComment());
        Assert.assertEquals(message.getErrorComment(), loanFlow.get(24).toUpperCase(), txtCommComment.getAttribute("value"));
    }

    public void generateReport() throws Throwable {
        WebElement generateReport =  driver.findElement(tr062000.getBtnVlcGenerateReport());
        generateReport.click();
        util.switchPages(0);
        /* +Validaciones:
               Comprobar que esté en el ventana principal */
        Assert.assertEquals(message.getErrorMainView(), message.getTitleIncoMainLoan(), driver.getTitle());
    }

    public void saveTransaction() throws Throwable {
        WebElement save = driver.findElement(global.getBtnF12());
        save.click();
        util.reactPage();
        util.waitPass(timeSave, "saveTransaction saveTransaction");
        util.switchPDF();
        /* +Validaciones:
               Comprobar que el status sea correcto */
        /*WebElement txtCodeTransaction = driver.findElement(global.getBoxCodeTransaction());
        WebElement txtStatus = driver.findElement(global.getTxtStatus());
        String code = txtCodeTransaction.getAttribute("value");
        util.waitPass(timeSave, "saveTransaction saveTransaction");
        Assert.assertEquals(message.getErrorValidateTx() + code, message.getSuccessTx(), txtStatus.getText());*/
    }
}
