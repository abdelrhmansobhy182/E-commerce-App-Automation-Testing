package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class P03_loggedUser {
    WebDriver driver;

    public P03_loggedUser(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement getCurrencyList(){

        return driver.findElement(By.id("customerCurrency"));
    }


    public WebElement getProduct(String prodName){

        return driver.findElement(By.linkText(prodName));
    }

    public WebElement getAddToCart(){

        return driver.findElement(By.xpath("//div[@class=\"add-to-cart\"]//button[@type=\"button\"]"));
    }

    public WebElement getAddToComparelist(){
        return driver.findElement(By.xpath("//div[@class=\"compare-products\"]//button[@type=\"button\"]"));
    }

    public WebElement getAddToWishlist(){
        return driver.findElement(By.xpath("//div[@class=\"add-to-wishlist\"]//button[@type=\"button\"]"));
    }



    public void changeCurrency(String currencyName) throws InterruptedException {
        Select drpCurr= new Select(getCurrencyList());
        drpCurr.selectByVisibleText(currencyName);
        Thread.sleep(3000);
    }
    public boolean validateCurrChange(String currencySign){
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/div[3]/div[1]/span[2]")).getText().contains(currencySign);
    }
    public void chooseRandomCategory() throws InterruptedException {

        List<WebElement> listOfCategories=driver.findElements(By.xpath("//ul[@class=\"top-menu mobile\"]"))  ;
        for (WebElement webElement: listOfCategories){
            if(webElement.getText().contains("Books")){
                webElement.click();
                break;
            }
        }

    }
    public void clickOnProduct(String prodName){
        getProduct(prodName).click();
    }
    public void clickOnAddToCart(){
        getAddToCart().click();
    }
    public void clickOnAddToWishlist(){
        getAddToWishlist().click();
    }
    public void clickOnAddToCompareList(){
        getAddToComparelist().click();
    }

}
