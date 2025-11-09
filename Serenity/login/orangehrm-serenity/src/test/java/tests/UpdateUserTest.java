package tests;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.LoginPage;
import pages.AdminPage;

@ExtendWith(SerenityJUnit5Extension.class)
public class UpdateUserTest {

    LoginPage login = new LoginPage();
    AdminPage admin = new AdminPage();

    @Test
    public void actualizarUsuarioJasmineMorgan() {
        login.openLoginPage();
        login.loginAs("Admin", "admin123");
        admin.goToAdminSection();
        admin.searchUser("Jasmine.Morgan");
        admin.editFirstUser("Jasmine.Morgan.Test");

        assert admin.successMessageIsDisplayed();
    }
}
