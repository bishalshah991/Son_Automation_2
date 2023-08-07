package SonPage;

import BaseClass.PageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MatchThis extends BasePage{
    WebDriver driver;

    public MatchThis(){
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
    }

    By MatchThis = By.xpath("//span[normalize-space()='Match This']");

    By SaveButton = By.xpath("//span[contains(text(),'Save')]");

    By ViewPage = By.xpath("(//span[contains(text(),'VIEW')])[1]");

    By ChooseButton = By.xpath("//span[normalize-space()='CHOOSE FILE']");

    By Body = By.xpath("//div[@aria-label='Page 1']//canvas");
    By ViewCloseIcon = By.xpath("//button[@aria-label='Close dialog']//mat-icon[@role='img'][normalize-space()='close']");


    public void Count_of_Match_this() throws InterruptedException {
        int count = size(MatchThis);
        System.out.println(count);
        for (int i = 1; i <= count; i++){
            driver.findElement(By.xpath("//div[@fxlayoutalign='center']/div["+i+"]/div/div[3]/button")).click();
        }
        click(SaveButton);
        Thread.sleep(5000);
        WaitForPresenceOfElement(ViewPage,10);
        WaitForPresenceOfElement(ChooseButton,10);
        WaitForPresenceOfElement(new InboxTab().Inbox,10);
        WaitForPresenceOfElement(new ClaimInformation().Beneficiary,10);
    }

    public void Click_View_Button() throws InterruptedException {
        click(ViewPage);
        Thread.sleep(15000);
        click(ViewCloseIcon);
        WaitForPresenceOfElement(ViewPage,10);
    }


}
