package pages;

public class PrincipalPage extends BasePage {
    String createLinkString = "//a[text()='Create an Account' and @href]";

    public PrincipalPage() {
        super(driver);
        
    }

    public void navigateToURL() {
        driver.manage().window().maximize();
        navigateToPage("https://magento.softwaretestingboard.com/");
    }

    public void clickLink(){
        scrollToElement(createLinkString);
        clickElement(createLinkString);
    }

}
