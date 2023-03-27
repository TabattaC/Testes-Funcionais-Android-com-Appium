package appium.Testes;

import appium.DSL.BaseTest;
import appium.PageObjects.Basepage;
import appium.PageObjects.FormularioPage;
import appium.PageObjects.ScrollPage;
import appium.driverFactory.DriverFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScrollTeste extends BaseTest {
    private Basepage basepage = new Basepage();
    private FormularioPage formularioPage = new FormularioPage();
    private ScrollPage scrollPage = new ScrollPage();

    @Test
    public void deveEncontrarOpcaoEscondida() {
        //Scroll Down
        //Fazer um wait por elemento
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
        System.out.println("Começando....");
        basepage.scroll(0.9, 0.1);
        //Clicar menu
        formularioPage.clicarOpcaoEscondida();
        //Verificar mensagem
        Assert.assertEquals("Você achou essa opção", scrollPage.obterMessageAlert() );
        //Fechar mensagem
        basepage.clicarPorTexto("OK");
    }
}
