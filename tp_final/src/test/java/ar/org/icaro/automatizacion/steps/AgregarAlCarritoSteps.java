package ar.org.icaro.automatizacion.steps;

import ar.org.icaro.automatizacion.pages.CamerasPage;
import ar.org.icaro.automatizacion.pages.LoginPage;
import ar.org.icaro.automatizacion.pages.ProductPage;
import ar.org.icaro.automatizacion.pages.ShoppingCartPage;
import ar.org.icaro.automatizacion.steps.driver.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AgregarAlCarritoSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private CamerasPage camerasPage;
    private ShoppingCartPage shoppingCartPage;
    private ProductPage productPage;

    @Before
    public void setUp() {
        driver = DriverManager.driver;
    }

    @Cuando("el usuario navega a cameras")
    public void elUsuarioNavegaACameras() {
        loginPage = new LoginPage(driver);
        camerasPage = loginPage.clickBotonCameras();
    }

    @Y("en el producto {string} hace click en agregar al carrito")
    public void enElProductoHaceClickEnAgregarAlCarrito(String nombreProducto) {
        productPage = camerasPage.addToShoppingCart(nombreProducto);
    }

    @Y("agrega la opcion {string}")
    public void seleccionaLaOpcion(String opcion) {
        productPage.selectOption(opcion);
        productPage.addToCart();
    }

    @Entonces("valido que se encuentre {string} en el carrito")
    public void validoQueSeEncuentreEnElCarrito(String nombreProducto) {
        shoppingCartPage = productPage.clickBotonCarrito();
        boolean productNameIsVisible = shoppingCartPage.shoppingCartProductExists(nombreProducto);
        Assert.assertTrue(productNameIsVisible);
    }
}
