package com.apiautomation;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GetCalenderEvent extends ApiRestAssured {


    @Test
    public void getcalendarEventUI() throws InterruptedException {
        Data data = ConfigFileReader.getData();
        ApiRestAssured oauth = new ApiRestAssured() ;
        oauth.getUrlFromBrowser(data.getcalender_url());
        Thread.sleep(5000);
        String calenderEvent = driver.findElement(By.xpath("//span[contains(@class, 'FAxxKc')]")).getText();
        System.out.println("Calener Event =  " +calenderEvent);
        Thread.sleep(5000);
        driver.quit();

    }

}

