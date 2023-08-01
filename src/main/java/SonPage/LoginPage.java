package SonPage;

import BaseClass.TestBase;
import Helper.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    WaitHelper waitHelper;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper = new WaitHelper(driver,10);
    }

    @FindBy(xpath = "//h1[contains(text(),'LOGIN TO YOUR ACCOUNT')]")
    public WebElement TextLoginPage;
    @FindBy(xpath = "//input[@placeholder='Email']")
    public WebElement UsernameXpath;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement PasswordXpath;

    @FindBy(xpath = "//span[normalize-space()='LOGIN']")
    public WebElement LoginButton;

    @FindBy(xpath = "//div[@class='advanced-pie chart']")
    WebElement PaymentOverview;

    @FindBy(css = "div[id='dashboard-analytics']>div[class='content ng-tns-c512-6']")
    public WebElement ClaimActivity;

    @FindBy(xpath = "//mat-icon[contains(text(),'keyboard_arrow_down')]")
    public WebElement LogoutArrow;
    @FindBy(xpath = "//span[contains(text(),'Sign Out')]")
    public WebElement Sign_out_text;


    public void Login(String username,String password){
        UsernameXpath.sendKeys(username);
        PasswordXpath.sendKeys(password);
        LoginButton.click();
        waitHelper.WaitForElement(PaymentOverview);
    }
    public void LogoutFromApplication(){
        LogoutArrow.click();
        waitHelper.WaitForElement(Sign_out_text);
        Sign_out_text.click();
        waitHelper.WaitForElement(TextLoginPage);
    }

}
