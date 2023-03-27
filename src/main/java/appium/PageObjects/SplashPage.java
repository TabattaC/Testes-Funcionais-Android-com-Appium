package appium.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static appium.driverFactory.DriverFactory.getDriver;

public class SplashPage extends Basepage {
    public boolean isTelaSplashEVisivel(){
        return verificarElementoPorTexto("Splash!");
    }

    public void aguardarSaidaSplash(){
        getDriver().manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='Splash!']")));
    }
}
