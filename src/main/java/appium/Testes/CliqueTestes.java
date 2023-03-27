package appium.Testes;

import appium.DSL.BaseTest;
import appium.PageObjects.CliquePage;
import appium.PageObjects.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CliqueTestes extends BaseTest {
    private MenuPage menuPage = new MenuPage();
    private CliquePage cliquePage= new CliquePage();
    @Before
    public void setup(){
        //Acessar Menu Clique
        menuPage.acessarCliqueMenu();
    }
    @Test
    public void deveRealizarCliqueLongo(){
        //Clique longo
        cliquePage.clicarCliqueLongo();
        //Verificar Texto
        Assert.assertEquals("Otexto está diferente do esperado","Clique Longo", cliquePage.obterTextoCliqueLongo());
    }

    @Test
    public void deveRealizarCliqueDuplo(){
        //Clique Duplo
        cliquePage.clicarCliqueDuplo();
        //Verificar Texto
        Assert.assertEquals("Otexto está diferente do esperado","Duplo Clique", cliquePage.obterTextoCliqueLongo());
    }




}
