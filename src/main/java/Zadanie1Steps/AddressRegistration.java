package Zadanie1Steps;

import Pages.AddressPage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class AddressRegistration {

    WebDriver driver;

    @Given("user is on {string} page")
    public void enterPage(String url) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

    }

    @When("user clicks on SignIn button and logs in")
    public void signIn() {
        LoginPage onLoginPage = new LoginPage(driver);
        onLoginPage.login1();
    }

    @And("user click create new address and inputs {string}, {string}, {string}, {string},{string}, {string}")
    public void creatingAddress(String alias, String address, String city, String zip, String country, String phone) throws InterruptedException {
        AddressPage onAddressPage = new AddressPage(driver);
        onAddressPage.address(alias, address, city, zip, country, phone);
    }

    @And("user checks if data is correct")
    public void userChecksIfDataIsCorrect() {
        String expectedAlias = "Kuba";
        WebElement actualAlias = driver.findElement(By.xpath("//*[@id='address-25253']/div[1]/h4"));
        try {
            assertEquals(expectedAlias, actualAlias.getText());
        } catch (AssertionError e) {
            System.out.println("Dane nie są zgodne, oczekiwane dane:" + expectedAlias + " otrzymane dane:" + actualAlias.getText());
        }
    }

    @Then("user deletes added address")
    public void deleteAddress() throws InterruptedException {
        AddressPage onAddressPage = new AddressPage(driver);
        onAddressPage.deletingAddress();
        driver.quit();
    }
}