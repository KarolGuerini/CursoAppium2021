package br.ce.wcaquino.appium.test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.SwipeElementPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SwipeElementTest extends BaseTest {
    private MenuPage menu = new MenuPage();
    private SwipeElementPage page = new SwipeElementPage();

    @Test

    public void deveInteragirComSwipeList(){

        //clicar swipe list
        menu.acessarSwipeList();

//        opç 1 para direita
        page.swipeElementRight("Opção 1");

//        opc 1 +
        esperar(1000);
        page.clicarPorTexto("(+)");
        page.tapByCoordinates(502,114);

//        verificar opc 1
        Assertions.assertTrue(page.existeElementoPorTexto("Opção 1 (+)"));

//        opc 4 para direita
        page.swipeElementRight("Opção 4");

//        opc 4 -
        page.clicarPorTexto("(+)");


//        verificar opc 4
        Assertions.assertTrue(page.existeElementoPorTexto("Opção 4 (-)"));

//        opc 5 para a esquerda
        page.swipeElementLeft("Opção 5 (-)");

//        verificar opc 5
        Assertions.assertTrue(page.existeElementoPorTexto("Opção 5"));


        }
    }
