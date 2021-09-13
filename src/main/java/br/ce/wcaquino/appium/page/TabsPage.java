package br.ce.wcaquino.appium.page;

import br.ce.wcaquino.appium.core.BasePage;
import org.openqa.selenium.By;

public class TabsPage extends BasePage {

    public String verificarAba1(){

        return obterTexto(By.xpath("//*[@text='Este é o conteúdo da Aba 1']"));

    }

    public void clicarAba2(){

        clicarPorTexto("ABA 2");
    }

    public String verificarAba2(){

        return obterTexto(By.xpath("//*[@text='Este é o conteúdo da Aba 2']"));

    }

}
