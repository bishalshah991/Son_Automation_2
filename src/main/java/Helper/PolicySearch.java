package Helper;

import BaseClass.PageDriver;
import BaseClass.TestBase;
import SonPage.BasePage;
import SonPage.ClaimInformation;
import SonPage.LoginPage;
import Utility.AssertionHelper;
import Utility.ReadJSonData;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class PolicySearch extends BasePage {
    WebDriver driver;
    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator +"son.json";

    public PolicySearch(){
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
    }

    By PolicySearchTab = By.xpath("//span[contains(text(),'Policy Search')]");
    By TabKeyEnter = By.xpath("//input[@placeholder='Type keywords and Press Enter....']");

    By PolicySearchTextBox =By.xpath("//input[@id='searchInput']");

    By ThreeDots = By.xpath("//mat-table[starts-with(@class,'mat-table cdk-table mat-sort ng-tns')]/mat-row/mat-cell[12]/div/button/span[1]/mat-icon");

    By Active = By.xpath("//div[contains(text(),'Active')]");
    By NeedsRequirement =By.xpath("//div[contains(text(),'Needs Requirement')]");

    By BeginClaim = By.xpath("//span[contains(text(),'Begin Claim')]");

    By ViewDetail = By.xpath("//span[normalize-space()='View Details']");

    /*
        Wait For a Page
     */

    By WaitPage = By.xpath("//div[contains(text(),'Start Claim')]");

    By Inbox = By.xpath("//div[normalize-space()='INBOX']");
    By ClaimDetail = By.xpath("//span[normalize-space()='Claim Detail']");


    /*
        Settled
     */

    @FindBy(xpath = "//div[contains(text(),'Settled')]")
    WebElement Settled;

    @FindBy(xpath = "//div[contains(text(),'Void')]")
    WebElement Void;



    By T1_steeled = By.xpath("//div[contains(text(),'Settled')]");
    By T1_Void = By.xpath("//div[contains(text(),'Void')]");

    /*
        Dashboard
     */

    By Dasboard = By.xpath("//span[normalize-space()='Dashboard']");



    public  void PolicySearchTab(){
        click(PolicySearchTab);
        WaitForPresenceOfElement(TabKeyEnter,10);
    }

    public void WaitForActive(String policy_number){
        type(PolicySearchTextBox,policy_number);
        WaitForPresenceOfElement(Active,10);
        click(ThreeDots);
        WaitForPresenceOfElement(BeginClaim,10);
        click(BeginClaim);
        WaitForPresenceOfElement(WaitPage,10);
    }

    public void WaiForNeedsRequirement(String policy_number){
        type(PolicySearchTextBox,policy_number);
        WaitForPresenceOfElement(NeedsRequirement,10);
        click(ThreeDots);
        WaitForPresenceOfElement(ViewDetail,10);
        click(ViewDetail);
        WaitForPresenceOfElement(Inbox,10);
        WaitForPresenceOfElement(new ClaimInformation().Beneficiary,10);
        WaitForPresenceOfElement(ClaimDetail,10);
    }

    public void WaitForSettled(String policy_number){
        type(PolicySearchTextBox,policy_number);
        WaitForPresenceOfElement(T1_steeled,10);
    }

    public void CheckStatus(String policy_number) {
        type(PolicySearchTextBox,policy_number);
        WaitForPresenceOfElement(T1_steeled,10);
        String exp = "Settled";

        WaitForPresenceOfElement(T1_steeled,10);
        AssertionHelper.verifyTextEquals(Settled,exp);
    }

    public void CheckVoidStatus(String policy_number) {
        type(PolicySearchTextBox,policy_number);
        WaitForPresenceOfElement(T1_Void,10);
        String exp = "Void";
        AssertionHelper.verifyTextEquals(Void,exp);
    }
    public void Dashboard(){
        click(Dasboard);
        new WaitHelper(driver,10).WaitForElement(new LoginPage(driver).PaymentOverview);

    }





}
