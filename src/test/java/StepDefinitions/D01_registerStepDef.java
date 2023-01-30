package StepDefinitions;

import Pages.P01_register;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D01_registerStepDef {

    public WebDriver driver=null;
    P01_register register;
    @Given("user open browser for register")
    public void userOpenBrowser() throws InterruptedException {
        String ChromPath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", ChromPath);
        System.out.println(ChromPath);
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
        Hooks.driver=driver;
        register=new P01_register(driver);

    }
    @And("user navigates to register page")
    public void navigateToRegisterPage() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/");
        By ReginBtn=By.className("ico-register");
        WebElement RegBtnEle=driver.findElement(ReginBtn);
        RegBtnEle.click();


    }

    @When ("user enter valid data and click on register")
    public void register_ValidData() throws InterruptedException {
        System.out.println("register_ValidData");
        register.registerData('m',"Abdelrahman","Sobhy",
                "18","2","2000","abdosobhy18220@gmail.com","123456","123456");
    }

    @Then("user could register successfully")
    public void validateRegistration(){

        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/registerresult/1?returnUrl=/");
        String expectedResult= "Your registration completed";
        String actualResult=driver.findElement(By.className("result")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }






}
