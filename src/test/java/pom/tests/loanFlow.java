package pom.tests;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pom.pages.StartPages;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

public class loanFlow extends StartPages {

    public loanFlow() throws IOException {
    }

    public void openBrowser() throws Throwable {
        caseScreen++;
        driver.get("http://" + loanFlow.get(0) + ":8380/WEB3/ingreso.html");
        Assert.assertEquals(message.getErrorBrowser(), message.getTitlePageLogin(), driver.getTitle());
    }

    public void closeSessionAndTypeUserPassword() throws Throwable {
        this.login(driver, loanFlow.get(1), caseScreenLogin);
        /* Validación: Compruebo que la pantalla es el entorno FitBank */
        Assert.assertEquals(message.getErrorDataLogin(), message.getTitleFitbank(), driver.getTitle());
    }

    public void typeDebtorDataProductDataLoan() throws Throwable {
        driver.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(3) + Keys.ENTER);
        util.waitPass(timeSave, "typeDebtorDataProductDataLoan Transacción 06-2100", driver);
        /* Validación: Estar en la pantalla de SIMULACIÓN DE PRÉSTAMOS - FitBank */
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
        /* Actividad Receptora*/
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
        util.waitPass(timeSave, "typeDataGeographicalDataLoanComment Ir a la transacción 06-2000", driver);
        util.multipleValidate(driver);
        /* Validación: Estar en la pantalla de INGRESO Y MANTENIMIENTO DE SOLICITUDES PRÉSTAMOS - FitBank */
        Assert.assertEquals(message.getErrorTx062000(), message.getTitleEntryAndMaintenance(), driver.getTitle());
        /* Ingresar el número de solicitud */
        driver.findElement(tr062000.getTxtNumberRequest()).sendKeys(requestNumber);
        driver.findElement(tr062000.getTxtNumberRequest()).sendKeys(Keys.ENTER);
        util.waitPass(timeSave, "typeDataGeographicalDataLoanComment Ingresar el número de solicitud", driver);
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
        /* Validación: Comprobar que esté en el ventana principal después de abrir la pestaña de reporte */
        Assert.assertEquals(message.getErrorMainView(), message.getTitleIncoMainLoan(), driver.getTitle());
    }

    public void saveTransaction() throws Throwable {
        this.saveFormGeneral(driver);
    }

    public void tabWarrantyProposed() throws Throwable {
        util.reactPage();
        driver.findElement(tr062000.getTabWarranty()).click();
        util.waitPass(timeSave, "tabWarrantyProposed Pestaña", driver);
        util.multipleValidate(driver);
        /* Validación: Comprobar que esté en el ventana de INGRESO Y MANTENIMIENTO DE GARANTIAS - FitBank */
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
        WebElement mainPrintDocuments = driver.findElement(tr062016.getTabMainPrintDocuments());
        mainPrintDocuments.click();
        util.waitPass(timeSave, "selectPrintDocuments", driver);
        /* Validación: Comprobar que esté en el ventana de IMPRESIÓN DE DOCUMENTOS - FitBank */
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
        util.waitPass(timeSave, "validateOrder Ingresar a la transacción 00-0267", driver);
        util.multipleValidate(driver);
        /* Validación: Comprobar que esté en el ventana de Consulta de Reportes Generados en Batch - FitBank */
        Assert.assertEquals(message.getErrorTx000267(), message.getTitleQueryReport(), driver.getTitle());
        util.reactPage();
        WebElement query = driver.findElement(global.getBtnF7());
        query.click();
        util.waitPass(timeSave, "validateOrder F7", driver);
        util.multipleValidate(driver);
        util.screenshot(caseScreen, caseScreenTx000267, driver);
    }

    public void pressChecksAndSave() throws Throwable {
        /* Ingresar a la transacción 06-3071 */
        util.reactPage();
        driver.findElement(global.getBoxCodeTransaction()).clear();
        driver.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(33) + Keys.ENTER);
        util.waitPass(timeSave, "pressChecksAndSave Ingresar a la transacción 06-3071", driver);
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
        util.waitPass(timeSave, "pressChecksAndSave Guardar", driver);
        util.multipleValidate(driver);
        util.screenshot(caseScreen, caseScreenTx063071, driver);
    }

    public void typeComment() throws Throwable {
        /* Ingresar a la transacción 06-3040 */
        util.reactPage();
        driver.findElement(global.getBoxCodeTransaction()).clear();
        driver.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(34) + Keys.ENTER);
        util.waitPass(timeSave, "typeComment Ingresar a la transacción 06-3040", driver);
        /* Validación: Comprobar que esté en el ventana de ANÁLISIS DE CRÉDITO - FitBank */
        Assert.assertEquals(message.getErrorTx063040(), message.getTitleCreditAnalysis(), driver.getTitle());
        util.reactTypeData();
        /* Ingresar el número de solicitud */
        WebElement txtRequestNumber = driver.findElement(tr063040.getTxtRequestNumber());
        txtRequestNumber.sendKeys(requestNumber);
        util.reactPageOp2();
        txtRequestNumber.sendKeys(Keys.TAB);
        util.waitPass(timeSave, "typeComment Ingresar el número de solicitud", driver);
        util.multipleValidate(driver);
        util.screenshot(caseScreen, caseScreenTx063040, driver);
        /* Validación: Comprobar que los datos hayan sido cargados */
        WebElement txtGpProductValue = driver.findElement(tr063040.getTxtGpProductValue());
        Assert.assertEquals(message.getErrorGeneral(), loanFlow.get(9), txtGpProductValue.getAttribute("value"));
        util.reactPageOp2();
        /* Comentario */
        driver.findElement(tr063040.getTxtDoComment()).sendKeys(loanFlow.get(35) + Keys.TAB);
        util.waitPass(timeSave, "typeComment Comentario", driver);
        util.multipleValidate(driver);
        util.screenshot(caseScreen, caseScreenTx063040, driver);
    }

    public void typeValuesRiskActivesPasives() throws Throwable {
        driver.findElement(tr063078.getTabAnalysisCred()).click();
        util.waitPass(timeSave, "Riego Indirecto", driver);
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
        util.waitPass(timeSave, "creditAnalysis Activo-Pasivo", driver);
        String patrimony = driver.findElement(tr063078.getTxtPatrimony()).getAttribute("value");
        driver.findElement(tr063078.getTxtConfirmedPatr()).sendKeys(patrimony + Keys.ENTER);
        util.waitPass(timeMedium, "creditAnalysis patrimony", driver);
        driver.findElement(tr063078.getAtxtComment()).sendKeys(loanFlow.get(37));
        util.waitPass(timeSave, "creditAnalysis Update Balance", driver);
        driver.findElement(tr063078.getChkUpdtaBalance()).click();
        util.screenshot(caseScreen, caseScreenTx063078, driver);
    }

    public void pressChecksPoliticsComment() throws Throwable {
        util.reactPage();
        /* Ir a la pestaña de Cumplimiento De Políticas*/
        WebElement tabPolicyCompliance = driver.findElement(tr063080.getTabPolicyCompliance());
        tabPolicyCompliance.click();
        util.waitPass(timeSave, "pressChecksPoliticsComment", driver);
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
        util.waitPass(timeSave, "pressChecksPoliticsComment Checks en Políticas Adicionales", driver);
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

    public void openNewBrowserIncognito() {
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
        util.waitPass(timeSave, "approveNumberRequest Ingresar a la transacción 00-2008", util.driverIncognito);
        /* Validación: Comprobar que esté en el ventana de BUZON DE AUTORIZACIONES - FitBank */
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
        util.waitPass(timeSave, "typeRiskAnalysisApproval", util.driverIncognito);
        /* +Validación: Comprobar que esté en el ventana de CUMPLIMIENTO DE POLITICAS */
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
        util.waitPass(timeSave, "typeRiskAnalysisApproval Aprobar", util.driverIncognito);
        util.multipleValidate(util.driverIncognito);
        util.screenshot(caseScreen, caseScreenTx062033, util.driverIncognito);
        /* Se cierra después de terminar el proceso en modo incógnito */
        util.driverIncognito.close();
    }

    public void approveCreditNumber() throws Throwable {
        /* Vuelve a la página principal */
        util.reactPage();
        driver.findElement(global.getBoxCodeTransaction()).clear();
        driver.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(53) + Keys.ENTER);
        util.waitPass(timeSave, "generateCreditNumber", driver);
        util.multipleValidate(driver);
        /* Validación: Comprobar que esté en el ventana de CUMPLIMIENTO DE POLITICAS */
        Assert.assertEquals(message.getErrorTx062001(), message.getTitleRiskRequestApproval(), driver.getTitle());
        /* Número de Solicitud */
        driver.findElement(tr062001.getTxtRequestNumber()).sendKeys(requestNumber);
        driver.findElement(tr062001.getTxtRequestNumber()).sendKeys(Keys.ENTER);
        util.waitPass(timeMedium, "generateCreditNumber Número de solicitud", driver);
        util.multipleValidate(driver);
        util.screenshot(caseScreen, caseScreenTx062001, driver);
    }

    public void generateCreditNumber() throws Throwable {
        this.typeDecision(driver);
        util.screenshot(caseScreen, caseScreenTx062001, driver);
    }

    public void openBrowserIncognitToApprove() throws Throwable {
        util.screenshot(caseScreen, caseScreenTx062001, driver);
        this.openBrowserIncognito();
    }

    public void incognitoTwoCloseSessionAndTypeUserPassword() throws Throwable {
        this.login(util.driverIncognito, userIncognit, caseScreenIncognitoLogin2);
            /* +Validaciones:
               Compruebo que la pantalla es el entorno FitBank */
        Assert.assertEquals(message.getErrorDataLogin(), message.getTitleFitbank(), util.driverIncognito.getTitle());
    }

    public void selectTransactionIncognito() throws Throwable {
        util.driverIncognito.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(48) + Keys.ENTER);
        util.waitPass(timeSave, "approveNumberRequest", util.driverIncognito);
        util.driverIncognito.findElement(tr002008.getTxtTransaction()).sendKeys(loanFlow.get(55) + Keys.TAB);
        util.waitPass(timeMedium, "authMailBox", util.driverIncognito);
        /* Buscar el número de solicitud */
        util.driverIncognito.findElement(tr002008.getTxtBaSearchRequest()).sendKeys(requestNumber);
        util.waitPass(timeMedium, "authMailBox buscar solicitud", util.driverIncognito);
        util.driverIncognito.findElement(global.getBtnF7()).click();
        util.waitPass(timeMedium, "authMailBox buscando", util.driverIncognito);
        util.reactPageOp2();
        util.screenshot(caseScreen, caseScreenTx002008Incognito, util.driverIncognito);
        util.driverIncognito.findElement(tr002008.getLinkBaRequest()).click();
        util.waitPass(timeMedium, "authMailBox enlace", util.driverIncognito);
        util.multipleValidate(util.driverIncognito);
    }

    public void generateNumberCredit() throws Throwable {
        this.typeDecision(util.driverIncognito);
    }

    public void saveIncognito() throws Throwable {
        this.saveFormGeneral(util.driverIncognito);
    }

    public void getNumberCredit() throws Throwable {
        util.reactPage();
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
        driver.findElement(tr063002.getTxtLoan()).sendKeys("60001295008" + Keys.ENTER);
        util.waitPass(timeMedium, "Número de Préstamo", driver);
        driver.findElement(tr063002.getTxtAccountDebit()).sendKeys(loanFlow.get(57) + Keys.ENTER);
        Calendar c = Calendar.getInstance();
    }

    public void loanWarranty() throws Throwable {
        util.reactPage();
//        driver.findElement(global.getBoxCodeTransaction()).clear();
//        driver.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(18) + Keys.ENTER);
        driver.findElement(tr062006.getTxtWarranty()).sendKeys("60001295008" + Keys.ENTER);
        util.waitPass(timeMedium, "Préstamo", driver);
        driver.findElement(tr062006.getTxtNumberWarranty()).sendKeys(loanFlow.get(59) + Keys.ENTER);
        util.waitPass(timeMedium, "Número de Préstamo", driver);
        WebElement txtValueWarranty = driver.findElement(tr062006.getTxtValueWarranty());
        driver.findElement(tr062006.getTxtValueToWarranty()).sendKeys(txtValueWarranty.getAttribute("value"));
    }

    public void enablingDocuments() throws Throwable {
        util.reactPage();
//        driver.findElement(global.getBoxCodeTransaction()).clear();
//        driver.findElement(global.getBoxCodeTransaction()).sendKeys(loanFlow.get(18) + Keys.ENTER);
        driver.findElement(tr063005.getTxtWarranty()).sendKeys("60001295008" + Keys.ENTER);
    }

    /* Métodos que se usa en modo normal e incógnito */
    public void openBrowserIncognito() {
        WebElement statustNotification = driver.findElement(global.getTxtStatus());
        String txtStatus = statustNotification.getText();
        userIncognit = txtStatus.substring(txtStatus.indexOf(":") + 1, txtStatus.indexOf("NOMBRE")).trim();
        util.options.addArguments("-incognito");
        util.driverIncognito = new ChromeDriver(util.options);
        util.driverIncognito.manage().window().maximize();
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
        util.waitPass(timeMedium, "generateCreditNumber Número de solicitud", typeDriver);
    }

    public void saveFormGeneral(WebDriver typeDriver) throws Throwable {
        util.reactPage();
        WebElement save = typeDriver.findElement(global.getBtnF12());
        save.click();
        util.waitPass(timeSave, "saveTransaction saveTransaction", typeDriver);
        util.multipleValidate(typeDriver);
    }
}
