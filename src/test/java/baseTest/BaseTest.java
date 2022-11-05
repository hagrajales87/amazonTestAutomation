package baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.HomePage;

public class BaseTest {

    protected HomePage homepage;
    private  WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com.mx/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        homepage = new HomePage(driver);
    }
    @BeforeMethod
    public void goHomePage(){
        driver.get("https://www.amazon.com.mx/");
    }
   // @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
