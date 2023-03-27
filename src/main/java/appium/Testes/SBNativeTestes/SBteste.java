package appium.Testes.SBNativeTestes;

import appium.DSL.BaseTest;
import appium.PageObjects.Basepage;
import appium.PageObjects.MenuPage;
import appium.PageObjects.SBnative.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SBteste extends BaseTest {
    private MenuPage menuPage = new MenuPage();
    private SBloginPage sBloginPage = new SBloginPage();
    private SBcontasPage sBcontasPage = new SBcontasPage();
    private Basepage basepage = new Basepage();
    private SBresumoPage sBresumoPage = new SBresumoPage();
    private SBmovimetacaoPage sBmovimetacaoPage = new SBmovimetacaoPage();
    private SBMenuPage sbMenuPage = new SBMenuPage();

    @Before
    public void setup() {
        menuPage.acessarSeuBarrigaNativo();
        sBloginPage.setLogin("tabatta@email.com");
        sBloginPage.setSenha("senha123");
        sBloginPage.clicoBotaoEntrar();
    }

    @Test
    public void adicionarConta() {
        sBcontasPage.acessarConta();
        sBcontasPage.escreverNomeConta("Tabatta conta 1");
        sBcontasPage.clicarBotaoSalvar();
        Assert.assertEquals("Conta adicionada com sucesso", sBcontasPage.getMensagemContaSalva());

    }

    @Test
    public void excluirConta() {
        sBcontasPage.acessarConta();
        sBcontasPage.selecionarConta("Tabatta conta 1");
        sBcontasPage.clicarBotaoExcluir();
        Assert.assertEquals("Conta excluída com sucesso", sBcontasPage.getMensagemContaExcluida());

    }

    @Test
    public void validarInclusaoMovimentacao() {
        sBcontasPage.acessarMovimentacao();
        //validar Descrição
        sBmovimetacaoPage.clicarSalvar();
        Assert.assertTrue(basepage.verificarElementoPorTexto("Descrição é um campo obrigatório"));

        //Validar mensagem de erro ao salvar sem interresado
        sBmovimetacaoPage.setDescricao("Tabatta");
        sBmovimetacaoPage.clicarSalvar();
        Assert.assertTrue(basepage.verificarElementoPorTexto("Interessado é um campo obrigatório"));

        //Validar mensagem de erro ao salvar sem valor
        sBmovimetacaoPage.setInteressado("TesteAppium");
        sBmovimetacaoPage.clicarSalvar();
        Assert.assertTrue(basepage.verificarElementoPorTexto("Valor é um campo obrigatório"));

        //Validar Conta
        sBmovimetacaoPage.setValor("1300,90");
        sBmovimetacaoPage.clicarSalvar();
        Assert.assertTrue(basepage.verificarElementoPorTexto("Conta é um campo obrigatório"));

        //Salvar conta cm sucesso
        sBmovimetacaoPage.setConta("Conta para alterar");
        sBmovimetacaoPage.clicarSalvar();
        Assert.assertTrue(basepage.verificarElementoPorTexto("Movimentação cadastrada com sucesso!"));
    }

    @Test
    public void deveAtualizaorSaldoAoExcluirMovimentacao() {
        //Verificar o saldo na tela HOME
        Assert.assertEquals("534.00", sBmovimetacaoPage.obterSaldoConta("Conta para saldo"));
        //Acessar resumo
        sBcontasPage.acessarResumo();
        //Excluir movimentação 3
        sBresumoPage.exluirMovimentacao("Movimentacao 3, calculo saldo");
        //Validar mensagem de excluisão de movimentação
        Assert.assertTrue(sBresumoPage.verificarElementoPorTexto("Movimentação removida com sucesso!"));
        //Retornar para HOME
        sbMenuPage.acessarHome();
        //Atualizar Pagina
        wait(1000);
        sbMenuPage.atualizarHome();
        //Verificar que saldo fique -1000
        Assert.assertEquals("-1000.00", sBmovimetacaoPage.obterSaldoConta("Conta para saldo"));


    }
}
