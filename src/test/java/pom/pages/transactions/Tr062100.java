package pom.pages.transactions;

import org.openqa.selenium.By;

public class Tr062100 {

    //DEUDOR-CODEUDOR Y GARANTES
    private final By txtId = By.id("c_F2Id_0");
    private final By txtRelationsText = By.id("c_F2Drelacionp_0");
    private final By txtIdCod = By.xpath("//*[@id=\'container_5\']/div/table/tbody/tr[2]/td[3]/input");
    private final By txtRelationsCod = By.xpath("//*[@id=\'container_5\']/div/table/tbody/tr[2]/td[5]/input");
    private final By txtRelationsCodText = By.xpath("//*[@id=\'container_5\']/div/table/tbody/tr[2]/td[6]/input");
    private final By txtIdGar = By.xpath("//*[@id=\'container_5\']/div/table/tbody/tr[3]/td[3]/input");
    private final By txtRelationsGar = By.xpath("//*[@id=\'container_5\']/div/table/tbody/tr[3]/td[5]/input");
    private final By txtRelationsGarText = By.xpath("//*[@id=\'container_5\']/div/table/tbody/tr[3]/td[6]/input");

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
    private final By btnInterestRate = By.id("c_F4Tasaboton_0");
    private final By btnCloseInterestRate = By.xpath("//*[@id=\'entorno-formulario\']/div[2]/form/div[37]/div[1]/img");

    private final By saveForm = By.xpath("//*[@id=\'entorno-teclas\']/button[9]");

    public By getTxtId() { return this.txtId; }
    public By getTxtRelationsText() { return this.txtRelationsText; }
    public By getTxtIdCod() { return this.txtIdCod; }
    public By getTxtRelationsCod() { return this.txtRelationsCod; }
    public By getTxtRelationsCodText() { return this.txtRelationsCodText; }
    public By getTxtIdGar() { return this.txtIdGar; }
    public By getTxtRelationsGar() { return this.txtRelationsGar; }
    public By getTxtRelationsGarText() { return this.txtRelationsGarText; }
    public By getTxtProductGroup() { return this.txtProductGroup; }
    public By getTxtProduct() { return this.txtProduct; }
    public By getTxtIdExecutive() { return this.txtIdExecutive; }
    public By getTxtOrigin() { return this.txtOrigin; }
    public By getTxtReceptorActivity() { return this.txtReceptorActivity; }
    public By getTxtDestinationFunds() { return this.txtDestinationFunds; }
    public By getTxtAmountCredit() { return this.txtAmountCredit; }
    public By getTxtCapitalFrequency() { return this.txtCapitalFrequency; }
    public By getTxtNumberQuotas() { return this.txtNumberQuotas; }
    public By getBtnInterestRate() { return this.btnInterestRate; }
    public By getBtnCloseInterestRate() { return this.btnCloseInterestRate; }
    public By getSaveForm() { return this.saveForm; }
}
