package ar.org.icaro.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public boolean shoppingCartProductExists(String productName){
        return driver.findElement(By.xpath("//a[text()='" + productName + "']")).isEnabled();
    }
}
