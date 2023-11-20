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




public class RegistrationBDD extends env_target{
    @Given("User is on registration page")
    public void userIsOnRegistrationPage() {

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
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

    @Then("User fill registration form")
    public void userFillRegistrationForm() {
        driver.findElement(By.id("user[first_name]")).sendKeys("Ronissdd");
        driver.findElement(By.id("user[last_name]")).sendKeys("sandmawwn");
        driver.findElement(By.id("user[email]")).sendKeys("Ronidsdd@gg.cocom");
        driver.findElement(By.id("user[password]")).sendKeys("Californias");
        driver.findElement(By.id("user[terms]")).click();
    }

    @Then("User fill invalid registration form")
    public void userFillInvalidRegistrationForm() {
        driver.findElement(By.id("user[first_name]")).sendKeys("123");
        driver.findElement(By.id("user[last_name]")).sendKeys("222");
        driver.findElement(By.id("user[email]")).sendKeys("33");
        driver.findElement(By.id("user[password]")).sendKeys("s");
        driver.findElement(By.id("user[terms]")).click();
    }

    @And("User click sign up button")
    public void userClickSignUpButton() {
        driver.findElement(By.xpath("//button[@type = \"submit\"][contains(text(), \"Sign up\")]")).click();
    }

    @Then("User verify registration result")
    public void userVerifyRegistrationResult() {

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), \"Products\")]"))
        );

        driver.quit();
    }

    @Then("User get error register message")
    public void userGetErrorRegisterMessage() {

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("form-error__list-item"))
        );

        driver.quit();
    }


}
