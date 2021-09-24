package pom.tests;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pom.pages.StartPages;
import java.io.IOException;
import java.util.List;


public class loanFlow extends StartPages {

    public loanFlow() throws IOException { }

    public void openBrowser() throws Throwable {
        caseScreen++;
        driver.get("http://" + loanFlow.get(0) + ":8380/WEB3/ingreso.html");
        Assert.assertEquals(message.getErrorBrowser(), message.getTitlePageLogin(), driver.getTitle());
        util.screenshot(caseScreen, caseScreenLogin, driver);
    }

    public void closeSessionAndTypeUserPassword() throws Throwable {
        /* Forzar cierre de sesiones */
        driver.findElement(loginPage.getLinkMoreOptions()).click();
        driver.findElement(loginPage.getBtnForceClose()).click();
        util.screenshot(caseScreen, caseScreenLogin, driver);
        /* Ingreso de usuario y contraseña */
        driver.findElement(loginPage.getTxtUser()).sendKeys(loanFlow.get(1));
        driver.findElement(loginPage.getTxtPassword()).sendKeys(loanFlow.get(2));
        util.screenshot(caseScreen, caseScreenLogin, driver);
        driver.findElement(loginPage.getBtnSubmit()).submit();
            /* +Validaciones:
               Compruebo que la pantalla es el entorno FitBank */
        Assert.assertEquals(message.getErrorDataLogin(), message.getTitleFitbank(), driver.getTitle());
    }

    public void typeTransaction() throws Throwable {
        driver.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(3) + Keys.ENTER);
        util.waitPass(timeBase, "typeTransaction", driver);
        util.screenshot(caseScreen, caseScreenTx062100, driver);
        /* Deudor */
        driver.findElement(tr062100.getTxtId()).sendKeys(loanFlow.get(4) + Keys.ENTER);
        util.waitPass(timeBase, "idDeudor", driver);
        WebElement relation = driver.findElement(tr062100.getTxtRelationsText());
        Assert.assertEquals("Error", "DEUDOR", relation.getAttribute("value"));
        /* Codeudor */
        driver.findElement(tr062100.getTxtIdCod()).sendKeys(loanFlow.get(5) + Keys.ENTER);
        util.waitPass(timeBase, "idCodeudor Id", driver);
        driver.findElement(tr062100.getTxtRelationsCod()).sendKeys(loanFlow.get(6) + Keys.ENTER);
        util.waitPass(timeBase, "idCodeudor Cod", driver);
        WebElement relation1 = driver.findElement(tr062100.getTxtRelationsCodText());
        Assert.assertEquals("Error", "CODEUDOR", relation1.getAttribute("value"));
        /* Garante */
        driver.findElement(tr062100.getTxtIdGar()).sendKeys(loanFlow.get(7) + Keys.ENTER);
        util.waitPass(timeBase, "idGarante Id", driver);
        driver.findElement(tr062100.getTxtRelationsGar()).sendKeys(loanFlow.get(8) + Keys.ENTER);
        util.waitPass(timeBase, "idGarante Cod", driver);
        util.screenshot(caseScreen, caseScreenTx062100, driver);
        WebElement relation2 = driver.findElement(tr062100.getTxtRelationsGarText());
        Assert.assertEquals("Error", "GARANTE", relation2.getAttribute("value"));
    }

    public void productGroup() throws Throwable {
        driver.findElement(tr062100.getTxtProductGroup()).sendKeys(loanFlow.get(9) + Keys.ENTER);
        util.waitPass(timeBase, "productGroup", driver);
        /* Producto */
        driver.findElement(tr062100.getTxtProduct()).sendKeys(loanFlow.get(10) + Keys.ENTER);
        util.waitPass(timeBase, "product", driver);
        /* Identificacion Ejecutivo */
        driver.findElement(tr062100.getTxtIdExecutive()).sendKeys(loanFlow.get(11) + Keys.ENTER);
        util.waitPass(timeBase, "idExecutive", driver);
        /* Origen */
        driver.findElement(tr062100.getTxtOrigin()).sendKeys(loanFlow.get(12) + Keys.ENTER);
        util.waitPass(timeBase, "Origin", driver);
        /* Fondos de destino */
        driver.findElement(tr062100.getTxtDestinationFunds()).sendKeys(loanFlow.get(13) + Keys.ENTER);
        util.waitPass(timeBase, "destFunds", driver);
        /* Actividad Receptora*/
        driver.findElement(tr062100.getTxtReceptorActivity()).sendKeys(loanFlow.get(14) + Keys.ENTER);
        util.waitPass(timeBase, "recpActivity", driver);
    }

    public void amountCred() throws Throwable {
        driver.findElement(tr062100.getTxtAmountCredit()).sendKeys(loanFlow.get(15) + Keys.ENTER);
        util.waitPass(timeBase, "amountCred", driver);
        /* Frecuencia Capital */
        driver.findElement(tr062100.getTxtCapitalFrequency()).sendKeys(loanFlow.get(16) + Keys.ENTER);
        util.waitPass(timeBase, "capFrecuency", driver);
        /* Numero de Cuotas */
        driver.findElement(tr062100.getTxtNumberQuotas()).sendKeys(loanFlow.get(17) + Keys.ENTER);
        util.waitPass(timeBase, "numberQuotas", driver);
        util.screenshot(caseScreen, caseScreenTx062100, driver);
        /* Tasa de Interes */
        driver.findElement(tr062100.getBtnInterestRate()).click();
        util.waitPass(timeBase, "interestRate open", driver);
        util.screenshot(caseScreen, caseScreenTx062100, driver);
        Thread.sleep(700);
        driver.findElement(tr062100.getBtnCloseInterestRate()).click();
        util.waitPass(timeBase, "interestRate close", driver);
    }

    public void saveForm() throws Throwable {
        driver.findElement(tr062100.getSaveForm()).sendKeys(Keys.F12);
        util.waitPass(timeSave, "saveForm", driver);
        util.multipleValidate(driver);
        driver.findElement(tr062100.getNumberSoli()).click();
        requestNumber = driver.findElement(tr062100.getNumberSoli()).getAttribute("value");
        util.screenshot(caseScreen, caseScreenTx062100, driver);
    }

    public void typeTx062000() throws Throwable {
        driver.findElement(global.getBoxCodeTransaction()).clear();
        driver.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(18) + Keys.ENTER);
        util.waitPass(timeSave, "typeTx062000", driver);
        util.reactStartTransaction();
        driver.findElement(tr062000.getTxtNumberRequest()).sendKeys(requestNumber);
        util.screenshot(caseScreen, caseScreenTx062000, driver);
        driver.findElement(tr062000.getTxtNumberRequest()).sendKeys(Keys.ENTER);
        util.waitPass(timeMedium, "typeRequestNumber typeRequestNumber", driver);
        util.multipleValidate(driver);
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
        util.waitPass(timeBase, "typeGeographicalData País", driver);
            /* +Validaciones:
               Compruebo que se cargó el país */
        WebElement txtDgfCountryVal = driver.findElement(tr062000.getTxtDgfCountryVal());
        Assert.assertEquals(message.getErrorCountry(), message.getCountry(), txtDgfCountryVal.getAttribute("value"));
        /* Provincia */
        driver.findElement(tr062000.getTxtDgfState()).sendKeys(loanFlow.get(20) + Keys.ENTER);
        util.waitPass(timeBase, "typeGeographicalData Provincia", driver);
            /* +Validaciones:
               Compruebo que se cargó la provincia */
        WebElement txtDgfStateVal = driver.findElement(tr062000.getTxtDgfStateVal());
        Assert.assertEquals(message.getErrorState(), message.getState(), txtDgfStateVal.getAttribute("value"));
        /* Cantón */
        driver.findElement(tr062000.getTxtDgfCanton()).sendKeys(loanFlow.get(21) + Keys.ENTER);
        util.waitPass(timeBase, "typeGeographicalData Cantón", driver);
            /* +Validaciones:
               Compruebo que se cargó la provincia */
        WebElement txtDgfCantonVal = driver.findElement(tr062000.getTxtDgfCantonVal());
        Assert.assertEquals(message.getErrorCanton(), message.getCanton(), txtDgfCantonVal.getAttribute("value"));
        /* Parroquia */
        driver.findElement(tr062000.getTxtDgfParish()).sendKeys(loanFlow.get(22) + Keys.ENTER);
        util.waitPass(timeBase, "typeGeographicalData Parroquia", driver);
        util.screenshot(caseScreen, caseScreenTx062000, driver);
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
        util.waitPass(timeBase, "typeLoanDataAndComments Aplica Reajuste", driver);
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
        util.waitPass(timeBase, "typeLoanDataAndComments Forma De Pago", driver);
            /* +Validaciones:
               Compruebo que se cargó la forma de pago de DEBITO CTA */
        WebElement txtDpWayToPayVal = driver.findElement(tr062000.getTxtDpWayToPayVal());
        Assert.assertEquals(message.getErrorWayToPay(), message.getWayToPay(), txtDpWayToPayVal.getAttribute("value"));
        /* Débito A Cuenta */
        driver.findElement(tr062000.getTxtDpDebitToAccount()).sendKeys(loanFlow.get(25) + Keys.ENTER);
        util.waitPass(timeBase, "typeLoanDataAndComments Débito A Cuenta", driver);
            /* +Validaciones:
               Compruebo que se cargó la forma de pago de DEBITO CTA */
        WebElement txtDpDebitToAccountVal = driver.findElement(tr062000.getTxtDpDebitToAccountVal());
        Assert.assertEquals(message.getErrorDebitToAccount(), message.getDebitToAccount(), txtDpDebitToAccountVal.getAttribute("value"));
        /* Agregar Comentario */
        driver.findElement(tr062000.getTxtCommComment()).sendKeys(loanFlow.get(26));
        util.waitPass(timeBase, "typeLoanDataAndComments Forma De Pago", driver);
        util.screenshot(caseScreen, caseScreenTx062000, driver);
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
        util.waitPass(timeSave, "saveTransaction saveTransaction", driver);
        util.multipleValidate(driver);
    }

    public void tabWarranty() throws Throwable {
        util.reactPage();
        driver.findElement(tr062000.getTabWarranty()).click();
        util.waitPass(timeMedium, "Tab Warranty", driver);
        util.screenshot(caseScreen, caseScreenTx062008, driver);
        util.multipleValidate(driver);
    }

    public void warrantyProp() throws Throwable {
        util.reactTypeData();
        driver.findElement(tr062008.getWarrantyProp()).sendKeys(loanFlow.get(27) + Keys.ENTER);
        util.waitPass(timeMedium, "warrantyPro identificacion", driver);
        WebElement txtIdEjec = driver.findElement(tr062008.getWarrantyProp());
        Assert.assertEquals(message.getErrorIdEjec(), message.getIdEjec(), txtIdEjec.getAttribute("value"));
        driver.findElement((tr062008.getTxtTypeWarranty())).sendKeys(loanFlow.get(28) + Keys.ENTER);
        util.waitPass(timeMedium, "Type Garantía", driver);
        driver.findElement((tr062008.getTxtTypeGoods())).sendKeys(loanFlow.get(29) + Keys.ENTER);
        util.waitPass(timeMedium, "Bien", driver);
        driver.findElement((tr062008.getTxtValueComercial())).sendKeys(loanFlow.get(30) + Keys.ENTER);
        util.waitPass(timeMedium, "Value Comercial", driver);
        driver.findElement((tr062008.getChkOpen())).click();
        util.waitPass(timeMedium, "Bien Adquirido", driver);
        driver.findElement((tr062008.getTxtDescription())).sendKeys(loanFlow.get(31) + Keys.ENTER);
        util.waitPass(timeMedium, "Description", driver);
        util.screenshot(caseScreen, caseScreenTx062008, driver);
    }

    public void selectPrintDocuments() throws Throwable {
        util.reactPage();
        WebElement mainPrintDocuments = driver.findElement(tr062016.getTabMainPrintDocuments());
        mainPrintDocuments.click();
        util.waitPass(timeBase, "selectPrintDocuments", driver);
        util.screenshot(caseScreen, caseScreenTx062016, driver);
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
        util.screenshot(caseScreen, caseScreenTx062016, driver);
    }

    public void validateOrder() throws Throwable {
        driver.findElement(global.getBoxCodeTransaction()).clear();
        driver.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(32) + Keys.ENTER);
        util.waitPass(timeBase, "typeTransaction", driver);
        util.screenshot(caseScreen, caseScreenTx000267, driver);
            /* +Validaciones:
               Comprobar que esté en el ventana de Consulta de Reportes Generados en Batch - FitBank */
        Assert.assertEquals(message.getErrorTx000267(), message.getTitleQueryReport(), driver.getTitle());
    }

    public void queryOrder() throws Throwable {
        util.reactPage();
        WebElement query = driver.findElement(global.getBtnF7());
        query.click();
        util.waitPass(timeSave, "queryOrder", driver);
        util.multipleValidate(driver);
        util.screenshot(caseScreen, caseScreenTx000267, driver);
            /* +Validaciones:
               Comprobar que se hayan cargado los datos */
        WebElement test = driver.findElement(tr000267.getTxtCrgbUser());
        Assert.assertEquals(message.getErrorGeneral(), loanFlow.get(1), test.getAttribute("value"));
    }

    public void typeTxt063071() throws Throwable {
        driver.findElement(global.getBoxCodeTransaction()).clear();
        driver.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(33) + Keys.ENTER);
        util.waitPass(timeSave, "typeTx063071", driver);
        util.reactStartTransaction();
        driver.findElement(tr063071.getTxtNumSoli()).sendKeys(requestNumber);
        util.screenshot(caseScreen, caseScreenTx063071, driver);
        driver.findElement(tr063071.getTxtNumSoli()).sendKeys(Keys.ENTER);
        util.waitPass(timeMedium, "typeRequestNumber typeRequestNumber", driver);
    }

    public void checkList() throws Throwable {
        List<WebElement> tablePrint = driver.findElements(tr063071.getTbCheckList());
        for (int i = 1; i <= tablePrint.size(); i++) {
            String checkLists = tr063071.getChkPart1() + i + tr063071.getChkPart2();
            WebElement columnChecks = driver.findElement(By.xpath(checkLists));
            if (columnChecks.isEnabled()) {
                columnChecks.click();
                util.waitPass(timeBase, "Checks List", driver);
            } else {
                break;
            }
        }
        driver.findElement(tr063071.getBtnSaveChkList()).click();
        util.waitPass(timeSave, "Checks Save", driver);
        util.multipleValidate(driver);
        util.screenshot(caseScreen, caseScreenTx063071, driver);
    }

    public void typeTransaction3040() throws Throwable {
        util.reactPage();
        driver.findElement(global.getBoxCodeTransaction()).clear();
        driver.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(34) + Keys.ENTER);
        util.waitPass(timeBase, "typeTransaction3040", driver);
        util.screenshot(caseScreen, caseScreenTx063040, driver);
            /* +Validaciones:
               Comprobar que esté en el ventana de ANÁLISIS DE CRÉDITO - FitBank */
        Assert.assertEquals(message.getErrorTx063040(), message.getTitleCreditAnalysis(), driver.getTitle());
    }

    public void typeRequestNumberAnalysis() throws Throwable {
        util.reactTypeData();
        driver.findElement(tr063040.getTxtRequestNumber()).sendKeys(requestNumber + Keys.ENTER);
        util.waitPass(timeMedium, "typeRequestNumberAnalysis", driver);
        util.screenshot(caseScreen, caseScreenTx063040, driver);
            /* +Validaciones:
               Comprobar que los datos hayan sido cargados */
        WebElement txtGpProductValue = driver.findElement(tr063040.getTxtGpProductValue());
        Assert.assertEquals(message.getErrorGeneral(), loanFlow.get(9), txtGpProductValue.getAttribute("value"));
    }

    public void typeComment() throws Throwable {
        driver.findElement(tr063040.getTxtDoComment()).sendKeys(loanFlow.get(35));
        util.waitPass(timeBase, "typeComment", driver);
        util.screenshot(caseScreen, caseScreenTx063040, driver);
        util.multipleValidate(driver);
    }

    public void creditAnalysis() throws Throwable {
        driver.findElement(tr063078.getTabAnalysisCred()).click();
        util.waitPass(timeBase, "Riego Indirecto", driver);
        WebElement indirectRisk = driver.findElement(tr063078.getTxtIndirectRisk());
        util.multipleValidate(driver);
        if (indirectRisk.isEnabled()) {
            driver.findElement(tr063078.getTxtSubsCancel()).sendKeys(loanFlow.get(36) + Keys.ENTER);
            util.screenshot(caseScreen, caseScreenTx063078, driver);
            util.waitPass(timeBase, "SusbsCancel", driver);
        }
        driver.findElement(tr063078.getTabActPasiv()).click();
        util.waitPass(timeBase, "Pasar Activo Pasivo", driver);
    }

    public void activPasiv() throws Throwable {
        String patrimony = driver.findElement(tr063078.getTxtPatrimony()).getAttribute("value");
        driver.findElement(tr063078.getTxtConfirmedPatr()).sendKeys(patrimony + Keys.ENTER);
        util.waitPass(timeBase, "Activo Pasivo", driver);
        driver.findElement(tr063078.getAtxtComment()).sendKeys(loanFlow.get(37));
        util.waitPass(timeSave, "Check Update Balance", driver);
        driver.findElement(tr063078.getChkUpdtaBalance()).click();
        util.screenshot(caseScreen, caseScreenTx063078, driver);
    }

    public void selectPolicyCompliance() throws Throwable {
        util.reactPage();
        WebElement tabPolicyCompliance = driver.findElement(tr063080.getTabPolicyCompliance());
        tabPolicyCompliance.click();
        util.waitPass(timeBase, "selectPolicyCompliance", driver);
        util.screenshot(caseScreen, caseScreenTx063080, driver);
            /* +Validaciones:
               Comprobar que esté en el ventana de CUMPLIMIENTO DE POLITICAS */
        WebElement lblCpTitle = driver.findElement(tr063080.getLblCpTitle());
        Assert.assertEquals(message.getErrorTx063080(), message.getTitlePolicyCompliance(), lblCpTitle.getText());
    }

    public void completePolicyCompliance() throws Throwable {
        util.multipleValidate(driver);
        /* Checks */
        if (loanFlow.get(38).equalsIgnoreCase("Sí") || loanFlow.get(38).equalsIgnoreCase("Si")) {
            driver.findElement(tr063080.getChkCpAntiquity()).click();
        }
        if (loanFlow.get(39).equalsIgnoreCase("Sí") || loanFlow.get(39).equalsIgnoreCase("Si")) {
            driver.findElement(tr063080.getChkCpCreditHistory()).click();
        }
        if (loanFlow.get(40).equalsIgnoreCase("Sí") || loanFlow.get(40).equalsIgnoreCase("Si")) {
            driver.findElement(tr063080.getChkCpValidationAnalysis()).click();
        }
        util.screenshot(caseScreen, caseScreenTx063080, driver);
        /* Comentario */
        driver.findElement(tr063080.getTxtCpComment()).sendKeys(loanFlow.get(41));
        util.waitPass(timeBase, "completePolicyCompliance Comment", driver);
        util.screenshot(caseScreen, caseScreenTx063080, driver);
    }

    public void completeAdditionalPolicies() throws Throwable {
        util.reactPage();
        driver.findElement(tr063080.getTabCpAditionalPolicies()).click();
        util.waitPass(timeSave, "completeAdditionalPolicies", driver);
        util.screenshot(caseScreen, caseScreenTx063080, driver);
        /* Cumple Política De Garantías */
        if (loanFlow.get(42).equalsIgnoreCase("Sí") || loanFlow.get(42).equalsIgnoreCase("Si")) {
            driver.findElement(tr063080.getChkCpGuaranteePolicy()).click();
        }
        if (loanFlow.get(43).equalsIgnoreCase("Sí") || loanFlow.get(43).equalsIgnoreCase("Si")) {
            driver.findElement(tr063080.getTxtCpCoverage()).click();
        }
        if (loanFlow.get(44).equalsIgnoreCase("Sí") || loanFlow.get(44).equalsIgnoreCase("Si")) {
            driver.findElement(tr063080.getChkCpDocumentaryRequirements()).click();
        }
        util.screenshot(caseScreen, caseScreenTx063080, driver);
        if (loanFlow.get(45).equalsIgnoreCase("Sí") || loanFlow.get(45).equalsIgnoreCase("Si")) {
            driver.findElement(tr063080.getChkCpPaymentCapacity()).click();
        }
        if (loanFlow.get(46).equalsIgnoreCase("Sí") || loanFlow.get(46).equalsIgnoreCase("Si")) {
            driver.findElement(tr063080.getChkCpBorrowingLimit()).click();
        }
        if (loanFlow.get(47).equalsIgnoreCase("Sí") || loanFlow.get(47).equalsIgnoreCase("Si")) {
            driver.findElement(tr063080.getChkCpSubmitApproval()).click();
        }
        util.screenshot(caseScreen, caseScreenTx063080, driver);
    }

    public void openNewBrowserIncognito() throws Throwable {
        util.screenshot(caseScreen, caseScreenTx063080, driver);
        WebElement statustNotification = driver.findElement(global.getTxtStatus());
        String txtStatus = statustNotification.getText();
        userIncognit = txtStatus.substring(txtStatus.indexOf(":") + 1, txtStatus.indexOf("NOMBRE")).trim();
        util.options.addArguments("-incognito");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, util.options);
        util.driverIncognito = new ChromeDriver(capabilities);
        util.driverIncognito.manage().window().maximize();
        util.driverIncognito.get("http://" + loanFlow.get(0) + ":8380/WEB3/ingreso.html");
        util.screenshot(caseScreen, caseScreenIncognitoLogin, util.driverIncognito);
    }

    public void incognitoCloseSessionAndTypeUserPassword() throws Throwable {
        util.reactPage();
        /* Forzar cierre de sesiones */
        util.driverIncognito.findElement(loginPage.getLinkMoreOptions()).click();
        util.driverIncognito.findElement(loginPage.getBtnForceClose()).click();
        util.screenshot(caseScreen, caseScreenIncognitoLogin, util.driverIncognito);
        /* Ingreso de usuario y contraseña */
        //Quemar BA01003274 y comentar la linea 424
        util.driverIncognito.findElement(loginPage.getTxtUser()).sendKeys(userIncognit);
        util.driverIncognito.findElement(loginPage.getTxtPassword()).sendKeys(loanFlow.get(2));
        util.screenshot(caseScreen, caseScreenIncognitoLogin, util.driverIncognito);
        util.driverIncognito.findElement(loginPage.getBtnSubmit()).submit();
            /* +Validaciones:
               Compruebo que la pantalla es el entorno FitBank */
        Assert.assertEquals(message.getErrorDataLogin(), message.getTitleFitbank(), util.driverIncognito.getTitle());
    }

    public void authMailBox() throws Throwable {
        util.driverIncognito.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(48) + Keys.ENTER);
        util.waitPass(timeSave, "completeAdditionalPolicies", util.driverIncognito);
        util.driverIncognito.findElement(tr002008.getTxtTransaction()).sendKeys(loanFlow.get(49) + Keys.TAB);
        util.waitPass(timeMedium, "authMailBox", util.driverIncognito);
        util.screenshot(caseScreen, caseScreenTx002008, util.driverIncognito);
        /*Genero una lista de elementos para poder sacar el tamaño total de la tabla*/
        List<WebElement> tablePrint = util.driverIncognito.findElements(tr002008.getTblTransaction());
        /* Capturo el ultimo valor de la tabla */
        int numColu = tablePrint.size()-1;
        String numColTrans = tr002008.columTransaction() + ( numColu + 1 ) + tr002008.columTransaction2();
        WebElement transation = util.driverIncognito.findElement(By.xpath(numColTrans));
        transation.click();
        util.waitPass(timeSave, "Open Link", util.driverIncognito);
        util.screenshot(caseScreen, caseScreenTx002008, util.driverIncognito);
        /* Se cierra después de terminar el proceso en modo incógnito */
        Thread.sleep(3000);
        util.driverIncognito.close();

        /* Vuelve a la página principal */
        util.reactPage();
        driver.findElement(global.getBoxCodeTransaction()).clear();
        driver.findElement(global.getBoxCodeTransaction()).sendKeys("06-2100" + Keys.ENTER);
        util.waitPass(timeBase, "typeTransaction", driver);
    }























    public void typeRiskAnalysisApproval() throws Throwable {
        util.reactPage();
        util.driverIncognito.findElement(global.getBoxCodeTransaction()).clear();
        util.driverIncognito.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(50) + Keys.ENTER);
        util.waitPass(timeBase, "typeRiskAnalysisApproval", util.driverIncognito);
        /* +Validaciones:
               Comprobar que esté en el ventana de CUMPLIMIENTO DE POLITICAS */
        Assert.assertEquals(message.getErrorTx062033(), message.getTitleRiskAnalysisApproval(), util.driverIncognito.getTitle());
        /* Número de Solicitud */
        util.driverIncognito.findElement(tr062033.getTxtRequestNumber()).sendKeys(requestNumber);
        util.screenshot(caseScreen, caseScreenTx062033, util.driverIncognito);
        util.driverIncognito.findElement(tr062033.getTxtRequestNumber()).sendKeys(Keys.ENTER);
        util.waitPass(timeMedium, "typeRiskAnalysisApproval Número de solicitud", util.driverIncognito);
        util.multipleValidate(util.driverIncognito);
        util.screenshot(caseScreen, caseScreenTx062033, util.driverIncognito);
        /* Comentario */
        util.driverIncognito.findElement(tr062033.getTxtAarComment()).sendKeys(loanFlow.get(51));
        /* Aprobar */
        util.driverIncognito.findElement(tr062033.getBtnAarRiskAnalysisApproval()).click();
        util.waitPass(timeSave, "typeRiskAnalysisApproval Aprobar", util.driverIncognito);
        util.multipleValidate(util.driverIncognito);
        util.screenshot(caseScreen, caseScreenTx062033, util.driverIncognito);
        /* Se cierra después de terminar el proceso en modo incógnito */
        util.driverIncognito.close();
    }

    public void generateCreditNumber() throws Throwable {
        /* Vuelve a la página principal */
        util.reactPage();
        driver.findElement(global.getBoxCodeTransaction()).clear();
        driver.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(52) + Keys.ENTER);
        util.waitPass(timeBase, "generateCreditNumber", driver);
        /* +Validaciones:
               Comprobar que esté en el ventana de CUMPLIMIENTO DE POLITICAS */
        Assert.assertEquals(message.getErrorTx062001(), message.getTitleRiskRequestApproval(), util.driverIncognito.getTitle());
        /* Número de Solicitud */
        driver.findElement(tr062001.getTxtRequestNumber()).sendKeys(requestNumber);
        util.screenshot(caseScreen, caseScreenTx062001, driver);
        driver.findElement(tr062001.getTxtRequestNumber()).sendKeys(Keys.ENTER);
        util.waitPass(timeMedium, "generateCreditNumber Número de solicitud", driver);
        util.multipleValidate(driver);
        util.screenshot(caseScreen, caseScreenTx062001, driver);
    }
}
