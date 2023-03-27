package appium.Testes;

import appium.DSL.BaseTest;
import appium.PageObjects.DragAndDropPage;
import appium.PageObjects.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class DragAndDropTeste extends BaseTest {
    MenuPage menuPage = new MenuPage();
    DragAndDropPage dragAndDropPage = new DragAndDropPage();
    @Test
    public void deveEfetuarDragAndDrop(){
        /**
         * 1 - Acessar Menu
         * 2 - Verificar estado atual
         * 3 - Arrastar "Esta" para "é uma lista"
         * 4 - Verificar estado intermediario
         * 5- Arrastar "Faça um clique longo", para "é uma lista"
         * 6-Verificar estado final
         */
        menuPage.acessarDragAndDropMenu();
        wait(1000);
        dragAndDropPage.verificarEstadoAtualDaLista();
        dragAndDropPage.arrastar("Esta","e arraste para");
        dragAndDropPage.verificarEstadoIntermediario();
        dragAndDropPage.arrastar("Faça um clique longo,", "é uma lista");
        dragAndDropPage.verificarEstadoFinal();


    }
}
