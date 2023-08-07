package PageObject;

import BaseClass.PageDriver;
import BaseClass.TestBase;
import Helper.PolicySearch;
import SonPage.*;
import Utility.Upload;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class EndToEnd_Setup extends TestBase {

    PolicyDetail policyDetail;
    ClaimInformation claimInformation;

    public EndToEnd_Setup(){
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
        policyDetail = new PolicyDetail();
        claimInformation = new ClaimInformation();
    }

    public void Policy_Detail() throws IOException, ParseException {
        policyDetail.StartClaim();
        policyDetail.EnterDateOfDeath();
        policyDetail.EnterCauseOfDeath();
    }

    public void Claim_Information() throws IOException, ParseException {
        claimInformation.WaiForClaimInformationPage();
        claimInformation.ClaimInformationTypeDropDown();
        claimInformation.EnterTheNotifier();
        claimInformation.EnterRelationShip();
        claimInformation.EnterPhoneNumber();
        claimInformation.EnterEmailAddress();
        claimInformation.EnterCallNotes();
        claimInformation.ClickCheckBox();
        claimInformation.AcceptButton();
    }

    public void Navigate_to_Inbox() throws IOException, ParseException, InterruptedException {
        InboxTab inboxTab = new InboxTab();
        inboxTab.Inbox();
        inboxTab.EventLog();
        inboxTab.CustomerSupport();
        inboxTab.LockOut();
        inboxTab.ClaimTag();
    }

    public void Navigate_to_view_check_list() throws InterruptedException {
        ViewCheckList viewCheckList = new ViewCheckList();
        viewCheckList.View_Check_List();
    }

    public void Navigate_Add_Beneficiary() throws IOException, ParseException, InterruptedException {
        AddBeneficiary addBeneficiary = new AddBeneficiary();
        addBeneficiary.BeneficiaryTab();
        addBeneficiary.EnterBusinessEntry();
        addBeneficiary.EnterFirstAndLastName();
        addBeneficiary.EnterAddress();

    }

    public void Upload_file_document(){
        Upload upload = new Upload();
        upload.UploadDocument();
    }

    public void Navigate_to_match() throws InterruptedException {
        MatchThis matchThis = new MatchThis();
        matchThis.Count_of_Match_this();
        matchThis.Click_View_Button();
    }

    public void Navigate_assign_to_me() throws IOException, ParseException, InterruptedException {
        AssignToMe assignToMe = new AssignToMe();
        assignToMe.Assign_to_me();
        assignToMe.Approve_tab();
        assignToMe.Payment_tab();
        assignToMe.Benefit_amount_po();
        assignToMe.Payee_tab();
        assignToMe.ApplyDiff();
        assignToMe.Click_Approve();
        assignToMe.Settled_Claim();
        assignToMe.Export_claim_packet();
    }

    public void Navigate_void_setup() throws IOException, ParseException {
        AssignToMe assignToMe = new AssignToMe();
        assignToMe.Assign_to_me();
        assignToMe.Approve_tab();
        assignToMe.Void_setup();
    }






}
