package SonPage;

import BaseClass.PageDriver;
import Helper.WaitHelper;
import Utility.ReadJSonData;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class ClaimInformation extends BasePage {

    WebDriver driver;
    WaitHelper waitHelper;
    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator +"son.json";

    public ClaimInformation(){
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
        waitHelper = new WaitHelper(driver,10);
    }

    /*
        Wait For Element
     */

    By TextClaimInformation = By.xpath("(//div[contains(text(),'Claim Information')])[1]");
    By TextClaim = By.xpath("//mat-label[contains(text(),'Claim Notification Type')]");


    /*
        Drop Down Value
     */
    By NotSelected = By.xpath("//span[contains(text(),'None Selected]')]");
    By Phone = By.xpath("//span[contains(text(),'Phone')]");

    By Notifier = By.xpath("//input[@id='notifier']");

    By Relationship = By.xpath("//input[@id='relationship_to_the_decedent']");

    By PhoneInput = By.xpath("//input[@id='phone']");

    By Email = By.xpath("//input[@id='e_mail_address']");

    By CallNote = By.xpath("//input[@id='call_notes']");

    By CheckBox = By.xpath("//span[@class='mat-checkbox-inner-container']");

    By AcceptButton = By.xpath("//span[normalize-space()='ACCEPT']");

    By SubmitClaimButton = By.xpath("//span[normalize-space()='SUBMIT CLAIM']");

    /*
           Needs Requirement Header
     */
    By InboxTab = By.xpath(" //div[normalize-space()='INBOX']");
    public By Beneficiary = By.xpath("//div[normalize-space()='BENEFICIARIES']");

    By EventLog = By.xpath("//div[normalize-space()='EVENT LOGS']");

    public void WaiForClaimInformationPage(){
        WaitForPresenceOfElement(TextClaimInformation,10);
        WaitForPresenceOfElement(TextClaim,10);
    }

    public void ClaimInformationTypeDropDown(){
        click(NotSelected);
        WaitForPresenceOfElement(Phone,10);
        click(Phone);
    }

    public void EnterTheNotifier() throws IOException, ParseException {
        type(Notifier,new ReadJSonData().Read_the_value_from_json(path,"Notifier"));
    }

    public void EnterRelationShip() throws IOException, ParseException {
        type(Relationship,new ReadJSonData().Read_the_value_from_json(path,"Relationship"));
    }

    public void EnterPhoneNumber() throws IOException, ParseException {
        type(PhoneInput,new ReadJSonData().Read_the_value_from_json(path,"Phone"));
    }

    public void EnterEmailAddress() throws IOException, ParseException {
        type(Email,new ReadJSonData().Read_the_value_from_json(path,"Username"));
        tab(Email);
    }

    public void EnterCallNotes() throws IOException, ParseException {
        type(CallNote,new ReadJSonData().Read_the_value_from_json(path,"CallNote"));
    }

    public void ClickCheckBox(){
        click(CheckBox);
    }
    public void AcceptButton(){
        click(AcceptButton);
        WaitForPresenceOfElement(SubmitClaimButton,10);
        click(SubmitClaimButton);
        WaitForPresenceOfElement(InboxTab,10);
        WaitForPresenceOfElement(Beneficiary,10);
        WaitForPresenceOfElement(EventLog,10);
    }






}
