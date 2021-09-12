package br.ce.wcaquino.appium.core;

import org.openqa.selenium.By;

import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;

public class Generics {

    public void escrever(By by, String texto){

        getDriver().findElement(by).sendKeys(texto);
    }

    public String obterTexto(By by){

        return getDriver().findElement(by).getText();
    }

}
