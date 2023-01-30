package StepDefinitions;

import Pages.P03_loggedUser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class addProduct {

    public static WebDriver driver=null;
    public static P03_loggedUser loggedUser;

    @When("^user click on product \"(.*)\"$")
    public void clickOnProduct(String prodName){
        loggedUser.clickOnProduct(prodName);
    }
    @And("user click on add to cart button")
    public void clickOnAddToCartBtn() throws InterruptedException {
        loggedUser.clickOnAddToCart();
        Thread.sleep(3000);
    }
    @Then("^product \"(.*)\" shall be added to cart$")
    public void validateProductAddedToCart(String Name) throws InterruptedException {
        Assert.assertTrue(driver.findElement(By.className("content")).getText().contains("The product has been added to your "));
        Thread.sleep(3000);
        driver.findElement(By.className("cart-label")).click();

        List<WebElement> rowElements= driver.findElements(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr"));
        int rowsCount=rowElements.size();

        List<WebElement> colElements= driver.findElements(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr[1]/td"));
        int colCount=colElements.size();

        int j=3;
        for(int i=1; i<=rowsCount; i++){
            String productName=driver.findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr["+ i +"]/td["+ j +"]")).getText();
            if(productName.contains(Name)){
                Assert.assertTrue(productName.contains(Name));
            }
        }


    }
    @When("user click on add to wishlist button")
    public void clickOnAddToWishlist() throws InterruptedException {
        loggedUser.clickOnAddToWishlist();
        Thread.sleep(3000);
    }
    @And("^product \"(.*)\" shall be added to wishlist$")
    public void validateProductAddedToWishlist(String Name) throws InterruptedException {
        Assert.assertTrue(driver.findElement(By.xpath("//p//a[@href=\"/wishlist\"]")).getText().contains("wishlist"));
        Thread.sleep(4000);
        driver.findElement(By.className("ico-wishlist")).click();

        List<WebElement> rowElements= driver.findElements(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr"));
        int rowsCount=rowElements.size();

        List<WebElement> colElements= driver.findElements(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr[1]/td"));
        int colCount=colElements.size();

        int j=3;
        for(int i=1; i<=rowsCount; i++){
            String productName=driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr["+i+"]/td[4]")).getText();
            if(productName.contains(Name)){
                Assert.assertTrue(productName.contains(Name));
            }
        }
    }

    @When("user click on add to compareList button")
    public void clickOnAddToComparelist() throws InterruptedException {
        loggedUser.clickOnAddToCompareList();
        Thread.sleep(3000);
    }

    @And("^product \"(.*)\" shall be added to compareList$")
    public void validateProductAddedToComparelist(String Name) throws InterruptedException {
        Assert.assertTrue(driver.findElement(By.xpath("//p//a[@href=\"/compareproducts\"]")).getText().contains("product comparison"));
        driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]/div[2]/ul/li[5]/a")).click();

        Thread.sleep(3000);

        List<WebElement> rowElements= driver.findElements(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr"));
        int rowsCount=rowElements.size();

        List<WebElement> colElements= driver.findElements(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td"));
        int colCount=colElements.size();

        int j=3;
        for(int i=1; i<=colCount; i++){
            String productName=driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr[3]/td["+i+"]")).getText();
            if(productName.contains(Name)){
                Assert.assertTrue(productName.contains(Name));
                System.out.println(productName);
            }
        }
    }
}
