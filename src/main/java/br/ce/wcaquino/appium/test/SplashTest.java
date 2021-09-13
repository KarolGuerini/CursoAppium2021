package br.ce.wcaquino.appium.test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.SplashPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SplashTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private SplashPage page = new SplashPage();

    @Test
    public  void deveAguardarSplashSumir(){

        //acessar o menu
        menu.acessarSplash();

        //verificar que o splash está sendo exibido
        page.telaSplashVisivel();

        //aguardar saida do splash
        page.aguardarSplashSumir();

        //verificar que o formulário está aparecendo
        Assertions.assertTrue(page.existeElementoPorTexto("Formulário"));
    }
}
