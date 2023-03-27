package appium.PageObjects;

import appium.driverFactory.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;

public class SwippePage extends Basepage{
    public void clicarBotaoSwipeDireita() {
        clicarPorTexto("›");
    }

    public void swipeElemetoRigth(String opcao){
        swipeElemento(DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")),0.9,0.1);
    }

    public void swipeElemetoLeft(String opcao){
        swipeElemento(DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")),0.1,0.9);
    }

    public void clicarMais(){
        MobileElement botaoMais = DriverFactory.getDriver().findElement(By.xpath("//*[@text='(+)']/.."));
        new TouchAction(DriverFactory.getDriver()).tap(botaoMais,-50,0).perform();
    }
}
