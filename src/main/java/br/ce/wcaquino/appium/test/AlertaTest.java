package br.ce.wcaquino.appium.test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.AlertaPage;
import br.ce.wcaquino.appium.page.MenuPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlertaTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AlertaPage page = new AlertaPage();

    @Test
    public void deveConfirmarAlerta(){

        //acessar menu alerta
        menu.acessarAlerta();

        //clicar em alert confirm
        page.clicarAlertaConfirm();

        //veriifcar o texto
        page.obterMensagemAlerta();
        Assertions.assertEquals("Confirma a operação?",page.obterMensagemAlerta());

        //comfirmar o alerta
        page.confirmarAlerta();

        //verificar o texto
        page.obterMensagemAlerta();
        Assertions.assertEquals("Confirmado",page.obterMensagemAlerta());

        //sair
        page.clicarSair();
        Assertions.assertTrue(page.existeElementoPorTexto("Alerta de confirmação"));
    }
}
