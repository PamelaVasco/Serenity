package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class AdminPage extends PageObject {

    private By adminMenu = By.xpath("//span[text()='Admin']");
    private By searchInput = By.xpath("//label[text()='Username']/../following-sibling::div/input");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By editButton = By.xpath("(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[1]");
    private By usernameField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private By saveButton = By.xpath("//button[@type='submit']");
    private By successToast = By.xpath("//p[contains(text(),'Successfully Updated')]");

    public void goToAdminSection() {
        $(adminMenu).waitUntilVisible().click();
    }

    public void searchUser(String username) {
        $(searchInput).waitUntilVisible().clear();
        $(searchInput).sendKeys(username);
        $(searchButton).click();
    }

    public void editFirstUser(String newUsername) {
        $(editButton).waitUntilClickable().click();
        $(usernameField).waitUntilVisible().shouldBeEnabled();
        $(usernameField).clear();
        $(usernameField).sendKeys(newUsername);
        $(saveButton).waitUntilClickable().click();
    }

    public boolean successMessageIsDisplayed() {
        return $(successToast).waitUntilVisible().isVisible();
    }
}