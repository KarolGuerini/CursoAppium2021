package br.ce.wcaquino.appium.test;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.AlertaPage;
import br.ce.wcaquino.appium.page.MenuPage;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static br.ce.wcaquino.appium.core.DriverFactory.driver;
import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;

public class AlertaTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AlertaPage page = new AlertaPage();
    private BasePage base = new BasePage();
    @Test
    public void deveConfirmarAlerta(){

        //acessar menu alerta
        menu.acessarAlerta();

        //clicar em alert confirm
        page.clicarAlerta("ALERTA CONFIRM");

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

    @Test
    public void deveClicarForaAlerta(){
        menu.acessarAlerta();
        page.clicarAlerta("ALERTA SIMPLES");
        page.tapByCoordinates(333,945);
        System.out.println("passei aqui");
        //Assertions.assertTrue(page.existeElementoPorTexto("Alerta que pode clicar fora"));
        //Esse teste está dando falso positivo devido a versão do appium que não é compatível com o tap


    }

}
