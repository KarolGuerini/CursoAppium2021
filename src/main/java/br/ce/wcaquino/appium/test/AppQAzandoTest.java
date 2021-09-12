package br.ce.wcaquino.appium.test;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppQAzandoTest {
    @Test
    public void acessandoAPK() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("app", "/home/karol/AppiumJavaFinal/resources/apps/app-debug.apk");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "7.1.1");
        desiredCapabilities.setCapability("deviceName", "0032320614");

        AndroidDriver<MobileElement> driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);


        MobileElement el1 = (MobileElement) driver.findElementById("com.example.qazando.espressotests:id/login_username");
        el1.sendKeys("qazando@gmail.com");
        MobileElement el2 = (MobileElement) driver.findElementById("com.example.qazando.espressotests:id/login_password");
        el2.sendKeys("12345678");
        MobileElement el3 = (MobileElement) driver.findElementById("com.example.qazando.espressotests:id/login_button");
        el3.click();

        driver.quit();
    }
}
