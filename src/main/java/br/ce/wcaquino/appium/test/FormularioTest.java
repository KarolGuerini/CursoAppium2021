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
    public static FormularioPage page = new FormularioPage();


    @BeforeAll
    static void beforeAll() {
        getDriver();
        menu.acessarFormulario();
    }

    //@AfterAll
    static void afterAll() {
        killDriver();
    }

    @Test
    public void devePreencherCampoTexto()  {

        page.escreverNome("karol");

        Assertions.assertEquals("karol",page.obterNome());
        gerarScreenShot();
    }

    @Test
    public void deveInteragirComCombo() throws MalformedURLException {

        page.limparDados();

        page.selecionarCombo("Nintendo Switch");

        Assertions.assertEquals("Nintendo Switch", page.obterValorCombo());
        gerarScreenShot();

    }

    @Test
    public void deveInteragirComSwitchECheckBox() throws MalformedURLException {
        page.limparDados();

        Assertions.assertTrue(page.statusCheck("checked").equals("false"));
        Assertions.assertTrue(page.statusSwitch("checked").equals("true"));

        page.clique("check");
        page.clique("switch");

        Assertions.assertTrue(page.statusCheck("checked").equals("true"));
        Assertions.assertTrue(page.statusSwitch("checked").equals("false"));
        gerarScreenShot();

    }

    @Test
    public void deveRealizarCadastro() throws MalformedURLException {

        page.limparDados();

        page.escreverNome("karol");

        page.selecionarCombo("Nintendo Switch");

        page.clique("check");
        page.clique("switch");

        page.clicarEmSalvar();

        Assertions.assertEquals("Nome: karol", page.verificarNome("Nome: karol"));

        page.verificandoConsole("Console: switch");
        Assertions.assertEquals("Console: switch", page.verificandoConsole("Console: switch"));

        page.verificandoSwitch("Switch: Off");
        Assertions.assertEquals("Switch: Off", page.verificandoConsole("Switch: Off"));

        page.verificandoCheckbox("Checkbox: Marcado");
        Assertions.assertEquals("Checkbox: Marcado", page.verificandoConsole("Checkbox: Marcado"));
        gerarScreenShot();

    }
    @Test
    public void deveRealizarCadastroDemorado() throws MalformedURLException {

        page.limparDados();

        page.escreverNome("karol");

        page.clicarEmSalvarDemorado();

        //utilizando espera explícita
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(("//*[@text='Nome: karol']"))));

        Assertions.assertEquals("Nome: karol", page.verificarNome("Nome: karol"));
    }

    @Test
    public void deveAlterarData(){
        page.clicarPorTexto("01/01/2000");
        esperar(2000);
        page.clicarPorTexto("20");
        page.clicarPorTexto("OK");
        Assertions.assertTrue(page.verificarTexto("20/2/2000"));
    }

    @Test
    public void deveAletrarTime(){
        page.clicarPorTexto("06:00");
        esperar(1000);
        page.clique("3");
        page.clique("35");
        page.clicarPorTexto("OK");
        Assertions.assertTrue(page.verificarTexto("3:35"));

    }
    @Test
    public void deveInteragirComSeekBar(){

        page.clicarSeekBar(0.50);
        page.clicarEmSalvar();
        Assertions.assertTrue(page.verificarTexto("Slider: 51"));
    }

}


