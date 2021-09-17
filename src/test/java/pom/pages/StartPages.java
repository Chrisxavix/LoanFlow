package pom.pages;

import org.openqa.selenium.WebDriver;
import pom.pages.transactions.Tr062000;
import steps.hook.Hook;
import pom.messages.Messages;
import pom.pages.global.Global;
import pom.pages.login.Login;
import pom.pages.transactions.Tr062100;
import pom.utilities.Utilities;
import java.io.IOException;
import java.util.List;

public class StartPages {
    /* Constructor con excepciones dadas por el excel */
    public StartPages() throws IOException { }
    protected WebDriver driver = Hook.getDriver();
    /* Tiempos de espera */
    protected static final int timeBase = 15;
    protected static final int timeMedium = 30;
    protected static final int timeSave = 60;
    /* Inicializa las páginas */
    protected Login loginPage = new Login();
    protected Messages message = new Messages();
    protected Global global = new Global();
    /* Capturador de pantallas por transacción */
    protected static int caseScreen = 0;
    protected static final String caseScreenLogin = "login";
    protected static final Tr062100 tr062100 = new Tr062100();
    protected static final Tr062000 tr062000 = new Tr062000();

    /* Lectura de datos del excel */
    protected final Utilities util = new Utilities();
    protected final List<String> loanFlow = util.readExcel();

    /* Número de Solicitud */
    protected String requestNumber = "7511000698";
}
