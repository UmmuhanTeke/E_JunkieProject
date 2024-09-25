import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.event.KeyEvent;

public class US_308 extends BaseDriver {

    @Test
    public void Test1() throws AWTException {
        By link = By.xpath("(//div[@class='banner_btn']/a)[1]");
        By play = By.cssSelector("[class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']");
        By headerText = By.linkText("Sell downloads and more");

        driver.get("https://shopdemo.fatfreeshop.com/?");
        wait.until(ExpectedConditions.urlToBe("https://shopdemo.fatfreeshop.com/?"));

        Robot robot = new Robot();
        for (int i = 0; i <= 24; i++) {// 25tab
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            MyFunc.Wait(1);
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(link));
        WebElement seeHowItWorksBtn = driver.findElement(link);
        wait.until(ExpectedConditions.elementToBeClickable(link));
        seeHowItWorksBtn.click();

        driver.switchTo().frame(0);
        wait.until(ExpectedConditions.textToBe(headerText, "Sell downloads and more"));
        driver.navigate().refresh();

        wait.until(ExpectedConditions.visibilityOfElementLocated(link));
        WebElement seeHowItWorksBtn2 = driver.findElement(link);
        wait.until(ExpectedConditions.elementToBeClickable(link));
        seeHowItWorksBtn2.click();

        driver.switchTo().frame(0);
        wait.until(ExpectedConditions.visibilityOfElementLocated(play));
        WebElement videoPlay = driver.findElement(play);
        wait.until(ExpectedConditions.elementToBeClickable(play));
        videoPlay.click();
        MyFunc.Wait(12);

        tearDown();
    }
}
