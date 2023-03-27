package appium.Testes;

import appium.DSL.BaseTest;
import appium.PageObjects.Basepage;
import appium.PageObjects.MenuPage;
import appium.PageObjects.SplashPage;
import org.junit.Assert;
import org.junit.Test;


public class SpashTeste extends BaseTest {
    MenuPage menuPage = new MenuPage();
    SplashPage splashPage = new SplashPage();
    @Test
    public void deveAguardarSpashSumir(){
        //Acessar menu spash
        menuPage.acessarSplash();

        //Verificar que o spash esta sendo exibido
        splashPage.isTelaSplashEVisivel();

        //Aguardar a saida do spash
        splashPage.aguardarSaidaSplash();

        //verificar que o formulario esta aparecendo
        Assert.assertTrue(menuPage.verificarElementoPorTexto("Formulário"));
    }
}
