package pom.pages.transactions;

import org.openqa.selenium.By;

public class Tr063005 {

    private final By txtLoan = By.xpath("//*[@id=\'container_0\']/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/input[1]");
    private final By txtOpenDate = By.xpath("//*[@id=\"container_8\"]/table/tbody/tr/td[3]/table/tbody/tr[3]/td[2]/input[1]");

    private final By txtStarDatePay = By.xpath("//*[@id=\'container_8\']/table/tbody/tr/td[3]/table/tbody/tr[2]/td[2]/input[1]");

    private final By txtFixedDayPay = By.id("c_w1_fijopago_0");
    private final By tbPrintDocuments = By.xpath("//*[@id=\'container_11\']/div/table/tbody/tr");

    public By getTxtLoan() { return this.txtLoan; }
    public By getTxtOpenDate() { return this.txtOpenDate; }
    public By getTxtStarDatePay() { return this.txtStarDatePay; }
    public By getTxtFixedDayPay() { return this.txtFixedDayPay; }
    public By getTbPrintDocuments() { return this.tbPrintDocuments; }

    public String getTxtPrintDocCod1Part1() { return "//*[@id=\"container_11\"]/div/table/tbody/tr["; }
    public String getTxtPrintDocCod1Part2() { return "]/td[1]/input"; }
    public String getBtnPrintPart1() { return "//*[@id=\"container_11\"]/div/table/tbody/tr["; }
    public String getBtnPrintPart2() { return "]/td[4]/button"; }
}
