package com.orangehrm.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

public class AdminPage extends PageObject {

    @FindBy(xpath = "//span[text()='Admin']")
    WebElement adminMenu;

    public void goToAdminSection() {
        adminMenu.click();
    }
}
