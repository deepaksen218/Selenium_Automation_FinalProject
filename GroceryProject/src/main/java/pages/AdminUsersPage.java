package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage {

	public WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	// Element locators for New Button and related fields

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newButton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement newUsername;
	@FindBy(id = "password")
	WebElement newPassword;
	@FindBy(id = "user_type")
	WebElement selectUserType;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successAlert;
	@FindBy(xpath = "//div[text()= 'User Created Successfully']")
	WebElement successfullyCreated;

//--------------------------------------------------------------------
	// Element locators for Search Button and related fields

	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement adminSearchButton;
	@FindBy(xpath = "//input[@id='un']")
	WebElement usernameSearch;
	@FindBy(id = "ut")
	WebElement userTypeSelectionForSearchDropDown;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchSearchButton;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement deleteButton;
	@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']")
	WebElement searchAlert;
//--------------------------------------------------------------------
	// Element locators for Reset Button and related fields

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetButton;

	// Locators for the Admin Users page page

	@FindBy(xpath = "//h1[text()='Admin Users']")
	WebElement adminUserHeading;

	// checking reset Button is enabled
	@FindBy(xpath = "//i[@class='ace-icon fa fa-sync-alt']")
	WebElement resetButtonEnabled;

//-------------------------------------------------------------------

	public AdminUsersPage clickOnNewButton() {
		newButton.click();
		return this;
	}

	public AdminUsersPage enterNewUsernameOnUsernameField(String newUsernameValue) {
		newUsername.sendKeys(newUsernameValue);
		return this;
	}

	public AdminUsersPage enterNewPasswordOnPasswordField(String newPasswordValue) {
		newPassword.sendKeys(newPasswordValue);
		return this;
	}

	public AdminUsersPage selectUserType() {
		// Select select = new Select(selectUserType);
		// select.selectByValue("staff");
		pageutility.selectByIndex(selectUserType, 1);
		return this;
	}

	public AdminUsersPage clickOnSaveButton() {
		saveButton.click();
		return this;
	}

	// Assertion
	public boolean alertSuccess() {
		return successAlert.isDisplayed();
	}
//----------------------------------------------------------------

	public AdminUsersPage clickOnSearchButton() {
		adminSearchButton.click();
		return this;
	}

	public AdminUsersPage enterUsernameOnSearchField(String searchUsernameValue) {
		usernameSearch.sendKeys(searchUsernameValue);
		return this;
	}

	public AdminUsersPage selectUserTypeForSearch() {
		// Select select = new Select(userTypeSelectionForSearch);
		// select.selectByIndex(1);
		pageutility.selectByIndex(userTypeSelectionForSearchDropDown, 1);
		return this;
	}

	public AdminUsersPage selectSearchButtonFromSearchAdminUsers() {
		searchSearchButton.click();
		return this;
	}

	public void selectDeleteButton() {
		deleteButton.click();
	}

	// Assertion
	public String resultNotDisplayed() {
		return searchAlert.getText();
	}

//----------------------------------------------------------------	

	public AdminUsersPage clickOnResetButton() {
		resetButton.click();
		return this;
	}

	// Assertion
	public String isAdminUsersHeadingDisplayed() {
		return adminUserHeading.getText();
	}

	// Assertion
	public boolean isResetButtonEnabled() {
		return resetButtonEnabled.isEnabled();
	}

}
