package appium.PageObjects;

import appium.DSL.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;

public class AlertaPage extends Basepage {
MenuPage menuPage = new MenuPage();
Basepage basepage = new Basepage();
    public void acessarAlertaDeConfirmacao(){
        menuPage.clicarPorTexto("ALERTA CONFIRM");
    }
    public String obterMessageAlert(){
        return  getText(By.id("android:id/message"));
    }

    public void acessarAlertaSimples(){
        menuPage.clicarPorTexto("ALERTA SIMPLES");
    }
    public void clicarForaDoAlerta(int x, int y){

        basepage.tap(x,y);
    }
}
