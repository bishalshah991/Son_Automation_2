package SonPage;

import BaseClass.PageDriver;
import Utility.RandomNames;
import Utility.ReadJSonData;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class AddBeneficiary extends BasePage{
    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator +"son.json";
    WebDriver driver;
    public AddBeneficiary(){
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
    }

    By AddIcon = By.cssSelector("button[aria-label='Add bene/payee']");
    By SaveRecordButton = By.cssSelector("button[class='mat-focus-indicator save-button mat-button mat-button-base ng-star-inserted']");

    By BusinessEntry = By.xpath("//input[@id='BusinessEntity']");

    By FirstName = By.xpath("//input[@id='FirstName']");

    By LastName = By.xpath("//input[@id='LastName']");

    By Address = By.xpath("//input[@id='AddressLine1']");

    By PostalCode = By.xpath("//input[@id='PostalCode']");

    By City = By.xpath("//input[@id='City']");
    By State = By.xpath("//input[@id='State']");

    By Row = By.xpath("mat-row[role='row']");
    By DeleteIcon = By.xpath("//mat-icon[normalize-space()='remove_circle_outline']");

    By AlertMessage = By.xpath("//h2[normalize-space()='Are you sure you want to delete this record?']");
    By OK_Button = By.xpath("//span[normalize-space()='OK']");

    By CancelIcon = By.xpath("//*[@id='forms']/mat-toolbar/button/span[1]/mat-icon");


    public void BeneficiaryTab(){
        click(new ClaimInformation().Beneficiary);
        WaitForPresenceOfElement(AddIcon,10);
        click(AddIcon);
        WaitForPresenceOfElement(SaveRecordButton,10);
    }
    public void EnterBusinessEntry() throws IOException, ParseException {
        type(BusinessEntry,new ReadJSonData().Read_the_value_from_json(path,"BusinessEntry"));
    }

    public void EnterFirstAndLastName(){
        type(FirstName, new RandomNames().GenerateFirstName());
        type(LastName,new RandomNames().GenerateLastName());
    }

    public void EnterAddress() throws IOException, ParseException, InterruptedException {
        type(Address, new ReadJSonData().Read_the_value_from_json(path,"Address"));
        type(City, new ReadJSonData().Read_the_value_from_json(path,"City"));
        type(State, new ReadJSonData().Read_the_value_from_json(path,"State"));
        type(PostalCode,new ReadJSonData().Read_the_value_from_json(path,"PostCode"));
        click(SaveRecordButton);
        Thread.sleep(6000);
        click(CancelIcon);
    }

    public void DeleteBeneficiaries(){
        click(new ClaimInformation().Beneficiary);
        WaitForPresenceOfElement(DeleteIcon,10);
        click(DeleteIcon);
        WaitForPresenceOfElement(AlertMessage,10);
        click(OK_Button);
        WaitForPresenceOfElement(AddIcon,10);
        click(CancelIcon);
    }
}
