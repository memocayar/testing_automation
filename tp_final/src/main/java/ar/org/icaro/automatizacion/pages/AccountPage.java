package ar.org.icaro.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage {
    By myAccountTextBy = By.xpath("//h2[text()='My Account']");
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getMyAccountSubtitulo() {
        return myAccountSubtitulo().getText();
    }

    private WebElement myAccountSubtitulo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(myAccountTextBy));
        return driver.findElement(myAccountTextBy);
    }
}
