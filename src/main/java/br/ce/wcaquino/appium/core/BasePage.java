package br.ce.wcaquino.appium.core;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

import static br.ce.wcaquino.appium.core.DriverFactory.driver;
import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;

public class BasePage {
    public void escrever(By by, String texto){

        getDriver().findElement(by).sendKeys(texto);
    }

    public String obterTexto(By by){

        return getDriver().findElement(by).getText();
    }
    public void clicarPorTexto(String texto){
        getDriver().findElementByXPath("//*[@text='"+texto+"']").click();
    }

    public boolean existeElementoPorTexto(String texto){

        List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='"+texto+"']"));
        return elementos.size() >0;
    }
}
