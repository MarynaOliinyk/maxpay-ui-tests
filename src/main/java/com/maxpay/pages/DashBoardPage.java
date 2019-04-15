package com.maxpay.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertTrue;

public class DashBoardPage {

    @Getter
    private SelenideElement controlPanel = $(By.id("sidebar-dashboard"));

    public void checkSuccessfulLogin(String successfulLoginText, String controlPanelText) {
        assertTrue(url().contains(successfulLoginText));
        controlPanel.should(visible, text(controlPanelText));
    }
}

