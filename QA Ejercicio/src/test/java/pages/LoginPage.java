package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//button[@type='submit']");

    public void openLoginPage() {
        openUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    public void loginAs(String user, String pass) {
        $(usernameField).waitUntilVisible().sendKeys(user);
        $(passwordField).sendKeys(pass);
        $(loginButton).click();
    }
}
