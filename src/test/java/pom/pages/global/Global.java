package pom.pages.global;

import org.openqa.selenium.By;

public class Global {
    /* Barra inferior de estados */
    private final By boxCodeTransaction = By.id("entorno-pt");
    private final By txtStatus = By.id("entorno-estatus-contenido");
    private final By btnF12 = By.xpath("//*[@id='entorno-teclas']/button[9]");
    private final By btnF7 = By.xpath("//*[@id='entorno-teclas']/button[5]");

    public By getBoxCodeTransaction() { return this.boxCodeTransaction; }
    public By getTxtStatus() { return this.txtStatus; }
    public By getBtnF12() { return this.btnF12; }
    public By getBtnF7() { return this.btnF7; }
}
