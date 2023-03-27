package appium.PageObjects;

import appium.driverFactory.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class DragAndDropPage extends Basepage{

    public String[] retornaLista() {
        List<MobileElement> elementosEncontrados = DriverFactory.getDriver().findElements(By.className("android.widget.TextView"));
        String[] retorno = new String[elementosEncontrados.size()];
        for (int i = 0; i < elementosEncontrados.size(); i++) {
            retorno[i] = elementosEncontrados.get(i).getText();
        }
        return retorno;
    }

    public void verificarEstadoAtualDaLista() {
        String[] nomesOrdemCorreta = {"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "qualquer local desejado."};
        Assert.assertEquals("A lista de nomes na pagina Drag and Drop não está na rdem inicial correta", nomesOrdemCorreta, retornaLista());
    }

    public void arrastar(String origem, String destino) {
        MobileElement inicio = DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+origem+"']"));
        MobileElement fim = DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+destino+"']"));

        new TouchAction(DriverFactory.getDriver()).longPress(inicio).moveTo(fim).release().perform();
    }

    public void verificarEstadoIntermediario(){
        String[] nomesOrdemIntermediario = {"é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "Esta", "qualquer local desejado."};
        Assert.assertEquals( "A lista de nomes na pagina Drag and Drop não está na ordem Intermediaria correta", nomesOrdemIntermediario ,retornaLista());
    }
    public void verificarEstadoFinal(){
        String[] nomesOrdemFinal = {"Faça um clique longo,","é uma lista", "Drag em Drop!", "e arraste para", "Esta", "qualquer local desejado."};
        Assert.assertEquals( "A lista de nomes na pagina Drag and Drop não está na ordem Intermediaria correta", nomesOrdemFinal,retornaLista());
    }
}
