package com.maxpay.login;

import com.maxpay.core.DriverBase;
import org.testng.annotations.Test;
import com.maxpay.pages.DashBoardPage;
import com.maxpay.pages.LoginPage;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

public class LoginTest extends DriverBase {
    private String email = "qa+test+automation@maxpay.com";
    private String password = "ZXCasdQWE123";
    private String incorrectEmail = "qa+test+automation@axpay.com";
    private String incorrectCredentialsText = "Некорректны пароль или email";
    private String successfulLoginText = "app.php#/app/dashboard";
    private String signURL = "https://my-sandbox.maxpay.com/#/signin";
    private LoginPage loginPage =  new LoginPage(signURL);
    private DashBoardPage dashBoard = new DashBoardPage();

    @Test
    public void loginWithCorrectCredentials(){
        loginPage.login(email,password);
        dashBoard.checkSuccessfulLogin(successfulLoginText);
    }

    @Test
    public void loginWithInCorrectCredentials() {
        loginPage.login(incorrectEmail, password);
        loginPage.checkIncorrectCredentialsMessage(incorrectCredentialsText);
        assertEquals(url(), signURL);
    }
}
