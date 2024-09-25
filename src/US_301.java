import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class US_301 extends BaseDriver {
    @Test
    public void US_301Test(){
        driver.get("https://shopdemo.fatfreeshop.com/?");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='box'])[2]")));
        WebElement eBook=driver.findElement(By.xpath("(//div[@class='box'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='box'])[2]")));
        eBook.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='ADD TO CART']")));
        WebElement button=driver.findElement(By.xpath("//button[text()='ADD TO CART']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='ADD TO CART']")));
        button.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add Promo Code']")));
        WebElement addPromecode=driver.findElement(By.xpath("//button[text()='Add Promo Code']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add Promo Code']")));
        addPromecode.click();

        MyFunc.Wait(5);
        WebElement promeCode=driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        promeCode.sendKeys("12345678");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='Promo-Apply']")));
        WebElement apply=driver.findElement(By.xpath("//button[@class='Promo-Apply']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='Promo-Apply']")));
        apply.click();




        driver.quit();
    }
}
