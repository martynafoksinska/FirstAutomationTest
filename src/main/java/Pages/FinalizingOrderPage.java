package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FinalizingOrderPage {
    private WebDriver driver;

    public FinalizingOrderPage (WebDriver driver) {
        this.driver = driver;
    }

    public void addresses() {
        WebElement continueButton = driver.findElement(By.name("confirm-addresses"));
        continueButton.click();
    }

    public void shippingMethod() throws InterruptedException {
/*        WebElement prestaShopInput = driver.findElement(By.id("delivery_option_1"));
        prestaShopInput.click();
        Thread.sleep(1000);
 */
        WebElement continueButton = driver.findElement(By.xpath("//*[@id='js-delivery']/button"));
        continueButton.click();
    }

    public void payment() {
        WebElement paymentTypeInput = driver.findElement(By.id("payment-option-1"));
        paymentTypeInput.click();
        WebElement termsAndConditionsInput = driver.findElement(By.name("conditions_to_approve[terms-and-conditions]"));
        termsAndConditionsInput.click();
    }
}
