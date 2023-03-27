package appium.PageObjects;

import appium.driverFactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage extends  Basepage {

    public void acessarFormulario(){
        clicarPorTexto("Formulário");
    }

    public void acessarSplash(){
        clicarPorTexto("Splash");
    }

    public void acessarAlertMenu(){
        clicarPorTexto("Alertas");
    }

    public void acessarCliqueMenu(){
        clicarPorTexto("Cliques");
    }
    public void acessarAbaMenu(){
        clicarPorTexto("Abas");
    }

    public void acessarAccordion(){
        clicarPorTexto("Accordion");
    }

    public void acessarSwippeMenu(){
        clicarPorTexto("Swipe");
    }

    public void acessarSwippeListMenu(){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@text='Formulário']")));
        scrollDown();
        clicarPorTexto("Swipe List");
    }
    public void acessarDragAndDropMenu(){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@text='Formulário']")));
        scrollDown();
        clicarPorTexto("Drag and drop");
    }

    public void acessarSeuBarrigaHibrido(){
        clicarPorTexto("SeuBarriga Híbrido");
    }
    public void acessarSeuBarrigaNativo(){
        clicarPorTexto("SeuBarriga Nativo");
    }
}
