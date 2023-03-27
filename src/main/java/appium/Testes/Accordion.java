package appium.Testes;

import appium.DSL.BaseTest;
import appium.PageObjects.AccordionPage;
import appium.PageObjects.Basepage;
import appium.PageObjects.MenuPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Accordion extends BaseTest {
    private MenuPage menuPage = new MenuPage();
    private AccordionPage accordionPage = new AccordionPage();
    @Test
    public void interragirComAccordion() {
        //acessar menu
        menuPage.acessarAccordion();
        //Clicar opcoes e verificar as opcoes
        accordionPage.clicoOpcao1();
        Assert.assertEquals("Texto está diferente do esperado","Esta é a descrição da opção 1", accordionPage.obterTextOpcao1());
    }

}
