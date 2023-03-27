package appium.PageObjects;

import appium.DSL.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class AbasPage extends Basepage {
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.TextView")
    private MobileElement txtAba1;
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.TextView")
    private MobileElement txtAba2;
    Basepage basePage = new Basepage();

    public boolean isAba1(){
       return verificarElementoPorTexto("Este é o conteúdo da Aba 1");
    }

    public boolean isAba2(){
        return verificarElementoPorTexto("Este é o conteúdo da Aba 2");
    }

    public void clicarAba2(){
        clicarPorTexto("ABA 2");
    }
}
