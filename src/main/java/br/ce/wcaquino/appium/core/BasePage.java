package br.ce.wcaquino.appium.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import java.time.Duration;
import java.util.List;

import static br.ce.wcaquino.appium.core.DriverFactory.driver;
import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;

public class BasePage {


    public void escrever(By by, String texto) {

        getDriver().findElement(by).sendKeys(texto);
    }

    public String obterTexto(By by) {

        return getDriver().findElement(by).getText();
    }

    public void clicarPorTexto(String texto) {
        getDriver().findElementByXPath("//*[@text='" + texto + "']").click();
    }

    public boolean existeElementoPorTexto(String texto) {

        List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));
        return elementos.size() > 0;
    }

    public void tapByCoordinates(int x, int y) {
        new TouchAction(getDriver()).tap(new PointOption().withCoordinates(x, y)).release();
        new TouchAction(getDriver()).tap(new PointOption().withCoordinates(x, y)).perform();

    }

    public void scrollDown(){
        scroll(0.9, 0.1);

    }
    public void scrollUp() {
        scroll(0.1, 0.9);
    }

    public void swipeLeft() {
        swipe(0.1, 0.9);
    }
    public void swipeRight() {
        swipe(0.9, 0.1);
    }

        public void scroll(double inicio, double fim){
     Dimension size =  getDriver().manage().window().getSize();

     int x = size.width / 2;
     int start_y = (int) (size.height * inicio);
     int end_y = (int) (size.height * fim);


         new TouchAction (getDriver())
                .press(PointOption.point(x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x,end_y))
                .release()
                .perform();
    }

    public void swipe (double inicio, double fim){
        Dimension size =  getDriver().manage().window().getSize();

        int y = size.width / 2;
        int start_x = (int) (size.width * inicio);
        int end_x = (int) (size.width * fim);

        new TouchAction (getDriver())
                .press(PointOption.point(start_x, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end_x,y))
                .release()
                .perform();
    }

    public void swipeElement (MobileElement element, double inicio, double fim){

        int y = element.getLocation().y + (element.getSize().height / 2);
        int start_x = (int) (element.getSize().width * inicio);
        int end_x = (int) (element.getSize().width * fim);

        new TouchAction (getDriver())
                .press(PointOption.point(start_x, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end_x,y))
                .release()
                .perform();
    }


}
