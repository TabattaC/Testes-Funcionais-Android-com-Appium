package appium.Testes;

import appium.DSL.BaseTest;
import appium.PageObjects.Basepage;
import appium.PageObjects.FormularioPage;
import appium.PageObjects.MenuPage;
import io.appium.java_client.MobileBy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import static appium.driverFactory.DriverFactory.getDriver;


public class DesafioFormulario extends BaseTest {
    private MenuPage menu = new MenuPage();
    private Basepage basepage = new Basepage();
    private FormularioPage formularioPage = new FormularioPage();

    @Before
    public void inicializarAppium() throws MalformedURLException {
        getDriver();
    }

    public void entrarNoFormulario() {
        menu.acessarFormulario();
    }


    @Test
    public void desafioFormulario() throws MalformedURLException {
        //Metodo entrar no fomulario
        entrarNoFormulario();

        //Escrever o nome no campo
        formularioPage.escreverNomeFormulario("Tábatta Cerri");

        //Checar o texto escrito

        String nome = formularioPage.obterNomeDoFormulario();
        Assert.assertEquals("Erro não Funcional - Nome prenechido no campo (nome) está incorreto.", "Tábatta Cerri", nome);

        //Clicar Combox
        formularioPage.selecionarCombo("PS4");

        //Verificar a opcao desejada esta correta
        String text = formularioPage.obterValordoCombo();
        Assert.assertEquals("Erro não Funcional - O campo selecionado está incorreto", "PS4", text);

        //Verificar o status dos elementos
        Assert.assertFalse("O checkBox não está desativado", formularioPage.isCheckedMarcado());
        Assert.assertTrue("O Switch não está desativado", formularioPage.isSwitchMarcado());

        //Clicar no combox
        formularioPage.clicarCheck();
        formularioPage.clicarSwitch();

        //Verificar status depois da alteracao
        Assert.assertTrue("O checkBox não está desativado", formularioPage.isCheckedMarcado());
        Assert.assertFalse("O Switch não está desativado", formularioPage.isSwitchMarcado());

        //Adicionar data
        basepage.clicarPorTexto("01/01/2000");
        basepage.clicarPorTexto("20");
        basepage.clicarPorTexto("OK");

        //Assert.assertTrue(basepage.elementoExiste(By.xpath("//*[contains(text(),'20/02/2000')]")));

        //Alterar as horas do cadastro
        basepage.clicarPorTexto("06:00");
        basepage.clicar(MobileBy.AccessibilityId("10"));
        basepage.clicar(MobileBy.AccessibilityId("40"));
        basepage.clicarPorTexto("OK");
        Assert.assertTrue(basepage.verificarElementoPorTexto("10:40"));

        // Deve Interragir com Seekbar
        //Clicar no seekbar
        formularioPage.clicarSeekbar(0.67);

        //Clicar em salvar o cadastro
        formularioPage.salvarCadastro();

        //Verificar se os campos salvos estão corretos
        String nomeResultado = formularioPage.obterNomeDoFormulario();
        String console = formularioPage.obterConsoleCadastrado();
        String switche = formularioPage.obterSwicth();
        String checkBoxResult = formularioPage.obterCheckBoxResult();


        //TestesAsserts
        Assert.assertEquals("O nome adicionado não está correto", nome, nomeResultado);
        Assert.assertEquals("O nome console não está correto", text, console.toUpperCase());
        Assert.assertEquals("O switch não foi desativado", "Off", switche);
        Assert.assertEquals("O Check box não foi marcado", "Marcado", checkBoxResult);
    }
}
