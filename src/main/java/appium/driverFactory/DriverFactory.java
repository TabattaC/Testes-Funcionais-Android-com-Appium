package appium.driverFactory;

import appium.DSL.BaseTest;
import appium.PageObjects.Basepage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class DriverFactory extends BaseTest {
    private static AndroidDriver<MobileElement> driver;

    /**
     * O método vai inicializar o driver se não tiver nenhum driver inicializado
     * Dentro do if ele será inicializado
     *
     * @return Este metodo retorna o driver
     */
    public static AndroidDriver<MobileElement> getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }


    private static void createDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/Tabatta/IdeaProjects/CursoAppiumCalculadora/src/main/resources/CTAppium_1_2.apk");

        try {
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver<MobileElement>(url, desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //É necessario do android de conexão
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void killDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
