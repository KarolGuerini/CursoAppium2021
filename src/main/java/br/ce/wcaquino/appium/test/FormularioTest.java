package br.ce.wcaquino.appium.test;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.core.DriverFactory;
import br.ce.wcaquino.appium.page.FormularioPage;
import br.ce.wcaquino.appium.page.MenuPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;
import static br.ce.wcaquino.appium.core.DriverFactory.killDriver;

public class FormularioTest extends BaseTest {


    public static MenuPage menu = new MenuPage();
    public static FormularioPage formPage = new FormularioPage();


    @BeforeAll
    static void beforeAll() {
        getDriver();
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
        gerarScreenShot();
    }

    @Test
    public void deveInteragirComCombo() throws MalformedURLException {

        formPage.limparDados();

        formPage.selecionarCombo("Nintendo Switch");

        Assertions.assertEquals("Nintendo Switch", formPage.obterValorCombo());
        gerarScreenShot();

    }

    @Test
    public void deveInteragirComSwitchECheckBox() throws MalformedURLException {
        formPage.limparDados();

        Assertions.assertTrue(formPage.statusCheck("checked").equals("false"));
        Assertions.assertTrue(formPage.statusSwitch("checked").equals("true"));

        formPage.clique("check");
        formPage.clique("switch");

        Assertions.assertTrue(formPage.statusCheck("checked").equals("true"));
        Assertions.assertTrue(formPage.statusSwitch("checked").equals("false"));
        gerarScreenShot();

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
        gerarScreenShot();

    }
    @Test
    public void deveRealizarCadastroDemorado() throws MalformedURLException {

        formPage.limparDados();

        formPage.escreverNome("karol");

        formPage.clicarEmSalvarDemorado();

        //utilizando espera explícita
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(("//*[@text='Nome: karol']"))));

        Assertions.assertEquals("Nome: karol", formPage.verificarNome("Nome: karol"));
    }
}


