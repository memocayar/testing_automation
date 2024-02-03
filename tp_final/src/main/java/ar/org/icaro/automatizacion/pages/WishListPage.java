package ar.org.icaro.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListPage extends BasePage {

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    public boolean wishListProductExists(String productName){
        return driver.findElement(By.xpath("//a[text()='" + productName + "']")).isEnabled();
    }

}
