package Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    WebDriver driver;

    protected TopMenu topMenu;
    protected ComputersPage computersPage;
    protected NotebookPage notebookPage;
    protected ShoppingCart shoppingCart;
    protected RegisterUser registerUser;
    protected HeaderUpper headerUpper;
    protected BillablePage billablePage;
    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public TopMenu getTopMenu() {
        if(topMenu == null) {
            topMenu = new TopMenu(driver);
        }
        return topMenu;
    }

    public ComputersPage getComputersPage() {
        if(computersPage == null ) {
            computersPage = new ComputersPage(driver);
        }
        return computersPage;
    }

    public NotebookPage getNotebookPage() {
        if(notebookPage == null) {
            notebookPage = new NotebookPage(driver);
        }
        return notebookPage;
    }

    public ShoppingCart getShoppingCart() {
        if(shoppingCart == null ) {
            shoppingCart = new ShoppingCart(driver);
        }
        return shoppingCart;
    }

    public RegisterUser getRegisterUser() {
        if(registerUser == null ) {
            registerUser = new RegisterUser(driver);
        }
        return registerUser;
    }

    public HeaderUpper getHeaderUpper() {
        if(headerUpper == null ) {
            headerUpper = new HeaderUpper(driver);
        }
        return headerUpper;
    }

    public BillablePage getBillablePage() {
        if(billablePage == null ) {
            billablePage = new BillablePage(driver);
        }
        return billablePage;
    }
}