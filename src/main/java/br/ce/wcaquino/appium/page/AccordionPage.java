package br.ce.wcaquino.appium.page;

import br.ce.wcaquino.appium.core.BasePage;
import org.openqa.selenium.By;

public class AccordionPage extends BasePage {

    private MenuPage menu = new MenuPage();

    public void clicarOpcao(String numero){

        clicarPorTexto("Opção "+numero);
    }

    public String verificarTextoOpcao(String numero){

        return obterTexto(By.xpath("//*[@text='Esta é a descrição da opção "+numero+"']"));

    }
    public String verificarTextoOpcao3(){
        return obterTexto(By.xpath("//*[@text='Esta é a descrição da opção 3. Que pode, inclusive ter mais que uma linha']"));
    }
}
