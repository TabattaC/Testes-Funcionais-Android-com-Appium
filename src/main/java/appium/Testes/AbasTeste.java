package appium.Testes;

import appium.DSL.BaseTest;
import appium.PageObjects.AbasPage;
import appium.PageObjects.Basepage;
import appium.PageObjects.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AbasTeste extends BaseTest {
    private Basepage basepage = new Basepage();
    private MenuPage menuPage = new MenuPage();
    private AbasPage abasPage = new AbasPage();

    @Test
    public void clicarEmAbas() {
        //Clicar am abas no na page de Menu
        menuPage.acessarAbaMenu();
        //Clicar na aba 1 e verificar que esta na aba 1
        Assert.assertTrue(abasPage.isAba1());
        //Acessar aba 2 e verificar que está na aba 2
        abasPage.clicarAba2();
        Assert.assertTrue(abasPage.isAba2());

    }

}
