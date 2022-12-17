package StepDefinition;

import Pages.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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

    @And("Go to shopping cart page from Nav bar and verify item is added to cart.")
    public void go_to_shopping_cart_page_from_nav_bar_and_verify_item_is_added_to_cart() {
        //pageFactory.getHeaderUpper().selectHeaderLink("Shopping cart");
        pageFactory.getShoppingCart().clickingOnShoppinCart("Shopping cart");
    }

    @And("Click on check Out button on Shopping cart Page.")
    public void click_on_check_out_button_on_shopping_cart_page() {
        pageFactory.getShoppingCart().checkout();
    }

    @And("On SignIn page click on Register and register with any random email address.")
    public void on_signin_page_click_on_register_and_register_with_any_random_email_address() throws IOException {
        pageFactory.getHeaderUpper().selectHeaderLink("Register");
        pageFactory.getRegisterUser().registeringUser("FirstName", "LastName", "Company", "Text", "Email", "Password", "ConfirmPassword");
    }

    @And("Navigate to Shopping Cart button, increase the order Quantity to 4.")
    public void navigate_to_shopping_cart_button_increase_the_order_quantity_to_4() {
        pageFactory.getShoppingCart().clickingOnShoppinCart("Shopping cart");
        pageFactory.getShoppingCart().increasingQuantities("4");
        pageFactory.getShoppingCart().checkout();
    }

    @And("Fill up the shipping details.")
    public void fill_up_the_shipping_details() throws IOException {
        pageFactory.getBillablePage().FillingBillDetails("BillingNewAddress_City", "BillingNewAddress.City", "BillingNewAddress_Address1", "BillingNewAddress.Address1", "BillingNewAddress_ZipPostalCode", "BillingNewAddress.ZipPostalCode", "BillingNewAddress_PhoneNumber", "BillingNewAddress.PhoneNumber");
    }

    @Then("Place the order and verify")
    public void place_the_order_and_verify() {
        pageFactory.getBillablePage().orderVerify();
    }

    @And("Close browser")
    public void close_browser() {
        close();
    }
}
