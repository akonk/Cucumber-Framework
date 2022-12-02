package Stepdefinition;

import PageObject.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

public class StefDefinition {

    public WebDriver driver;
    public LoginPage loginPage;

    @Given("User Launch chrome browser")
    public void user_launch_chrome_browser() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        loginPage = new LoginPage(driver);


        }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {

            driver.get(url);
          }


    @When("User Enter email id as {string} and  Password as {string}")
    public void user_enter_email_id_as_and_password_as(String emailid, String passwordid) {

        loginPage.setEmailid(emailid);
        loginPage.setPassword(passwordid);

         }

    @When("Click on Login")
    public void click_on_login() {
        loginPage.SubmitLoginBtn();

         }


    @Then("Title should be {string}")
    public void Title_should_be(String title) {

     String actualtitle = driver.getTitle();

     if (title.equals(actualtitle)){

         Assert.assertTrue(true);
     }else {
         Assert.assertTrue(false);
     }

         }

    @When("User Click on LogOut link")
    public void user_click_on_log_out_link() {

        loginPage.Logoutmethod();
        }





    @Then("Login Form Should be appeared and title Should be {string}")
    public void login_form_should_be_appeared_and_title_should_be(String Logouttitle) {
     String actualTitle = driver.getTitle();

     if (actualTitle.equals(Logouttitle)){
         Assert.assertTrue(true);
     }else {

        Assert.assertTrue(false);

     }
    }

    @Then("Close the browser")
    public void close_the_browser() {

        driver.close();
        driver.quit();

       }


}
