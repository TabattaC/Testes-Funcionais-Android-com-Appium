package appium.PageObjects.SBnative;

import appium.PageObjects.Basepage;
import appium.PageObjects.SwippePage;
import org.openqa.selenium.By;

public class SBmovimetacaoPage extends Basepage {
    public void clicarSalvar() {
        clicarPorTexto("SALVAR");
    }

    public void setDescricao(String descricao) {
        setText(By.xpath("//*[@text='Descrição']"), descricao);
    }

    public void setInteressado(String interessado) {
        setText(By.xpath("//android.widget.EditText[2]"), interessado);
    }

    public void setValor(String valor) {
        setText(By.xpath("//android.widget.EditText[3]"), valor);
    }

    public void setConta(String conta){
        selecionarCombo(By.xpath("//android.widget.Spinner[2]"), conta);
    }

    public String getMensagemAviso(){
       return getText(By.xpath("//*[@text='Descrição é um campo obrigatório']"));
    }

    public String obterSaldoConta(String conta){
        return getText(By.xpath("//*[@text='"+conta+"']/following-sibling::android.widget.TextView"));
    }
}
