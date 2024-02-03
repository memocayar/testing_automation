package ar.org.icaro.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MP3PlayersPage extends BasePage {


    private By primerProductoBy = By.xpath("(//div[@class='product-thumb'])[1]");
    private By segundoProductoBy = By.xpath("(//div[@class='product-thumb'])[2]");

    private Producto primerProducto;
    private Producto segundoProducto;
    private By productComparisonBy = By.xpath("//a[text()='product comparison']");

    public MP3PlayersPage(WebDriver driver) {
        super(driver);
    }

    public void scrollHastaPrimerProducto() {


        wait.until(ExpectedConditions.visibilityOfElementLocated(primerProductoBy));
        WebElement primerProductoElem = driver.findElement(primerProductoBy);

        primerProducto = new Producto(primerProductoElem);
        primerProducto.scrollAlProducto();
    }

    public void scrollHastaSegundoProducto() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(segundoProductoBy));
        WebElement segundoProductoElem = driver.findElement(segundoProductoBy);

        segundoProducto = new Producto(segundoProductoElem);
        segundoProducto.scrollAlProducto();
    }

    public String agregarPrimerProductoAComparacion() {
        return agregarProductoAComparacion(primerProducto);
    }

    public String agregarSegundoProductoAComparacion() {
        return agregarProductoAComparacion(segundoProducto);
    }

    private String agregarProductoAComparacion(Producto p) {
        String nombreProducto = p.getNombre();
        p.agregarAComparacion();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".alert-success")));
        return nombreProducto;
    }

    public ComparisonPage clickProductComparison() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        productComparisonBy));
        driver.findElement(productComparisonBy).click();

        return new ComparisonPage(driver);
    }

    private class Producto {

        private WebElement productoElem;
        private By addToCompareButtonBy = By.cssSelector("[data-original-title='Compare this Product']");
        private By nombreBy;

        public Producto(WebElement primerProductoElem) {
            productoElem = primerProductoElem;
        }

        public void scrollAlProducto() {
            scrollHasta(productoElem);
        }

        public void agregarAComparacion() {
            productoElem.findElement(addToCompareButtonBy).click();
        }

        public String getNombre() {
            nombreBy = By.cssSelector(".caption a");
            return productoElem.findElement(nombreBy).getText();
        }
    }
}
