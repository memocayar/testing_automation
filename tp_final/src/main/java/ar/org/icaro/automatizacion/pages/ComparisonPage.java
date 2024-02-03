package ar.org.icaro.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ComparisonPage extends BasePage {

    private Tabla tablaDeComparacion;

    public ComparisonPage(WebDriver driver) {
        super(driver);
    }

    public String nombreDelPrimerProducto() {
        return tablaDeComparacion.getFila("Product").get(1);
    }

    public void scrollearATablaDeComparacion() {
        WebElement tabla = driver.findElement(By.cssSelector(".table"));
        tablaDeComparacion = new Tabla(tabla);
        tablaDeComparacion.scrollALaTabla();
    }

    public String nombreDelSegundoProducto() {
        return tablaDeComparacion.getFila("Product").get(2);

    }

    private class Tabla {

        private WebElement tablaElem;

        public Tabla(WebElement tabla) {
            tablaElem = tabla;
        }

        public void scrollALaTabla() {
            scrollHasta(tablaElem);
        }

        public List<String> getFila(String nombre) {
            String selector = String.format("//td[text()='%s']/parent::tr", nombre);
            By filaBy = By.xpath(selector);
            WebElement fila = tablaElem.findElement(filaBy);
            List<WebElement> columnas = fila.findElements(By.tagName("td"));
            List<String> textoColumnas = new ArrayList<>();
            for (WebElement col:columnas) {
                textoColumnas.add(col.getText());
            }
            return textoColumnas;
        }
    }
}
