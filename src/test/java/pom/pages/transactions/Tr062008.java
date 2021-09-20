package pom.pages.transactions;

import org.openqa.selenium.By;

public class Tr062008 {

    public final By warrantyProp = By.id("c_F3Identificacion_0");
    public final By txtTypeWarranty = By.id("c_F3Ctipogarantia_0");
    public final By txtTypeGoods = By.id("c_F3Ctipobien_0");
    public final By txtValueComercial = By.id("c_F3Valorcomercial_0");
    public final By chkOpen = By.xpath("//*[@id=\'container_5\']/div/table/tbody/tr[1]/td[11]/span/input[2]");
    public final By txtDescription = By.id("c_F3Descripcion_0");

    public By getWarrantyProp() {
        return warrantyProp;
    }
    public By getTxtTypeWarranty() { return txtTypeWarranty; }
    public By getTxtTypeGoods() { return txtTypeGoods; }
    public By getTxtValueComercial() { return txtValueComercial; }
    public By getChkOpen() { return chkOpen; }
    public By getTxtDescription() { return txtDescription; }
}
