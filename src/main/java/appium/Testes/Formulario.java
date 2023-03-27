package appium.Testes;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Formulario {
    @Test
    public void devePreencherCampoTexto() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/Tabatta/IdeaProjects/CursoAppiumCalculadora/src/main/resources/CTAppium_1_2.apk");

        //É necessario do android de conexão
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver<MobileElement> driver = new AndroidDriver(url, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Selecionar o Formulario
        List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
        elementosEncontrados.get(1).click();

        //Escrever o nome no campo
        MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
        campoNome.sendKeys("Tábatta");

        //Checar o texto escrito
        String nome = campoNome.getText();
        Assert.assertEquals("Erro não Funcional - Nome prenechido no campo (nome) está incorreto.", "Tábatta", nome);
        driver.quit();
    }

    @Test
    public void devePreencherCombo() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/Tabatta/IdeaProjects/CursoAppiumCalculadora/src/main/resources/CTAppium_1_2.apk");

        //É necessario do android de conexão
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver<MobileElement> driver = new AndroidDriver(url, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Selecionando formulário utizando o find Xpath do elemento
        driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();

        //Escrever o nome no campo utizando o find Xpath do elemento
        MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
        campoNome.sendKeys("Tábatta");

        //Clicar no combo
        driver.findElement(MobileBy.AccessibilityId("console")).click();

        //Seleciona opção do combo desejada
        driver.findElement(MobileBy.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();
        //Verificar a opcao desejada esta correta
        String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
        Assert.assertEquals("Erro não Funcional - O campo selecionado está incorreto", "PS4", text);

        //Checar o texto escrito
        Assert.assertEquals("Erro não Funcional - Nome prenechido no campo (nome) está incorreto.", "Tábatta", campoNome.getText());
        driver.quit();
    }

    @Test
    public void deveAtivarComboBoxEDesativarSwitch() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/Tabatta/IdeaProjects/CursoAppiumCalculadora/src/main/resources/CTAppium_1_2.apk");

        //É necessario do android de conexão
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver<MobileElement> driver = new AndroidDriver(url, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Selecionando formulário utizando o find Xpath do elemento
        //Qualquer elemento que tiver o nome Formulário
        driver.findElement(By.xpath("//*[@text='Formulário']")).click();

        //Verificar o status dos elementos
        MobileElement checkBox = driver.findElement(By.xpath("//android.widget.CheckBox[@content-desc='check']"));
        MobileElement swtche = driver.findElement(By.xpath("//android.widget.Switch[@content-desc='switch']"));
        Assert.assertTrue("O checkBox não está desativado", checkBox.getAttribute("checked").equals("false"));
        Assert.assertTrue("O checkBox não está desativado", swtche.getAttribute("checked").equals("true"));
        //Clicar no combox
        checkBox.click();
        swtche.click();
        //Verificar status depois da alteracao
        Assert.assertFalse("O checkBox não está desattivado", checkBox.getAttribute("checked").equals("false"));
        Assert.assertFalse("O checkBox não está desattivado", swtche.getAttribute("checked").equals("true"));

        //Clicar em salvar o cadastro
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='save']/android.widget.TextView")).click();

    }

}