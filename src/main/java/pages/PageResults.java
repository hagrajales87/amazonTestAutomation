package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageResults {

    private WebDriver driver;
    private By description = By.cssSelector(".a-size-mini span");
    private boolean brandFound = false;

    public PageResults(WebDriver driver){
        this.driver = driver;
    }

    public ProductDetail selectProduct(String brand){

        List<WebElement> descriptions = driver.findElements(description);
        for(var element : descriptions){
            if(element.getText().contains(brand)){
                brandFound = true;
                element.click();
                break;
            }
        }
        return new ProductDetail(driver);
    }

    public boolean wasBrandFound(){
        return brandFound;
    }


}
