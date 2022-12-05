package Stepdefinition;

import  BaseTest.Baseclass;
import PageObject.AddCustomer;
import PageObject.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class StefDefinition {

public WebDriver driver;
public LoginPage loginPage;
public AddCustomer addNewCustPg;
    @Given("User Launch chrome browser")
    public void user_launch_chrome_browser() {


        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        addNewCustPg = new AddCustomer(driver);



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

   /* @Then("Close the browser")
    public void close_the_browser() {

        driver.close();
        driver.quit();

       }
*/



    ///////////////////////////Add new customer/////////////////////


    @Then("User can view Dashboad")
    public void user_can_view_dashboad() {
        String actualTitle = addNewCustPg.getPageTitle();
        String expectedTitle = "Dashboard / nopCommerce administration";

        if(actualTitle.equals(expectedTitle))
        {
           // log.info("user can view dashboard test passed.");
            Assert.assertTrue(true);

        }
        else
        {
            Assert.assertTrue(false);
            //log.warn("user can view dashboard test failed.");

        }
    }

    @When("User click on customers Menu")
    public void user_click_on_customers_menu() {
        addNewCustPg.clickOnCustomersMenu();
        //log.info("customer menu clicked");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @When("click on customers Menu Item")
    public void click_on_customers_menu_item() {
        addNewCustPg.clickOnCustomersMenuItem();
       // log.info("customer menu item clicked");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @When("click on Add new button")
    public void click_on_add_new_button() {
        addNewCustPg.clickOnAddnew();
        //log.info("clicked on add new button.");

    }

    @Then("User can view Add new customer page")
    public void user_can_view_add_new_customer_page() {
        String actualTitle = addNewCustPg.getPageTitle();
        String expectedTitle = "Add a new customer / nopCommerce administration";

        if(actualTitle.equals(expectedTitle))
        {
          //  log.info("User can view Add new customer page- passed");

            Assert.assertTrue(true);//pass
        }
        else
        {
            //log.info("User can view Add new customer page- failed");

            Assert.assertTrue(false);//fail
        }
    }

    @When("User enter customer info")
    public void user_enter_customer_info() {
        addNewCustPg.enterEmail("ABC@gmail.com");
      
        addNewCustPg.enterPassword("test1");
        addNewCustPg.enterFirstName("Rahul");
        addNewCustPg.enterLastName("Roy");
        addNewCustPg.enterGender("Male");
        addNewCustPg.enterDob("6/13/1988");
        addNewCustPg.enterCompanyName("Microsoft");
        addNewCustPg.enterAdminContent("Software Developer");
        addNewCustPg.enterManagerOfVendor("Vendor 2");

       // log.info("customer information entered");


    }

    @When("click on Save button")
    public void click_on_save_button() {
        addNewCustPg.clickOnSave();
       // log.info("clicked on save button");

    }

    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String exptectedConfirmationMsg) {

        String bodyTagText = driver.findElement(By.tagName("Body")).getText();
        if(bodyTagText.contains(exptectedConfirmationMsg))
        {
            Assert.assertTrue(true);//pass
            //log.info("User can view confirmation message - passed");

        }
        else
        {
           // log.warn("User can view confirmation message - failed");

            Assert.assertTrue(false);//fail

        }

    }


}
