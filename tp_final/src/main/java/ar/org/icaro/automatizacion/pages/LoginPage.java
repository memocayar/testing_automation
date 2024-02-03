package ar.org.icaro.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    private By campoEmailBy = By.id("input-email");
    private By campoContraseniaBy = By.id("input-password");
    private By botonLoginBy = By.xpath("//input[@type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void realizarLoginCon(String usuario, String contrasenia) {
        ingresarEmail(usuario);
        ingresarContrasenia(contrasenia);
    }

    public AccountPage clickBotonLogin() {
        botonLogin().click();
        return new AccountPage(driver);
    }

    private void ingresarContrasenia(String contrasenia) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoContraseniaBy));
        driver.findElement(campoContraseniaBy).sendKeys(contrasenia);
    }

    private void ingresarEmail(String usuario) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoEmailBy));
        driver.findElement(campoEmailBy).sendKeys(usuario);
    }

    private WebElement botonLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(botonLoginBy));
        return driver.findElement(botonLoginBy);
    }
}
