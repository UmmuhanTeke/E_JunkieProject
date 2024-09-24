import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.event.KeyEvent;

public class US_307 extends BaseDriver {

    @Test
    public void homePageIconControl() throws AWTException {
        driver.get("https://shopdemo.fatfreeshop.com/");
        wait.until(ExpectedConditions.urlToBe("https://shopdemo.fatfreeshop.com/"));

        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        wait.until(ExpectedConditions.urlToBe("https://shopdemo.fatfreeshop.com/"));
        Assert.assertTrue("Failed to reach home page",driver.getTitle().equals("Example E-junkie Shop Shop"));
        Assert.assertTrue("Failed to reach home page",driver.getCurrentUrl().equals("https://shopdemo.fatfreeshop.com/"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='T-shirts'])[1]")));

        tearDown();
    }
}
