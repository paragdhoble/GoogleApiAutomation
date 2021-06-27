package com.apiautomation;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import java.io.*;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.List;
import static io.restassured.RestAssured.given;


public class ApiRestAssured {

   public static WebDriver driver ;

    private static final String propertyFilePath = "C:\\Parag\\Stud_Code\\Automation_Code\\AutomationWithSauceLab\\src\\test\\resources\\application.json" ;
    Data data = ConfigFileReader.getData();
    @Test
    public void init() throws IOException, InterruptedException {

        getUrlFromBrowser(data.getgmail_url());
        String url = getUrl() ;
        String code = getCodeFromUrl(url);
        String decoded_code = decode(code);
        String accessToken = getAccessToken(decoded_code);
        List<LinkedHashMap> calendarList = getCalendarList(accessToken);
    }

    private static String getCodeFromUrl(String url) {
        String partialcode = url.split("code=")[1];
        String code = partialcode.split("&scope")[0];
        System.out.println("code: " + code);
        return code;
    }

    private static String decode(String code) throws UnsupportedEncodingException {
        String decodedString = URLDecoder.decode(code.replace("+", "%2B"), "UTF-8")
                .replace("%2B", "+");
        System.out.println("decoded:" + decodedString);
        return decodedString;
    }


    private String getAccessToken(String decoded_code) {
        String hs = io.restassured.RestAssured.given()
                .queryParam("code", decoded_code)
                .queryParam("client_id", data.getClient_id())
                .queryParam("client_secret", data.getClient_secret())
                .queryParam("redirect_uri", data.getRedirect_uri())
                .queryParam("grant_type", "authorization_code")
                .post(data.getToken_url()).asString();

        JsonPath js = new JsonPath(hs);
        String accessToken = js.getString("access_token");
        System.out.println("access token = " +accessToken);
        return accessToken;
    }


    public void getUrlFromBrowser(String url1) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", data.getChrome_driver());
        driver = new FirefoxDriver();
        driver.get(url1);
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys(data.getEmailId());
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(data.getPassword());
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(Keys.ENTER);
        Thread.sleep(10000);

    }
    private static String getUrl() throws InterruptedException {
        Thread.sleep(5000);
         String  url = driver.getCurrentUrl();
         System.out.println(url);
         driver.close();
         return url ;

    }



    private static List<LinkedHashMap> getCalendarList(String accessToken) {
        Response res = given().auth().oauth2(accessToken).get("https://www.googleapis.com/calendar/v3/users/me/calendarList");
        System.out.println("Status of list calendars: "+res.getStatusCode());
        List<LinkedHashMap> items = res.jsonPath().getList("items");
        items.forEach(item -> {
            System.out.println(item.toString());
        });

        RestAssured.baseURI ="https://www.googleapis.com" ;



        return items;



    }



}
