package StepDefinitions;

import Pages.selectCategoryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class selectCategory {

    public static WebDriver driver=null;
    public static selectCategoryPage myCategory;
    static String randomCatName="hello";


    @When("user selects random category")
    public void selectRandomCategory(){
        randomCatName=myCategory.selectRandomCategory();
    }

    @Then("redirected to category's products")
    public void validateRedirectToCatProducts(){
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[1]/h1")).getText().contains(randomCatName));
    }


    @When ("user go to specific category")
    public void goToSpecificCategory(){
       myCategory.goToShoesCategory();
    }
    @And ("filter category products by color")
    public void filterByColor() throws InterruptedException {
        myCategory.filterByColor();
        Thread.sleep(3000);
    }
    @Then ("products should be filtered successfully")
    public void validateFilterByColor(){
        Assert.assertTrue(myCategory.validateFilter());
    }




}
