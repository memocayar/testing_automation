package ar.org.icaro.automatizacion.steps;

import ar.org.icaro.automatizacion.pages.*;
import ar.org.icaro.automatizacion.steps.driver.DriverManager;
import org.testng.Assert;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;

public class AgregarAFavoritosSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private CamerasPage camerasPage;
    private WishListPage wishListPage;

    @Before
    public void setUp() {
        driver = DriverManager.driver;
    }

    @Cuando("el usuario navega a la pagina de cameras")
    public void elUsuarioNavegaALaPaginaDeCameras() {
        loginPage = new LoginPage(driver);
        camerasPage = loginPage.clickBotonCameras();
    }

    @Y("agrego {string} a favoritos")
    public void agregoAFavoritos(String nombreProducto) {
        camerasPage.addToWishList(nombreProducto);
    }

    @Y("el usuario navega a la Wish List")
    public void elUsuarioNavegaALaWishList() {
        wishListPage = camerasPage.clickBotonWishList();
    }

    @Entonces("valido que se encuentre {string}")
    public void validoQueSeEncuentre(String nombreProducto) {
        boolean productNameIsVisible = wishListPage.wishListProductExists(nombreProducto);
        Assert.assertTrue(productNameIsVisible);
    }
}
