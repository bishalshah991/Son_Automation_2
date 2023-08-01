package Helper;

import BaseClass.TestBase;
import Utility.ReadJSonData;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class PolicySearch extends TestBase {
    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator +"son.json";

    WaitHelper waitHelper;
    ReadJSonData readJSonData;
    public PolicySearch(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        readJSonData = new ReadJSonData();
        waitHelper = new WaitHelper(driver,10);
    }


    @FindBy(xpath = "//span[contains(text(),'Policy Search')]")
    WebElement Policy_search_Tab;
    @FindBy(xpath = "//input[@placeholder='Type keywords and Press Enter....']")
    WebElement Type_Key_Enter;

    @FindBy(xpath = "//input[@id='searchInput']")
    WebElement Policy_search_Text_Box;

    @FindBy(xpath = "//div[contains(text(),'Active')]")
    public WebElement Active;

    @FindBy(xpath = "//mat-table[starts-with(@class,'mat-table cdk-table mat-sort ng-tns')]/mat-row/mat-cell[12]/div/button/span[1]/mat-icon")
    public WebElement Action_Three_Dots;

    @FindBy(xpath = "//span[contains(text(),'Begin Claim')]")
    public WebElement Begin_Claim;

    @FindBy(xpath = "//div[contains(text(),'Start Claim')]")
    WebElement StartClaim;


    public void SearchPolicy(String policy_number) throws IOException, ParseException {
        Policy_search_Tab.click();
        waitHelper.WaitForElement(Type_Key_Enter);
        Policy_search_Text_Box.sendKeys(policy_number);
        waitHelper.WaitForElement(Active);
    }

    public void PolicyDetail(){
        Action_Three_Dots.click();
        waitHelper.WaitForElement(Begin_Claim);
        Begin_Claim.click();
        waitHelper.WaitForElement(StartClaim);
    }
}
