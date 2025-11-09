package com.orangehrm.definitions;

import com.orangehrm.steps.LoginStep;
import com.orangehrm.pages.AdminPage;
import com.orangehrm.pages.UserManagementPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class LoginSteps {

    @Steps
    LoginStep loginStep;

    AdminPage adminPage;
    UserManagementPage userManagementPage;

    @Given("que Maria navega por la pagina de login")
    public void queMariaNavegaPorLaPaginaDeLogin() {
        loginStep.openLoginPage();
    }

    @When("accede con sus credenciales {string} y {string}")
    public void accedeConSusCredenciales(String username, String password) {
        loginStep.enterCredentials(username, password);
        loginStep.clickLogin();
    }

    @When("busca al usuario {string}")
    public void buscaAlUsuario(String usuarioActual) {
        userManagementPage.searchUser(usuarioActual);
    }

    @When("edita el campo Username con {string}")
    public void editaElCampoUsernameCon(String nuevoUsuario) {
        userManagementPage.editUsername(nuevoUsuario);
    }

    @Then("valida que se muestre el mensaje {string}")
    public void validaQueSeMuestreElMensaje(String mensajeEsperado) {
        Assert.assertTrue("El mensaje de exito no se mostro",
                userManagementPage.isSuccessMessageDisplayed());
    }
}