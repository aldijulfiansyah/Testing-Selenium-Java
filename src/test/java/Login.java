import config.env_target;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login extends env_target {
    @Test
    public void main() {
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

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"][@type=\"submit\"]")).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"title\"][contains(text(), 'Products')]"))
        );

        driver.quit();
    }


    @Test
    public void negativeTest() {
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

        driver.findElement(By.id("user-name")).sendKeys("ssssda");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"][@type=\"submit\"]")).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@data-test=\"error\"]"))
        );

        driver.quit();

    }
}
