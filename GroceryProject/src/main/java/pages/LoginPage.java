package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement username;
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signinButton;
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboard;// for assertion
	@FindBy(xpath = "//div [@class='alert alert-danger alert-dismissible']")
	WebElement errorAlert;

	public LoginPage enterUsernameOnUsernameField(String usernameValue) {
		username.sendKeys(usernameValue);
		return this;
		// here insted of void we use LoginPage, chaining of Pages, for this we need to
		// give return this at the end of each declaration
	}

	public LoginPage enterPasswordOnPasswordField(String passwordValue) {
		password.sendKeys(passwordValue);
		return this;
	}

	public HomePage clickOnSigninButton() {
		WaitUtility wait = new WaitUtility();
		wait.waitUntilElementToBeClickable(driver, signinButton);
		signinButton.click();
		return new HomePage(driver); //  here the concept is, page move to Home page
	}

	public boolean isDashboardDisplayed() {
		return dashboard.isDisplayed();
	}

	public boolean alertError() {
		return errorAlert.isDisplayed();
	}

}
