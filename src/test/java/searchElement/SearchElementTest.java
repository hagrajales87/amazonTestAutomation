package searchElement;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pages.CartPage;
import pages.HomePage;
import pages.PageResults;
import pages.ProductDetail;

import static org.testng.Assert.assertTrue;


public class SearchElementTest extends BaseTest{

    @Test
    public void searchAnElement(){
        homepage.clickOnSearchBar();
        homepage.typeOnSearchBar("refrigerador");
        PageResults pageResults = homepage.clickOnSearchButton();
        ProductDetail productDetail = pageResults.selectProduct("Samsung");
        assertTrue(pageResults.wasBrandFound());
        productDetail.clickOnAddToCartButton();
        homepage =productDetail.selectCoverage(false);

        homepage.clickOnAmazonIcon();
        homepage.clickOnSearchBar();
        homepage.typeOnSearchBar("refrigerador");
        homepage.clickOnSearchBar();
        pageResults = homepage.clickOnSearchButton();

        productDetail = pageResults.selectProduct("Mabe");
        assertTrue(pageResults.wasBrandFound());
        productDetail.clickOnAddToCartButton();
        homepage= productDetail.selectCoverage(false);
        CartPage cartPage = homepage.clickOnShoppingCart();
        cartPage.getTotalAmount();

    }
}
