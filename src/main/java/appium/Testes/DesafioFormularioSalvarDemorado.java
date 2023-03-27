package appium.Testes;

import appium.DSL.BaseTest;
import appium.PageObjects.FormularioPage;
import appium.PageObjects.MenuPage;
import appium.driverFactory.DriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

import static appium.driverFactory.DriverFactory.getDriver;


public class DesafioFormularioSalvarDemorado extends BaseTest {
    private MenuPage menu = new MenuPage();
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

        //Clicar em salvar o cadastro (Salvar demorado)
        formularioPage.salvarCadastroDemorado();
        //wait(3000);
        //WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),10);
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]");

        //Verificar se os campos salvos estão corretos
        String nomeResultado = formularioPage.obterNomeCadastrado();
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
