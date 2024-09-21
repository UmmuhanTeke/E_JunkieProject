import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class US_306 extends BaseDriver {
    String nameStr="John";
    String emailStr="TestUser"+(int)(Math.random()*100)+"@gmail.com";
    String subjectStr="Private";
    String messageStr="No Message";

    @Test
    public void contactUs(){
        Actions actions=new Actions(driver);
        driver.get("https://shopdemo.fatfreeshop.com/");
        wait.until(ExpectedConditions.urlToBe("https://shopdemo.fatfreeshop.com/"));

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='contact']")));
        WebElement contactUsBtn=driver.findElement(By.cssSelector("[class='contact']"));
        MyFunc.scrollElement(contactUsBtn);
        actions.click(contactUsBtn).build().perform();

        wait.until(ExpectedConditions.urlToBe("https://shopdemo.fatfreeshop.com/contact"));
        WebElement contactUsControl=driver.findElement(By.cssSelector("[class='has-text-centered']"));
        Assert.assertTrue("Contact us sayfası açılamadı",contactUsControl.getText().contains("You can use the form"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='sender_name']")));
        WebElement name=driver.findElement(By.cssSelector("[name='sender_name']"));
        actions.click(name).sendKeys(nameStr).build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='sender_email']")));
        WebElement email=driver.findElement(By.cssSelector("[name='sender_email']"));
        actions.click(email).sendKeys(emailStr).build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='sender_subject']")));
        WebElement subject=driver.findElement(By.cssSelector("[id='sender_subject']"));
        actions.click(subject).sendKeys(subjectStr).build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='sender_message']")));
        WebElement message=driver.findElement(By.cssSelector("[id='sender_message']"));
        actions.click(message).sendKeys(messageStr).build().perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        WebElement sendMessageBtn=driver.findElement(By.cssSelector("button[type='submit']"));
        actions.click(sendMessageBtn).build().perform();

        wait.until(ExpectedConditions.alertIsPresent());
        String alertMessage=driver.switchTo().alert().getText();
        Assert.assertTrue("Alert çıkmadı",alertMessage.contains("didn't match"));
        driver.switchTo().alert().accept();

        tearDown();
    }
}
