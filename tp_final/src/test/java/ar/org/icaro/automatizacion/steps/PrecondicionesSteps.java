package ar.org.icaro.automatizacion.steps;

import ar.org.icaro.automatizacion.steps.driver.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import org.openqa.selenium.WebDriver;

public class PrecondicionesSteps {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverManager.driver;
    }

    @Dado("un usuario que realizó login con usuario {string} y contrasenia {string}")
    public void unUsuarioQueRealizoLoginConUsuarioYContrasenia(String usuario, String contrasenia) {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.unUsuarioQueSeEncuentraEnLaPaginaPrincipal();
        loginSteps.navegaALaPaginaDeLogin();
        loginSteps.iniciaSesionConUsuarioYContrasenia(usuario, contrasenia);
    }
}
