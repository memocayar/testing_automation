package ar.org.icaro.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {

    private By formularioBy = By.id("content");
    private By condicionesBy = By.name("agree");
    private By inputFirstNameBy = By.id("input-firstname");
    private By inputLastNameBy = By.id("input-lastname");
    private By inputEmailBy = By.id("input-email");
    private By inputTelephoneBy = By.id("input-telephone");
    private By inputPasswordBy = By.id("input-password");
    private By inputConfirmBy = By.id("input-confirm");
    private By continueButtonBy = By.cssSelector(".btn.btn-primary");
    private By congratulationsMessageBy = By.xpath("//p[contains(text(),'Congratulations! Your new account has been successfully created!')]");



    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void scrollHastaElFormulario() {
        // Scrolleamos hasta el formulario para que los elementos estén a la vista
        WebElement formulario = getFormulario();
        scrollHasta(formulario);
    }

    private WebElement getFormulario() {
        wait.until(ExpectedConditions.presenceOfElementLocated(formularioBy));
        return driver.findElement(formularioBy);
    }

    public void rellenarFormulario(String nombre, String apellido, String email, String telefono, String password, String confirmarPassword) {
        driver.findElement(inputFirstNameBy).sendKeys(nombre);
        driver.findElement(inputLastNameBy).sendKeys(apellido);
        driver.findElement(inputEmailBy).sendKeys(email);
        driver.findElement(inputTelephoneBy).sendKeys(telefono);
        driver.findElement(inputPasswordBy).sendKeys(password);
        driver.findElement(inputConfirmBy).sendKeys(confirmarPassword);
    }

    public void checkCondiciones() {
        WebElement condicionesBoton = driver.findElement(condicionesBy);
        condicionesBoton.click();
    }

    public void enviarFormulario() {
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(continueButtonBy));
        continueButton.click();
    }

    public boolean congratulationsMessageIsVisible() {
        WebElement congratulationsMessage = wait.until(ExpectedConditions.presenceOfElementLocated(congratulationsMessageBy));
        return congratulationsMessage.isDisplayed();
    }
}
