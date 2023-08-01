package testCase;

import BaseClass.TestBase;
import SonPage.LoginPage;
import Utility.ReadJSonData;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class LoginPageTest extends TestBase {
    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator +"son.json";

    @Test
    public void LoginToApplication() throws IOException, ParseException {
        ReadJSonData readJSonData = new ReadJSonData();
        String U_name = readJSonData.Read_the_value_from_json(path,"Username");
        String P_password = readJSonData.Read_the_value_from_json(path,"Password");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(U_name,P_password);
        loginPage.LogoutFromApplication();
    }






}
