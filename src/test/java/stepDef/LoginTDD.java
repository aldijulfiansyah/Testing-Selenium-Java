package stepDef;


import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginTDD extends env_target{
    @Given("User already in login page")
    public void userAlreadyInLoginPage() {
//        set driver path
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

//        set url
        driver.get(baseUrl);

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login-button\"][@type=\"submit\"]"))
        );
    }

    @When("^User input (.*) and (.*)$")
    public void userInputUsernameAndPassword(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("User click the login button")
    public void userClickTheLoginButton() {
        driver.findElement(By.xpath("//*[@id=\"login-button\"][@type=\"submit\"]")).click();
    }

    @Then("User get verify login (.*)$")
    public void userVerifyLoginResult(String result) {


        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        if (result == "Passed"){
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"title\"][contains(text(), 'Products')]"))
            );
        } else if (result == "Failed") {
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@data-test=\"error\"]"))
            );
        }


        driver.quit();
    }


}
