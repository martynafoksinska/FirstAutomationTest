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

import static org.junit.Assert.assertEquals;

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
        String expectedAlias = "Home address";
        WebElement rows = driver.findElement(By.xpath("//*[@id='content']"));
        WebElement div = rows.findElement(By.cssSelector("div[class*=col-lg-4]"));
        WebElement address = div.findElement(By.cssSelector("article[id*=address-]:last-child"));
        String actualAlias = address.findElement(By.tagName("h4")).getText();
        try {
            assertEquals(expectedAlias, actualAlias);
            System.out.println("Dane sa zgodne");
        } catch (AssertionError e) {
            String newLine = System.getProperty("line.separator");
            System.out.println("Dane nie sa zgodne," + newLine + "Oczekiwane dane: " + expectedAlias + newLine + "Otrzymane dane: " + actualAlias);
        }
    }

    @Then("user deletes added address")
    public void deleteAddress() throws InterruptedException {
        AddressPage onAddressPage = new AddressPage(driver);
        onAddressPage.deletingAddress();
        driver.quit();
    }
}