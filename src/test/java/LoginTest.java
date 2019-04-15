
import core.DriverBase;
import org.testng.annotations.Test;
import pages.DashBoardPage;
import pages.LoginPage;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

public class LoginTest extends DriverBase {
    String email = "qa+test+automation@maxpay.com";
    String password = "ZXCasdQWE123";
    String incorrecttEmail = "qa+test+automation@maxpay.com";
    String incorrectCredentialsText = "Некорректны пароль или email";

    LoginPage loginPage =  new LoginPage();
    DashBoardPage dashBoard = new DashBoardPage();
    @Test
    public void loginWithCorrectCredentials(){
        loginPage.login(email,password);
        dashBoard.checkSuccessfulLogin();

    }

    @Test
    public void loginWithInCorrectCredentials() {
        loginPage.login(incorrecttEmail, password);
        loginPage.checkIncorrectCredentialsMessage(incorrectCredentialsText);
        assertEquals(url(), "https://my-sandbox.maxpay.com/#/signin");
    }
}
