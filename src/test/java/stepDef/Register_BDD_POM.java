package stepDef;
import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import pages.RegisterPage;



public class Register_BDD_POM extends env_target{
    @Given("User is on register page")
    public void userIsOnRegistrationPage() {

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
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

    @Then("User fill register data")
    public void userFillRegistrationForm() {
        RegisterPage Register = new RegisterPage(driver);

        Register.inputRegisterData("Marco","Phoenix","Mp22@sas.com","08928364223","qwert12","qwert12");
        Register.clickData();
    }

    @Then("User fill invalid register data")
    public void userFillInvalidRegistrationForm() {
        RegisterPage Register = new RegisterPage(driver);

        Register.inputRegisterData("Marco","Phoenix","Mp22@sas.com","08928364223","qwert11","qwert12");
        Register.clickData();
    }

    @And("User click signup button")
    public void userClickSignUpButton() {
        RegisterPage Register = new RegisterPage(driver);
        Register.submit();
    }

    @Then("User done register")
    public void userVerifyRegistrationAsExpected() {

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains( text(), \"Congratulations! Your new account has been successfully created!\")]"))
        );

        driver.quit();
    }

    @Then("User failed to register")
    public void userGetErrorRegisterMessage() {

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'text-danger')]"))
        );

        driver.quit();
    }


}
