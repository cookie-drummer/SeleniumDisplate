package Core;

import Setup.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

public class Actions extends Setup {

    public static void OpenFirstElementFromBestsellers() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Elements.firstElementFromBestsellers)))).click();
    }

    public static void ClickAddToCartButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(Elements.addToCartButton)))).click();
    }

    public static void ClickSelectFinishAddFrameButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(Elements.selectFinishAddFrameButton)))).click();
    }

    public static void SelectFrameSize(int Size) {

        //0 = M
        //1 = L
        //2 = XL

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@counter='"+ Size +"']")))).click();
    }

    public static void OpenCartPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Elements.openCartButton)))).click();
    }

    public static String GetElementPriceBeforeAddingToCart() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Elements.priceBeforeAddingToCart)))).getText();
    }

    public static String GetElementPriceAfterAddingToCart() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Elements.priceAfterAddingToCart)))).getText().substring(1);
    }

    public static void SelectShippingCountry(String country) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@value='"+ country +"']"))));

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", driver.findElement(By.xpath("//div[@value='"+ country +"']")));
        Thread.sleep(1000);
    }

    public static void ExpandShipToCountriesList() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id='select-country']")))).click();
    }

    public static String GetCurrentPromoCode() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Elements.currentPromoCode+"[5]")))).getText();
    }

    public static void ClickIHaveDiscountCodeHyperlink() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Elements.iHaveDiscountCodeHyperlink)))).click();
    }

    public static void InsertCurrentPromoCodeToPromoCodeField() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Elements.inputPromoCode)))).sendKeys(Actions.GetCurrentPromoCode());
    }

    public static void FetchAppliedDiscountedRateAndVerifyPriceAfterDiscount() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String originalPrice =  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Elements.priceAfterAddingToCart)))).getText().trim().substring(1);
        var originalPriceTrimmed = Double.parseDouble(originalPrice);

        driver.findElement(By.xpath("//input[@value='Apply']")).click();

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(Elements.promoCodeApplyingLoader))));
        String appliedDiscount =  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Elements.promoCodeDiscountRate)))).getText().trim().replace(" %", "");
        int discountRate = Integer.parseInt(appliedDiscount);

        Thread.sleep(2000);

        String discountedPrice =  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Elements.priceAfterAddingToCart)))).getText().trim().substring(1);
        var discountedPriceTrimmed = Double.parseDouble(discountedPrice);

        assertEquals((originalPriceTrimmed * (100-discountRate)/100), discountedPriceTrimmed, 0.00);
    }

}
