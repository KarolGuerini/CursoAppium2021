package br.ce.wcaquino.appium.page;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.time.Duration;

import static br.ce.wcaquino.appium.core.DriverFactory.*;
import static br.ce.wcaquino.appium.core.DriverFactory.driver;
import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static org.openqa.selenium.By.xpath;

public class CliquesPage extends BasePage {



    public void cliqueLongo(){

        new TouchAction(getDriver()).longPress(longPressOptions()
                .withElement(element(getDriver().findElement(By.xpath("//*[@text='Clique Longo']")))))
                .release().perform();

    }
    public String obterTextoCampo(){
      return  getDriver().findElement(By.xpath("//android.widget.TextView[2]")).getText();
    }

}
