package appium.PageObjects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static appium.driverFactory.DriverFactory.getDriver;

public class FormularioPage extends Basepage {


    public void escreverNomeFormulario(String nome) {
        setText(MobileBy.AccessibilityId("nome"), nome);
    }

    public String obterNomeDoFormulario() {
        return getText(MobileBy.AccessibilityId("nome"));
    }

    public void selecionarCombo(String valor) {
        selecionarCombo(MobileBy.AccessibilityId("console"), valor);
    }

    public String obterValordoCombo() {
        return getText(By.xpath("//android.widget.Spinner/android.widget.TextView"));
    }

    public void clicarCheck() {
        clicar(By.xpath("//android.widget.CheckBox[@content-desc='check']"));
    }

    public void clicarSwitch() {
        clicar(By.xpath("//android.widget.Switch[@content-desc='switch']"));
    }

    public boolean isCheckedMarcado() {
        return isCheckedMarcado(By.xpath("//android.widget.CheckBox[@content-desc='check']"));
    }

    public boolean isSwitchMarcado() {
        return isCheckedMarcado(MobileBy.AccessibilityId("switch"));
    }

    public void salvarCadastro() {
        getDriver().findElement(By.xpath("//android.widget.Button[@content-desc='save']/android.widget.TextView")).click();
    }

    public void salvarCadastroDemorado() {
        getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button[2]/android.widget.TextView")).click();
    }

    public String obterNomeCadastrado() {
        return getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]")).getText().split(":")[1].trim();
    }

    public String obterConsoleCadastrado() {
        return getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[3]")).getText().split(":")[1].trim();
    }

    public String obterSwicth() {
        return getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[5]")).getText().split(":")[1].trim();
    }

    public String obterCheckBoxResult() {
        return getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[6]")).getText().split(":")[1].trim();
    }

    public boolean encontrarElementoData(String data) {
        return elementoExiste(By.xpath("//*[@text='" + data + "']"));
    }

    public void clicarSeekbar(double posicao) {
        MobileElement seek = getDriver().findElement(MobileBy.AccessibilityId("slid"));
        int delta = 50; //Vai mudar a posição incial do elemento
        int y = seek.getLocation().y + (seek.getSize().height / 2);
        System.out.println(y);
        int x = (int) (seek.getLocation().x + ((seek.getSize().width - 2 * delta) * posicao)); // casting para inteiro
        int xInicial = x + delta;
        System.out.println(xInicial);
    }

    public void clicarOpcaoEscondida(){
        clicarPorTexto("Opção bem escondida");
    }
}
