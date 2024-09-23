import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.awt.*;

public class US_304 extends BaseDriver {

    public static Actions action = new Actions(driver);
    public static Robot robot;
    String productName="Demo eBook";

    @Test
    public void paymentAndConfirmByCreditCard() throws AWTException {
        driver.get("https://shopdemo.fatfreeshop.com/");
        wait.until(ExpectedConditions.urlToBe("https://shopdemo.fatfreeshop.com/"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='column all_tag' ])//a[2]")));
        WebElement eBook = driver.findElement(By.xpath("(//div[@class='column all_tag' ])//a[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(eBook));
        action.click(eBook).build().perform();

        wait.until(ExpectedConditions.textToBe(By.className("title"),"Demo eBook"));
        WebElement eBookButton = driver.findElement(By.xpath("//*[@class='view_product' ]"));
        wait.until(ExpectedConditions.elementToBeClickable(eBookButton));
        action.click(eBookButton).build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//iframe[@class='EJIframeV3 EJOverlayV3' ])")));
        WebElement yourCartIframe=driver.findElement(By.xpath("(//iframe[@class='EJIframeV3 EJOverlayV3' ])"));
        wait.until(ExpectedConditions.visibilityOf(yourCartIframe));
        driver.switchTo().frame(yourCartIframe);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h3[@class='Title'])[1]")));
        WebElement yourCarttext=driver.findElement(By.xpath("(//h3[@class='Title'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(yourCarttext));
        Assert.assertTrue("Your Cart is not available",yourCarttext.getText().contains("Your Cart"));

        if (yourCarttext.isDisplayed()){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Demo eBook' ]")));
        WebElement productNameText=driver.findElement(By.xpath("//h5[text()='Demo eBook' ]"));
        wait.until(ExpectedConditions.visibilityOf(productNameText));
        Assert.assertTrue("Product name is not same",productNameText.getText().contains(productName));

        wait.until(ExpectedConditions.textToBe(By.xpath("//span[text()='0.50 USD' ]"),"0.50 USD"));
        WebElement totalPrice=driver.findElement(By.xpath("//span[text()='0.50 USD' ]"));

        String stringTotal=totalPrice.getText().replaceAll("[^0-9,.]","");
        double doubleTotal=Double.parseDouble(stringTotal);
        System.out.println("yeni fiyat : "+doubleTotal);
        Assert.assertTrue("Total price is not same",doubleTotal==0.5);

        }

    }
}
