package pom.pages.transactions;

import org.openqa.selenium.By;

public class Tr063078 {
    public final By tabAnalysisCred = By.xpath("//*[@id=\'container_0\']/table/tbody/tr/td/ul/li[2]/a");
    public final By txtSubsCancel = By.id("c_F3AbonoCancelacion_0");
    public final By tabActPasiv = By.xpath("//*[@id=\'container_5\']/table/tbody/tr/td/ul/li[2]/a");
    public final By txtPatrimony = By.id("c_F6patrimonio2_0");
    public final By txtConfirmedPatr = By.id("c_F6patrimonio_0");
    public final By atxtComment = By.id("c_F5Obsop_0");
    public final By txtIndirectRisk = By.id("c_F3Rindirectos_0");
    public final By chkUpdtaBalance = By.xpath("//*[@id=\'container_26\']/table/tbody/tr/td/span[2]/input[2]");

    public By getTabAnalysisCred() { return this.tabAnalysisCred; }
    public By getTxtSubsCancel() { return this.txtSubsCancel; }
    public By getAtxtComment() { return this.atxtComment; }
    public By getTabActPasiv() { return this.tabActPasiv; }
    public By getTxtPatrimony() { return this.txtPatrimony; }
    public By getTxtConfirmedPatr() { return this.txtConfirmedPatr; }
    public By getTxtIndirectRisk() { return this.txtIndirectRisk; }
    public By getChkUpdtaBalance() { return chkUpdtaBalance; }
}
