package testCase;

import BaseClass.TestBase;
import Helper.PolicySearch;
import PageObject.EndToEnd;
import SonPage.ClaimInformation;
import SonPage.LoginPage;
import SonPage.PolicyDetail;
import Utility.ReadJSonData;
import org.json.simple.parser.ParseException;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class EndToEndTest extends TestBase {
    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator +"son.json";

    @Parameters("PolicyNumber")
    @Test
    public void LoginToApplication(ITestContext context, String PolicyNumber) throws IOException, ParseException, InterruptedException {
        ReadJSonData readJSonData = new ReadJSonData();
        String U_name = readJSonData.Read_the_value_from_json(path,"Username");
        String P_password = readJSonData.Read_the_value_from_json(path,"Password");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(U_name,P_password);

        PolicySearch policySearch = new PolicySearch();
        policySearch.PolicySearchTab();
        //policySearch.WaitForActive(PolicyNumber);
        policySearch.WaiForNeedsRequirement(PolicyNumber);

        EndToEnd endToEnd = new EndToEnd();
        endToEnd.AddBeneficiary();
        endToEnd.InBoxTab();
        endToEnd.View_check_list();
        endToEnd.Assign_to_me_tab();
        endToEnd.Enter_Payee();
        policySearch.PolicySearchTab();
        policySearch.CheckStatus(PolicyNumber);
        loginPage.LogoutFromApplication();
    }






}
