package pom.pages.transactions;

import org.openqa.selenium.By;

public class Tr063018 {

     private final By txtLoan = By.id("c_w2_ccuenta_0");
     private final By txtStatus = By.xpath("//*[@id=\'container_17\']/table/tbody/tr/td[2]/input[2]");
     private final By txtObservations = By.id("c_observaciones_0");

    public By getTxtLoan() { return this.txtLoan; }
    public By getTxtStatus() { return this.txtStatus; }
    public By getTxtObservations() { return this.txtObservations; }
}
