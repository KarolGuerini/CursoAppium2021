package br.ce.wcaquino.appium.page;

import br.ce.wcaquino.appium.core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WebViewPage {

    public void entrarContextoWeb(){
        Set<String> contextHandles = DriverFactory.getDriver().getContextHandles();
//        for (String valor: contextHandles){
//            System.out.println(valor);
//        }
       DriverFactory.getDriver().context((String) DriverFactory.getDriver().getContextHandles().toArray()[1]);

    }

    public void setEmail (String  email) {
       DriverFactory.getDriver().findElementById("email").sendKeys(email);

    }

    public void setSenha (String senha) {
        DriverFactory.getDriver().findElement(By.id("email")).sendKeys(senha);

    }

    public void entrar(){
        DriverFactory.getDriver().findElement(By.xpath("//button[contains(.,'Entrar')]")).click();
    }
}
