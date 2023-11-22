package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;

    //Setting driver
    public RegisterPage(WebDriver driver){
        this.driver=driver;
    }

    //element locator
    By firstnameField = By.id("input-firstname");
    By lastnameField = By.id("input-lastname");
    By emailField = By.id("input-email");
    By telephoneField = By.id("input-telephone");
    By passwordField = By.id("input-password");
    By confPasswordField = By.id("input-confirm");

    By radioField = By.xpath("//label[text()='Yes']");

    By termField = By.xpath("//label[contains(text(),'I have read and agree to')]");

    By submitButton = By.xpath("//input[@type = \"submit\"]");

    // action
    public void inputRegisterData(String firstname, String lastname, String email, String telephone, String password, String confPassword){
        driver.findElement(firstnameField).sendKeys(firstname);
        driver.findElement(lastnameField).sendKeys(lastname);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(telephoneField).sendKeys(telephone);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confPasswordField).sendKeys(confPassword);
    }

    public void clickData(){
        driver.findElement(radioField).click();
        driver.findElement(termField).click();
    }
    public void submit(){
        driver.findElement(submitButton).click();
    }
}