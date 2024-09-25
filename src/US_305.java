import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class US_305 extends BaseDriver {

    public static Actions action = new Actions(driver);
    String productName = "Demo eBook";
    String eMail = "kayamerve@gmail.com";
    String nameOnCard = "Merve Kaya";
    String creditCardNumber = "4242 4242 4242 4242";
    String expiration = "1224";
    String CVV = "000";
    String company = "Team6";
    String phoneNumber = "98757905";

    @Test
    public void paymentAndConfirmByCreditCard() throws AWTException {
        Robot robot = new Robot();
        driver.get("https://shopdemo.fatfreeshop.com/");
        wait.until(ExpectedConditions.urlToBe("https://shopdemo.fatfreeshop.com/"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='column all_tag' ])//a[2]")));
        WebElement eBook = driver.findElement(By.xpath("(//div[@class='column all_tag' ])//a[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(eBook));
        action.click(eBook).build().perform();

        wait.until(ExpectedConditions.textToBe(By.className("title"), "Demo eBook"));
        WebElement eBookButton = driver.findElement(By.xpath("//*[@class='view_product' ]"));
        wait.until(ExpectedConditions.elementToBeClickable(eBookButton));
        action.click(eBookButton).build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//iframe[@class='EJIframeV3 EJOverlayV3' ])")));
        WebElement yourCartIframe = driver.findElement(By.xpath("(//iframe[@class='EJIframeV3 EJOverlayV3' ])"));
        driver.switchTo().frame(yourCartIframe);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h3[@class='Title'])[1]")));
        WebElement yourCartText = driver.findElement(By.xpath("(//h3[@class='Title'])[1]"));
        Assert.assertTrue("Your Cart is not available", yourCartText.getText().contains("Your Cart"));

        if (yourCartText.isDisplayed()) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Demo eBook' ]")));
            WebElement productNameText = driver.findElement(By.xpath("//h5[text()='Demo eBook' ]"));
            Assert.assertTrue("Product name is not same", productNameText.getText().contains(productName));

            wait.until(ExpectedConditions.textToBe(By.xpath("//span[text()='0.50 USD' ]"), "0.50 USD"));
            WebElement totalPrice = driver.findElement(By.xpath("//span[text()='0.50 USD' ]"));

            String stringTotal = totalPrice.getText().replaceAll("[^0-9,.]", "");
            double doubleTotal = Double.parseDouble(stringTotal);
            Assert.assertTrue("Total price is not same", doubleTotal == 0.5);
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='Payment-Button CC']")));
        WebElement creditCardButton = driver.findElement(By.cssSelector("button[class='Payment-Button CC']"));
        wait.until(ExpectedConditions.elementToBeClickable(creditCardButton));
        action.click(creditCardButton).build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Billing-Form Form']")));
        WebElement billingDetailsForm = driver.findElement(By.xpath("//div[@class='Billing-Form Form']"));

        if (billingDetailsForm.isDisplayed()) {
            MyFunc.Wait(2);
            for (int i = 0; i <= 2; i++) {
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
            }
            action.sendKeys(eMail).perform();

            for (int i = 0; i < 1; i++) {
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
            }
            action.sendKeys(eMail).perform();

            for (int i = 0; i < 1; i++) {
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
            }
            action.sendKeys(nameOnCard).perform();

            for (int i = 0; i < 1; i++) {
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
            }
            action.sendKeys(phoneNumber).perform();

            for (int i = 0; i < 1; i++) {
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
            }
            action.sendKeys(company).perform();
        }

        for (int i = 0; i < 2; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='Checkout-Option ']")));
        action.sendKeys(creditCardNumber).perform();
        action.sendKeys(expiration).perform();
        action.sendKeys(CVV).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button' and @class='Pay-Button']")));
        WebElement payButton = driver.findElement(By.xpath("//button[@type='button' and @class='Pay-Button']"));
        wait.until(ExpectedConditions.elementToBeClickable(payButton));
        MyFunc.jsClick(payButton);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='confirme_text']")));
        WebElement confirmText = driver.findElement(By.xpath("//p[@class='confirme_text']"));
        Assert.assertTrue("The Confirm text is not matched", confirmText.getText().contains("confirmed"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Total']")));
        WebElement totalText=driver.findElement(By.xpath("//span[text()='Total']"));
        MyFunc.scrollElement(totalText);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='usd'])[2]")));
        WebElement orderInfo=driver.findElement(By.xpath("(//span[@class='usd'])[2]"));
        String orderTotal = orderInfo.getText().replaceAll("[^0-9,.]", "");
        double doubleTotal = Double.parseDouble(orderTotal);
        Assert.assertTrue("Total price is not same", doubleTotal == 0.5);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Download']")));
        WebElement downloadButton=driver.findElement(By.xpath("//span[text()='Download']"));
        wait.until(ExpectedConditions.elementToBeClickable(downloadButton));
        MyFunc.jsClick(downloadButton);

        StringSelection downloadFolderPath= new StringSelection("C:\\Users\\User\\Downloads\\demo.pdf");
        File downloadedFile = new File(downloadFolderPath + File.separator + "demo.pdf");

        if (downloadedFile.exists()){
            System.out.println("The file was successfully downloaded.");
        }else {
            System.out.println("The file could not be downloaded ");
        }

        tearDown();
    }
}