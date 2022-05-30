package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }

    public void login1() {
        WebElement signInButton = driver.findElement(By.xpath("//*[@id='_desktop_user_info']/div/a"));
        signInButton.click();
        WebElement emailInput = driver.findElement(By.name("email"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement submitButton = driver.findElement(By.id("submit-login"));
        emailInput.sendKeys("cajvedprdgmpelhmhi@bvhrs.com");
        passwordInput.sendKeys("password123");
        submitButton.click();
    }

    public void login2() {
        WebElement signInButton = driver.findElement(By.xpath("//*[@id='_desktop_user_info']/div/a"));
        signInButton.click();
        WebElement emailInput = driver.findElement(By.name("email"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement submitButton = driver.findElement(By.id("submit-login"));
        emailInput.sendKeys("cajvedprdgmpelhmhi@bvhrs.com");
        passwordInput.sendKeys("password123");
        submitButton.click();

        driver.get("https://mystore-testlab.coderslab.pl/index.php");

        WebElement tShirt = driver.findElement(By.xpath("//*[@id='content']/section/div/article[1]/div/a/img"));
        tShirt.click();
    }
}