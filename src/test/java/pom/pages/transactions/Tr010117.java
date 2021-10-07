package pom.pages.transactions;

import org.openqa.selenium.By;

public class Tr010117 {

    /* VARIABLES */

    /* INGRESO Y MODIFICACION DE USUARIOS: Imu */
    private final By txtImuUser = By.xpath("//*[@id='container_1']/div/table/thead/tr[1]/td[3]/input");
    private final By txtImuUserType = By.xpath("//*[@id='container_0']/table/tbody/tr/td[2]/input[1]");
    private final By txtImuF1UserType = By.xpath("//*[@id='container_1']/div/table/tbody/tr[1]/td[3]/input");

    /* GETTERS */

    /* INGRESO Y MODIFICACION DE USUARIOS: Imu */
    public By getTxtImuUser() { return this.txtImuUser; }
    public By getTxtImuUserType() { return this.txtImuUserType; }
    public By getTxtImuF1UserType() { return this.txtImuF1UserType; }
}
