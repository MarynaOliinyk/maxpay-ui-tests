package com.maxpay.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertTrue;

public class DashBoardPage {

    @Getter
    private SelenideElement supportLink = $(By.xpath("//a[@class='font-w300 link-effect ng-binding']"));

    public void checkSuccessfulLogin(String url) {
        supportLink.should(visible);
        assertTrue(url().contains(url));
    }
}

