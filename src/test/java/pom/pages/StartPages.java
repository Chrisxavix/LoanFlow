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
    /* Obtiene el driver desde el Hook */
    protected WebDriver driver = Hook.getDriver();
    /* Navegador Incógnito */
    protected String userIncognit;
    /* Tiempos de espera */
    protected static final int timeBase = 15;
    protected static final int timeMedium = 30;
    protected static final int timeSave = 60;
    /* Inicializa las páginas generales */
    protected Login loginPage = new Login();
    protected Messages message = new Messages();
    protected Global global = new Global();
    /* Capturador de pantallas por nombre de transacción */
    protected static int caseScreen = 0;
    protected static final String caseScreenLogin = "Tx00_login";
    protected static final String caseScreenTx062100 = "Tx01_06_2100";
    protected static final String caseScreenTx062000 = "Tx02_06_2000";
    protected static final String caseScreenTx062008 = "Tx03_06_2008";
    protected static final String caseScreenTx062016 = "Tx04_06_2016";
    protected static final String caseScreenTx000267 = "Tx05_00_0267";
    protected static final String caseScreenTx063071 = "Tx06_06_3071";
    protected static final String caseScreenTx063040 = "Tx07_06_3040";
    protected static final String caseScreenTx063078 = "Tx08_06_3078";
    protected static final String caseScreenTx063080 = "Tx09_06_3080";
    protected static final String caseScreenIncognitoLogin = "Tx10_LoginIncognito01";
    protected static final String caseScreenTx002008 = "Tx11_00_2008Incognito01";
    protected static final String caseScreenTx002009 = "Tx12_00_2009Incognito01";
    protected static final String caseScreenTx062033 = "Tx13_06_2033Incognito01";
    protected static final String caseScreenTx062001 = "Tx14_06_2001";
    protected static final String caseScreenIncognitoLogin2 = "Tx15_LoginIncognito02";
    protected static final String caseScreenTx002008Incognito = "Tx16_00_2008Incognito02";
    protected static final String caseScreenTx062001Incognito = "Tx17_06_2001Incognito02";
    /* Clases de Mapeo */
    protected static final Tr062100 tr062100 = new Tr062100();
    protected static final Tr062000 tr062000 = new Tr062000();
    protected static final Tr062016 tr062016 = new Tr062016();
    protected static final Tr062008 tr062008 = new Tr062008();
    protected static final Tr063071 tr063071 = new Tr063071();
    protected static final Tr000267 tr000267 = new Tr000267();
    protected static final Tr063078 tr063078 = new Tr063078();
    protected static final Tr063040 tr063040 = new Tr063040();
    protected static final Tr063080 tr063080 = new Tr063080();
    protected static final Tr002008 tr002008 = new Tr002008();
    protected static final Tr002009 tr002009 = new Tr002009();
    protected static final Tr062033 tr062033 = new Tr062033();
    protected static final Tr062001 tr062001 = new Tr062001();
    /* Lectura de datos del excel */
    protected final Utilities util = new Utilities();
    protected final List<String> loanFlow = util.readExcel();
    /* Número de Solicitud */
    protected String requestNumber;
    /* Número de Crédito */
    protected String creditNumber;
}
