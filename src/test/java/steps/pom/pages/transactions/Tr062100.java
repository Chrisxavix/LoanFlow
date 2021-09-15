package steps.pom.pages.transactions;

import org.openqa.selenium.By;

public class Tr062100 {

    private final By txtTransactions = By.id("entorno-pt");

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

    private final By txtAmountCredit = By.id("c_F4Monto_0");

}
