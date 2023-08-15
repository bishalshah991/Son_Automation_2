package Utility;

import Helper.WaitHelper;
import SonPage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssertionHelper extends BasePage {
    static WebDriver driver;

    public static synchronized boolean verifyElementPresent(WebElement element1,WebElement element2,WebElement element3) {
        boolean isDispalyed = true;
        try {
            isDispalyed= element1.isDisplayed();
            System.out.println(element1.getText()+"is displayed");
            element1.click();
            new WaitHelper(driver,10).WaitForElement(element2);
        }
        catch(Exception ex) {
            System.out.println("Element is not Found:"+ex);
        }

        return isDispalyed;
    }

    public static synchronized boolean verifyTextEquals( WebElement element,String expectedText) {
        boolean flag = false;
        try {
            String actualText=element.getText();
            if(actualText.equals(expectedText)) {
                System.out.println("Actual Text is :" + actualText + "Expected Text is : "+expectedText);
                return flag=true;
            }
            else {
                System.out.println("Actual Text is :"+actualText+ "Expected Text is : "+expectedText);
                return flag;
            }
        }
        catch(Exception ex) {
            System.out.println("Actual Text is :"+element.getText()+" Expected Text is : "+expectedText);
            System.out.println("Text is not Matching"+ex);
            return false;
        }
    }

}
