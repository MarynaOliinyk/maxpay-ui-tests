package pages;

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

    public void checkSuccessfulLogin() {
        assertTrue(url().contains("app.php#/app/dashboard"));
        controlPanel.should(visible, text("Панель управления"));
    }
}

