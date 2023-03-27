package appium.Testes;

import appium.DSL.BaseTest;
import appium.PageObjects.Basepage;
import appium.PageObjects.MenuPage;
import appium.PageObjects.WebViewPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class WebViewTeste extends BaseTest {
    private MenuPage menuPage = new MenuPage();
    private Basepage basepage = new Basepage();
    private WebViewPage webViewPage = new WebViewPage();
    @Test
    public void deveFazerLogin() {
        /**
         * 1 - Acessar Menu
         * 2 - Preencher email
         * 3 - Prenncher senha
         * 4 - Entrar
         */
        menuPage.acessarSeuBarrigaHibrido();
        wait(3000);
        basepage.entrarContextoWeb();
        webViewPage.setEmail("tabatta@email.com");
        webViewPage.setSenha("senha123");
        webViewPage.botaoEntrar();
        Assert.assertEquals("Bem vindo, Tabatta!",webViewPage.getMensagemLogin());

    }

    @After
    public void tearDown(){
        basepage.sairContextoWeb();
    }
}
