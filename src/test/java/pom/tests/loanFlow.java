package pom.tests;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pom.pages.StartPages;
import java.io.IOException;
import java.util.List;

public class loanFlow extends StartPages {

    public loanFlow() throws IOException {
    }

    public void openBrowser() throws Throwable {
        caseScreen++;
        driver.get("http://" + loanFlow.get(0) + ":8380/WEB3/ingreso.html");
        /* Validación: Compruebo que la pantalla es el Ingreso */
        Assert.assertEquals(message.getErrorBrowser(), message.getTitlePageLogin(), driver.getTitle());
    }

    public void closeSessionAndTypeUserPassword() throws Throwable {
        this.login(driver, loanFlow.get(1), caseScreenLogin);
        /* Validación: Compruebo que la pantalla es el entorno FitBank */
        Assert.assertEquals(message.getErrorDataLogin(), message.getTitleFitbank(), driver.getTitle());
    }

    public void typeDebtorDataProductDataLoan() throws Throwable {
        /* Ingresar a la transacción 06-2100 */
        driver.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(3) + Keys.ENTER);
        util.waitPass(timeLong, "typeDebtorDataProductDataLoan Transacción 06-2100", driver);
        /* Validación: Compruebo que la pantalla es SIMULACIÓN DE PRÉSTAMOS - FitBank */
        Assert.assertEquals(message.getErrorTx062100(), message.getTitleLoanSimulation(), driver.getTitle());
        /* DEUDOR-CODEUDOR Y GARANTES */
        /* Deudor, siempre será el primero de la fila */
        driver.findElement(tr062100.getTxtId()).sendKeys(loanFlow.get(4) + Keys.ENTER);
        util.waitPass(timeMedium, "typeDebtorDataProductDataLoan Deudor id", driver);
        /* Opcionales: Codeudor y Garante */
        if (loanFlow.get(5).length() > 0) {
            /* Fila 2 */
            driver.findElement(tr062100.getTxtIdCod()).sendKeys(loanFlow.get(5) + Keys.ENTER);
            util.waitPass(timeMedium, "typeDebtorDataProductDataLoan Codeudor Id", driver);
            driver.findElement(tr062100.getTxtRelationsCod()).sendKeys(loanFlow.get(6) + Keys.ENTER);
            util.waitPass(timeMedium, "typeDebtorDataProductDataLoan Codeudor Relación", driver);
        }
        if (loanFlow.get(7).length() > 0) {
            /* Fila 3 */
            driver.findElement(tr062100.getTxtIdGar()).sendKeys(loanFlow.get(7) + Keys.ENTER);
            util.waitPass(timeMedium, "typeDebtorDataProductDataLoan Garante Id", driver);
            driver.findElement(tr062100.getTxtRelationsGar()).sendKeys(loanFlow.get(8) + Keys.ENTER);
            util.waitPass(timeMedium, "typeDebtorDataProductDataLoan Garante Relación", driver);
        }
        util.screenshot(caseScreen, caseScreenTx062100, driver);
        /* Validación: Que se haya cargado el deudor */
        WebElement relationDebtor = driver.findElement(tr062100.getTxtRelationsText());
        Assert.assertEquals(message.getErrorGeneral(), message.getDebtor(), relationDebtor.getAttribute("value"));
        /* DATOS DEL PRODUCTO */
        /* Grupo de Producto */
        driver.findElement(tr062100.getTxtProductGroup()).sendKeys(loanFlow.get(9) + Keys.ENTER);
        util.waitPass(timeMedium, "typeDebtorDataProductDataLoan Grupo de producto", driver);
        /* Producto */
        driver.findElement(tr062100.getTxtProduct()).sendKeys(loanFlow.get(10) + Keys.ENTER);
        util.waitPass(timeMedium, "typeDebtorDataProductDataLoan Producto", driver);
        /* Identificacion Ejecutivo */
        driver.findElement(tr062100.getTxtIdExecutive()).sendKeys(loanFlow.get(11) + Keys.ENTER);
        util.waitPass(timeMedium, "typeDebtorDataProductDataLoan Ejecutivo", driver);
        /* Origen */
        driver.findElement(tr062100.getTxtOrigin()).sendKeys(loanFlow.get(12) + Keys.ENTER);
        util.waitPass(timeMedium, "typeDebtorDataProductDataLoan Origen", driver);
        /* Fondos de destino */
        driver.findElement(tr062100.getTxtDestinationFunds()).sendKeys(loanFlow.get(13) + Keys.ENTER);
        util.waitPass(timeMedium, "typeDebtorDataProductDataLoan Fondos de destino", driver);
        /* Actividad Receptora */
        driver.findElement(tr062100.getTxtReceptorActivity()).sendKeys(loanFlow.get(14) + Keys.ENTER);
        util.waitPass(timeMedium, "typeDebtorDataProductDataLoan Actividad Receptora", driver);
        /* DATOS DEL PRÉSTAMO */
        /* Monto del Crédito */
        driver.findElement(tr062100.getTxtAmountCredit()).sendKeys(loanFlow.get(15) + Keys.ENTER);
        util.waitPass(timeMedium, "typeDebtorDataProductDataLoan Monto del Crédito", driver);
        /* Frecuencia Capital */
        driver.findElement(tr062100.getTxtCapitalFrequency()).sendKeys(loanFlow.get(16) + Keys.ENTER);
        util.waitPass(timeMedium, "typeDebtorDataProductDataLoan Frecuencia Capital", driver);
        /* Número de Cuotas */
        driver.findElement(tr062100.getTxtNumberQuotas()).sendKeys(loanFlow.get(17) + Keys.ENTER);
        util.waitPass(timeMedium, "typeDebtorDataProductDataLoan Número de Cuotas", driver);
        util.screenshot(caseScreen, caseScreenTx062100, driver);
        /* Tasa de Interés */
        driver.findElement(tr062100.getBtnInterestRate()).click();
        util.waitPass(timeMedium, "typeDebtorDataProductDataLoan Abrir modal", driver);
        util.screenshot(caseScreen, caseScreenTx062100, driver);
        util.openModal();
        driver.findElement(tr062100.getBtnCloseInterestRate()).click();
        util.waitPass(timeMedium, "typeDebtorDataProductDataLoan Cerrar modal", driver);
    }

    public void typeDataGeographicalDataLoanComment() throws Throwable {
        /* Extraer el número de solicitud */
        driver.findElement(tr062100.getNumberSoli()).click();
        requestNumber = driver.findElement(tr062100.getNumberSoli()).getAttribute("value");
        util.screenshot(caseScreen, caseScreenTx062100, driver);
        /* Ir a la transacción 06-2000 */
        driver.findElement(global.getBoxCodeTransaction()).clear();
        driver.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(18) + Keys.ENTER);
        util.waitPass(timeLong, "typeDataGeographicalDataLoanComment Ir a la transacción 06-2000", driver);
        util.multipleValidate(driver);
        /* Validación: Estar en la pantalla de INGRESO Y MANTENIMIENTO DE SOLICITUDES PRÉSTAMOS - FitBank */
        Assert.assertEquals(message.getErrorTx062000(), message.getTitleEntryAndMaintenance(), driver.getTitle());
        /* Ingresar el número de solicitud */
        driver.findElement(tr062000.getTxtNumberRequest()).sendKeys(requestNumber);
        driver.findElement(tr062000.getTxtNumberRequest()).sendKeys(Keys.ENTER);
        util.waitPass(timeLong, "typeDataGeographicalDataLoanComment Ingresar el número de solicitud", driver);
        util.multipleValidate(driver);
        /* DATOS GEOGRÁFICOS */
        /* País */
        driver.findElement(tr062000.getTxtDgfCountry()).sendKeys(loanFlow.get(19) + Keys.ENTER);
        util.waitPass(timeMedium, "typeDataGeographicalDataLoanComment País", driver);
        /* Provincia */
        driver.findElement(tr062000.getTxtDgfState()).sendKeys(loanFlow.get(20) + Keys.ENTER);
        util.waitPass(timeMedium, "typeDataGeographicalDataLoanComment Provincia", driver);
        /* Cantón */
        driver.findElement(tr062000.getTxtDgfCanton()).sendKeys(loanFlow.get(21) + Keys.ENTER);
        util.waitPass(timeMedium, "typeDataGeographicalDataLoanComment Cantón", driver);
        /* Parroquia */
        driver.findElement(tr062000.getTxtDgfParish()).sendKeys(loanFlow.get(22) + Keys.ENTER);
        util.waitPass(timeMedium, "typeDataGeographicalDataLoanComment Parroquia", driver);
        util.screenshot(caseScreen, caseScreenTx062000, driver);
        /* DATOS DEL PRÉSTAMO */
        /* Aplica Reajuste */
        if (loanFlow.get(23).equalsIgnoreCase("No")) {
            driver.findElement(tr062000.getChkDpReadjustment()).click();
        }
        util.waitPass(timeMedium, "typeDataGeographicalDataLoanComment Aplica Reajuste", driver);
        /* Forma De Pago */
        driver.findElement(tr062000.getTxtDpWayToPay()).sendKeys(loanFlow.get(24) + Keys.ENTER);
        util.waitPass(timeMedium, "typeDataGeographicalDataLoanComment Forma De Pago", driver);
        if (loanFlow.get(24).equalsIgnoreCase("DEB")) {
            /* Débito A Cuenta */
            driver.findElement(tr062000.getTxtDpDebitToAccount()).sendKeys(loanFlow.get(25) + Keys.ENTER);
            util.waitPass(timeMedium, "typeDataGeographicalDataLoanComment Débito A Cuenta", driver);
        }
        /* COMENTARIO */
        driver.findElement(tr062000.getTxtCommComment()).sendKeys(loanFlow.get(26) + Keys.TAB);
        util.waitPass(timeMedium, "typeDataGeographicalDataLoanComment Forma De Pago", driver);
        util.screenshot(caseScreen, caseScreenTx062000, driver);
    }

    public void generateReport() throws Throwable {
        WebElement generateReport = driver.findElement(tr062000.getBtnVlcGenerateReport());
        generateReport.click();
        util.switchPages(0, "no");
        /* Validación: Comprobar que esté en la ventana principal después de abrir la pestaña de reporte */
        Assert.assertEquals(message.getErrorMainView(), message.getTitleIncoMainLoan(), driver.getTitle());
    }

    public void saveTransaction() throws Throwable {
        this.saveFormGeneral(driver);
    }

    public void tabWarrantyProposed() throws Throwable {
        util.reactPage();
        /* Pestaña de Garantías */
        driver.findElement(tr062000.getTabWarranty()).click();
        util.waitPass(timeLong, "tabWarrantyProposed Pestaña", driver);
        util.multipleValidate(driver);
        /* Validación: Comprobar que esté en la ventana de INGRESO Y MANTENIMIENTO DE GARANTIAS - FitBank */
        Assert.assertEquals(message.getErrorWarranty(), message.getTitleIncomeAndMaintenanceGuarantees(), driver.getTitle());
        /* GARANTÍAS PROPUESTAS */
        util.reactTypeData();
        /* Identificación */
        driver.findElement(tr062008.getWarrantyProp()).sendKeys(loanFlow.get(27) + Keys.ENTER);
        util.waitPass(timeMedium, "tabWarrantyProposed id", driver);
        /* Tipo de Garantía */
        driver.findElement((tr062008.getTxtTypeWarranty())).sendKeys(loanFlow.get(28) + Keys.ENTER);
        util.waitPass(timeMedium, "tabWarrantyProposed Tipo de Garantía", driver);
        /* Tipo de Bien */
        driver.findElement((tr062008.getTxtTypeGoods())).sendKeys(loanFlow.get(29) + Keys.ENTER);
        util.waitPass(timeMedium, "tabWarrantyProposed Tipo de Bien", driver);
        /* Valor Comercial */
        driver.findElement((tr062008.getTxtValueComercial())).sendKeys(loanFlow.get(30) + Keys.ENTER);
        util.waitPass(timeMedium, "tabWarrantyProposed Valor Comercial", driver);
        /* Abierta */
        driver.findElement((tr062008.getChkOpen())).click();
        util.waitPass(timeMedium, "tabWarrantyProposed Abierta", driver);
        /* Descripción */
        driver.findElement((tr062008.getTxtDescription())).sendKeys(loanFlow.get(31) + Keys.ENTER);
        util.waitPass(timeMedium, "tabWarrantyProposed Descripción", driver);
        util.screenshot(caseScreen, caseScreenTx062008, driver);
    }

    public void tabPrintDocuments() throws Throwable {
        util.reactPage();
        /* Pestaña de Impresión de Documentos */
        WebElement mainPrintDocuments = driver.findElement(tr062016.getTabMainPrintDocuments());
        mainPrintDocuments.click();
        util.waitPass(timeLong, "selectPrintDocuments", driver);
        /* Validación: Comprobar que esté en la ventana de IMPRESIÓN DE DOCUMENTOS - FitBank */
        Assert.assertEquals(message.getErrorTx062016(), message.getTitlePrintDocuments(), driver.getTitle());
    }

    public void generateReportCheklistReportOperation() throws Throwable {
        /* Descargar el reporte de la transacción 06-2000 */
        util.switchPDF();
        util.reactPage();
        /* Descargar el reporte de checklist */
        WebElement btnChklReport = driver.findElement(tr062016.getBtnChklReport());
        btnChklReport.click();
        util.switchPages(4000, "yes");
        util.reactPage();
        /* Descargar el reporte de orden de crédito */
        WebElement btnOperationOrder = driver.findElement(tr062016.getBtnOperationOrder());
        btnOperationOrder.click();
        util.switchPages(4000, "yes");
        util.screenshot(caseScreen, caseScreenTx062016, driver);
    }

    public void validateOrder() throws Throwable {
        /* Ingresar a la transacción 00-0267 */
        driver.findElement(global.getBoxCodeTransaction()).clear();
        driver.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(32) + Keys.ENTER);
        util.waitPass(timeLong, "validateOrder Ingresar a la transacción 00-0267", driver);
        util.multipleValidate(driver);
        /* Validación: Comprobar que esté en la ventana de Consulta de Reportes Generados en Batch - FitBank */
        Assert.assertEquals(message.getErrorTx000267(), message.getTitleQueryReport(), driver.getTitle());
        util.reactPage();
        WebElement query = driver.findElement(global.getBtnF7());
        query.click();
        util.waitPass(timeLong, "validateOrder F7", driver);
        util.multipleValidate(driver);
        util.screenshot(caseScreen, caseScreenTx000267, driver);
    }

    public void pressChecksAndSave() throws Throwable {
        /* Ingresar a la transacción 06-3071 */
        util.reactPage();
        driver.findElement(global.getBoxCodeTransaction()).clear();
        driver.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(33) + Keys.ENTER);
        util.waitPass(timeLong, "pressChecksAndSave Ingresar a la transacción 06-3071", driver);
        util.multipleValidate(driver);
        /* Validación: Comprobar que esté en el ventana de VERIFICACIÓN DE INFORMACIÓN POR SOLICITUD - FitBank */
        Assert.assertEquals(message.getErrorTx063071(), message.getTitleVerifyInformation(), driver.getTitle());
        /* Ingreso el número de solicitud */
        driver.findElement(tr063071.getTxtNumSoli()).sendKeys(requestNumber);
        util.screenshot(caseScreen, caseScreenTx063071, driver);
        driver.findElement(tr063071.getTxtNumSoli()).sendKeys(Keys.ENTER);
        util.waitPass(timeMedium, "pressChecksAndSave Ingreso el número de solicitud", driver);
        /* Marcar los checklist */
        List<WebElement> tablePrint = driver.findElements(tr063071.getTbCheckList());
        for (int i = 1; i <= tablePrint.size(); i++) {
            String checkLists = tr063071.getChkPart1() + i + tr063071.getChkPart2();
            WebElement columnChecks = driver.findElement(By.xpath(checkLists));
            if (columnChecks.isEnabled()) {
                columnChecks.click();
                util.waitPass(timeMedium, "pressChecksAndSave check", driver);
            } else {
                break;
            }
        }
        driver.findElement(tr063071.getBtnSaveChkList()).click();
        util.waitPass(timeLong, "pressChecksAndSave Guardar", driver);
        util.multipleValidate(driver);
        util.screenshot(caseScreen, caseScreenTx063071, driver);
    }

    public void typeComment() throws Throwable {
        /* Ingresar a la transacción 06-3040 */
        util.reactPage();
        driver.findElement(global.getBoxCodeTransaction()).clear();
        driver.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(34) + Keys.ENTER);
        util.waitPass(timeLong, "typeComment Ingresar a la transacción 06-3040", driver);
        /* Validación: Comprobar que esté en la ventana de ANÁLISIS DE CRÉDITO - FitBank */
        Assert.assertEquals(message.getErrorTx063040(), message.getTitleCreditAnalysis(), driver.getTitle());
        util.reactTypeData();
        /* Ingresar el número de solicitud */
        WebElement txtRequestNumber = driver.findElement(tr063040.getTxtRequestNumber());
        txtRequestNumber.sendKeys(requestNumber);
        util.reactPageOp2();
        txtRequestNumber.sendKeys(Keys.TAB);
        util.waitPass(timeLong, "typeComment Ingresar el número de solicitud", driver);
        util.multipleValidate(driver);
        util.screenshot(caseScreen, caseScreenTx063040, driver);
        /* Validación: Comprobar que los datos hayan sido cargados */
        WebElement txtGpProductValue = driver.findElement(tr063040.getTxtGpProductValue());
        Assert.assertEquals(message.getErrorGeneral(), loanFlow.get(9), txtGpProductValue.getAttribute("value"));
        util.reactPageOp2();
        /* Comentario */
        driver.findElement(tr063040.getTxtDoComment()).sendKeys(loanFlow.get(35) + Keys.TAB);
        util.waitPass(timeLong, "typeComment Comentario", driver);
        util.multipleValidate(driver);
        util.screenshot(caseScreen, caseScreenTx063040, driver);
    }

    public void typeValuesRiskActivesPasives() throws Throwable {
        driver.findElement(tr063078.getTabAnalysisCred()).click();
        util.waitPass(timeLong, "Riego Indirecto", driver);
        util.multipleValidate(driver);
        /* Validación: Comprobar que esté en la pestaña de ANÁLISIS DE CRÉDITO - FitBank */
        WebElement tabTitleCreditAnaysis = driver.findElement(tr063078.getLblAnalysisCred());
        Assert.assertEquals(message.getErrorTx063078(), message.getTabRiskBehavior(), tabTitleCreditAnaysis.getText());
        /* Riesgos */
        WebElement indirectRisk = driver.findElement(tr063078.getTxtIndirectRisk());
        if (indirectRisk.isEnabled()) {
            driver.findElement(tr063078.getTxtSubsCancel()).sendKeys(loanFlow.get(36) + Keys.ENTER);
            util.waitPass(timeMedium, "creditAnalysis Riesgos", driver);
            util.screenshot(caseScreen, caseScreenTx063078, driver);
        }
        /* Activos - Pasivos */
        driver.findElement(tr063078.getTabActPasiv()).click();
        util.waitPass(timeLong, "creditAnalysis Activo-Pasivo", driver);
        String patrimony = driver.findElement(tr063078.getTxtPatrimony()).getAttribute("value");
        driver.findElement(tr063078.getTxtConfirmedPatr()).sendKeys(patrimony + Keys.ENTER);
        util.waitPass(timeMedium, "creditAnalysis patrimony", driver);
        driver.findElement(tr063078.getAtxtComment()).sendKeys(loanFlow.get(37));
        util.waitPass(timeLong, "creditAnalysis Update Balance", driver);
        driver.findElement(tr063078.getChkUpdtaBalance()).click();
        util.screenshot(caseScreen, caseScreenTx063078, driver);
    }

    public void pressChecksPoliticsComment() throws Throwable {
        util.reactPage();
        /* Ir a la pestaña de Cumplimiento De Políticas */
        WebElement tabPolicyCompliance = driver.findElement(tr063080.getTabPolicyCompliance());
        tabPolicyCompliance.click();
        util.waitPass(timeLong, "pressChecksPoliticsComment", driver);
        util.multipleValidate(driver);
        /* Validación: Comprobar que esté en la pestaña de CUMPLIMIENTO DE POLITICAS */
        WebElement lblCpTitle = driver.findElement(tr063080.getLblCpTitle());
        Assert.assertEquals(message.getErrorTx063080(), message.getTitlePolicyCompliance(), lblCpTitle.getText());
        /* Checks en Politícas del Sujeto de Crédito */
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
        util.waitPass(timeMedium, "pressChecksPoliticsComment Comentario", driver);
        util.screenshot(caseScreen, caseScreenTx063080, driver);
        util.reactPage();
        /* Checks en Políticas Adicionales */
        driver.findElement(tr063080.getTabCpAditionalPolicies()).click();
        util.waitPass(timeLong, "pressChecksPoliticsComment Checks en Políticas Adicionales", driver);
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
        this.mailValidationAndGetUser(caseScreenTx063080, caseScreenWithoutMail01, caseScreenWithoutMail02 );
        this.getUser();
        this.openBrowserIncognito();
    }

    public void incognitoCloseSessionAndTypeUserPassword() throws Throwable {
        this.login(util.driverIncognito, userIncognit, caseScreenIncognitoLogin);
        /* Validación: Compruebo que la pantalla es el entorno FitBank */
        Assert.assertEquals(message.getErrorDataLogin(), message.getTitleFitbank(), util.driverIncognito.getTitle());
    }

    public void approveNumberRequest() throws Throwable {
        /* Ingresar a la transacción 00-2008 */
        util.driverIncognito.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(48) + Keys.ENTER);
        util.waitPass(timeLong, "approveNumberRequest Ingresar a la transacción 00-2008", util.driverIncognito);
        /* Validación: Comprobar que esté en la ventana de BUZON DE AUTORIZACIONES - FitBank */
        Assert.assertEquals(message.getErrorTx002008(), message.getTitleAuthorizationBox(), util.driverIncognito.getTitle());
        /* Validar la transacción 3080 */
        util.driverIncognito.findElement(tr002008.getTxtTransaction()).sendKeys(loanFlow.get(49) + Keys.TAB);
        util.waitPass(timeMedium, "approveNumberRequest Validar la transacción 3080", util.driverIncognito);
        /* Buscar el número de solicitud */
        util.driverIncognito.findElement(tr002008.getTxtBaSearchRequest()).sendKeys(requestNumber);
        util.waitPass(timeMedium, "approveNumberRequest Buscar el número de solicitud 1", util.driverIncognito);
        util.driverIncognito.findElement(global.getBtnF7()).click();
        util.waitPass(timeMedium, "approveNumberRequest Buscar el número de solicitud 2", util.driverIncognito);
        util.reactPageOp2();
        util.screenshot(caseScreen, caseScreenTx002008, util.driverIncognito);
        /* Selecciono el enlace a aprobar */
        util.driverIncognito.findElement(tr002008.getLinkBaRequest()).click();
        util.waitPass(timeMedium, "approveNumberRequest Selecciono el enlace a aprobar", util.driverIncognito);
        util.reactTypeData();
        /* Comentario para aprobar */
        util.driverIncognito.findElement(tr002009.getTxtObservation()).sendKeys(loanFlow.get(50) + Keys.TAB);
        util.screenshot(caseScreen, caseScreenTx002009, util.driverIncognito);
        util.waitPass(timeMedium, "approveNumberRequest Observacion", util.driverIncognito);
        /* Abrir el modal para aprobar */
        util.driverIncognito.findElement(tr002009.getBtnAprobar()).click();
        util.openModal();
        util.screenshot(caseScreen, caseScreenTx002009, util.driverIncognito);
        util.waitPass(timeMedium, "approveNumberRequest Boton Aprobar", util.driverIncognito);
        /* Cerrar el modal */
        util.driverIncognito.findElement(tr002009.getModalBtnAprobar()).click();
        util.waitPass(timeMedium, "approveNumberRequest Click Aprobar", util.driverIncognito);
        util.screenshot(caseScreen, caseScreenTx002009, util.driverIncognito);
    }

    public void typeRiskAnalysisApproval() throws Throwable {
        util.reactPage();
        /* Ingresar a la transacción 06-2033 */
        util.driverIncognito.findElement(global.getBoxCodeTransaction()).clear();
        util.driverIncognito.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(51) + Keys.ENTER);
        util.waitPass(timeLong, "typeRiskAnalysisApproval", util.driverIncognito);
        /* Validación: Comprobar que esté en la ventana de CUMPLIMIENTO DE POLITICAS */
        Assert.assertEquals(message.getErrorTx062033(), message.getTitleRiskAnalysisApproval(), util.driverIncognito.getTitle());
        /* Número de Solicitud */
        util.driverIncognito.findElement(tr062033.getTxtRequestNumber()).sendKeys(requestNumber);
        util.driverIncognito.findElement(tr062033.getTxtRequestNumber()).sendKeys(Keys.ENTER);
        util.waitPass(timeMedium, "typeRiskAnalysisApproval Número de solicitud", util.driverIncognito);
        util.multipleValidate(util.driverIncognito);
        util.screenshot(caseScreen, caseScreenTx062033, util.driverIncognito);
        /* Comentario */
        util.driverIncognito.findElement(tr062033.getTxtAarComment()).sendKeys(loanFlow.get(52) + Keys.TAB);
        /* Aprobar */
        util.driverIncognito.findElement(tr062033.getBtnAarRiskAnalysisApproval()).click();
        util.waitPass(timeLong, "typeRiskAnalysisApproval Aprobar", util.driverIncognito);
        util.multipleValidate(util.driverIncognito);
        util.screenshot(caseScreen, caseScreenTx062033, util.driverIncognito);
        /* Se cierra después de terminar el proceso en modo incógnito */
        util.driverIncognito.close();
    }

    public void generateUserToApproveCreditNumber() throws Throwable {
        util.reactPage();
        /* Ingresamos a la transacción 06-2001 */
        driver.findElement(global.getBoxCodeTransaction()).clear();
        driver.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(53) + Keys.ENTER);
        util.waitPass(timeLong, "generateUserToApproveCreditNumber Ingresamos a la transacción 06-2001", driver);
        util.multipleValidate(driver);
        /* Validación: Comprobar que esté en la ventana de CUMPLIMIENTO DE POLITICAS */
        Assert.assertEquals(message.getErrorTx062001(), message.getTitleRiskRequestApproval(), driver.getTitle());
        /* Número de Solicitud */
        driver.findElement(tr062001.getTxtRequestNumber()).sendKeys(requestNumber);
        driver.findElement(tr062001.getTxtRequestNumber()).sendKeys(Keys.ENTER);
        util.waitPass(timeMedium, "generateUserToApproveCreditNumber Número de solicitud", driver);
        util.multipleValidate(driver);
        util.screenshot(caseScreen, caseScreenTx062001, driver);
        this.typeDecision(driver);
        util.screenshot(caseScreen, caseScreenTx062001, driver);
    }

    public void openBrowserIncognitToApprove() throws Throwable {
        util.screenshot(caseScreen, caseScreenTx062001, driver);
        this.mailValidationAndGetUser(caseScreenTx062001, caseScreenWithoutMail03, "");
        this.getUser();
        this.openBrowserIncognito();
    }

    public void incognitoTwoCloseSessionAndTypeUserPassword() throws Throwable {
        this.login(util.driverIncognito, userIncognit, caseScreenIncognitoLogin2);
        /* Validación: Compruebo que la pantalla es el entorno FitBank */
        Assert.assertEquals(message.getErrorDataLogin(), message.getTitleFitbank(), util.driverIncognito.getTitle());
    }

    public void validateTransactionToGenerateCreditNumber() throws Throwable {
        /* Ingresar a la transacción 00-2008 */
        util.driverIncognito.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(48) + Keys.ENTER);
        util.waitPass(timeLong, "selectTransactionIncognito Ingresar a la transacción 00-2008", util.driverIncognito);
        /* Transacción */
        util.driverIncognito.findElement(tr002008.getTxtTransaction()).sendKeys(loanFlow.get(55) + Keys.TAB);
        util.waitPass(timeMedium, "selectTransactionIncognito Transacción", util.driverIncognito);
        /* Buscar el número de solicitud */
        util.driverIncognito.findElement(tr002008.getTxtBaSearchRequest()).sendKeys(requestNumber);
        util.waitPass(timeMedium, "selectTransactionIncognito buscar solicitud", util.driverIncognito);
        util.driverIncognito.findElement(global.getBtnF7()).click();
        util.waitPass(timeMedium, "selectTransactionIncognito buscando", util.driverIncognito);
        util.reactPageOp2();
        util.screenshot(caseScreen, caseScreenTx002008Incognito, util.driverIncognito);
        /* Selecionar el enlace aprobador */
        util.driverIncognito.findElement(tr002008.getLinkBaRequest()).click();
        util.waitPass(timeMedium, "selectTransactionIncognito Selecionar el enlace aprobador", util.driverIncognito);
        util.multipleValidate(util.driverIncognito);
        this.typeDecision(util.driverIncognito);
    }

    public void saveIncognitoAndGetCreditNumber() throws Throwable {
        /* Guardo la transacción */
        this.saveFormGeneral(util.driverIncognito);
        util.reactPage();
        /* Obtengo el número de crédito */
        WebElement getNumberCredit = util.driverIncognito.findElement(tr062001.getTxtBaLoanNumber());
        creditNumber = getNumberCredit.getAttribute("value");
        System.out.println("Número de crédito: " + creditNumber);
        util.driverIncognito.findElement(tr062001.getTxtRequestNumber()).click();
        util.screenshot(caseScreen, caseScreenTx062001Incognito, util.driverIncognito);
        util.driverIncognito.close();
    }

    public void tr063002() throws Throwable {
        // Quemamos el número de préstamo
//        driver.findElement(global.getBoxCodeTransaction()).clear();
//        driver.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(18) + Keys.ENTER);
        driver.findElement(tr063002.getTxtLoan()).sendKeys("60001295189" + Keys.ENTER);
        util.waitPass(timeMedium, "Número de Préstamo", driver);
        driver.findElement(tr063002.getTxtAccountDebit()).sendKeys(loanFlow.get(57) + Keys.ENTER);
        util.screenshot(caseScreen, caseScreenTx063002, driver);

    }

    public void loanWarranty() throws Throwable {
        util.reactPage();
//        driver.findElement(global.getBoxCodeTransaction()).clear();
//        driver.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(18) + Keys.ENTER);

        driver.findElement(tr062006.getTxtWarranty()).sendKeys("60001295189" + Keys.ENTER);
        util.waitPass(timeMedium, "Préstamo", driver);
        driver.findElement(tr062006.getTxtNumberWarranty()).sendKeys(loanFlow.get(59) + Keys.ENTER);
        util.waitPass(timeMedium, "Número de Préstamo", driver);
        WebElement txtValueWarranty = driver.findElement(tr062006.getTxtValueWarranty());
        driver.findElement(tr062006.getTxtValueToWarranty()).sendKeys(txtValueWarranty.getAttribute("value"));
        util.screenshot(caseScreen, caseScreenTx062006, driver);
    }

    public void enablingDocuments() throws Throwable {
        //util.reactPage();
//        driver.findElement(global.getBoxCodeTransaction()).clear();
//        driver.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(18) + Keys.ENTER);
        driver.findElement(tr063005.getTxtWarranty()).sendKeys("60001295189" + Keys.ENTER);
        util.waitPass(timeMedium, "Número de Préstamo", driver);
        driver.findElement(tr063005.getTxtStarDatePay()).sendKeys(addMonth());
        util.waitPass(timeMedium, "Add Month", driver);
        driver.findElement(tr063005.getTxtFixedDayPay()).sendKeys(getDay());
        util.waitPass(timeMedium, "Get Day", driver);
        util.screenshot(caseScreen, caseScreenTx063005, driver);
    }

    public void printReportDocuments() throws Throwable {
        util.reactPageOp2();
        /* Imprimir Reportes */
        List<WebElement> tablePrint = driver.findElements(tr063005.getTbPrintDocuments());
        util.screenshot(caseScreen, caseScreenTx063005, driver);
        for(int i = 1; i <= tablePrint.size(); i++) {
            String code = tr063005.getTxtPrintDocCod1Part1() + i + tr063005.getTxtPrintDocCod1Part2();
            String btnPrint = tr063005.getBtnPrintPart1() + i + tr063005.getBtnPrintPart2();
            WebElement columnCode = driver.findElement(By.xpath(code));
            WebElement columnBtnPrint = driver.findElement(By.xpath(btnPrint));
            String base = columnCode.getAttribute("value");
            if (base.length() > 0 ) {
                columnBtnPrint.click();
                util.switchPages(4000, "yes");
                util.reactPageOp2();
            } else {
                break;
            }
        }
    }

    /* Método para sumar un mes, para la emision de documentos habilitantes*/
    public String addMonth() {
        WebElement openDate = driver.findElement(tr063005.getTxtOpenDate());
        //System.out.println("Fecha Apertura: " + openDate.getAttribute("value"));
        String string = openDate.getAttribute("value");
        String[] parts = string.split("-");
        String dia = parts[0];
        String mes = parts[1];
        String anio = parts[2];
        int integerMes = Integer.parseInt(mes);
        if( integerMes > 12 ) {
            integerMes = 01;
        } else {
            integerMes = integerMes+1;
        }
        String addMes = String.valueOf(integerMes);
        addMes = dia+"-"+addMes+"-"+anio;
        return addMes;
    }

    /* Método para sacar el día, para la emision de documentos habilitantes*/
    public String getDay() {
        WebElement openDate = driver.findElement(tr063005.getTxtOpenDate());
        //System.out.println("Fecha Apertura: " + openDate.getAttribute("value"));
        String string = openDate.getAttribute("value");
        String[] parts = string.split("-");
        return parts[0];
    }

    public void creditDocumentsValidation() throws Throwable {
        util.reactPage();
        driver.findElement(tr063018.getTxtLoan()).sendKeys("60001295189" + Keys.ENTER);
        util.multipleValidate(driver);
        driver.findElement(tr063018.getTxtStatus()).sendKeys("DESEMBOLSO" + Keys.ENTER);
        util.waitPass(timeMedium, "Status", driver);
        driver.findElement(tr063018.getTxtObservations()).sendKeys("OK" + Keys.ENTER);
        util.waitPass(timeMedium, "Observations", driver);
        util.screenshot(caseScreen, caseScreenTx063018, driver);
    }

    public void outlayLoan() throws Throwable {
        driver.findElement(tr066010.getTxtLoan()).sendKeys("60001295189" + Keys.ENTER);
        util.waitPass(timeMedium, "Number Loan", driver);
        util.screenshot(caseScreen, caseScreenTx066010, driver);
    }

    /* Métodos que se usa en modo normal e incógnito */
    public void openBrowserIncognito() {
        util.options.addArguments("-incognito");
        util.driverIncognito = new ChromeDriver(util.options);
        util.driverIncognito.manage().window().maximize();
        /* Ingreso la Ip a navegar */
        util.driverIncognito.get("http://" + loanFlow.get(0) + ":8380/WEB3/ingreso.html");
    }

    public void login(WebDriver typeDriver, String user, String screenshot) throws IOException {
        /* Forzar cierre de sesiones */
        typeDriver.findElement(loginPage.getLinkMoreOptions()).click();
        typeDriver.findElement(loginPage.getBtnForceClose()).click();
        /* Ingreso de usuario y contraseña */
        typeDriver.findElement(loginPage.getTxtUser()).sendKeys(user);
        typeDriver.findElement(loginPage.getTxtPassword()).sendKeys(loanFlow.get(2));
        util.screenshot(caseScreen, screenshot, typeDriver);
        typeDriver.findElement(loginPage.getBtnSubmit()).submit();
    }

    public void typeDecision(WebDriver typeDriver) throws Throwable {//
        util.reactTypeDataOp2();
        /* Decisión */
        Select selectDecision = new Select(typeDriver.findElement(tr062001.getTxtAspDecision()));
        selectDecision.selectByVisibleText(loanFlow.get(54));
        WebElement accountingDate = typeDriver.findElement(tr062001.getTxtAspaccountingDate());
        typeDriver.findElement(tr062001.getTxtAspaccountingDateValue()).sendKeys(accountingDate.getAttribute("value") + Keys.TAB);
        util.waitPass(timeMedium, "typeDecision Decisión", typeDriver);
    }

    public void saveFormGeneral(WebDriver typeDriver) throws Throwable {
        util.reactPage();
        WebElement save = typeDriver.findElement(global.getBtnF12());
        save.click();
        util.waitPass(timeLong, "saveTransaction saveTransaction", typeDriver);
        util.multipleValidate(typeDriver);
    }

    /* Extraer usuario para aprobaciones */
    public void getUser() {
        WebElement statustNotification = driver.findElement(global.getTxtStatus());
        String txtStatus = statustNotification.getText();
        userIncognit = txtStatus.substring(txtStatus.indexOf(":") + 1, txtStatus.indexOf("NOMBRE")).trim();
    }

    /* VALIDACIÓN DE CORREO: Validar si el usuario que va a guardar las transacciones posee mail  */
    public void mailValidationAndGetUser(String screenshotBase, String screenshotWindowTwo, String screenshotWindowThree) throws Throwable {
        this.validateMail(screenshotBase, screenshotWindowTwo);
        WebElement statustNotification = driver.findElement(global.getTxtStatus());
        String txtStatusOp2 = statustNotification.getText().substring(0, 10);
        /* En caso de que los dos usuarios no poseen email, el que crea la solicitud y aprueba */
        if (txtStatusOp2.equalsIgnoreCase("SIN E-MAIL")) {
            this.validateMail(screenshotBase, screenshotWindowThree);
        }
        statustNotification = driver.findElement(global.getTxtStatus());
        userIncognit = statustNotification.getText().substring(statustNotification.getText().indexOf(":") + 1, statustNotification.getText().indexOf("NOMBRE")).trim();
    }

    /* Validar el tipo de usuario que puede tener */
    public void typeUser(String typeUser) throws Throwable {
        util.driverIncognito.findElement(tr010117.getTxtImuUserType()).clear();
        /* Ingresa el tipo usuario */
        util.driverIncognito.findElement(tr010117.getTxtImuUserType()).sendKeys(typeUser + Keys.ENTER);
        util.waitPass(timeLong, "typeUser Ingresa el tipo usuario", util.driverIncognito);
        util.driverIncognito.findElement(global.getBtnF7()).click();
        util.waitPass(timeLong, "typeUser click F7", util.driverIncognito);
        util.multipleValidate(util.driverIncognito);
    }

    /* Mail por defecto a ser agregado con código javascript */
    public void mailDefault() {
        JavascriptExecutor addValueJs = (JavascriptExecutor) util.driverIncognito;
        addValueJs.executeScript("document.getElementById('c_F2Direccion_0').removeAttribute('type')");
        addValueJs.executeScript("document.getElementById('c_F2Direccion_0').removeAttribute('value')");
        addValueJs.executeScript("document.getElementById('c_F2Direccion_0').setAttribute('type', 'email')");
        addValueJs.executeScript("document.getElementById('c_F2Direccion_0').setAttribute('value', 'ADMINS@BAUSTRO.FIN.EC')");
    }

    /* Agrega el mail al usuario que no posee */
    public void validateMail(String screenshotBase, String screenshotWindow) throws Throwable {
        WebElement statustNotification = driver.findElement(global.getTxtStatus());
        String txtStatus = statustNotification.getText().substring(0, 10);
        if (txtStatus.equalsIgnoreCase("SIN E-MAIL")) {
            String getUserWithoutEmail = statustNotification.getText().substring(48, statustNotification.getText().length());
            this.openBrowserIncognito();
            this.login(util.driverIncognito, "admin", screenshotWindow);
            util.reactPageOp2();
            /* Ingresar a la transacción 01-0117 */
            util.driverIncognito.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(60) + Keys.ENTER);
            util.waitPass(timeLong, "openNewBrowserIncognito Ingresar a la transacción 01-0117", driver);
            util.multipleValidate(util.driverIncognito);
            /* Validación: Comprobar que esté en la ventana de INGRESO Y MODIFICACION DE USUARIOS */
            Assert.assertEquals(message.getErrorTx010117(), message.getTitleLoginAndModificationUsers(), util.driverIncognito.getTitle());
            util.reactPageOp2();
            /* Ingreso el usuario a buscar para agregar el mail */
            util.driverIncognito.findElement(tr010117.getTxtImuUser()).sendKeys(getUserWithoutEmail);
            util.waitPass(timeLong, "openNewBrowserIncognito Ingresar a la transacción 01-0117", util.driverIncognito);
            /* Buscar el Usuario por cada sección */
            this.typeUser("ATM");
            String getUser = util.driverIncognito.findElement(tr010117.getTxtImuF1UserType()).getAttribute("value");
            if (getUser.length() > 0) {
                this.mailDefault();
            } else {
                this.typeUser("ECG");
                getUser = util.driverIncognito.findElement(tr010117.getTxtImuF1UserType()).getAttribute("value");
                if (getUser.length() > 0) {
                    this.mailDefault();
                } else {
                    this.typeUser("HBA");
                    getUser = util.driverIncognito.findElement(tr010117.getTxtImuF1UserType()).getAttribute("value");
                    if (getUser.length() > 0) {
                        this.mailDefault();
                    } else {
                        this.typeUser("OBA");
                        getUser = util.driverIncognito.findElement(tr010117.getTxtImuF1UserType()).getAttribute("value");
                        if (getUser.length() > 0) {
                            this.mailDefault();
                        } else {
                            this.typeUser("OTH");
                            getUser = util.driverIncognito.findElement(tr010117.getTxtImuF1UserType()).getAttribute("value");
                            if (getUser.length() > 0) {
                                this.mailDefault();
                            } else {
                                this.typeUser("PRO");
                                getUser = util.driverIncognito.findElement(tr010117.getTxtImuF1UserType()).getAttribute("value");
                                if (getUser.length() > 0) {
                                    this.mailDefault();
                                } else {
                                    this.typeUser("UEG");
                                    getUser = util.driverIncognito.findElement(tr010117.getTxtImuF1UserType()).getAttribute("value");
                                    if (getUser.length() > 0) {
                                        this.mailDefault();
                                    } else {
                                        System.out.println("NO EXISTE EL USUARIO A AGREGAR EL EMAIL");
                                    }
                                }
                            }
                        }
                    }
                }
            }
            this.saveFormGeneral(util.driverIncognito);
            util.screenshot(caseScreen, screenshotWindow, util.driverIncognito);
            util.driverIncognito.close();
            this.saveFormGeneral(driver);
            util.screenshot(caseScreen, screenshotBase, driver);
        } else {
            System.out.println("Con email");
        }
    }
}
