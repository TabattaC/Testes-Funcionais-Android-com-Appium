package appium.PageObjects;

import appium.driverFactory.DriverFactory;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;

public class CliquePage {
    private Basepage basepage =new Basepage();
    public void clicarCliqueLongo(){
        new TouchAction(DriverFactory.getDriver()).longPress(DriverFactory.getDriver().findElement(By.xpath("//*[@text='Clique Longo']"))).perform();
    }
    public String obterTextoCliqueLongo(){
        //O xpath está em parenteses para pegar tudo.
        return DriverFactory.getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
    }
    public void clicarCliqueDuplo(){
        basepage.clicarPorTexto("Clique duplo");
        basepage.clicarPorTexto("Clique duplo");
    }
}
