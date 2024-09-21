import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;

public class US_302 extends BaseDriver {

    public static Actions actions = new Actions(driver);
    public static Robot robot;

    @Test
    public void invalidEmailAndInvalidInvoiceName() throws AWTException {
        driver.get("https://shopdemo.fatfreeshop.com/");
        wait.until(ExpectedConditions.urlToBe("https://shopdemo.fatfreeshop.com/"));
        robot = new Robot();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='column all_tag']//*[text()='Ebook'] ")));
        WebElement ebookButton = driver.findElement(By.xpath("//div[@class='column all_tag']//*[text()='Ebook'] "));
        actions.moveToElement(ebookButton).click().build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='view_product']")));
        WebElement addToCartButton = driver.findElement(By.cssSelector("[class='view_product']"));
        actions.moveToElement(addToCartButton).click().build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Demo eBook'])[1]")));
        WebElement demoEbookControl = driver.findElement(By.xpath("(//*[text()='Demo eBook'])[1]"));
        Assert.assertTrue("‘Demo eBook’ could not be added to the basket.", demoEbookControl.getText().contains("eBook"));

        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Visa, AMEX, MasterCard, Maestro, Discover']")));

        WebElement bankCard = driver.findElement(By.xpath("//*[text()='Visa, AMEX, MasterCard, Maestro, Discover']"));
        wait.until(ExpectedConditions.elementToBeClickable(bankCard));
        MyFunc.jsClick(bankCard);

        // MyFunc.Wait(2);
        //        for (int i = 1; i <= 20; i++) {
        //            robot.keyPress(KeyEvent.VK_TAB);
        //            robot.keyRelease(KeyEvent.VK_TAB);
        //        }
        //
        //        MyFunc.Wait(2);
        //        robot.keyPress(KeyEvent.VK_ENTER);
        //        robot.keyRelease(KeyEvent.VK_ENTER);
        //        MyFunc.Wait(2);
        //
        //        tearDown();
    }
}
