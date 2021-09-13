package br.ce.wcaquino.appium.test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.AccordionPage;
import br.ce.wcaquino.appium.page.MenuPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccordionTest extends BaseTest {
    private MenuPage menu = new MenuPage();
    private AccordionPage page = new AccordionPage();


    @Test

    public void deveClicarOpcoesAcordion(){
        menu.acessarAccordion();

        page.clicarOpcao("1");

        page.verificarTextoOpcao("1");
        Assertions.assertEquals("Esta é a descrição da opção 1", page.verificarTextoOpcao("1"));

        page.clicarOpcao("3");
        Assertions.assertEquals("Esta é a descrição da opção 3. Que pode, inclusive ter mais que uma linha", page.verificarTextoOpcao3());


    }
}
