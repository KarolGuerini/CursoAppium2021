package br.ce.wcaquino.appium.test;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.AlertaPage;
import br.ce.wcaquino.appium.page.MenuPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OpcaoEscondidaTest extends BaseTest {


    private MenuPage menu = new MenuPage();
    private BasePage base = new BasePage();
    private AlertaPage page = new AlertaPage();

    @Test
    public void deveEncontrarOpcaoEscondida(){

        menu.acessarOpcaoEscondida();
        Assertions.assertEquals("Você achou essa opção",page.obterMensagemAlerta());
        menu.clicarPorTexto("OK");

    }



}
