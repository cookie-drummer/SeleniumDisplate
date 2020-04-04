package Core;

import Setup.Setup;

public class Elements extends Setup {

    public static String firstElementFromBestsellers = "//div[@data-index='0']";
    public static String addToCartButton = "[id=add-to-cart]";
    public static String selectFinishAddFrameButton = "a[class='link link--blue js-show-frames']";
    public static String openCartButton = "//*[@id='proceedToCart']";
    public static String priceBeforeAddingToCart = "//*[@class='product-price-option']//*[@class='js-item-price']";
    public static String priceAfterAddingToCart = "//*[@id='cart-total']";
    public static String currentPromoCode = "//span[@class='black-friday-text-regular']//strong";
    public static String iHaveDiscountCodeHyperlink = "//*[@class='discount']";
    public static String inputPromoCode = "//*[@id='discount-code']";
    public static String promoCodeDiscountRate = "//*[@class='discount__info text text--bold']//strong";
    public static String promoCodeApplyingLoader = "//*[@id='cart-container' and @style!='pointer-events: auto;']";

}
