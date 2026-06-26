package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement adminButton;

	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	WebElement logoutButton;

	@FindBy(xpath = "//a[contains(@href,'list-admin') and contains(text(),'More info')]")
	WebElement adminUserMoreInfo;

	@FindBy(xpath = "//a[contains(@href,'list-news') and contains(text(),'More info')]")
	WebElement manageNewsMoreInfo;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInButton;

	public HomePage clickOnAdminButton() {
		adminButton.click();
		return this;
	}

	public LoginPage clickOnLogoutButton() {
		logoutButton.click();
		return new LoginPage(driver);
	}

	public AdminUsersPage clickOnAdminUsersMoreInfoButton() {
		adminUserMoreInfo.click();
		return new AdminUsersPage(driver);
	}

	public ManageNewsPage clickOnManageNewsMoreInfoButton() {
		manageNewsMoreInfo.click();
		return new ManageNewsPage(driver);
	}

	// Assertion
	public Boolean isSignInButtonEnabled() {
		return signInButton.isEnabled();
	}

}
