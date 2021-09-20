package br.ce.wcaquino.appium.page;

import br.ce.wcaquino.appium.core.BasePage;
import org.openqa.selenium.By;

import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;

public class SBNativoPage extends BasePage {

    public void nome(String nome){
        getDriver().findElement(By.xpath("//*[@text='Nome']")).sendKeys(nome);
    }

    public void senha(String senha){
        getDriver().findElement(By.xpath("//*[@text='Senha']")).sendKeys(senha);
    }

    public void entrar(){
        clicarPorTexto("ENTRAR");
    }
}
