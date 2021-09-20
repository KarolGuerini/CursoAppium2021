package br.ce.wcaquino.appium.test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.CliquesPage;
import br.ce.wcaquino.appium.page.MenuPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CliquesTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private CliquesPage page = new CliquesPage();

    @Test
    public void deveRealizarCliqueLongo(){
        menu.acessarCliques();
        page.cliqueLongo();
        Assertions.assertEquals("Clique Longo", page.obterTextoCampo());

    }

    @Test
    public void deveRealizarCliqueDuplo(){
        menu.acessarCliques();
        page.clicarPorTexto("Clique duplo");
        page.clicarPorTexto("Clique duplo");
        Assertions.assertEquals("Duplo Clique", page.obterTextoCampo());

    }


}
