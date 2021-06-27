package com.apiautomation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

import java.io.FileReader;


public class ConfigFileReader {

    private static final String propertyFilePath = "C:\\Parag\\Stud_Code\\Automation_Code\\AutomationWithSauceLab\\src\\test\\resources\\application.json";


    @Test
    public static void getJsonValue() {
        Data data = getData();
        System.out.println(data);
    }

    public static Data getData() {
        JSONParser parser = new JSONParser();
        Data data = null;
        try {
            Object obj = parser.parse(new FileReader(propertyFilePath));

           JSONArray array = (JSONArray) obj;
            JSONObject jsonObject = (JSONObject) array.get(0);
            String gmail_url = (String) jsonObject.get("gmail_url");
            String email = (String) jsonObject.get("email");
            String password = (String) jsonObject.get("password");
            String chrome_driver = (String) jsonObject.get("chrome_driver");
            String calender_url = (String) jsonObject.get("calender_url");
             String client_id = (String)jsonObject.get("client_id");
            String client_secret = (String)jsonObject.get("client_secret");
            String redirect_uri = (String)jsonObject.get("redirect_uri");
            String token_url = (String)jsonObject.get("token_url");


            data = new Data(gmail_url, email, password,chrome_driver,calender_url,client_id,client_secret,redirect_uri ,token_url);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}