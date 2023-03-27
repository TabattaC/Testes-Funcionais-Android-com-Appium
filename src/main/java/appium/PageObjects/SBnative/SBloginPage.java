package appium.PageObjects.SBnative;

import appium.PageObjects.Basepage;
import org.openqa.selenium.By;

public class SBloginPage extends Basepage {

    public void setLogin(String email){
        setText(By.xpath("//*[@text='Nome']"),email);
    }
    public void setSenha(String senha){
        setText(By.xpath("//*[@text='Senha']"),senha);
    }
    public void clicoBotaoEntrar(){
        clicarPorTexto("ENTRAR");
    }
}
