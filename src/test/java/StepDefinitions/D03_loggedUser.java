package StepDefinitions;

import Pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D03_loggedUser {
    public static WebDriver driver=null;
    P03_loggedUser loggedUser;
    searchPage search;
    P02_login login;
    selectTagPage tag;
    selectCategoryPage category;
    makeOrderPage makeOrder;
    @Given("user open the browser")
    public void userOpenBrowser() throws InterruptedException {
        String chromePath= System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("webdriver.chrome.driver",chromePath); //input1: yfhm elcode enu hyt3aml m3 chromeDriver,input2: path of chromeDriver

        //2 New object of webDriver
        driver= new ChromeDriver(); //as mouse and keyboard of automation
        driver.manage().window().maximize(); //maximize screen when it open
        Thread.sleep(3000);
        login=new P02_login(driver);
        search=new searchPage(driver);
        loggedUser= new P03_loggedUser(driver);
        tag=new selectTagPage(driver);
        category=new selectCategoryPage(driver);
        makeOrder=new makeOrderPage(driver);

        addProduct.driver=driver;
        addProduct.loggedUser=loggedUser;

        selectTag.driver=driver;
        selectTag.myTag=tag;

        selectCategory.driver=driver;
        selectCategory.myCategory=category;

        Hooks.driver=driver;
        makeOrderSD.driver=driver;
        makeOrderSD.makeOrder=makeOrder;

    }

    @And("user navigates to the login page")
    public void navigateToLoginPage(){

        driver.navigate().to("https://demo.nopcommerce.com/");
        By LoginBtn=By.className("ico-login");
        WebElement LoginBtnEle=driver.findElement(LoginBtn);
        LoginBtnEle.click();

    }

    @And("^user enter \"(.*)\" and \"(.*)\" then click on login btn$")
    public void loginWithValidUsernameAndPassword(String userName, String pass) throws InterruptedException {
        login.loginFun(userName, pass);

    }
    @Then("user logged in successfully to the home page")
    public void successLogin_goToHomePage(){
        Assert.assertEquals(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"),true);
        //Assert.assertEquals(driver.findElement(By.className("ico-logout")).getText().contains("Log out"),true);
    }

    @When ("^user enter \"(.*)\" in search box$")
    public void enterSearchWord(String word){
        search.searchWord(word);
    }
    @Then("search results shall appear")
    public void validateSearchResult() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.className("product-title")).getText().contains("Pride and Prejudice"));
    }

    @When ("user click on Currency dropdown list and choose Euro currency")
    public void toEuroCurrency() throws InterruptedException{
        Thread.sleep(3000);
        loggedUser.changeCurrency("Euro");
    }
    @Then ("validate dealing with Euro currency")
    public void validateEurochange() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(loggedUser.validateCurrChange("€"));
    }

    @And ("user click on Currency dropdown list and choose US currency")
    public void toUSCurrency() throws InterruptedException {
        loggedUser.changeCurrency("US Dollar");
    }
    @Then ("validate dealing with US currency")
     public void validateUSchange(){
        Assert.assertTrue(loggedUser.validateCurrChange("$"));
    }
    @And("user click on random category")
    public void clickRandomCategory() throws InterruptedException {
        loggedUser.chooseRandomCategory();
    }


}
