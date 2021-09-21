package pom.pages;

import org.openqa.selenium.WebDriver;
import pom.pages.transactions.*;
import steps.hook.Hook;
import pom.messages.Messages;
import pom.pages.global.Global;
import pom.pages.login.Login;
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
    protected static final String caseScreenTx062100 = "Tx1_06_2100";
    protected static final String caseScreenTx062000 = "Tx2_06_2000";
    protected static final String caseScreenTx062016 = "Tx4_06_2016";
    protected static final String caseScreenTx062008 = "Tx3_06_2008";
    protected static final String caseScreenTx063071 = "Tx6_06_3071";
    protected static final String caseScreenTx000267 = "Tx5_00_0267";
    /* Clases de Mapeo */
    protected static final Tr062100 tr062100 = new Tr062100();
    protected static final Tr062000 tr062000 = new Tr062000();
    protected static final Tr062016 tr062016 = new Tr062016();
    protected static final Tr062008 tr062008 = new Tr062008();
    protected static final Tr063071 tr063071 = new Tr063071();
    protected static final Tr000267 tr000267 = new Tr000267();
    /* Lectura de datos del excel */
    protected final Utilities util = new Utilities();
    protected final List<String> loanFlow = util.readExcel();
    /* Número de Solicitud */
    protected String requestNumber;
}
