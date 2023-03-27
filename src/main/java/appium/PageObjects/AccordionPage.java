package appium.PageObjects;


import org.openqa.selenium.By;

public class AccordionPage extends  Basepage{


    public String XpathAccordions(int posicao) {
        return "//*[@text='Opção '" + posicao + "]";
    }

    public void clicoOpcao1() {
        clicarPorTexto("Opção 1");
    }

    public String obterTextOpcao1(){
        return getText(By.xpath("//*[@text='Esta é a descrição da opção 1']"));
    }
}
