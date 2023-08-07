package SonPage;

import BaseClass.PageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ViewCheckList extends BasePage{
    WebDriver driver;
    public ViewCheckList(){
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
    }

    By view_check_list = By.xpath("//div[normalize-space()='VIEW CHECKLIST']");
    By Beneficiary = By.xpath("//div[normalize-space()='BENEFICIARIES']");


    public void View_Check_List() throws InterruptedException {
        WaitForPresenceOfElement(view_check_list,10);
        click(view_check_list);
        WaitForPresenceOfElement(new InboxTab().Inbox,10);
        WaitForPresenceOfElement(Beneficiary,10);
        WaitForPresenceOfElement(new InboxTab().EventLog,10);
        WaitForPresenceOfElement(new InboxTab().Customer_support,10);
        Thread.sleep(5000);
    }
}
