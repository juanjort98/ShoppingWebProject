package pages;



public class JacketsPage extends BasePage {

    String locatorFirstProduct = "//img[@alt='Proteus Fitness Jackshirt']";
    String locatorSecondProduct = "//img[@alt='Montana Wind Jacket']";
    String sizeSelector = "//div[@class='swatch-opt-430']//div[@id='option-label-size-143-item-170']";
    String colorSelector = "//div[@class='swatch-opt-430']//div[@id='option-label-color-93-item-50']";
    String AddToCartButton = "//input[@value = '430']/following-sibling::button[@title='Add to Cart']";

    public JacketsPage() {
        super(driver);
        
    }

    
    
}
