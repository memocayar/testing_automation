package ar.org.icaro.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CamerasPage extends BasePage {
    public CamerasPage(WebDriver driver) {
        super(driver);
    }

    public void addToWishList(String productName){
        WebElement productCard = getProductCard(productName);

        WebElement addToWishListButton = getAddToWishListButton(productCard);

        addToWishListButton.click();
    }

    public ProductPage addToShoppingCart(String productName){
        WebElement productCard = getProductCard(productName);

        WebElement addToShoppingCartButton = getAddToShoppingCartButton(productCard);

        addToShoppingCartButton.click();

        return new ProductPage(driver);
    }

    public WebElement getProductCard(String productName){
        return driver.findElement(By.xpath("//h4/a[text()='" + productName + "']/ancestor::div[@class='product-thumb']"));
    }

    public WebElement getAddToWishListButton(WebElement productCard){
        return productCard.findElement(By.xpath(".//button[@data-original-title='Add to Wish List']"));
    }

    public WebElement getAddToShoppingCartButton(WebElement productCard){
        return productCard.findElement(By.xpath(".//button[contains(@onclick, 'cart.add')]"));
    }


}
