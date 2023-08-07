package SonPage;

import BaseClass.PageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class BasePage {

    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator +"TestData.pdf";

    WebDriverWait wait;

    public void DocumentUpload(By bylocator){
        PageDriver.getCurrentDriver()
                .findElement(bylocator)
                .sendKeys(path);
    }

    public void type(By bylocator, String text){
        PageDriver.getCurrentDriver()
                .findElement(bylocator)
                .sendKeys(text);
    }


    public int size(By bylocator){
        return  PageDriver.getCurrentDriver()
                .findElements(bylocator)
                .size();
    }

    public String GetText(By bylocator){
        return PageDriver.getCurrentDriver()
                .findElement(bylocator)
                .getText();
    }

    public void click(By bylocator){
        PageDriver.getCurrentDriver()
                .findElement(bylocator)
                .click();
    }


    public void tab(By bylocator){
        PageDriver.getCurrentDriver()
                .findElement(bylocator)
                .sendKeys(Keys.TAB);
    }

    public void WaitForPresenceOfElement(By byLocator,int timeout){
        wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofMinutes(timeout));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byLocator));
    }
    public void WaitForVisibilityOfElement(By byLocators,int timeout){
        wait = new WebDriverWait(PageDriver.getCurrentDriver(),Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf((WebElement) byLocators));
    }
}
