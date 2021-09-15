package steps.pom.pages.transactions;

import org.openqa.selenium.By;

public class Tr062100 {

    private By txtTransactions = By.id("entorno-pt");

    //DEUDOR-CODEUDOR Y GARANTES
    private final By txtId = By.id("c_F2Id_0");
    private final By txtRelations = By.id("c_F2Crelacionp_0");
    private final By txtIdCod = By.xpath("//*[@id=\'container_5\']/div/table/tbody/tr[2]/td[3]/input");
    private final By txtRelationsCod = By.xpath("//*[@id=\'container_5\']/div/table/tbody/tr[2]/td[5]/input");
    private final By txtIdGar = By.xpath("//*[@id=\'container_5\']/div/table/tbody/tr[3]/td[3]/input");
    private final By txtRelationsGar = By.xpath("//*[@id=\'container_5\']/div/table/tbody/tr[3]/td[5]/input");

    //DATOS DEL PRODUCTO
    private final By txtProductGroup = By.id("c_F3Cgrupoprod_0");
    private final By txtProduct = By.id("c_F3Cproducto_0");
    private final By txtIdExecutive = By.id("c_F3Cusrcta_0");
    private final By txtOrigin = By.id("c_F3CpropositoPreC_0");
    private final By txtReceptorActivity = By.id("c_F3Cactividad_0");
    private final By txtDestinationFunds = By.id("c_F3Cdestinofon_0");

    //DATOS DEL PRÉSTAMO
    private final By txtAmountCredit = By.id("c_F4Monto_0");
    private final By txtCapitalFrequency = By.id("c_F4Cfrecuenciacap_0");
    private final By txtNumberQuotas = By.id("c_F4Numcuotas_0");

    public By getTxtTransactions() {
        return txtTransactions;
    }

    public By getTxtId() {
        return txtId;
    }

    public By getTxtRelations() {
        return txtRelations;
    }

    public By getTxtIdCod() {
        return txtIdCod;
    }

    public By getTxtRelationsCod() {
        return txtRelationsCod;
    }

    public By getTxtIdGar() {
        return txtIdGar;
    }

    public By getTxtRelationsGar() {
        return txtRelationsGar;
    }

    public By getTxtProductGroup() {
        return txtProductGroup;
    }

    public By getTxtProduct() {
        return txtProduct;
    }

    public By getTxtIdExecutive() {
        return txtIdExecutive;
    }

    public By getTxtOrigin() {
        return txtOrigin;
    }

    public By getTxtReceptorActivity() {
        return txtReceptorActivity;
    }

    public By getTxtDestinationFunds() {
        return txtDestinationFunds;
    }

    public By getTxtAmountCredit() {
        return txtAmountCredit;
    }

    public By getTxtCapitalFrequency() {
        return txtCapitalFrequency;
    }

    public By getTxtNumberQuotas() {
        return txtNumberQuotas;
    }
}
