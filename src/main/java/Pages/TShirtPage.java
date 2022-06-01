package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;

public class TShirtPage {
    private WebDriver driver;

    public TShirtPage (WebDriver driver) {
        this.driver = driver;
    }

    public void purchasingTShirt() throws InterruptedException {
        if (driver.findElement(By.cssSelector("span[class='discount discount-percentage']")).isDisplayed()) {
            String expectedDiscount = "SAVE 20%";
            String actualDiscount = driver.findElement(By.cssSelector("span[class='discount discount-percentage']")).getText();
            assertEquals(expectedDiscount, actualDiscount);
        } else {
            System.out.println("Brak aktywnej znizki");
        }
        WebElement sizeInput = driver.findElement(By.xpath("//*[@id='group_1']/option[2]"));
        sizeInput.click();
        WebElement quantityInput = driver.findElement(By.id("quantity_wanted"));
        quantityInput.clear();
        quantityInput.sendKeys("5");
        WebElement addToCartButton = driver.findElement(By.xpath("//*[@id='add-to-cart-or-refresh']/div[2]/div/div[2]/button"));
        addToCartButton.click();
        Thread.sleep(1000);
        WebElement proceedToCheckout = driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a"));
        proceedToCheckout.click();
        WebElement proceedToCheckout2 = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a"));
        proceedToCheckout2.click();

    }
}
