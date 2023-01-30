package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class P01_register {
    WebDriver driver;

    public P01_register(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement getGender(char Gender){

        if (Gender =='F' || Gender =='f')
            return driver.findElement(By.id("gender-female"));
        else return driver.findElement(By.id("gender-male"));


    }

    public WebElement getFirstName(){

        return driver.findElement(By.id("FirstName"));
    }
    public WebElement getLastName(){

        return driver.findElement(By.id("LastName"));
    }

    public WebElement getDayBirth(){

        return driver.findElement(By.name("DateOfBirthDay"));
    }

    public WebElement getMonthBirth(){

        return driver.findElement(By.name("DateOfBirthMonth"));
    }
    public WebElement getYearBirth(){

        return driver.findElement(By.name("DateOfBirthYear"));
    }

    public WebElement getEmail(){

        return driver.findElement(By.id("Email"));
    }


    public WebElement getPassword(){
        return driver.findElement(By.id("Password"));

    }

    public WebElement getConfirmPassword(){

        return driver.findElement(By.id("ConfirmPassword"));
    }

    public void registerData(char gender  ,String firstName, String lastName,String day, String month, String year, String email, String pass, String confirmPass) throws InterruptedException {
        getGender(gender).click();
        getFirstName().sendKeys(firstName);
        getLastName().sendKeys(lastName);
        Select drpDay= new Select(getDayBirth());
        Select drpMonth= new Select(getMonthBirth());
        Select drpYear= new Select(getYearBirth());
        drpDay.selectByValue(day);
        drpMonth.selectByValue(month);
        drpYear.selectByValue(year);
        getEmail().sendKeys(email);
        getPassword().sendKeys(pass);
        getConfirmPassword().sendKeys(confirmPass);

        driver.findElement(By.id("register-button")).click();
        Thread.sleep(3000);
    }




}
