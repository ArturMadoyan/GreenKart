package GreenKartTests;

import GreenKartPages.Constants;
import GreenKartPages.GreenKartPracticePage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;


public class GreenKartTest extends BaseTest {

    @Test
    public void demoQaTask() throws InterruptedException {
        GreenKartPracticePage app = new GreenKartPracticePage(driver);

        // Task 1. Navigate to "https://rahulshettyacademy.com/seleniumPractise/#/" page
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        // Task 2. Assert page is opened (url, title)
        Assert.assertEquals(driver.getCurrentUrl(), Constants.EXPECTED_HOME_PAGE_URL);
        Assert.assertEquals(driver.getTitle(), Constants.EXPECTED_HOME_PAGE_TITLE);

        // Task 3. Add "Mango" to the cart
        app.fillSearchField("Mango");
        app.clickOnAddToCartButton();

        // Task 4. Assert Items and Price are shown as expected in the cart info (top right)
        Assert.assertNotNull(driver.findElement(By.cssSelector(Constants.EXPECTED_ITEM_COUNT_1)));
        Assert.assertEquals(driver.findElement(By.cssSelector(Constants.EXPECTED_PRICE_75)).getText(), "75");

        //Task 5. Click on the cart icon
        app.clickOnCartIcon();

        //Task 6. Assert "Mango" is shown on the opened overlay
        Assert.assertEquals(driver.findElement(By.cssSelector(Constants.ACTUAL_PRODUCT_NAME)).getText(),
                Constants.EXPECTED_PRODUCT_NAME);

        // Task 7. Click on "Proceed to checkout" button
        app.clickOnProceedToCheckOutButton();

        // Task 8. Assert cart page is opened
        Assert.assertEquals(driver.getCurrentUrl(), Constants.EXPECTED_CART_PAGE_URL);

        // Task 9. Asset only one item is shown in the cart
        Assert.assertTrue(app.getNoOfItems().contains(Constants.EXPECTED_NUMBER_OF_ITEMS_1));

        //Task 10. Click on "Place Order" button
        app.clickOnPlaceOrderButton();

        // Asserting the navigation of Country page
        Assert.assertEquals(driver.getCurrentUrl(), Constants.EXPECTED_COUNTRY_PAGE_URL);

        // Task 11. Check "Terms & Conditions" checkbox
        app.clickOnTermsAndCondCheckBox();

        // Asserting that the checkbox is selected
        Assert.assertTrue(driver.findElement(By.cssSelector(Constants.ACTUAL_CHECK_BOX_STATUS_ELEMENT)).isSelected());

        // Task 12. Click on "Proceed" button
        app.clickOnProceedButton();

        // Task 13. Assert Success message is shown
        Assert.assertTrue(app.getSuccessMessage().contains("Thank you, your order has been placed successfully"));

        //Thank you for amazing tasks

    }
}
