package appium.PageObjects.SBnative;

import appium.PageObjects.Basepage;

public class SBMenuPage  extends Basepage {

    public void acessarHome(){
        clicarPorTexto("HOME");
    }

    public void atualizarHome(){
        scroll(0.2, 0.9);
    }
}
