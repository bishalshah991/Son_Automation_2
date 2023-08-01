package SonPage;

import BaseClass.PageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriverWait wait;

    public void type(By bylocator, String text){
        PageDriver.getCurrentDriver()
                .findElement(bylocator)
                .sendKeys(text);
    }

    public void click(By bylocator){
        PageDriver.getCurrentDriver()
                .findElement(bylocator)
                .click();
    }

    public void WaitForPresenceOfElement(By byLocator,int timeout){
        wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byLocator));
    }
    public void WaitForVisibilityOfElement(By byLocators,int timeout){
        wait = new WebDriverWait(PageDriver.getCurrentDriver(),Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf((WebElement) byLocators));
    }
}
