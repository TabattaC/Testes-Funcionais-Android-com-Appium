package appium.PageObjects.SBnative;

import appium.PageObjects.Basepage;
import appium.driverFactory.DriverFactory;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class SBresumoPage extends Basepage {


    public void exluirMovimentacao(String descricao){
        //Encontrar o elemento e subi um nivel
        MobileElement elemento = DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+descricao+"']/.."));
        swipeElemento(elemento,0.9,0.1);
        clicarPorTexto("Del");
    }
}
