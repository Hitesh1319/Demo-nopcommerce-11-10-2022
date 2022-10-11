package StepDefinition;

import Pages.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.io.IOException;

public class AddingItemInCartAndCheckoutTheItem extends BaseClass {

    @Given("Go to the Website.")
    public void go_to_the_website() throws IOException {
      Setup();
    }

    @When("Navigate to Computer section.")
    public void navigate_to_computer_section() {
     pageFactory.getTopMenu().selectingMenu("Computers ");
    }

    @And("Click on Notebooks.")
    public void click_on_notebooks() {
        pageFactory.getComputersPage().selectingProduct("Notebooks");
    }

    @And("Sort the items by Price Low to High and Display filter to maximum - 9.")
    public void sort_the_items_by_price_low_to_high_and_display_filter_to_maximum() {
        pageFactory.getNotebookPage().sortingPrice("Price: Low to High");
        pageFactory.getNotebookPage().sortingDisplay("9");
    }

    @And("Get the results listed with Name and Price.")
    public void get_the_results_listed_with_name_and_price() {
        pageFactory.getNotebookPage().displayingProducts();
    }

    @And("Add any item to the cart, put assertion on the confirmation message displayed.")
    public void add_any_item_to_the_results_listed_with_name_and_price() {
        pageFactory.getNotebookPage().addingHpSpectreXtProUltraBook("HP Spectre XT Pro UltraBook");
        pageFactory.getNotebookPage().verifyConfirmationMessage();
    }

    @And("Go to shoping cart page from Nav bar and verify item is added to cart.")
    public void go_to_shopping_cart_page_from_nav_bar_and_verify_item_is_added_to_cart() {
        pageFactory.getShoppingCart().clickingOnShoppinCart("Shopping Cart");
    }

    @And("Click on check Out button on Shopping cart Page.")
    public void click_on_check_out_button_on_shopping_cart_page() {
        pageFactory.getShoppingCart().checkout();
    }
}
