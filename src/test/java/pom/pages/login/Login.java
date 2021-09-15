package pom.pages.login;

import org.openqa.selenium.By;

public class Login {

    private final By txtUser = By.xpath("//*[@id='ingreso']/input[1]");
    private final By txtPassword = By.xpath("//*[@id='ingreso']/input[2]");
    private final By btnSubmit = By.xpath("//*[@id='ingreso']/p[2]/input");
    private final By linkMoreOptions = By.id("mas_opciones");
    private final By btnForceClose = By.id("cierre");

    public By getTxtUser() { return this.txtUser; }
    public By getTxtPassword() { return this.txtPassword; }
    public By getBtnSubmit() { return this.btnSubmit; }
    public By getLinkMoreOptions() { return this.linkMoreOptions; }
    public By getBtnForceClose() { return this.btnForceClose; }
}
