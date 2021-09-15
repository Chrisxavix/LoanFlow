package steps.pom.pages;

import org.openqa.selenium.WebDriver;
import steps.hook.Hook;
import steps.pom.messages.Messages;
import steps.pom.pages.global.Global;
import steps.pom.pages.login.Login;
import steps.pom.pages.transactions.Tr062100;
import steps.pom.utilities.Utilities;
import java.io.IOException;
import java.util.List;

public class StartPages {
    /* Constructor con excepciones dadas por el excel */
    public StartPages() throws IOException { }
    protected WebDriver driver = Hook.getDriver();
    /* Tiempos de espera */
    protected static final int timeBase = 15;
    /* Inicializa las páginas */
    protected Login loginPage = new Login();
    protected Messages message = new Messages();
    protected Global global = new Global();
    /* Capturador de pantallas por transacción */
    protected static int caseScreen = 0;
    protected static final String caseScreenLogin = "login";
    protected static final Tr062100 tr062100 = new Tr062100();

    /* Lectura de datos del excel */
    protected final Utilities util = new Utilities();
    protected final List<String> loanFlow = util.readExcel();
}
