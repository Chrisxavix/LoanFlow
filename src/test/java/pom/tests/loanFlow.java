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
        driver.get("http://" + loanFlow.get(0) + ":8380/WEB3/ingreso.html");
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
        driver.findElement(loginPage.getTxtUser()).sendKeys(loanFlow.get(1));
        driver.findElement(loginPage.getTxtPassword()).sendKeys(loanFlow.get(2));
        util.screenshot(caseScreen, caseScreenLogin);
        /*util.screenshot();*/
        driver.findElement(loginPage.getBtnSubmit()).submit();
            /* +Validaciones:
               Compruebo que la pantalla es el entorno FitBank */
        Assert.assertEquals(message.getErrorDataLogin(), message.getTitleFitbank(), driver.getTitle());
    }

    public void typeTransaction() throws Throwable {
        driver.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(3) + Keys.ENTER);
        util.waitPass(timeBase, "typeTransaction");
        util.screenshot(caseScreen, caseScreenTx062100);
    }

    public void idDeudor() throws Throwable {
        driver.findElement(tr062100.getTxtId()).sendKeys(loanFlow.get(4) + Keys.ENTER);
        util.waitPass(timeBase, "idDeudor");
        WebElement relation = driver.findElement(tr062100.getTxtRelationsText());
        Assert.assertEquals("Error", "DEUDOR", relation.getAttribute("value"));
    }

    public void idCod() throws Throwable {
        driver.findElement(tr062100.getTxtIdCod()).sendKeys(loanFlow.get(5) + Keys.ENTER);
        util.waitPass(timeBase, "idCodeudor Id");
        driver.findElement(tr062100.getTxtRelationsCod()).sendKeys(loanFlow.get(6) + Keys.ENTER);
        util.waitPass(timeBase, "idCodeudor Cod");
        WebElement relation = driver.findElement(tr062100.getTxtRelationsCodText());
        Assert.assertEquals("Error", "CODEUDOR", relation.getAttribute("value"));
    }

    public void idGarante() throws Throwable {
        driver.findElement(tr062100.getTxtIdGar()).sendKeys(loanFlow.get(7) + Keys.ENTER);
        util.waitPass(timeBase, "idGarante Id");
        driver.findElement(tr062100.getTxtRelationsGar()).sendKeys(loanFlow.get(8) + Keys.ENTER);
        util.waitPass(timeBase, "idGarante Cod");
        util.screenshot(caseScreen, caseScreenTx062100);
        WebElement relation = driver.findElement(tr062100.getTxtRelationsGarText());
        Assert.assertEquals("Error", "GARANTE", relation.getAttribute("value"));
    }

    public void productGroup() throws Throwable {
        driver.findElement(tr062100.getTxtProductGroup()).sendKeys(loanFlow.get(9) + Keys.ENTER);
        util.waitPass(timeBase, "productGroup");
    }

    public void product() throws Throwable {
        driver.findElement(tr062100.getTxtProduct()).sendKeys(loanFlow.get(10) + Keys.ENTER);
        util.waitPass(timeBase, "product");
    }

    public void idExecutive() throws Throwable {
        driver.findElement(tr062100.getTxtIdExecutive()).sendKeys(loanFlow.get(11) + Keys.ENTER);
        util.waitPass(timeBase, "idExecutive");
    }

    public void origin() throws Throwable {
        driver.findElement(tr062100.getTxtOrigin()).sendKeys(loanFlow.get(12) + Keys.ENTER);
        util.waitPass(timeBase, "Origin");
    }

    public void destFunds() throws Throwable {
        driver.findElement(tr062100.getTxtDestinationFunds()).sendKeys(loanFlow.get(13) + Keys.ENTER);
        util.waitPass(timeBase, "destFunds");
    }

    public void recpActivity() throws Throwable {
        driver.findElement(tr062100.getTxtReceptorActivity()).sendKeys(loanFlow.get(14) + Keys.ENTER);
        util.waitPass(timeBase, "recpActivity");
    }

    public void amountCred() throws Throwable {
        driver.findElement(tr062100.getTxtAmountCredit()).sendKeys(loanFlow.get(15) + Keys.ENTER);
        util.waitPass(timeBase, "amountCred");
    }

    public void capFrecuency() throws Throwable {
        driver.findElement(tr062100.getTxtCapitalFrequency()).sendKeys(loanFlow.get(16) + Keys.ENTER);
        util.waitPass(timeBase, "capFrecuency");
    }

    public void numberQuotas() throws Throwable {
        driver.findElement(tr062100.getTxtNumberQuotas()).sendKeys(loanFlow.get(17) + Keys.ENTER);
        util.waitPass(timeBase, "numberQuotas");
        util.screenshot(caseScreen, caseScreenTx062100);
    }

    public void interestRate() throws Throwable {
        driver.findElement(tr062100.getBtnInterestRate()).click();
        util.waitPass(timeBase, "interestRate open");
        util.screenshot(caseScreen, caseScreenTx062100);
        Thread.sleep(700);
        driver.findElement(tr062100.getBtnCloseInterestRate()).click();
        util.waitPass(timeBase, "interestRate close");
    }

    public void saveForm() throws Throwable {
        driver.findElement(tr062100.getSaveForm()).sendKeys(Keys.F12);
        util.waitPass(timeSave, "saveForm");
        util.multipleValidate();
        driver.findElement(tr062100.getNumberSoli()).click();
        requestNumber = driver.findElement(tr062100.getNumberSoli()).getAttribute("value");
        util.screenshot(caseScreen, caseScreenTx062100);
    }

    public void typeTx062000() throws Throwable {
        driver.findElement(global.getBoxCodeTransaction()).clear();
        driver.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(18) + Keys.ENTER);
        util.waitPass(timeSave, "typeTx062000");
    }

    public void typeRequestNumber() throws Throwable {
        util.reactStartTransaction();
        driver.findElement(tr062000.getTxtNumberRequest()).sendKeys(requestNumber);
        util.screenshot(caseScreen, caseScreenTx062000);
        driver.findElement(tr062000.getTxtNumberRequest()).sendKeys(Keys.ENTER);
        util.waitPass(timeMedium, "typeRequestNumber typeRequestNumber");
        util.multipleValidate();
        /* +Validaciones:
               Compruebo que existan los tres usuarios */
        WebElement f1Ced = driver.findElement(tr062000.getTxtDcgF1Ced());
        WebElement f2Ced = driver.findElement(tr062000.getTxtDcgF2Ced());
        WebElement f3Ced = driver.findElement(tr062000.getTxtDcgF3Ced());
        Assert.assertEquals(message.getErrorUser(), message.getRuc(), f1Ced.getAttribute("value"));
        Assert.assertEquals(message.getErrorUser(), message.getRuc(), f2Ced.getAttribute("value"));
        Assert.assertEquals(message.getErrorUser(), message.getRuc(), f3Ced.getAttribute("value"));
    }

    public void typeGeographicalData() throws Throwable {
        /* País */
        driver.findElement(tr062000.getTxtDgfCountry()).sendKeys(loanFlow.get(19) + Keys.ENTER);
        util.waitPass(timeBase, "typeGeographicalData País");
            /* +Validaciones:
               Compruebo que se cargó el país */
        WebElement txtDgfCountryVal = driver.findElement(tr062000.getTxtDgfCountryVal());
        Assert.assertEquals(message.getErrorCountry(), message.getCountry(), txtDgfCountryVal.getAttribute("value"));
        /* Provincia */
        driver.findElement(tr062000.getTxtDgfState()).sendKeys(loanFlow.get(20) + Keys.ENTER);
        util.waitPass(timeBase, "typeGeographicalData Provincia");
            /* +Validaciones:
               Compruebo que se cargó la provincia */
        WebElement txtDgfStateVal = driver.findElement(tr062000.getTxtDgfStateVal());
        Assert.assertEquals(message.getErrorState(), message.getState(), txtDgfStateVal.getAttribute("value"));
        /* Cantón */
        driver.findElement(tr062000.getTxtDgfCanton()).sendKeys(loanFlow.get(21) + Keys.ENTER);
        util.waitPass(timeBase, "typeGeographicalData Cantón");
            /* +Validaciones:
               Compruebo que se cargó la provincia */
        WebElement txtDgfCantonVal = driver.findElement(tr062000.getTxtDgfCantonVal());
        Assert.assertEquals(message.getErrorCanton(), message.getCanton(), txtDgfCantonVal.getAttribute("value"));
        /* Parroquia */
        driver.findElement(tr062000.getTxtDgfParish()).sendKeys(loanFlow.get(22) + Keys.ENTER);
        util.waitPass(timeBase, "typeGeographicalData Parroquia");
        util.screenshot(caseScreen, caseScreenTx062000);
            /* +Validaciones:
               Compruebo que se cargó la provincia */
        WebElement txtDgfParishVal = driver.findElement(tr062000.getTxtDgfParishVal());
        Assert.assertEquals(message.getErrorParish(), message.getParish(), txtDgfParishVal.getAttribute("value"));
    }

    public void typeLoanDataAndComments() throws Throwable {
        /* Aplica Reajuste */
        if (loanFlow.get(23).equalsIgnoreCase("No")) {
            driver.findElement(tr062000.getChkDpReadjustment()).click();
        }
        util.waitPass(timeBase, "typeLoanDataAndComments Aplica Reajuste");
            /* +Validaciones:
               Compruebo que esté o no seleccionado el check */
        if (loanFlow.get(23).equalsIgnoreCase("No")) {
            WebElement chkDpReadjustment1 = driver.findElement(tr062000.getChkDpReadjustment());
            Assert.assertFalse("El check de reajuste activado ", chkDpReadjustment1.isSelected());
        } else {
            WebElement chkDpReadjustment2 = driver.findElement(tr062000.getChkDpReadjustment());
            Assert.assertTrue("El check de reajuste está desactivado", chkDpReadjustment2.isSelected());
        }
        /* Forma De Pago */
        driver.findElement(tr062000.getTxtDpWayToPay()).sendKeys(loanFlow.get(24) + Keys.ENTER);
        util.waitPass(timeBase, "typeLoanDataAndComments Forma De Pago");
            /* +Validaciones:
               Compruebo que se cargó la forma de pago de DEBITO CTA */
        WebElement txtDpWayToPayVal = driver.findElement(tr062000.getTxtDpWayToPayVal());
        Assert.assertEquals(message.getErrorWayToPay(), message.getWayToPay(), txtDpWayToPayVal.getAttribute("value"));
        /* Débito A Cuenta */
        driver.findElement(tr062000.getTxtDpDebitToAccount()).sendKeys(loanFlow.get(25) + Keys.ENTER);
        util.waitPass(timeBase, "typeLoanDataAndComments Débito A Cuenta");
            /* +Validaciones:
               Compruebo que se cargó la forma de pago de DEBITO CTA */
        WebElement txtDpDebitToAccountVal = driver.findElement(tr062000.getTxtDpDebitToAccountVal());
        Assert.assertEquals(message.getErrorDebitToAccount(), message.getDebitToAccount(), txtDpDebitToAccountVal.getAttribute("value"));
        /* Agregar Comentario */
        driver.findElement(tr062000.getTxtCommComment()).sendKeys(loanFlow.get(26));
        util.waitPass(timeBase, "typeLoanDataAndComments Forma De Pago");
        util.screenshot(caseScreen, caseScreenTx062000);
        /* +Validaciones:
               Compruebo que se cargó el comentario */
        WebElement txtCommComment = driver.findElement(tr062000.getTxtCommComment());
        Assert.assertEquals(message.getErrorComment(), loanFlow.get(26).toUpperCase(), txtCommComment.getAttribute("value"));
    }

    public void generateReport() throws Throwable {
        WebElement generateReport = driver.findElement(tr062000.getBtnVlcGenerateReport());
        generateReport.click();
        util.switchPages(0, "no");
        /* +Validaciones:
               Comprobar que esté en el ventana principal */
        Assert.assertEquals(message.getErrorMainView(), message.getTitleIncoMainLoan(), driver.getTitle());
    }

    public void saveTransaction() throws Throwable {
        util.reactPage();
        WebElement save = driver.findElement(global.getBtnF12());
        save.click();
        util.waitPass(timeSave, "saveTransaction saveTransaction");
        util.multipleValidate();
    }

    public void tabWarranty() throws Throwable {
        util.reactPage();
        driver.findElement(tr062000.getTabWarranty()).click();
        util.waitPass(timeMedium, "Tab Warranty");
        util.screenshot(caseScreen, caseScreenTx062008);
    }

    public void warrantyProp() throws Throwable {
        util.reactPage();
        driver.findElement(tr062008.getWarrantyProp()).sendKeys(loanFlow.get(27) + Keys.ENTER);
        util.waitPass(timeBase, "warrantyPro identificacion");
        WebElement txtIdEjec = driver.findElement(tr062008.getWarrantyProp());
        Assert.assertEquals(message.getErrorIdEjec(), message.getIdEjec(), txtIdEjec.getAttribute("value"));
        driver.findElement((tr062008.getTxtTypeWarranty())).sendKeys(loanFlow.get(28) + Keys.ENTER);
        util.waitPass(timeBase, "Type Garantía");
        driver.findElement((tr062008.getTxtTypeGoods())).sendKeys(loanFlow.get(29) + Keys.ENTER);
        util.waitPass(timeBase, "Bien");
        driver.findElement((tr062008.getTxtValueComercial())).sendKeys(loanFlow.get(30) + Keys.ENTER);
        util.waitPass(timeBase, "Value Comercial");
        driver.findElement((tr062008.getChkOpen())).click();
        util.waitPass(timeBase, "Bien Adquirido");
        driver.findElement((tr062008.getTxtDescription())).sendKeys(loanFlow.get(31) + Keys.ENTER);
        util.waitPass(timeBase, "Description");
        util.screenshot(caseScreen, caseScreenTx062008);
    }

    public void selectPrintDocuments() throws Throwable {
        util.reactPage();
        WebElement test = driver.findElement(tr062016.getTabMainPrintDocuments());
        test.click();
        util.waitPass(timeBase, "selectPrintDocuments");
        util.screenshot(caseScreen, caseScreenTx062016);
            /* +Validaciones:
               Comprobar que esté en el ventana de IMPRESIÓN DE DOCUMENTOS - FitBank */
        Assert.assertEquals(message.getErrorTx062016(), message.getTitlePrintDocuments(), driver.getTitle());
    }

    public void generateReportCheklist() throws Throwable {
        util.switchPDF();
        util.reactPage();
        WebElement btnChklReport = driver.findElement(tr062016.getBtnChklReport());
        btnChklReport.click();
        util.switchPages(4000, "yes");
    }

    public void generateOrder() throws Throwable {
        util.reactPage();
        WebElement btnOperationOrder = driver.findElement(tr062016.getBtnOperationOrder());
        btnOperationOrder.click();
        util.switchPages(4000, "yes");
        util.screenshot(caseScreen, caseScreenTx062016);
    }

    public void validateOrder() throws Throwable {
        driver.findElement(global.getBoxCodeTransaction()).clear();
        driver.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(32) + Keys.ENTER);
        util.waitPass(timeBase, "typeTransaction");
        util.screenshot(caseScreen, caseScreenTx000267);
        /* +Validaciones:
               Comprobar que esté en el ventana de Consulta de Reportes Generados en Batch - FitBank */
        Assert.assertEquals(message.getErrorTx000267(), message.getTitleQueryReport(), driver.getTitle());
    }

    public void queryOrder() throws Throwable {
        util.reactPage();
        WebElement query = driver.findElement(global.getBtnF7());
        query.click();
        util.waitPass(timeSave, "queryOrder");
        util.multipleValidate();
        util.screenshot(caseScreen, caseScreenTx000267);
        /* +Validaciones:
               Comprobar que se hayan cargado los datos */
        WebElement test = driver.findElement(tr000267.getTxtCrgbUser());
        Assert.assertEquals(message.getErrorGeneral(), loanFlow.get(1), test.getAttribute("value"));
    }

}
