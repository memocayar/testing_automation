package ar.org.icaro.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {

    private By selectDropdownBy = By.id("input-option226");
    private By addToCartButtonBy = By.id("button-cart");


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void selectOption(String option) {
        WebElement selectDropdownButton = wait.until(ExpectedConditions.visibilityOfElementLocated(selectDropdownBy));
        new Actions(driver)
                .click(selectDropdownButton)
                .perform();

        By optionBy = By.xpath("//select[@id='input-option226']/option[normalize-space(text())='" + option + "']");

        wait.until(ExpectedConditions.visibilityOfElementLocated(optionBy));
        driver.findElement(optionBy).click();
    }

    public void addToCart(){
        WebElement addToCartButton = driver.findElement(addToCartButtonBy);
        addToCartButton.click();
    }


}
