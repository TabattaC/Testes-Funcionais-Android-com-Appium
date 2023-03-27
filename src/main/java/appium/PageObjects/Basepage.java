package appium.PageObjects;

import appium.driverFactory.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static appium.driverFactory.DriverFactory.getDriver;

public class Basepage {
    /**
     * Métodos genéricos devem ficar nesta classe
     */

    public void setText(By by, String texto) {
        getDriver().findElement(by).sendKeys(texto);
    }

    public String getText(By by) {
        return getDriver().findElement(by).getText();
    }

    public void clicarPorTexto(String texto) {
        getDriver().findElement(By.xpath("//*[@text='" + texto + "']")).click();
    }

    public void clicar(By by) {
        getDriver().findElement(by).click();
    }

    public void selecionarCombo(By by, String valor) {
        getDriver().findElement(by).click();
        clicarPorTexto(valor);
    }

    //Se estiver matcado vai retornar true, se estiver desmarcado vai retornar false
    public boolean isCheckedMarcado(By by) {
        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }

    public boolean verificarElementoPorTexto(String texto) {
        List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));
        return elementos.size() > 0;
    }

    public boolean elementoExiste(By elemento) {
        try {
            getDriver().findElement(elemento);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void tap(int x, int y) {
        new TouchAction(getDriver()).tap(x, y).perform();
    }

    public void scroll(double inicio, double fim) {

        Dimension size = getDriver().manage().window().getSize();
        int x = size.width / 2;
        int startY = (int) (size.height * inicio);
        int endY = (int) (size.height * fim);
        (new TouchAction(getDriver())).press(x, startY).waitAction(Duration.ofMillis(500)).moveTo(x, endY).release().perform();
    }

    public void swipe(double inicio, double fim) {
        //Pegar a dimensao da tela
        Dimension size = getDriver().manage().window().getSize();

        int y = size.height / 2;
        //Largura em vez da altura pq estamos trabalhando no eixo X
        int startX = (int) (size.width * inicio);
        int endX = (int) (size.width * fim);

        new TouchAction(getDriver()).press(startX, y).waitAction(Duration.ofMillis(500)).moveTo(endX, y).release().perform();
    }

    public void scrollDown(){
       scroll(0.9,0.1);
    }
    public void scrollUp(){
        scroll(0.1,0.9);
    }

    public void swipeLefth(){
        swipe(0.1,0.9);
    }

    public void swipeRight(){
        swipe(0.9,0.2);
    }

    public void swipeElemento(MobileElement elemento, double inicio, double fim){
        /**
         * elemento.getLocation().y = Localização do elemento
         * (elemento).getSize().height / 2 = A altura do elemento dividido por 2
         * Vertical
         */
        int y = elemento.getLocation().y + (elemento).getSize().height / 2;
        //Horizontal
        int startX = (int) (elemento.getSize().width * inicio);
        int endX = (int) (elemento.getSize().width * fim);
        new TouchAction(getDriver()).press(startX, y).waitAction(Duration.ofMillis(500)).moveTo(endX, y).release().perform();

    }

    public void entrarContextoWeb(){
        Set<String> contextHandles = DriverFactory.getDriver().getContextHandles();
        DriverFactory.getDriver().context((String) contextHandles.toArray()[1]);
    }

    public void sairContextoWeb(){
        DriverFactory.getDriver().context((String)  DriverFactory.getDriver().getContextHandles().toArray()[0]);
    }

    public void clicarCliqueLongo(By by){
        new TouchAction(DriverFactory.getDriver()).longPress(DriverFactory.getDriver().findElement(by)).perform();
    }
}
