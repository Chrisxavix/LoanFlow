package pom.pages.transactions;

import org.openqa.selenium.By;

public class Tr063071 {

    /* VARIABLES */

    public final By txtNumSoli = By.id("c_F1Csolicitudpri_0");
    public final By tbCheckList = By.xpath("//*[@id='container_5']/div/table/tbody/tr");
    public final By btnSaveChkList = By.id("c_c4_btnGuardarCondic_0");

    /* GETTERS */

    public String getChkPart1 () { return "//*[@id='container_5']/div/table/tbody/tr[";}
    public String getChkPart2 () { return "]/td[2]/span/input[2]";}
    public By getTxtNumSoli() { return this.txtNumSoli; }
    public By getTbCheckList() { return this.tbCheckList; }
    public By getBtnSaveChkList() { return this.btnSaveChkList; }
}
