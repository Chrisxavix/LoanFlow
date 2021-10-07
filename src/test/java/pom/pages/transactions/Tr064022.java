package pom.pages.transactions;

import org.openqa.selenium.By;

public class Tr064022 {

    /* VARIABLES */

    private final By txtLoan = By.xpath("//*[@id='container_0']/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/input[1]");
    private final By txtStatus = By.xpath("//*[@id='container_9']/table/tbody/tr/td[2]/table/tbody/tr[7]/td[2]/input[1]");
    private final By txtDateNext = By.xpath("//*[@id='container_13']/table/tbody/tr/td[3]/table/tbody/tr[8]/td[2]/input");

    /* GETTERS */

    public By getTxtLoan() { return this.txtLoan; }
    public By getTxtStatus() { return this.txtStatus; }
    public By getTxtDateNext() { return this.txtDateNext; }
}
