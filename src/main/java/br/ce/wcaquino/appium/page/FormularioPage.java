package br.ce.wcaquino.appium.page;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;

public class FormularioPage extends DriverFactory {

    private BasePage dsl = new BasePage(); //usando o modelo DSL na base page
    

    public void escreverNome(String nome){
        dsl.escrever(MobileBy.AccessibilityId("nome"), nome);
    }
    public String obterNome(){
        return dsl.obterTexto(MobileBy.AccessibilityId("nome"));
    }
    public void selecionarCombo(String texto){
        driver.findElementByAccessibilityId("console").click();
        driver.findElementByXPath("//*[@text='"+texto+"']").click();
    }
    public String obterValorCombo(){
        return driver.findElementById("android:id/text1").getText();
    }
    public String statusCheck( String valorCheck ){
        return driver.findElementByAccessibilityId("check").getAttribute(valorCheck);
    }

    public void clique(String valor){
        driver.findElementByAccessibilityId(valor).click();
    }

    public String statusSwitch( String valorSwitch ){
        return driver.findElementByAccessibilityId("switch").getAttribute(valorSwitch);
    }

    public void limparDados(){
        driver.findElementByXPath("//android.widget.TextView[@text='LIMPAR']").click();
    }

    public void clicarEmSalvar(){
        driver.findElementByXPath("//*[@text='SALVAR']").click();
    }
    public void clicarEmSalvarDemorado(){
        driver.findElementByXPath("//*[@text='SALVAR DEMORADO']").click();
    }

    public String verificarNome(String nome){
       return driver.findElementByXPath("//android.widget.TextView[@text='"+nome+"']").getText();

    }

    public String verificandoConsole(String console){
        return driver.findElementByXPath("//android.widget.TextView[@text='"+console+"']").getText();
    }

    public String verificandoSwitch(String console){
        return driver.findElementByXPath("//android.widget.TextView[@text='"+console+"']").getText();
    }
    public String verificandoCheckbox(String console){
        return driver.findElementByXPath("//android.widget.TextView[@text='"+console+"']").getText();
    }




}
