package StepDefinitions;

import Pages.P02_login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {


        public static   WebDriver driver=null;
        P02_login login;


        SoftAssert softAssert =new SoftAssert() ;

        @Given("user open browser")
        public void userOpenBrowser() throws InterruptedException {
            String ChromPath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", ChromPath);
            System.out.println(ChromPath);
            driver= new ChromeDriver();
            driver.manage().window().maximize();
            Thread.sleep(3000);
            Hooks.driver=driver;
            login =new P02_login(driver);

        }
        @And("user navigates to login page")
        public void navigateToLoginPage(){

            driver.navigate().to("https://demo.nopcommerce.com/");
            By LoginBtn=By.className("ico-login");
            WebElement LoginBtnEle=driver.findElement(LoginBtn);
            LoginBtnEle.click();
        }

        @When("^user enter \"(.*)\" and \"(.*)\" then click on login button$")
        public void loginWithValidUsernameAndPassword(String userName, String pass) throws InterruptedException {
        login.loginFun(userName, pass);

        }

        @Then("user could login successfully to the home page")
        public void successLogin_goToHomePage(){
            softAssert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"));
        }


        @Then("user could not login to the system")
        public void user_cannot_login_successfully_to_the_home_page() {
            String Expected = "Login was unsuccessful. Please correct the errors and try again.";
            WebElement Message = driver.findElement(By.className("message-error"));
            String Actual = Message.getText();
            ////////////////
            String s = Message.getCssValue("color");
            String c = Color.fromString(s).asHex();
            System.out.println("color : " + c);
            softAssert.assertTrue(c.contains("#e4434b"));
            softAssert.assertTrue(Actual.contains(Expected));
            softAssert.assertAll();
        }

        @When ("user click on forgot password")
        public void clickForgotPassword(){
            driver.findElement(By.className("forgot-password")).click();
        }
        @And ("user redirected to reset page")
        public void redirectToResetPage(){
            Assert.assertEquals(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/passwordrecovery"),true);
        }
        @And ("user enter his valid mail then click recover button")
        public void enterValidMail(){
            login.resetPassword("abdosobhy18220@gmail.com");
            driver.findElement(By.name("send-email")).click();
        }
        @Then ("reset mail should be sent to user")
        public void validateReset(){

            Assert.assertTrue(driver.findElement(By.id("bar-notification")).isDisplayed());
            Assert.assertEquals(driver.findElement(By.className("content")).getText().contains("Email with instructions has been sent to you."),true);
        }


}
