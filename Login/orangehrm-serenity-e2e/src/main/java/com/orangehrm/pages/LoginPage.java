package com.orangehrm.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageObject {

    @FindBy(name = "username")
    WebElement usernameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    WebElement loginButton;

    public void openLoginPage() {
        openUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }

    public void enterCredentials(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }
}