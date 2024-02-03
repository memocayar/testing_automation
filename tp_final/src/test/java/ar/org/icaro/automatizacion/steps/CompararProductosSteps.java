package ar.org.icaro.automatizacion.steps;

import ar.org.icaro.automatizacion.pages.ComparisonPage;
import ar.org.icaro.automatizacion.pages.MP3PlayersPage;
import ar.org.icaro.automatizacion.pages.LoginPage;
import ar.org.icaro.automatizacion.steps.driver.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CompararProductosSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private MP3PlayersPage mp3PlayersPage;
    private ComparisonPage comparisonPage;

    private String nombrePrimerProductoAgregado;
    private String nombreSegundoProductoAgregado;


    @Before
    public void setUp() {
        driver = DriverManager.driver;
    }

    @Cuando("el usuario navega a la pagina de mp3")
    public void elUsuarioNavegaALaPaginaDeMP3() {
        loginPage = new LoginPage(driver);
        mp3PlayersPage = loginPage.clickOnMP3PlayersButton();
    }

    @Y("agrega dos mp3 a la comparacion de productos")
    public void agregaDosMpALaComparacionDeProductos() {
        mp3PlayersPage.scrollHastaPrimerProducto();
        nombrePrimerProductoAgregado = mp3PlayersPage.agregarPrimerProductoAComparacion();

        mp3PlayersPage.scrollHastaSegundoProducto();
        nombreSegundoProductoAgregado = mp3PlayersPage.agregarSegundoProductoAComparacion();
    }

    @Y("navega a la pagina de comparacion de productos")
    public void navegaALaPaginaDeComparacionDeProductos() {
        comparisonPage = mp3PlayersPage.clickProductComparison();
    }

    @Entonces("observa que se agregaron los datos de ambos productos agregados")
    public void observaQueSeAgregaronLosDatosDeAmbosProductosAgregados() {
        comparisonPage.scrollearATablaDeComparacion();
        String nombrePrimerProductoAComparar = comparisonPage.nombreDelPrimerProducto();
        String nombreSegundoProductoAComparar = comparisonPage.nombreDelSegundoProducto();

        Assert.assertEquals(nombrePrimerProductoAComparar, nombrePrimerProductoAgregado, "Los nombres difieren");
        Assert.assertEquals(nombreSegundoProductoAComparar, nombreSegundoProductoAgregado, "Los nombres difieren");
    }

}
