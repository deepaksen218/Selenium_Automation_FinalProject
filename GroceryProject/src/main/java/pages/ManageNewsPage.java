package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Locators for the Manage News page

	@FindBy(xpath = "//h1[text()='Manage News']")
	WebElement manageNewsHeading;

	// Element locators for New Button and related fields

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newsNewButton;
	
	// Element locators for New Button and related fields
	
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement enterNewsText;
	
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement enterNewsTextFake;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement newsSaveButton;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement newsSuccess;
	
	
	// Element locators for Search Button and related fields/ buttons

	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement newsSearchButton;

	@FindBy(xpath = "//input[@placeholder='Title']")
	WebElement searchNewsTitle;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement newsSearchButtonAfterText;

	// Element locators for Reset Button

	@FindBy(xpath = "//i[@class='ace-icon fa fa-sync-alt']")
	WebElement resetButton;

	@FindBy(xpath = "//a[@class='btn btn-default btn-fix']")
	WebElement resetButtonAfterSearch;

	@FindBy(xpath = "//a[@class='btn btn-default btn-fix']")
	WebElement newResetButton;

//---------------------------------------------------------
	// Assertion
	public String isManageNewsHeadingDisplayed() {
		return manageNewsHeading.getText();
	}
	
	
//---------------------------------------------------------
	
	public ManageNewsPage enterNewTextInTheField() {
		enterNewsText.sendKeys("Dummy Sample News- HardCoded");
		return this;
	}
	
	public ManageNewsPage enterNewTextInTheFieldFaker(String fakeNews, String sen ) {
		enterNewsTextFake.sendKeys(fakeNews, sen);
		return this;
	}
	
	public ManageNewsPage clickOnNewsSaveButton() {
		newsSaveButton.click();
		return this;
	}
	
	// Assertion
	public  boolean alertNewsMessageIsSuccess() {
		return newsSuccess.isDisplayed();
	}
	
	

//---------------------------------------------------------
	public ManageNewsPage clickOnNewButton() {
		newsNewButton.click();
		return this;
	}

	// Assertion
	public boolean newButtonEnabled() {
		return newsNewButton.isEnabled();
	}

//---------------------------------------------------------
	public ManageNewsPage clickOnSearchButton() {
		newsSearchButton.click();
		return this;
	}

	public ManageNewsPage searchManageNews() {
		searchNewsTitle.sendKeys("Dummy Sample News");
		return this;
	}

	public ManageNewsPage searchManageNewsFromFake() {
		searchNewsTitle.sendKeys(".sen");
		return this;
	}

	public ManageNewsPage searchButtonAfterTextEntered() {
		newsSearchButtonAfterText.click();
		return this;
	}

	// Assertion
	public boolean searchButtonEnabled() {
		return newsSearchButton.isEnabled();
	}

//---------------------------------------------------------		
	public ManageNewsPage clickOnResetButton() {
		resetButton.click();
		return this;
	}

	public ManageNewsPage newResetButtonAfterSearch() {
		resetButtonAfterSearch.click();
		return this;
	}

	// Assertion
	public boolean newRestButtonEnabled() {
		return newResetButton.isEnabled();
	}

}
