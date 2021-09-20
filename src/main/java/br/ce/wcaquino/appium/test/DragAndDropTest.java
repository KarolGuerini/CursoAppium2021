package br.ce.wcaquino.appium.test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.DragAndDropPage;
import br.ce.wcaquino.appium.page.MenuPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DragAndDropTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private DragAndDropPage page = new DragAndDropPage();

    private String[] estadoInicial = new String[]{
            "Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "qualquer local desejado."
    };

    private String[] estadoIntermediario = new String[]{
            "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "qualquer local desejado.", "Esta"
    };

    private String[] estadoFinal = new String[]{
            "Faça um clique longo,", "é uma lista", "Drag em Drop!",  "e arraste para", "qualquer local desejado.", "Esta"
    };

    @Test

    public void deveInteragirDragAndDrop(){
        menu.acessarDragAndDrop();

        esperar(1000);
        Assertions.assertArrayEquals(estadoInicial, page.obterLista());

        page.arrastar("Esta", "qualquer local desejado.");
        Assertions.assertArrayEquals(estadoIntermediario, page.obterLista());

        page.arrastar("Faça um clique longo,","é uma lista");
        Assertions.assertArrayEquals(estadoFinal, page.obterLista());




    }
}
