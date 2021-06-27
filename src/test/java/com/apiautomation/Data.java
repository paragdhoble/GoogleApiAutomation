package com.apiautomation;

public  class Data {

    private String gmail_url;
    private String emailId;
    private String password;
    private String chrome_driver ;
    private String calender_url ;
    private String client_id ;
    private String client_secret ;
    private String redirect_uri ;
    private String token_url ;

    public Data(){

    }

    @Override
    public String toString() {
        return "Data{" +
                "gmail_url='" + gmail_url + '\'' +
                ", emailId='" + emailId + '\'' +
                ", password='" + password + '\'' +
                ", chrome_driver='" + chrome_driver + '\'' +
                ", calender_url='" + calender_url + '\'' +
                ", client_id='" + client_id + '\'' +
                ", client_secret='" + client_secret + '\'' +
                ", redirect_uri='" + redirect_uri + '\'' +
                ", token_url='" + token_url + '\'' +

                '}';
    }



    public Data(String gmail_url, String emailId, String password , String chrome_driver, String calender_url
    , String redirect_uri , String client_id , String client_secret , String token_url ) {
        this.gmail_url = gmail_url;
        this.emailId = emailId;
        this.password = password;
        this.chrome_driver = chrome_driver ;
        this.calender_url = calender_url ;
        this.redirect_uri = redirect_uri;
        this.client_id = client_id;
        this.client_secret = client_secret ;
        this.token_url = token_url ;
    }

    public String getgmail_url() {
        return gmail_url;
    }

    public void setgmail_url(String gmail_url) {
        this.gmail_url = gmail_url;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getChrome_driver() {
        return chrome_driver;
    }

    public void setChrome_driver(String chrome_driver) {
        this.chrome_driver = chrome_driver;
    }

    public String getcalender_url() {
        return calender_url;
    }

    public void setcalender_url(String calender_url) {
        this.calender_url = calender_url;
    }


    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public String getToken_url() {
        return token_url;
    }

    public void setToken_url(String token_url) {
        this.token_url = token_url;
    }
}
