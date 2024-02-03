package ar.org.icaro.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private By myAccountBy = By.cssSelector("[title='My Account']");
    private By loginBy = By.xpath("//*[text()='Login']");
    private By registerBy = By.xpath("//*[text()='Register']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    // My account
    public void clickBotonMyAccount() {
        myAccount().click();
    }

    private WebElement myAccount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(myAccountBy));
        return driver.findElement(myAccountBy);
    }

    public LoginPage clickBotonLoginMyAccount() {
        botonLoginMyAccount().click();
        return new LoginPage(driver);
    }

    private WebElement botonLoginMyAccount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginBy));
        return driver.findElement(loginBy);
    }

    public RegisterPage clickBotonRegisterMyAccount(){
        botonRegisterMyAccount().click();
        return new RegisterPage(driver);
    }

    private WebElement botonRegisterMyAccount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerBy));
        return driver.findElement(registerBy);
    }
}
