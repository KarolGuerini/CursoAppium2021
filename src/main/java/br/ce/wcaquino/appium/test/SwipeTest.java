package br.ce.wcaquino.appium.test;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SwipeTest extends BaseTest {

    private MenuPage menu = new MenuPage();

    @Test
    public void deveRealizarSwipe(){

        menu.acessarSwipe();

        Assertions.assertTrue(menu.existeElementoPorTexto("a esquerda"));

        menu.swipeRight();

        Assertions.assertTrue(menu.existeElementoPorTexto("E veja se"));

        menu.clicarPorTexto("›");

        Assertions.assertTrue(menu.existeElementoPorTexto("Chegar até o fim!"));

        menu.swipeLeft();

        menu.clicarPorTexto("‹");

        Assertions.assertTrue(menu.existeElementoPorTexto("a esquerda"));








    }
}
