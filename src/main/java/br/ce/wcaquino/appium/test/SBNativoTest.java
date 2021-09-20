package br.ce.wcaquino.appium.test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.SBNativoPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SBNativoTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private SBNativoPage page = new SBNativoPage();

    @BeforeEach
    public void setup (){

        menu.acessarSeuBarrigaHibrido();
        page.nome("k@teste.com");
        page.senha("123456");
        page.entrar();

    }
    @Test
    public void validarLogin(){

        Assertions.assertTrue(page.existeElementoPorTexto("HOME"));

    }


}
