package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement getUsername(){

        return driver.findElement(By.id("Email"));
    }
    public WebElement getPassword(){
        return driver.findElement(By.id("Password"));
    }
    public WebElement getLoginButton(){

        return driver.findElement(By.className("login-button"));
    }


    public void loginFun(String username, String password) throws InterruptedException {
        getUsername().clear();
        getUsername().sendKeys(username);
        getPassword().sendKeys(password);
        getLoginButton().click();
        Thread.sleep(3000);
    }

    public void resetPassword(String email){
        getUsername().sendKeys(email);

    }

}
