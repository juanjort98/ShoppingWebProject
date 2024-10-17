package pages;

public class MyAccountpage extends BasePage {

    String succesfullAccountCreation = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']";

    public MyAccountpage() {
        super(driver);
    }

    public Boolean isPresent(){
        System.out.println(findLocator(succesfullAccountCreation).getText());
        return isElementPresent(succesfullAccountCreation);
    }

}
