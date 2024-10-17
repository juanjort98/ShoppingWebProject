package pages;

public class AccountCreationPage extends BasePage {
    String createAccountButton = "//button[@title='Create an Account']//span[contains(text(),'Create an Account')]";

    public AccountCreationPage() {
        super(driver);

    }

    private String inputField(String id) {
        String inputXpath = "//input[@id='" + id + "']";
        System.out.println(inputXpath);
        return inputXpath;
    }

    public void inputFieldMethod(String inputs, String personalInformation) {
        write(inputField(inputs), personalInformation);

    }

    public void clickCreateButton(){
        scrollToElement(createAccountButton);
        clickElement(createAccountButton);
    }

    
}
