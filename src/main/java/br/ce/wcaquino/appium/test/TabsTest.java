package br.ce.wcaquino.appium.test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.TabsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TabsTest extends BaseTest {
    private MenuPage menu = new MenuPage();
    private TabsPage page = new TabsPage();

    @Test
    public void deveTrocarDeAbas(){
        //acessar menu tabs
        menu.acessarTabs();

        //verificar aba 1
        page.verificarAba1();
        Assertions.assertEquals("Este é o conteúdo da Aba 1", page.verificarAba1());

        //mudar para aba 2
        page.clicarAba2();

        //verifcar aba 2
        page.verificarAba2();
        Assertions.assertEquals("Este é o conteúdo da Aba 2", page.verificarAba2());





    }
}
