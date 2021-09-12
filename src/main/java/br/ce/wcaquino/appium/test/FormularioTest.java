package br.ce.wcaquino.appium.test;

import br.ce.wcaquino.appium.core.DriverFactory;
import br.ce.wcaquino.appium.core.Generics;
import br.ce.wcaquino.appium.page.FormularioPage;
import br.ce.wcaquino.appium.page.MenuPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

public class FormularioTest extends DriverFactory{

    private Generics gnr = new Generics();
    public static MenuPage menu = new MenuPage();
    public static FormularioPage formPage = new FormularioPage();

    @BeforeAll
    static void beforeAll() {
        driver = getDriver();

        menu.acessarFormulario();
    }

    @AfterAll
    static void afterAll() {
        killDriver();
    }

    @Test
    public void devePreencherCampoTexto()  {

        formPage.escreverNome("karol");

        Assertions.assertEquals("karol",formPage.obterNome());
    }

    @Test
    public void deveInteragirComCombo() throws MalformedURLException {

        formPage.selecionarCombo("Nintendo Switch");

        Assertions.assertEquals("Nintendo Switch", formPage.obterValorCombo());

    }

    @Test
    public void deveInteragirComSwitchECheckBox() throws MalformedURLException {

        Assertions.assertTrue(formPage.statusCheck("checked").equals("false"));
        Assertions.assertTrue(formPage.statusSwitch("checked").equals("true"));

        formPage.clique("check");
        formPage.clique("switch");

        Assertions.assertTrue(formPage.statusCheck("checked").equals("true"));
        Assertions.assertTrue(formPage.statusSwitch("checked").equals("false"));

    }

    @Test
    public void deveRealizarCadastro() throws MalformedURLException {

        formPage.limparDados();

        formPage.escreverNome("karol");

        formPage.selecionarCombo("Nintendo Switch");

        formPage.clique("check");
        formPage.clique("switch");

        formPage.clicarEmSalvar();

        Assertions.assertEquals("Nome: karol", formPage.verificarNome("Nome: karol"));

        formPage.verificandoConsole("Console: switch");
        Assertions.assertEquals("Console: switch", formPage.verificandoConsole("Console: switch"));

        formPage.verificandoSwitch("Switch: Off");
        Assertions.assertEquals("Switch: Off", formPage.verificandoConsole("Switch: Off"));

        formPage.verificandoCheckbox("Checkbox: Marcado");
        Assertions.assertEquals("Checkbox: Marcado", formPage.verificandoConsole("Checkbox: Marcado"));

    }

}


