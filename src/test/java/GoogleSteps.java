import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSteps {
    Elements elements = new Elements();


    @And("Click on Button")
    public void clickOnButton() {
        elements.searchButtonSecondButton();
    }

    @Then("Should Result string on page")
    public void shouldResultStringOnPage() {
        elements.resultStat();
    }


    @When("Input data")
    public void inputData() {

        elements.searchString("Radiohead - Kid A");

    }
}
