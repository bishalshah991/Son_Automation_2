package testCase;

import BaseClass.TestBase;
import Helper.PolicySearch;
import PageObject.EndToEnd_Setup;
import SonPage.LoginPage;
import Utility.ReadJSonData;
import org.json.simple.parser.ParseException;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class End_to_Setup_Void_Test extends TestBase {

    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator +"son.json";

    @Parameters("PolicyNumber1")
    @Test
    public void Verify_the_functionality_void(ITestContext context, String PolicyNumber1) throws IOException, ParseException, InterruptedException {
        ReadJSonData readJSonData = new ReadJSonData();
        String U_name = readJSonData.Read_the_value_from_json(path,"Username");
        String P_password = readJSonData.Read_the_value_from_json(path,"Password");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(U_name,P_password);

        PolicySearch policySearch = new PolicySearch();
        policySearch.PolicySearchTab();
        policySearch.WaitForActive(PolicyNumber1);

        EndToEnd_Setup endToEndSetup = new EndToEnd_Setup();
        endToEndSetup.Policy_Detail();
        endToEndSetup.Claim_Information();
        endToEndSetup.Navigate_Add_Beneficiary();
        endToEndSetup.Navigate_to_Inbox();
        endToEndSetup.Navigate_to_view_check_list();
        endToEndSetup.Upload_file_document();
        endToEndSetup.Navigate_to_match();
        endToEndSetup.Navigate_void_setup();
        policySearch.PolicySearchTab();
        policySearch.CheckVoidStatus(PolicyNumber1);
        policySearch.Dashboard();
        loginPage.LogoutFromApplication();
    }
}
