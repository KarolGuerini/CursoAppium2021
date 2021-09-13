package br.ce.wcaquino.appium.page;

import br.ce.wcaquino.appium.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;

public class SplashPage extends BasePage {

    public boolean telaSplashVisivel(){
        return existeElementoPorTexto("Splash!");
    }

    public void aguardarSplashSumir(){
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='Splash!']")));
    }
}
