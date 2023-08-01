package Helper;

import BaseClass.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper extends TestBase {
    WebDriverWait webDriverWait;

    public WaitHelper(WebDriver driver, int timeout){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        webDriverWait = new WebDriverWait(driver, Duration.ofMinutes(timeout));
    }

    public void WaitForElement(WebElement element){
        webDriverWait.until(ExpectedConditions.visibilityOf(element));

        boolean status=element.isDisplayed();
        if (status){
            System.out.println("Element is Displayed:-"+element.getText());
        }
        else {
            System.out.println("Element is not displayed: "+element.getText());
        }

    }
}
