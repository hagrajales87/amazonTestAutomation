package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private WebDriver driver;
    private By goToShoppingCart = By.cssSelector("#sc-subtotal-amount-buybox  span");

    public  CartPage(WebDriver driver){
        this.driver = driver;
    }

    public void getTotalAmount(){

        String stringTotalAmount = driver.findElement(goToShoppingCart).getText();
        stringTotalAmount = stringTotalAmount.replaceAll("[$,]","");
        double totalAmount=Double.parseDouble(stringTotalAmount);

        validateAmount(totalAmount, stringTotalAmount);
    }

    public void validateAmount(double  totalAmount, String stringTotalAmount){
        if(totalAmount > 10000 ){
            System.out.println("The total amount is greater than $10,000.0" + " The total is " + driver.findElement(goToShoppingCart).getText());
        }
        else{
            System.out.println("The total amount is lower than $10,000.0" + " The total is " + driver.findElement(goToShoppingCart).getText());
        }
    }
}
