import Collections.Countries;
import Core.Actions;
import Setup.Setup;
import org.junit.*;
import static Core.Actions.*;
import static org.junit.Assert.assertEquals;

public class DisplateTests extends Setup {

    @Before
    public void InitializeWebDriver() {
        Setup.WebDriverSetup();
    }

    @After
    public void CloseBrowser() {
         driver.close();
    }

    @Test
    public void S01T01_AddMSizedItemToCartAndApplyDiscountCode() throws InterruptedException {
        OpenFirstElementFromBestsellers();
        ClickSelectFinishAddFrameButton();
        SelectFrameSize(0);

        //store item price before going further
        String priceBeforeAddingToCart = GetElementPriceBeforeAddingToCart();

        ClickAddToCartButton();
        OpenCartPage();

        //assert that price before adding to card is the same as price in a cart view
        assertEquals(priceBeforeAddingToCart, Actions.GetElementPriceAfterAddingToCart());

        ExpandShipToCountriesList();
        SelectShippingCountry(Countries.US);
        ClickIHaveDiscountCodeHyperlink();
        InsertCurrentPromoCodeToPromoCodeField();
        FetchAppliedDiscountedRateAndVerifyPriceAfterDiscount();
    }

    @Test
    public void S01T02_AddLSizedItemToCartAndApplyDiscountCode() throws InterruptedException {
        OpenFirstElementFromBestsellers();
        ClickSelectFinishAddFrameButton();
        SelectFrameSize(1);

        //store item price before going further
        String priceBeforeAddingToCart = GetElementPriceBeforeAddingToCart();

        ClickAddToCartButton();
        OpenCartPage();

        //assert that price before adding to card is the same as price in a cart view
        assertEquals(priceBeforeAddingToCart, Actions.GetElementPriceAfterAddingToCart());

        ExpandShipToCountriesList();
        SelectShippingCountry(Countries.US);
        ClickIHaveDiscountCodeHyperlink();
        InsertCurrentPromoCodeToPromoCodeField();
        FetchAppliedDiscountedRateAndVerifyPriceAfterDiscount();
    }

    @Test
    public void S01T03_AddXLSizedItemToCartAndApplyDiscountCode() throws InterruptedException {
        OpenFirstElementFromBestsellers();
        ClickSelectFinishAddFrameButton();
        SelectFrameSize(2);

        //store item price before going further
        String priceBeforeAddingToCart = GetElementPriceBeforeAddingToCart();

        ClickAddToCartButton();
        OpenCartPage();

        //assert that price before adding to card is the same as price in a cart view
        assertEquals(priceBeforeAddingToCart, Actions.GetElementPriceAfterAddingToCart());

        ExpandShipToCountriesList();
        SelectShippingCountry(Countries.US);
        ClickIHaveDiscountCodeHyperlink();
        InsertCurrentPromoCodeToPromoCodeField();
        FetchAppliedDiscountedRateAndVerifyPriceAfterDiscount();
    }

}