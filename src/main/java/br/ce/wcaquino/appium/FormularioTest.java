package br.ce.wcaquino.appium;

import br.ce.wcaquino.appium.core.DriverFactory;
import br.ce.wcaquino.appium.core.Generics;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class FormularioTest extends DriverFactory{


    public static AndroidDriver<MobileElement> driver;
    private Generics gnr = new Generics();

    @BeforeAll
    static void beforeAll() {
        driver = getDriver();

        //selecionando o formulário
        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.TextView");
        el1.click();
    }

    @AfterAll
    static void afterAll() {
      killDriver();
    }

    @Test
    public void devePreencherCampoTexto()  {

        //usando DSL na classe Generics no teste abaixo

        //digitando no campo nome
        gnr.escrever(MobileBy.AccessibilityId("nome"), "karol");

        //verificando o nome salvo
        Assertions.assertEquals("karol",gnr.obterTexto(MobileBy.AccessibilityId("nome")));
    }

    @Test
    public void deveInteragirComCombo() throws MalformedURLException {

        //clicando no combo
        driver.findElementByAccessibilityId("console").click();

        //selecionando a opção
        driver.findElementByXPath("//android.widget.CheckedTextView[@text='Nintendo Switch']").click();

        //verificando opção selecionada
        MobileElement el1 = (MobileElement) driver.findElementById("android:id/text1");
        Assertions.assertEquals("Nintendo Switch", el1.getText());

    }

    @Test
    public void deveInteragirComSwitchECheckBox() throws MalformedURLException {

        //verificando o status dos elementos
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("check");
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("switch");
        Assertions.assertTrue(el1.getAttribute("checked").equals("false"));
        Assertions.assertTrue(el2.getAttribute("checked").equals("true"));

        //clicando nos elementos
        el1.click();
        el2.click();

        //verificando novo status dos elementos
        Assertions.assertTrue(el1.getAttribute("checked").equals("true"));
        Assertions.assertTrue(el2.getAttribute("checked").equals("false"));

    }

    @Test
    public void deveResolverDesafio() throws MalformedURLException {

        //limpar os dados
        driver.findElementByXPath("//android.widget.TextView[@text='LIMPAR']").click();

        //digitando no campo nome
        driver.findElementByAccessibilityId("nome").sendKeys("karol");

        //clicando no combo
        driver.findElementByAccessibilityId("console").click();

        //selecionando a opção
        driver.findElementByXPath("//android.widget.CheckedTextView[@text='Nintendo Switch']").click();

        //clicando nos checks
        driver.findElementByAccessibilityId("check").click();
        driver.findElementByAccessibilityId("switch").click();

        //clicando no botão salvar
        MobileElement el0 = (MobileElement) driver.findElementByXPath("//*[@text='SALVAR']");
        el0.click();

        //verificando o nome salvo
        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]");
        Assertions.assertEquals("Nome: karol", el1.getText());

        //verificando a seleção do console
        MobileElement el2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Console: switch']");
        Assertions.assertEquals("Console: switch", el2.getText());

        //verificando o switch
        MobileElement el3 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Switch: Off']");
        Assertions.assertEquals("Switch: Off", el3.getText());

        //verificando o checkbox
        MobileElement el4 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Checkbox: Marcado']");
        Assertions.assertEquals("Checkbox: Marcado", el4.getText());

    }

}


