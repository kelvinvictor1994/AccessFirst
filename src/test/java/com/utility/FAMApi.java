package com.utility;


import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.*;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class FAMApi {
    //static String JSessionID = "E4CE2A603AAD648331FDDD7E15556CF3.webappdev-jvwlcdcqvm001";
    //String JSessionIDC ;
    //static String ServerID = "SERVERID=jvwlcdcqvm001.nyumc.org";
    static Cookies cookie ;
    static String temp ;

    public String loginToFam(){
        RestAssured.config = RestAssured.config.encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));
        Response response = RestAssured
                .given()
                .urlEncodingEnabled(false)
                .header("Connection","keep-alive")
                .header("Cache-Control", "no-cache")
                //.config(RestAssured.config.encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                //.contentType("application/x-www-form-urlencoded")
                .formParam("userId", "Leadership01")
                .formParam("password", "Super2022mcitSafe01")
                .when()
                .post("http://jvwlcdcqvm001.nyumc.org:8080/fam/login.html");

        Response response2 = RestAssured
                .given()
                .cookie("JSESSIONID", response.getCookie("JSESSIONID"))
                .when()
               .get("http://jvwlcdcqvm001.nyumc.org:8080/fam/authorize.html");
        //System.out.println(response.getHeaders());
        System.out.println("Fam login code -"+response.getStatusCode());
        //cookie = response.getCookies().toString();
        //cookie = response.detailedCookie("JSESSIONID");
        //System.out.println(cookie);
        return response.getCookie("JSESSIONID");
    }
    public void logout(String sessionID){
        Response response = RestAssured
                .given()
                .contentType("text/html;charset=UTF-8")
                .sessionId(sessionID)
                .when()
                .get("http://jvwlcdcqvm001.nyumc.org:8080/fam/logout.html");
        System.out.println("logout code -"+response.getStatusCode());
    }
    public void sendActivationLink(String sessionID){
        Response response = RestAssured.given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("member_id", "180951")
                .formParam("member_id", "178936")
                .formParam("email", "testernyu@gmail.com")
                .formParam("myaction", "send link")
                //.header("cookie","JSESSIONID=E4CE2A603AAD648331FDDD7E15556CF3.webappdev-jvwlcdcqvm001")
                //.cookie("JSESSIONID",sessionID)
                .sessionId(sessionID)
                .post("http://jvwlcdcqvm001.nyumc.org:8080/fam/af_activation.html");
        System.out.println("send activation code -"+response.getStatusCode());
    }

    public static void disableMember(String sessionID){
        Response response = RestAssured.given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("member_id", "180951")
                //.formParam("member_id", "178936")
                .formParam("email", "testernyu@gmail.com")
                //.cookie("JSESSIONID="+JSessionID)
                .formParam("myaction", "disable")
                .sessionId(sessionID)
                .post("http://jvwlcdcqvm001.nyumc.org:8080/fam/af_disable.html");
        System.out.println("Disable member code -"+response.getStatusCode());
    }
    public static void createPassword(){
        Response response = RestAssured.given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("MIME Type", "application/x-www-form-urlencoded")
                .formParam("userName", "testernyu@gmail.com")
                .formParam("userId", "180951")
                //.formParam("userId", "178936")
                .formParam("password", "Test@123")
                .formParam("confirmPassword", "Test@123")
                //.cookie("JESSIONID",cookie)
                .post("https://app-qa.nyumc.org/accessfirstv2/submitcreatepassword");
        System.out.println("Create password code -"+response.getStatusCode());
    }

}
