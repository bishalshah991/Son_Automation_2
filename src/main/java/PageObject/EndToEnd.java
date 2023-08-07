package PageObject;

import BaseClass.PageDriver;
import BaseClass.TestBase;
import Helper.JavaScriptHelper;
import Helper.PolicySearch;
import SonPage.*;
import Utility.Upload;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class EndToEnd extends TestBase {

    PolicySearch policySearch;
    PolicyDetail policyDetail;
    ClaimInformation claimInformation;
    JavaScriptHelper javaScriptHelper;
    Upload upload;
    AssignToMe assignToMe;
    public EndToEnd(){
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
        policySearch = new PolicySearch();
        policyDetail = new PolicyDetail();
        claimInformation = new ClaimInformation();
        javaScriptHelper = new JavaScriptHelper();
        upload = new Upload();
        assignToMe = new AssignToMe();
    }

    @FindBy(xpath = "//span[@class='mat-checkbox-inner-container']")
    WebElement CheckBox;


    public void Enter_Policy_Detail() throws IOException, ParseException {
        policyDetail.StartClaim();
        policyDetail.EnterDateOfDeath();
        policyDetail.EnterCauseOfDeath();
    }

    public void Enter_Claim_Information() throws IOException, ParseException {
        claimInformation.WaiForClaimInformationPage();
        claimInformation.ClaimInformationTypeDropDown();
        claimInformation.EnterTheNotifier();
        claimInformation.EnterRelationShip();
        claimInformation.EnterPhoneNumber();
        javaScriptHelper.scroll_To_Element(CheckBox);
        claimInformation.EnterEmailAddress();
        claimInformation.EnterCallNotes();
        claimInformation.ClickCheckBox();
        claimInformation.AcceptButton();
    }

    public void AddBeneficiary() throws IOException, ParseException, InterruptedException {
        AddBeneficiary addBeneficiary = new AddBeneficiary();
        addBeneficiary.BeneficiaryTab();
        addBeneficiary.EnterBusinessEntry();
        addBeneficiary.EnterFirstAndLastName();
        addBeneficiary.EnterAddress();
    }

    public void DeleteBeneficiary(){
        AddBeneficiary addBeneficiary = new AddBeneficiary();
        addBeneficiary.DeleteBeneficiaries();
    }

    public void InBoxTab() throws IOException, ParseException, InterruptedException {
        InboxTab inbox = new InboxTab();
        inbox.Inbox();
        inbox.EventLog();
        inbox.CustomerSupport();
        inbox.LockOut();
        inbox.ClaimTag();
        inbox.BackButton();
    }

    public void View_check_list() throws InterruptedException {
        ViewCheckList viewCheckList = new ViewCheckList();
        viewCheckList.View_Check_List();
        upload.UploadDocument();
        new MatchThis().Count_of_Match_this();
        new MatchThis().Click_View_Button();
    }

    public void Assign_to_me_tab() throws IOException, ParseException {
        assignToMe.Assign_to_me();
        assignToMe.Approve_tab();
        assignToMe.Payment_tab();
        assignToMe.Benefit_amount_po();
    }

    public void Enter_Payee() throws InterruptedException {
        assignToMe.Payee_tab();
        assignToMe.ApplyDiff();
        assignToMe.Click_Approve();
        assignToMe.Settled_Claim();
        assignToMe.Export_claim_packet();
    }

}
