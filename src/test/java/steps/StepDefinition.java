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

public class StepDefinition {

    PrincipalPage principal = new PrincipalPage();
    AccountCreationPage createAccountPage = new AccountCreationPage();
    MyAccountpage myAccountpage = new MyAccountpage();

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
            String dataToFill = data.get("Value");
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
    public void clickCreateAnAccountButton(){
        createAccountPage.clickCreateButton();
    }

    @Then("the account should be created successfully")
    public void accountShouldBeCreatedSuccessfully() {
        Assert.assertTrue(myAccountpage.isPresent(), "element is present in page");
    }
}
