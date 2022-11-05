package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;

import javax.lang.model.element.Element;
import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private By searchBar = By.id("twotabsearchtextbox");
    private By searchButton = By.id("nav-search-submit-button");
    private By amazonIcon = By.id("nav-logo-sprites");
    private By goToShoppingCart = By.cssSelector("#sw-gtc  a");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnAmazonIcon(){
        driver.findElement(amazonIcon).click();
    }

    public void clickOnSearchBar(){
        WebDriverWait wait = new  WebDriverWait(driver, Duration.ofMillis(2000));
        wait.until(ExpectedConditions.presenceOfElementLocated(searchBar));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchBar)));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(searchBar)));
        driver.findElement(searchBar).click();
    }

    public void typeOnSearchBar(String article){
        driver.findElement(searchBar).sendKeys(article);
    }
    public PageResults clickOnSearchButton(){
        driver.findElement(searchButton).click();
        return new PageResults(driver);
    }

    public CartPage clickOnShoppingCart(){
        WebDriverWait wait = new  WebDriverWait(driver, Duration.ofMillis(2000));
        wait.until(ExpectedConditions.presenceOfElementLocated(goToShoppingCart));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(goToShoppingCart)));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(goToShoppingCart)));
        driver.findElement(goToShoppingCart).click();
        return new CartPage(driver);
    }
}
