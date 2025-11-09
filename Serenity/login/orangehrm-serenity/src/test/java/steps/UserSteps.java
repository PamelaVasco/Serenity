package steps;

import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.AdminPage;
import net.thucydides.core.annotations.Steps;

public class UserSteps {

    LoginPage loginPage;
    AdminPage adminPage;

    @Given("que María navega por la página de login")
    public void abrirPaginaLogin() {
        loginPage.openLoginPage();
    }

    @When("ingresa sus credenciales {string} y {string}")
    public void ingresarCredenciales(String user, String pass) {
        loginPage.login(user, pass);
    }

    @And("accede a la sección Admin/User Management")
    public void accederSeccionAdmin() {
        adminPage.goToAdminSection();
    }

    @And("busca al usuario {string}")
    public void buscarUsuario(String username) {
        adminPage.searchUser(username);
    }

    @And("edita el username a {string}")
    public void editarUsuario(String nuevoUsername) {
        adminPage.editFirstUser(nuevoUsername);
    }

    @Then("valida que el mensaje {string} se muestre")
    public void validarMensaje(String mensaje) {
        boolean visible = adminPage.successMessageIsDisplayed();
        if (!visible) {
            throw new AssertionError("El mensaje esperado no se mostró: " + mensaje);
        }
    }
}