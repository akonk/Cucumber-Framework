package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Keys;


public class LoginPage {
   public static WebDriver driver;

    public LoginPage(WebDriver driver){

        LoginPage.driver = driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(id="Email")
    WebElement emailid;

    @FindBy(id="Password")
    WebElement passwordid;

    @FindBy(xpath ="//button[@type='submit']")
    WebElement Submitbtn;

    @FindBy(linkText ="Logout")
    WebElement logoutbtn;

    public void setEmailid(String email){

       emailid.clear();
        emailid.sendKeys(email);
    }
    public void setPassword(String password){
        passwordid.clear();
        passwordid.sendKeys(password);
    }


    public void SubmitLoginBtn(){

        Submitbtn.click();
    }

    public void Logoutmethod(){

        logoutbtn.click();
    }

}
