package pom.pages.transactions;

import org.openqa.selenium.By;

public class Tr062033 {

    /* VARIABLES */

    /* APROBACIÓN DE ANÁLISIS DE RIESGOS: Aar */
    private final By txtRequestNumber = By.xpath("//*[@id='container_3']/table/tbody/tr[1]/td[2]/input");
    /* Comentario */
    private final By txtAarComment = By.xpath("//*[@id='container_19']/table/tbody/tr/td/textarea");
    /* Botón de Aprobar */
    private final By btnAarRiskAnalysisApproval = By.xpath("//*[@id='container_20']/table/tbody/tr/td/button[1]");

    /* GETTERS */

    /* APROBACIÓN DE ANÁLISIS DE RIESGOS */
    public By getTxtRequestNumber() { return this.txtRequestNumber; }
    /* Comentario */
    public By getTxtAarComment() { return this.txtAarComment; }
    /* Botón de Aprobar */
    public By getBtnAarRiskAnalysisApproval() { return this.btnAarRiskAnalysisApproval; }
}
