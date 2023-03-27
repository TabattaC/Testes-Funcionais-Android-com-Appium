package appium.DSL;

import appium.driverFactory.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;


public class BaseTest {
    @Rule
    public TestName testName = new TestName();
    @AfterClass
    public static void finalizarClasse(){
        DriverFactory.killDriver();
    }
    @After
    public void sair() {
        gerarScreenShot();
        DriverFactory.getDriver().resetApp();
    }

    public void gerarScreenShot(){
       File imagem = (File) DriverFactory.getDriver().getScreenshotAs(OutputType.FILE);
       try{
           FileUtils.copyFile(imagem,new File("target/screenShot/"+ testName.getMethodName()+".png"));
       }catch (IOException e){
           e.printStackTrace();
       }
    }

    public void wait(int tempo){
        try{
            Thread.sleep(tempo);
        }catch (InterruptedException erro){
            erro.printStackTrace();
        }
    }
}
