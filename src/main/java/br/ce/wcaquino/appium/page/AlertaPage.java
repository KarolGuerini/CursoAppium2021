package br.ce.wcaquino.appium.page;

import br.ce.wcaquino.appium.core.BasePage;
import org.openqa.selenium.By;

public class AlertaPage extends BasePage {

    public void clicarAlerta(String texto) {

        clicarPorTexto(texto);
    }

    public String obterMensagemAlerta(){

        return obterTexto(By.id("android:id/message"));
    }

    public void confirmarAlerta(){

        clicarPorTexto("CONFIRMAR");
    }

    public void clicarSair(){
        clicarPorTexto("SAIR");
    }

}

