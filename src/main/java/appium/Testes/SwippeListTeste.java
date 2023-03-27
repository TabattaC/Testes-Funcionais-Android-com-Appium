package appium.Testes;

import appium.DSL.BaseTest;
import appium.PageObjects.Basepage;
import appium.PageObjects.MenuPage;
import appium.PageObjects.SwippePage;
import org.junit.Assert;
import org.junit.Test;

public class SwippeListTeste extends BaseTest {
    /**
     * Teste Desafio
     * 1 - Clicar swipe List
     * 2 - Arrastar opc1 para "Direita"
     * 3 - Clicar op1(+)
     * 4 - Verificar texto op1+
     * 5 - Arrastar opc4 para"Direita"
     * 6 - Clicar op4(+)
     * 7 - 4 - Verificar texto op4+
     * 8 - Arrastar op5 para "Esquerda"
     * 9 - Fim Teste
     */
   private MenuPage menuPage = new MenuPage();
   private Basepage basepage = new Basepage();

   private SwippePage swippePage = new SwippePage();
    @Test
    public void desafioSwipeList() {
        menuPage.acessarSwippeListMenu();

        swippePage.swipeElemetoRigth("Opção 1");

        swippePage.clicarMais();

        Assert.assertTrue(menuPage.verificarElementoPorTexto("Opção 1 (+)"));

        swippePage.swipeElemetoRigth("Opção 4");

        menuPage.clicarPorTexto("(-)");

        Assert.assertTrue(menuPage.verificarElementoPorTexto("Opção 4 (-)"));

        swippePage.swipeElemetoLeft("Opção 5 (-)");

        Assert.assertTrue(menuPage.verificarElementoPorTexto("Opção 5"));


    }
}
