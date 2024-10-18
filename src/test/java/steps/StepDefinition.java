package steps;

import java.util.List;
import java.util.Map;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AccountCreationPage;
import pages.MyAccountpage;
import pages.PrincipalPage;
import com.github.javafaker.Faker;;

public class StepDefinition {

    PrincipalPage principal = new PrincipalPage();
    AccountCreationPage createAccountPage = new AccountCreationPage();
    MyAccountpage myAccountpage = new MyAccountpage();
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password(8, 15, true, true, true);

    private String getField(String field) {
        String value;
        switch (field) {
            case "firstname":
                value = firstName;
                break;
            case "lastname":
                value = lastName;

                break;
            case "email_address":
                value = email;

                break;
            case "password":
            case "password-confirmation":
                value = password;
                break;
            default:
                value = "";
                break;
        }
        return value;
    }

    @Given("user navigates to webpage")
    public void navigateToWebPage() {
        principal.navigateToURL();
    }

    @When("user clicks on the create an Account link")
    public void userClicksOnTheLink() {

        principal.clickLink();
    }

    @And("fills the input field with information")
    public void fillFieldWithData(DataTable dataTable) {

        List<Map<String, String>> fieldData = dataTable.asMaps(); // List of maps bring the key value pairs from
                                                                  // cucumber DataTable into the list
        for (Map<String, String> data : fieldData) { // Iterate the list to bring key and value in different variables
            String inputCompletion = data.get("Field Name");
            String dataToFill = getField(inputCompletion);
            createAccountPage.inputFieldMethod(inputCompletion, dataToFill); // Pass variables key value to the method
                                                                             // that needs this parameters

        }

        // Hardcoded version:

        // List<String> listOfInputs = Arrays.asList("firstname","lastname", "password",
        // "password-confirmation");
        // List<String> personalInformationList =
        // Arrays.asList("Juan","Ramirez","juanjose1234", "juanjose1234");
        // for (int i = 0; i < listOfInputs.size(); i++) {
        // createAccountPage.inputFieldMethod(listOfInputs.get(i),
        // personalInformationList.get(i));
        // }

    }

    @And("user clicks the Create an Account Button")
    public void clickCreateAnAccountButton() {
        createAccountPage.clickCreateButton();
    }

    @Then("the account should be created successfully and the name should appear to the right of welcome")
    public void accountShouldBeCreatedSuccessfully() {

        String actualName = myAccountpage.findLocator().getText();
        Assert.assertTrue(myAccountpage.isPresent(), "element is present in page");
        Assert.assertTrue(actualName.contains(firstName));

    }


    @When("the user navigates to the Jackets section by hovering over Men > Tops > Jackets")
    public void hoverTopsAndClickJackets(){
        myAccountpage.hoverMenButton();
        myAccountpage.hoverTopsButton();
        myAccountpage.clickJackets();
    }
}
