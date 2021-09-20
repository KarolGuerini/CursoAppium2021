package br.ce.wcaquino.appium.page;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.DriverFactory;
import org.openqa.selenium.By;

public class SwipeElementPage extends BasePage {

    public void swipeElementLeft(String opcao){
        //O /.. sobe um nível na hierarquia
        swipeElement(DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")),0.1,0.9);
    }

    public void swipeElementRight(String opcao){
        swipeElement(DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")),0.9,0.1);
    }


}
