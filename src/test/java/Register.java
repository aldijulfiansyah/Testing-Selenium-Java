import config.env_target;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Register extends env_target {
    @Test
    public void main(){

        //set up driver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // set link
        driver.get(lambdaTest);

        //set time

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class = \"page__heading\"][contains(text(), \"Create a new account\")]"))
        );

        driver.findElement(By.id("user[first_name]")).sendKeys("Roni");
        driver.findElement(By.id("user[last_name]")).sendKeys("sandman");
        driver.findElement(By.id("user[email]")).sendKeys("Roni@gg.cocom");
        driver.findElement(By.id("user[password]")).sendKeys("California");
        driver.findElement(By.id("user[terms]")).click();



        driver.findElement(By.xpath("//button[@type = \"submit\"][contains(text(), \"Sign up\")]")).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), \"Products\")]"))
        );

        driver.quit();

    }



    @Test
    public void negativeTest(){

        //set up driver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // set link
        driver.get(lambdaTest);

        //set time

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class = \"page__heading\"][contains(text(), \"Create a new account\")]"))
        );

        driver.findElement(By.id("user[first_name]")).sendKeys("Roni");
        driver.findElement(By.id("user[last_name]")).sendKeys("sandman");
        driver.findElement(By.id("user[email]")).sendKeys("Roniss");
        driver.findElement(By.id("user[password]")).sendKeys("California");
        driver.findElement(By.id("user[terms]")).click();



        driver.findElement(By.xpath("//button[@type = \"submit\"][contains(text(), \"Sign up\")]")).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("form-error__list-item"))
        );

        driver.quit();

    }
}
