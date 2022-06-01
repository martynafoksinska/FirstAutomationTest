package Zadanie2Steps;

import Pages.FinalizingOrderPage;
import Pages.LoginPage;
import Pages.TShirtPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.media.model.Timestamp;

import java.io.File;
import java.io.IOException;

public class Purchasing {

    WebDriver driver;

    @Given("user is on {string} webpage")
    public void enterPage(String url) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

    }

    @When("user logs into his account and click on Hummingbird Printed Sweater")
    public void logIn() throws InterruptedException {
        LoginPage onLoginPage = new LoginPage(driver);
        onLoginPage.login2();
        Thread.sleep(1000);
    }

    @And("user chooses M size and picks quantity 5, then adds to cart and proceeds to checkout")
     public void buyingProcedure() throws InterruptedException {
        TShirtPage onTShirtPage = new TShirtPage(driver);
        onTShirtPage.purchasingTShirt();
    }

    @And("user finalizes his order")
    public void finalizingOrder() throws InterruptedException {
        FinalizingOrderPage onFinalizingOrderPage = new FinalizingOrderPage(driver);
        onFinalizingOrderPage.addresses();
        onFinalizingOrderPage.shippingMethod();
        onFinalizingOrderPage.payment();

    }

    @Then("screenshot with payment confirmation is done")
    public void screenshot() throws IOException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String imageFileDir = "\\Users\\marty\\ZadanieWarsztatowe1\\src\\tmpS";
        FileUtils.copyFile(scrFile, new File(imageFileDir, "test" + timestamp + ".png"));
        driver.quit();

    }
}