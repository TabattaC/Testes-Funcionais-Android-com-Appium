package appium.PageObjects.SBnative;

import appium.PageObjects.Basepage;
import org.openqa.selenium.By;

public class SBcontasPage extends Basepage {

    public void acessarConta() {
        clicarPorTexto("CONTAS");
    }

    public void escreverNomeConta(String nomeConta) {
        setText(By.className("android.widget.EditText"), nomeConta);
    }

    public void clicarBotaoSalvar(){
        clicarPorTexto("SALVAR");
    }

    public String getMensagemContaSalva(){
      return getText(By.xpath("//*[@text='Conta adicionada com sucesso']"));
    }
    public String getMensagemContaExcluida(){
      return getText(By.xpath("//*[@text='Conta excluída com sucesso']"));
    }

    public void selecionarConta(String conta){
        clicarCliqueLongo(By.xpath("//*[@text='"+conta+"']"));
    }
    public void clicarBotaoExcluir(){
        clicarPorTexto("EXCLUIR");
    }

    public void acessarMovimentacao(){
        clicarPorTexto("MOV...");
    }
    public void acessarResumo(){
        clicarPorTexto("RESUMO");
    }
}
