package SonPage;

import BaseClass.PageDriver;
import Utility.ReadJSonData;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class InboxTab extends BasePage{

    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator +"son.json";
    WebDriver driver;
    public InboxTab(){
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
    }

    public By Inbox = By.xpath("//div[normalize-space()='INBOX']");
    By TextInbox = By.xpath("//span[contains(text(),' YOU HAVE NO INBOX MAIL FOR THIS CLAIM ')]");

    public By EventLog = By.xpath("//div[normalize-space()='EVENT LOGS']");
    By Log = By.xpath("//th[normalize-space()='Log']");

    public By BackButton = By.xpath("//div[normalize-space()='BACK']");

    /*
        Customer Support
     */
    public By Customer_support = By.xpath("//div[normalize-space()='CUSTOMER SUPPORT']");
    By CustomerMessage = By.xpath("//textarea[@placeholder='Type your message']");
    By Send = By.xpath("//mat-icon[normalize-space()='send']");

    By CustomerImage =By.xpath("//img[@class='avatar ng-star-inserted']");

    /*
        Claim Tag
     */

    By ClaimTag = By.xpath("//div[normalize-space()='CLAIM TAG']");
    By ConfirmButton = By.xpath("//span[normalize-space()='CONFIRM']");

    By UserTag = By.xpath("//input[@placeholder='Select User Tags']");

    By TextMyClaim = By.xpath("//span[contains(text(),'My Claims ')]");

    By TagReason = By.xpath("//textarea[@id='ClaimTagReason']");

    /*
        Lock out
     */

    By LockOut = By.xpath("//div[normalize-space()='LOCK OUT']");
    By TextLockOut = By.xpath("//a[normalize-space()='Click here to release lock']");

    /*
        Needs Requirement
     */

    public By TextClaimDetail = By.xpath("//span[normalize-space()='Claim Detail']");
    public By TextProductDetail =By.xpath("(//span[normalize-space()='Product Detail'])[1]");

    /*
        Update Button
     */

    By UpdateButton = By.xpath("//span[contains(text(),'UPDATE')]");
    @FindBy(xpath = "//span[contains(text(),'UPDATE')]")
    WebElement T_UpdateButton;

    @FindBy(xpath = "//span[normalize-space()='CONFIRM']")
    WebElement T_ConfirmButton;



    public void Inbox(){
        click(Inbox);
        WaitForPresenceOfElement(TextInbox,10);
        WaitForPresenceOfElement(EventLog,10);
    }

    public void EventLog(){
        click(EventLog);
        WaitForPresenceOfElement(Log,10);
        click(BackButton);
        WaitForPresenceOfElement(TextInbox,10);
    }

    public void CustomerSupport() throws IOException, ParseException {
        click(Customer_support);
        WaitForPresenceOfElement(CustomerMessage,10);
        type(CustomerMessage,new ReadJSonData().Read_the_value_from_json(path,"CallNote"));
        click(Send);
        WaitForPresenceOfElement(CustomerImage,10);
        click(BackButton);
        WaitForPresenceOfElement(TextInbox,10);
    }

    public void LockOut(){
        click(LockOut);
        WaitForPresenceOfElement(TextLockOut,10);
        click(TextLockOut);
        WaitForPresenceOfElement(TextInbox,10);
    }

    public void ClaimTag() throws IOException, ParseException, InterruptedException {
        click(ClaimTag);
        Thread.sleep(5000);

        boolean isPresent = true;

        try {
            isPresent = T_ConfirmButton.isDisplayed();
            click(UserTag);
            WaitForPresenceOfElement(TextMyClaim,10);
            click(TextMyClaim);
            type(TagReason,new ReadJSonData().Read_the_value_from_json(path,"CallNote"));
            click(ConfirmButton);
        }
        catch (Exception ex){
            System.out.println("Element is not Found:"+ex);
            click(UserTag);
            WaitForPresenceOfElement(TextMyClaim,10);
            click(TextMyClaim);
            type(TagReason,new ReadJSonData().Read_the_value_from_json(path,"CallNote"));
            click(UpdateButton);
        }
    }

    public void BackButton(){
        click(BackButton);
        WaitForPresenceOfElement(TextClaimDetail,10);
        WaitForPresenceOfElement(TextProductDetail,10);
    }


}
