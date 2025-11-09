package com.orangehrm.steps;

import com.orangehrm.pages.LoginPage;
import net.thucydides.core.annotations.Step;

public class LoginStep {

    LoginPage loginPage;

    @Step("Abrir la página de login")
    public void openLoginPage() {
        loginPage.openLoginPage();
    }

    @Step("Ingresar credenciales {0} / {1}")
    public void enterCredentials(String username, String password) {
        loginPage.enterCredentials(username, password);
    }

    @Step("Hacer clic en Login")
    public void clickLogin() {
        loginPage.clickLogin();
    }
}