package stepDef;
import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class RegistrationTDD extends env_target{
    @Given("User already in register page")
    public void userIsOnRegistrationPage() {

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // set link
        driver.get(lambdaTest);

        //set time

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(  text(), \"Register Account\")]"))
        );


    }

    @Then("^User fill (.*), (.*), (.*), (.*), (.*), (.*) check (.*), (.*)$")
    public void userFillRegistrationForm(String firstname, String lastname, String email, String telephone, String password, String confirmPass, String radio, String checkbox) {
        driver.findElement(By.id("input-firstname")).sendKeys(firstname);
        driver.findElement(By.id("input-lastname")).sendKeys(lastname);
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-telephone")).sendKeys(telephone);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.id("input-confirm")).sendKeys(confirmPass);

        if (radio.equalsIgnoreCase("yes")) {
            WebElement radioYes = driver.findElement(By.xpath("//label[text()='Yes']"));
            if (!radioYes.isSelected()) {
                radioYes.click();
            }
        } else {
            WebElement radioNo = driver.findElement(By.xpath("//label[text()='No']"));
            if (!radioNo.isSelected()) {
                radioNo.click();
            }
        }

        if (checkbox.equalsIgnoreCase("yes")){
            WebElement termsCheckbox = driver.findElement(By.xpath("//label[contains(text(),'I have read and agree to')]"));
            if (!termsCheckbox.isSelected()){
                termsCheckbox.click();
            }
        }

    }


    @And("User click on the sign up button")
    public void userClickSignUpButton() {
        driver.findElement(By.xpath("//input[@type = \"submit\"]")).click();
    }

    @Then("^User verify registration (.*)$")
    public void userVerifyRegistrationResult(String result) {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        if (result == "Passed"){
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains( text(), \"Congratulations! Your new account has been successfully created!\")]"))
            );
        } else if (result == "Failed"){
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'text-danger')]"))
            );
        }


        driver.quit();
    }


}
