package pom.pages.transactions;

import org.openqa.selenium.By;

public class Tr002008 {

    private final By txtTransaction = By.id("c_ctransaccionc_0");
    private final By tblTransaction = By.xpath("//*[@id=\'container_3\']/div/table/tbody/tr");

    public By getTxtTransaction() { return this.txtTransaction; }
    public By getTblTransaction() { return this.tblTransaction; }
}
