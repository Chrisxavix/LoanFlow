package pom.pages.transactions;

import org.openqa.selenium.By;

public class Tr002008 {

    /* VARIABLES */
    /* BUZON DE AUTORIZACIONES: Ba */
    private final By txtTransaction = By.id("c_ctransaccionc_0");
    private final By tblTransaction = By.xpath("//*[@id='container_3']/div/table/tbody/tr");


    /* GETTERS */
    /* BUZON DE AUTORIZACIONES: Ba */
    public By getTxtTransaction() { return this.txtTransaction; }
    public By getTblTransaction() { return this.tblTransaction; }
    public String getTxtBaRequestPart1() { return "//*[@id='container_3']/div/table/tbody/tr["; }
    public String getTxtBaRequestPart2() { return "]/td[8]/input"; }
    public String getTxtBaGoPart1() { return "//*[@id='container_3']/div/table/tbody/tr["; }
    public String getTxtBaGoPart2() { return "]/td[10]/span/a"; }
}
