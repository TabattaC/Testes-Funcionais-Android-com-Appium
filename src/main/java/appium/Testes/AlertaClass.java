package appium.Testes;

import appium.DSL.BaseTest;
import appium.PageObjects.AlertaPage;
import appium.PageObjects.Basepage;
import appium.PageObjects.MenuPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class AlertaClass extends Basepage{
    MenuPage menuPage = new MenuPage();
    AlertaPage alertaPage = new AlertaPage();

    BaseTest baseTest = new BaseTest();
    @Test
    public void deveConfirmarAlerta() {
        //Acessar menu Alerta
        menuPage.acessarAlertMenu();
        //Clicar no alert comfirm
        if(elementoExiste(By.xpath("//*[@text='Alerta de confirmação']"))){
            clicar(By.xpath("//*[@text='ALERTA CONFIRM']"));
        }
        //verificar os textos
        if(elementoExiste(By.xpath("//*[@text='Info']"))){
            Assert.assertEquals("A mensagem exibida é diferente da esperada", "Confirma a operação?", alertaPage.obterMessageAlert());
            //Confirmar alert
            clicar(By.xpath("//*[@text='CONFIRMAR']"));
        }
        //Verificar nova Mensagem
        if(elementoExiste(By.xpath("//*[@text='Confirmado']"))){
            //Sair
            clicar(By.xpath("//*[@text='SAIR']"));
        }

    }

    @Test
    public void deveClicarAlertaSimplesEClicarFora(){
        //Acessar alerta Menu
        menuPage.acessarAlertMenu();
        //Acessar alerta simples
        alertaPage.acessarAlertaSimples();
        //clicar para fora do alerta  100,150
        baseTest.wait(1000);
        alertaPage.clicarForaDoAlerta(100,150);
        //Garantir que do alerta
        Assert.assertFalse(verificarElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
    }

}
