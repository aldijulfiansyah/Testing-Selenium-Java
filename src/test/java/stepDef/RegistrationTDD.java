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
        driver.get(ultimateQALink);

        //set time

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class = \"page__heading\"][contains(text(), \"Create a new account\")]"))
        );
    }

    @Then("^User fill (.*), (.*), (.*), (.*), check (.*)$")
    public void userFillRegistrationForm(String firstname, String lastname, String email, String password, String checkbox) {
        driver.findElement(By.id("user[first_name]")).sendKeys(firstname);
        driver.findElement(By.id("user[last_name]")).sendKeys(lastname);
        driver.findElement(By.id("user[email]")).sendKeys(email);
        driver.findElement(By.id("user[password]")).sendKeys(password);

        if (checkbox.equalsIgnoreCase("yes")){
            WebElement termsCheckbox = driver.findElement(By.id("user[terms]"));
            if (!termsCheckbox.isSelected()){
                termsCheckbox.click();
            }
        }

    }


    @And("User click on the sign up button")
    public void userClickSignUpButton() {
        driver.findElement(By.xpath("//button[@type = \"submit\"][contains(text(), \"Sign up\")]")).click();
    }

    @Then("User verify registration (.*)")
    public void userVerifyRegistrationResult(String result) {

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        if (result == "Passed"){
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), \"Products\")]"))
            );
        } else if (result == "Failed") {
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.className("form-error__list-item"))
            );
        }


        driver.quit();
    }


}
