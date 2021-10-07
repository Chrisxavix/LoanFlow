package pom.pages.transactions;

import org.openqa.selenium.By;

public class Tr063040 {

    /* VARIABLES */

    /* Número de Solicitud */
    private final By txtRequestNumber = By.xpath("//*[@id='container_4']/table/tbody/tr[1]/td[2]/input");
    /* DESTINO DE LA OPERACIÓN: Do */
    private final By txtDoComment = By.xpath("//*[@id='container_18']/table/tbody/tr/td/textarea");
    /* Grupo del producto, validación */
    private final By txtGpProductValue = By.xpath("//*[@id='container_11']/div/table/tbody/tr/td[1]/input");

    /* GETTERS */

    /* Número de Solicitud */
    public By getTxtRequestNumber() { return this.txtRequestNumber; }
    /* DESTINO DE LA OPERACIÓN: Do */
    public By getTxtDoComment() { return this.txtDoComment; }
    /* Grupo del producto, validación */
    public By getTxtGpProductValue() { return this.txtGpProductValue; }
}
