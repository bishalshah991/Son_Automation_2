package SonPage;

import BaseClass.PageDriver;
import BaseClass.TestBase;
import Helper.WaitHelper;
import Utility.ReadJSonData;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class PolicyDetail extends BasePage {

    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator +"son.json";

    WebDriver driver;
    WaitHelper waitHelper;

    public PolicyDetail(){
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
        waitHelper = new WaitHelper(PageDriver.getCurrentDriver(),10);
    }

    By StartClaimTab = By.xpath("//div[contains(text(),'Start Claim')]");
    By StartClaimButton = By.xpath("//span[contains(text(),'Start Claim')]");
    By DateDeath = By.xpath("//input[@id='v_datDeath_initial']");

    /*
        Cause of Death
     */


    By NonSelected = By.xpath("//span[contains(text(),'[None Selected]')]");
    By TextNatural = By.xpath("//span[normalize-space()='Accident']");

    /*
        Claim Information
     */

    By TextPhone = By.xpath("//span[contains(text(),'Phone')]");

    public void StartClaim(){
        click(StartClaimTab);
        WaitForPresenceOfElement(StartClaimButton,10);
    }

    public void EnterDateOfDeath() throws IOException, ParseException {
        String date = new ReadJSonData().Read_the_value_from_json(path,"Date");
        type(DateDeath,date);
    }

    public void EnterCauseOfDeath(){
        click(NonSelected);
        WaitForPresenceOfElement(TextNatural,10);
        click(TextNatural);
        click(StartClaimButton);
        WaitForPresenceOfElement(NonSelected,10);
    }

    /*
        Detail of Claim Information
     */
    public void ClaimNotificationType(){
        click(NonSelected);
        WaitForPresenceOfElement(TextPhone,10);
        click(TextPhone);
    }











}
