package br.ce.wcaquino.appium.page;

import br.ce.wcaquino.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;

public class MenuPage extends DriverFactory {

    public void acessarFormulario(){

        //selecionando o formulário
        MobileElement el1 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Formulário']");
        el1.click();
    }
}
