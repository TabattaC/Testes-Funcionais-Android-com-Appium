package appium.Testes;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Calculadora {
    private AndroidDriver<MobileElement> inicializarAppium() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/Tabatta/IdeaProjects/CursoAppiumCalculadora/src/main/resources/CTAppium_1_2.apk");

        //É necessario do android de conexão
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver<MobileElement> driver = new AndroidDriver(url, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
    @Test
    public void devePreencehrCampoTexto() throws MalformedURLException {
        AndroidDriver<MobileElement> driver = inicializarAppium();

        //Selecionar o Formulario

        MobileElement el3 = driver.findElementById("com.google.android.calculator:id/digit_2");
        el3.click();
        MobileElement el4 = driver.findElementByAccessibilityId("plus");
        el4.click();
        MobileElement el5 = driver.findElementById("com.google.android.calculator:id/digit_2");
        el5.click();
        MobileElement el6 = driver.findElementById("com.google.android.calculator:id/result_preview");
        System.out.println(el6.getText());
        Assert.assertEquals("Erro Funcional - A soma dos valores não está correta", "4", el6.getText());
        // Deve encerar a sessão com o appium
        driver.quit();
    }
}