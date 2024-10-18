package pages;

import org.openqa.selenium.WebElement;

public class MyAccountpage extends BasePage {

    String succesfullAccountCreation = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']";
    String welcomeMessage = "//div[@class='panel header']//span[@class='logged-in'][contains(normalize-space(),'Welcome')]";
    String menButtonLocator = "//span[normalize-space()='Men']";
    String topsOptionsLocator = "//a[@id='ui-id-17' and normalize-space()='Tops']";
    String jacketsOptionLocator = "//a[@id='ui-id-19']//span[contains(text(),'Jackets')]";

    public MyAccountpage() {
        super(driver);
    }

    public Boolean isPresent() {
        System.out.println(findLocator(succesfullAccountCreation).getText());
        return isElementPresent(succesfullAccountCreation);
    }

    public WebElement findLocator() {
        return findLocator(welcomeMessage);

    }

    public void hoverMenButton() {
        hoverElement(menButtonLocator);
    }

    public void hoverTopsButton() {
        hoverElement(topsOptionsLocator);
    }

    public void clickJackets() {
        clickElement(jacketsOptionLocator);
    }

}
