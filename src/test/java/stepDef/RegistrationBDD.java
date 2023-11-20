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
        driver.get(lambdaTest);

        //set time

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(  text(), \"Register Account\")]"))
        );
    }

    @Then("User fill registration form")
    public void userFillRegistrationForm() {
        driver.findElement(By.id("input-firstname")).sendKeys("kylian");
        driver.findElement(By.id("input-lastname")).sendKeys("mbappes");
        driver.findElement(By.id("input-email")).sendKeys("mbappeas@abdc.com");
        driver.findElement(By.id("input-telephone")).sendKeys("628938333");
        driver.findElement(By.id("input-password")).sendKeys("user2323");
        driver.findElement(By.id("input-confirm")).sendKeys("user2323");

        driver.findElement(By.xpath("//label[text()='Yes']")).click();
        driver.findElement(By.xpath("//label[contains(text(),'I have read and agree to')]")).click();
    }

    @Then("User fill invalid registration form")
    public void userFillInvalidRegistrationForm() {
        driver.findElement(By.id("input-firstname")).sendKeys("kylian");
        driver.findElement(By.id("input-lastname")).sendKeys("mbappes");
        driver.findElement(By.id("input-email")).sendKeys("mbappeas@abdc.com");
        driver.findElement(By.id("input-telephone")).sendKeys("628938333");
        driver.findElement(By.id("input-password")).sendKeys("user2123");
        driver.findElement(By.id("input-confirm")).sendKeys("user2323");

        driver.findElement(By.xpath("//label[text()='Yes']")).click();
        driver.findElement(By.xpath("//label[contains(text(),'I have read and agree to')]")).click();
    }

    @And("User click sign up button")
    public void userClickSignUpButton() {
        driver.findElement(By.xpath("//input[@type = \"submit\"]")).click();
    }

    @Then("User succes register as expected")
    public void userVerifyRegistrationAsExpected() {

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains( text(), \"Congratulations! Your new account has been successfully created!\")]"))
        );

        driver.quit();
    }

    @Then("User get error register message")
    public void userGetErrorRegisterMessage() {

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'text-danger')]"))
        );

        driver.quit();
    }


}
