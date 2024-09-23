import Utility.BaseDriver;
import Utility.MyFunc;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class US_302 extends BaseDriver {

    public static Actions actions = new Actions(driver);

    @Test
    public void invalidEmailAndInvalidInvoiceName() throws AWTException, IOException {
        Robot robot = new Robot();

        driver.get("https://shopdemo.fatfreeshop.com/");
        wait.until(ExpectedConditions.urlToBe("https://shopdemo.fatfreeshop.com/"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='column all_tag']//*[text()='Ebook'] ")));
        WebElement ebookButton = driver.findElement(By.xpath("//div[@class='column all_tag']//*[text()='Ebook'] "));
        wait.until(ExpectedConditions.elementToBeClickable(ebookButton));
        actions.moveToElement(ebookButton).click().build().perform();

        wait.until(ExpectedConditions.urlToBe("https://shopdemo.fatfreeshop.com/tags/Ebook"));
        Assert.assertTrue("Failed to proceed to the Ebook page", driver.getCurrentUrl().contains("/Ebook"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='view_product']")));
        WebElement addToCartButton = driver.findElement(By.cssSelector("[class='view_product']"));
        MyFunc.scrollElement(addToCartButton);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        actions.moveToElement(addToCartButton).click().build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']")));
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Demo eBook'])[1]")));
        WebElement demoEbookControl = driver.findElement(By.xpath("(//*[text()='Demo eBook'])[1]"));
        Assert.assertTrue("‘Demo eBook’ could not be added to the basket.", demoEbookControl.getText().contains("eBook"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Visa, AMEX, MasterCard, Maestro, Discover']")));
        WebElement bankCard = driver.findElement(By.xpath("//*[text()='Visa, AMEX, MasterCard, Maestro, Discover']"));
        wait.until(ExpectedConditions.elementToBeClickable(bankCard));
        MyFunc.jsClick(bankCard);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Billing-Form Form']//p")));
        WebElement billingDetails = driver.findElement(By.xpath("//div[@class='Billing-Form Form']//p"));
        wait.until(ExpectedConditions.visibilityOf(billingDetails));
        Assert.assertTrue("‘Billing information’ has been filled in.", billingDetails.isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button' and @class='Pay-Button']")));
        WebElement payButton = driver.findElement(By.xpath("//button[@type='button' and @class='Pay-Button']"));
        wait.until(ExpectedConditions.elementToBeClickable(payButton));
        MyFunc.jsClick(payButton);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='SnackBar']//span")));
        WebElement invalidMessage = driver.findElement(By.xpath("//div[@id='SnackBar']//span"));
        LocalDateTime localDateTime=LocalDateTime.now();
        DateTimeFormatter imgFormat=DateTimeFormatter.ofPattern("dd.MM.yyyy.HH.mm.ss");

        if (invalidMessage.isDisplayed()) {
            System.out.println(invalidMessage.getText());
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='SnackBar']//span")));

            TakesScreenshot ts = (TakesScreenshot) driver;
            File hafizadakiFile = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(hafizadakiFile, new File("errorMessageImg\\"+localDateTime.format(imgFormat)+"screenShot.jpg"));
        }
        tearDown();
    }
}






