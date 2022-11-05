package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetail {

    WebDriver driver;
    private By buyButton = By.id("buy-now-button");
    private By addToCartButton = By.id("add-to-cart-button");
    private By addNotCoverage = By.id("attachSiNoCoverage");
    private By addCoverage = By.id("attachSiAddCoverage");


    ProductDetail(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnAddToCartButton(){
        driver.findElement(addToCartButton).click();
    }

    public HomePage selectCoverage(boolean coverage){
        WebDriverWait wait = new  WebDriverWait(driver, Duration.ofMillis(2000));
        if(coverage){

            wait.until(ExpectedConditions.visibilityOf(driver.findElement(addNotCoverage)));
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(addNotCoverage)));
            driver.findElement(addNotCoverage).click();
        }
        else{

            wait.until(ExpectedConditions.visibilityOf(driver.findElement(addNotCoverage)));
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(addNotCoverage)));
            driver.findElement(addNotCoverage).click();
        }

        return new HomePage(driver);

    }

}
