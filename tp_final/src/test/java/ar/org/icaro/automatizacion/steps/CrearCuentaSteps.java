package ar.org.icaro.automatizacion.steps;


import ar.org.icaro.automatizacion.pages.HomePage;
import ar.org.icaro.automatizacion.pages.RegisterPage;
import ar.org.icaro.automatizacion.steps.driver.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Map;

public class CrearCuentaSteps {

    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;

    @Before
    public void setUp() {
        driver = DriverManager.driver;
        homePage = new HomePage(driver);
    }

    @Cuando("navega a la pagina de registro")
    public void navegaALaPaginaDeRegistro() {
        homePage.clickBotonMyAccount();
        registerPage = homePage.clickBotonRegisterMyAccount();
    }


    @Y("completa el formulario con sus datos:")
    public void completaElFormularioConSusDatos(Map<String, String> datosDeRegistro) {
        String nombre = datosDeRegistro.get("nombre");
        String apellido = datosDeRegistro.get("apellido");
        String email = datosDeRegistro.get("email");
        String telefono = datosDeRegistro.get("telefono");
        String password = datosDeRegistro.get("password");
        String confirmarPassword = datosDeRegistro.get("confirmar_password");

        registerPage.rellenarFormulario(nombre, apellido, email, telefono, password, confirmarPassword);
    }

    @Y("habiendo aceptado los terminos y condiciones presiona enviar")
    public void habiendoAceptadoLosTerminosYCondicionesPresionaEnviar() {
        registerPage.checkCondiciones();
        registerPage.enviarFormulario();
    }

    @Entonces("valido creación exitosa")
    public void validoCreacionExitosa() {
        boolean creacionExitosa = registerPage.congratulationsMessageIsVisible();
        Assert.assertTrue(creacionExitosa);
    }
}
