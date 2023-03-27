package appium.Testes;

import appium.DSL.BaseTest;
import appium.PageObjects.Basepage;
import appium.PageObjects.MenuPage;
import appium.PageObjects.SwippePage;
import org.junit.Assert;
import org.junit.Test;

public class SwippeTeste extends BaseTest {
    private MenuPage menuPage = new MenuPage();
    private SwippePage swippePage = new SwippePage();
    private  Basepage basepage = new Basepage();
    @Test
    public void deveRealizarSwippe(){
        //Entrar MenuSwippe
        menuPage.acessarSwippeMenu();
        //Verificar texto "a esquerda"
        Assert.assertTrue(menuPage.verificarElementoPorTexto("a esquerda"));
        //Swippe a direita
        basepage.swipeRight();
        //menuPage.swipe(0.9,0.1); //90% ate 10%
        //verificar texto "E veja se"
        Assert.assertTrue(menuPage.verificarElementoPorTexto("E veja se"));
        //Clicar botão direita
        swippePage.clicarBotaoSwipeDireita();
        //Vericar texto "Chegar até o fim"
        Assert.assertTrue(menuPage.verificarElementoPorTexto("Chegar até o fim!"));
        //Clicar botão esquerda
        menuPage.swipeLefth();
        //menuPage.swipe(0.1,0.9); //10% ate 90%
        //Verificar texto esquerda
        Assert.assertTrue(menuPage.verificarElementoPorTexto("E veja se"));
    }


}
