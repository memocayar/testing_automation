package ar.org.icaro.automatizacion.steps;

import ar.org.icaro.automatizacion.pages.AccountPage;
import ar.org.icaro.automatizacion.pages.HomePage;
import ar.org.icaro.automatizacion.pages.LoginPage;
import ar.org.icaro.automatizacion.steps.driver.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.E;
import io.cucumber.java.es.Entonces;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Map;

public class LoginSteps {

    private WebDriver driver;
    @Before
    public void setUp() {
        driver = DriverManager.driver;
    }
    private HomePage homePage;
    private LoginPage loginPage;

    private AccountPage accountPage;

    @Dado("un usuario que se encuentra en la home page")
    public void unUsuarioQueSeEncuentraEnLaPaginaPrincipal() {
        driver = DriverManager.driver;
        driver.get("https://opencart.abstracta.us/index.php?route=common/home");
        homePage = new HomePage(driver);
    }

    @Cuando("navega a la pagina de login")
    public void navegaALaPaginaDeLogin() {
        homePage.clickBotonMyAccount();
        loginPage = homePage.clickBotonLoginMyAccount();
    }

    @E("inicia sesion con usuario {string} y contrasenia {string}")
    public void iniciaSesionConUsuarioYContrasenia(String usuario, String contrasenia) {
        loginPage.realizarLoginCon(usuario, contrasenia);
        accountPage = loginPage.clickBotonLogin();
    }

    @Entonces("el usuario se encuentra en la account page")
    public void elUsuarioSeEncuentraEnLaAccountPage() {
        String myAccountText = accountPage.getMyAccountSubtitulo();
        String expectedText = "My Account";
        Assert.assertEquals(myAccountText, expectedText, "Los textos no coinciden");
    }
}
