package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressPage {
    private WebDriver driver;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public void address(String alias, String address, String city, String postalCode, String country, String phone) {
        WebElement addressesButton = driver.findElement(By.xpath("//*[@id='addresses-link']/span/i"));
        addressesButton.click();
        WebElement createButton = driver.findElement(By.xpath("//*[@id='content']/div[3]/a/span"));
        createButton.click();
        WebElement aliasInput = driver.findElement(By.name("alias"));
        WebElement addressInput = driver.findElement(By.name("address1"));
        WebElement cityInput = driver.findElement(By.name("city"));
        WebElement postalCodeInput = driver.findElement(By.name("postcode"));
        WebElement countryInput = driver.findElement(By.name("id_country"));
        WebElement phoneInput = driver.findElement(By.name("phone"));

        aliasInput.sendKeys(alias);
        addressInput.sendKeys(address);
        cityInput.sendKeys(city);
        postalCodeInput.sendKeys(postalCode);
        countryInput.sendKeys(country);
        phoneInput.sendKeys(phone);
        WebElement saveButton = driver.findElement(By.className("btn"));
        saveButton.click();

    }

    public void deletingAddress() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//*[@id='main']"));
        WebElement deleteButton = element.findElement(By.cssSelector("a[data-link-action='delete-address']"));
        deleteButton.click();
    }
}