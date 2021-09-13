package br.ce.wcaquino.appium.core;

import org.apache.commons.io.FileUtils;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class BaseTest {


    public void gerarScreenShot(){
        File imagem = (File) DriverFactory.getDriver().getScreenshotAs(OutputType.FILE);
        try {
            String date = getStringCurrentDateTime();
            FileUtils.copyFile((File) imagem,new File("target/screenshots/imagem_"+date+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String getStringCurrentDateTime(){
        Long timestamp = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance() ;
        calendar.setTimeInMillis(timestamp);
        String day = String.valueOf(calendar.getTime().getDate());
        String month = String.valueOf(calendar.getTime().getMonth()+1);
        String hour = String.valueOf(calendar.getTime().getHours());
        String minutes = String.valueOf(calendar.getTime().getMinutes());
        String seconds = String.valueOf(calendar.getTime().getSeconds());

        return day+"-"+month+" "+hour+":"+minutes+":"+seconds;
    }

    //utilizando espera fixa
    public void esperar(long tempo){
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
