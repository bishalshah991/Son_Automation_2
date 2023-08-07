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

public class AssignToMe extends BasePage{
    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator +"son.json";
    WebDriver driver;

    public AssignToMe(){
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
    }

    By AssignToMeTab = By.xpath("//div[contains(text(),'ASSIGN TO ME ')]");

    By ConfirmButton = By.xpath("//span[contains(text(),'CONFIRM')]");

    By ApproveTab = By.xpath("//div[contains(text(),'APPROVE')]");
    By DenyTab = By.xpath("//div[contains(text(),'DENY')]");

    By StatusOverride = By.xpath("//div[contains(text(),' STATUS OVERRIDE')]");

    /*
        Payment Tab
     */

    By payment_tab = By.xpath("//div[contains(text(),'PAYMENT')]");

    By text_Payment_Details = By.xpath("//div[contains(text(),'Payment Details')]");

    By text_Benefit_amount = By.xpath("//div[contains(text(),'Benefit Amount')]");

    /*
        Benefit Amount
     */

    By Po = By.xpath("//a[normalize-space()='PO+']");

    By SubmitButton = By.xpath("//span[contains(text(),'SUBMIT')]");

    By OverrideAmount = By.xpath("//input[@data-placeholder='Override Amount (Negative Number Allowed)']");

    By Reason = By.xpath("//input[@data-placeholder='Reason']");

    /*
        Payee
     */

    @FindBy(xpath = "//div[normalize-space()='PAYEES']")
    WebElement T1_Payees;
    By PayeeTab = By.xpath("//div[normalize-space()='PAYEES']");
    By Done = By.xpath("//mat-icon[normalize-space()='done']");

    /*
        Apply Diff
     */

    @FindBy(xpath = "//span[normalize-space()='Apply Diff']")
    WebElement T1_apply_diff;
    By applyDiff = By.xpath("//span[normalize-space()='Apply Diff']");

    /*
        Payment
     */

    By paymentTab = By.xpath("//div[contains(text(),'PAYMENT')]");

    By settledClaim = By.xpath("//div[contains(text(),'SETTLE CLAIM')]");

    /*
        Export Claim Packet
     */

    By exportClaim = By.xpath("//div[contains(text(),'EXPORT CLAIM PACKET')]");

    By selectAll = By.xpath("//div[normalize-space()='Select All']");

    By ok = By.xpath("//span[normalize-space()='OK']");

    By ExportMultiplePackets = By.xpath("//span[normalize-space()='Export Multiple Packets']");

    By Void = By.xpath("//div[contains(text(),'VOID')] ");
    By VoidReason = By.xpath("//textarea[@id='reason']");

    public void Assign_to_me(){
        click(AssignToMeTab);
        WaitForPresenceOfElement(ConfirmButton,10);
        click(ConfirmButton);
        WaitForPresenceOfElement(ApproveTab,10);
        WaitForPresenceOfElement(DenyTab,10);
        WaitForPresenceOfElement(StatusOverride,10);
    }

    public void Approve_tab(){
        click(ApproveTab);
        WaitForPresenceOfElement(new InboxTab().TextClaimDetail,10);
        WaitForPresenceOfElement(new InboxTab().TextProductDetail,10);
        WaitForPresenceOfElement(new InboxTab().BackButton,10);
        WaitForPresenceOfElement(new InboxTab().EventLog,10);
    }

    public void Payment_tab(){
        click(payment_tab);
        WaitForPresenceOfElement(text_Payment_Details,10);
        WaitForPresenceOfElement(text_Benefit_amount,10);
    }

    public void Benefit_amount_po() throws IOException, ParseException {
        click(Po);
        WaitForPresenceOfElement(SubmitButton,10);
        type(OverrideAmount,new ReadJSonData().Read_the_value_from_json(path,"Override"));
        type(Reason,new ReadJSonData().Read_the_value_from_json(path,"Reason"));
        click(SubmitButton);
    }

    public void Payee_tab() throws InterruptedException {
        click(PayeeTab);
        Thread.sleep(5000);
        click(Done);
        WaitForPresenceOfElement(Po,10);
        Thread.sleep(7000);

    }

    public void ApplyDiff(){
        boolean isPresent = true;

        try {
            isPresent = T1_apply_diff.isDisplayed();
            click(applyDiff);
        }
        catch (Exception e){
            System.out.println("Element is not found"+e);
        }
    }

    public void Click_Approve(){
        click(ApproveTab);
        WaitForPresenceOfElement(new InboxTab().TextProductDetail,10);
        WaitForPresenceOfElement(new InboxTab().TextClaimDetail,10);
        WaitForPresenceOfElement(new InboxTab().Inbox,10);
    }

    public void Void_setup() throws IOException, ParseException {
        click(Void);
        WaitForPresenceOfElement(ConfirmButton,10);
        type(VoidReason,new ReadJSonData().Read_the_value_from_json(path,"Reason"));
        click(ConfirmButton);
        WaitForPresenceOfElement(new InboxTab().Inbox,10);
    }

    public void Settled_Claim() throws InterruptedException {
        click(paymentTab);
        WaitForPresenceOfElement(settledClaim,10);
        click(settledClaim);
        WaitForPresenceOfElement(ConfirmButton,10);
        click(ConfirmButton);
        Thread.sleep(7000);
        WaitForPresenceOfElement(exportClaim,10);
        WaitForPresenceOfElement(new InboxTab().Inbox,10);
    }

    public void Export_claim_packet() throws InterruptedException {
        click(exportClaim);
        Thread.sleep(5000);
        click(selectAll);
        click(ok);
        Thread.sleep(5000);
        click(ExportMultiplePackets);
        WaitForPresenceOfElement(new InboxTab().TextClaimDetail,10);
        WaitForPresenceOfElement(new InboxTab().TextProductDetail,10);
    }



}
