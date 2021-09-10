package br.ce.wcaquino.appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FormularioTest {
    @Test
    public void devePreencherCampoTexto() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("app", "/home/karol/IdeaProjects/cursoAppiumWA/src/main/resources/CTAppium_1_2.apk");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "7.1.1");
        desiredCapabilities.setCapability("deviceName", "0032320614");

        AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //forma mais encorpada de fazer o código

        //selecionando o formulário
        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.TextView");
        el1.click();

        //digitando no campo nome
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("nome");
        el2.sendKeys("karol");

        //clicando no botão salvar
        MobileElement el3 = (MobileElement) driver.findElementByXPath("//android.widget.Button[@content-desc=\"save\"]/android.widget.TextView");
        el3.click();

        //verificando o nome salvo
        MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]");
        Assertions.assertEquals("Nome: karol", el4.getText());

        driver.quit();
    }

    @Test
    public void deveInteragirComCombo() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("app", "/home/karol/IdeaProjects/cursoAppiumWA/src/main/resources/CTAppium_1_2.apk");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "7.1.1");
        desiredCapabilities.setCapability("deviceName", "0032320614");

        AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //forma mais enxuta de fazer o código

        //selecionando o formulário
        driver.findElementByXPath("//android.widget.TextView[@text='Formulário']").click();

        //clicando no combo
        driver.findElementByAccessibilityId("console").click();

        //selecionando a opção
        driver.findElementByXPath("//android.widget.CheckedTextView[@text='Nintendo Switch']").click();

        //verificando opção selecionada
        MobileElement el1 = (MobileElement) driver.findElementById("android:id/text1");
        Assertions.assertEquals("Nintendo Switch", el1.getText());

        driver.quit();
    }

    @Test
    public void deveInteragirComSwitchECheckBox() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("app", "/home/karol/IdeaProjects/cursoAppiumWA/src/main/resources/CTAppium_1_2.apk");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "7.1.1");
        desiredCapabilities.setCapability("deviceName", "0032320614");

        AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //forma mais enxuta de criar o xpath

        //selecionando o formulário
        driver.findElementByXPath("//*[@text='Formulário']").click();

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

        driver.quit();
    }
}

