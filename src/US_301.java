import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class US_301 extends BaseDriver {

    @Test
    public void invalidPromoCode() {
        String promoCode = "345231234";

        driver.get("https://shopdemo.fatfreeshop.com/");
        wait.until(ExpectedConditions.urlToBe("https://shopdemo.fatfreeshop.com/"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='column all_tag']//*[text()='Ebook'] ")));
        WebElement ebookButton = driver.findElement(By.xpath("//div[@class='column all_tag']//*[text()='Ebook'] "));
        wait.until(ExpectedConditions.elementToBeClickable(ebookButton));
        MyFunc.jsClick(ebookButton);

        wait.until(ExpectedConditions.urlToBe("https://shopdemo.fatfreeshop.com/tags/Ebook"));
        Assert.assertTrue("Failed to proceed to the Ebook page", driver.getCurrentUrl().contains("/Ebook"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='view_product']")));
        WebElement addToCartButton = driver.findElement(By.cssSelector("[class='view_product']"));
        MyFunc.scrollElement(addToCartButton);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        MyFunc.jsClick(addToCartButton);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']")));
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Demo eBook'])[1]")));
        WebElement demoEbookControl = driver.findElement(By.xpath("(//*[text()='Demo eBook'])[1]"));
        Assert.assertTrue("‘Demo eBook’ could not be added to the basket.", demoEbookControl.getText().contains("eBook"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='Actions']//button)[2]")));
        WebElement addPromoCode = driver.findElement(By.xpath("(//div[@class='Actions']//button)[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(addPromoCode));
        MyFunc.jsClick(addPromoCode);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='Promo-Code-Value']")));
        WebElement promoCodeBox = driver.findElement(By.xpath("//input[@class='Promo-Code-Value']"));
        promoCodeBox.sendKeys(promoCode);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Promo-Box Active']//button")));
        WebElement applyButton = driver.findElement(By.xpath("//div[@class='Promo-Box Active']//button"));
        wait.until(ExpectedConditions.elementToBeClickable(applyButton));
        MyFunc.jsClick(applyButton);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='SnackBar']//span")));
        WebElement invalidCodeMessage = driver.findElement(By.xpath("//div[@id='SnackBar']//span"));
        System.out.println(invalidCodeMessage.getText());
        Assert.assertTrue("Valid promo code", invalidCodeMessage.getText().contains("Invalid"));

        tearDown();
    }
}
