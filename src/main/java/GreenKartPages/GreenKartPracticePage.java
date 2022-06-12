package GreenKartPages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenKartPracticePage extends BasePage {
    WebDriverWait wait = new WebDriverWait(driver, 12);

    private By searchField = By.cssSelector("[type='search']");
    private By addToCartButton = By.cssSelector("div.product-action > button");
    private By cartIcon = By.cssSelector("a[class='cart-icon']");
    private By proceedToCheckOut = By.cssSelector("div:nth-child(2) > [class=' ']");
    private By noOfItems = By.xpath("//*[@class='cartTable']/following-sibling::div");
    private By placeOrder = By.xpath("//*[text()='Place Order']");
    private By termsAndConditionsCheckBox = By.cssSelector("input[type='checkbox']");
    private By proceed = By.xpath("//*[text()='Proceed']");
    private By successMessage = By.xpath("//*[contains(text(),'Thank you')]");

    public GreenKartPracticePage(WebDriver driver) {
        super(driver);
    }

    public void fillSearchField(String search) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='search']")));
        driver.findElement(searchField).sendKeys(search);
    }

    public void clickOnAddToCartButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.product-action > button")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Mango - 1 Kg']")));
        Thread.sleep(1000);
        driver.findElement(addToCartButton).click();
    }

    public void clickOnCartIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartIcon));
        driver.findElement(cartIcon).click();
    }

    public void clickOnProceedToCheckOutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckOut));
        driver.findElement(proceedToCheckOut).click();
        wait.until(ExpectedConditions.urlContains("cart"));
    }

    public String getNoOfItems() {
        return driver.findElement(noOfItems).getText();
    }

    public void clickOnPlaceOrderButton() {
        driver.findElement(placeOrder).click();
        wait.until(ExpectedConditions.urlContains("country"));
    }

    public void clickOnTermsAndCondCheckBox() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(termsAndConditionsCheckBox));
        driver.findElement(termsAndConditionsCheckBox).click();
    }

    public void clickOnProceedButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceed));
        driver.findElement(proceed).click();
    }

    public String getSuccessMessage() {
        System.out.println(driver.findElement(successMessage).getText());
        return driver.findElement(successMessage).getText();

    }
}



