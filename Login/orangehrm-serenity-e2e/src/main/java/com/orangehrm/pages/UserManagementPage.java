package com.orangehrm.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

public class UserManagementPage extends PageObject {

    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement searchUsernameField;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement searchButton;

    @FindBy(xpath = "//div[text()='Jasmine.Morgan']")
    WebElement userResult;

    @FindBy(xpath = "//button[normalize-space()='Edit']")
    WebElement editButton;

    @FindBy(xpath = "//input[@name='username']")
    WebElement editUsernameField;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'Success')]")
    WebElement successMessage;

    public void searchUser(String username) {
        searchUsernameField.sendKeys(username);
        searchButton.click();
    }

    public void editUsername(String newUsername) {
        userResult.click();
        editButton.click();
        editUsernameField.clear();
        editUsernameField.sendKeys(newUsername);
        saveButton.click();
    }

    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }
}