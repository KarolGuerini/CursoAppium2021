package br.ce.wcaquino.appium.test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.WebViewPage;
import org.junit.jupiter.api.Test;

public class WebViewTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private WebViewPage page = new WebViewPage();

    @Test
    public void deveFazerLogin(){

        menu.acessarSeuBarrigaHibrido();
        esperar(2000);
        page.entrarContextoWeb();

        esperar(2000);
        page.setEmail("k@teste.com");

        page.setSenha("123456");

        page.entrar();

    }
}
