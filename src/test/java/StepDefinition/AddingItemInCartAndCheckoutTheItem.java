package StepDefinition;

import Pages.BaseClass;
import io.cucumber.java.en.Given;

import java.io.IOException;

public class AddingItemInCartAndCheckoutTheItem extends BaseClass {

    @Given("Go to the Website.")
    public void go_to_the_website() throws IOException {
      Setup();
    }
}
