package appium.PageObjects;

import appium.driverFactory.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;



public class WebViewPage extends Basepage {

    @AndroidFindBy(id = "email")
    private MobileElement campoEmail;


    public void setEmail(String email){
        //campoEmail.sendKeys(email);
        DriverFactory.getDriver().findElement(By.id("email")).sendKeys(email);
    }

    public void setSenha(String senha){
        //campoEmail.sendKeys(email);
        DriverFactory.getDriver().findElement(By.id("senha")).sendKeys(senha);
    }

    public void botaoEntrar(){
        clicar(By.xpath("//button[@type='submit']"));
    }

    public String getMensagemLogin(){
        return getText(By.xpath("//div[@class='alert alert-success']"));
    }


}
