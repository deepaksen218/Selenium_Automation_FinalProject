package testScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends BaseClass {
	HomePage home;

	// Positive Case: Valid Username and Password
	@Test(priority = 1, description = "Validating userlogin with valid credentials", groups = "smoke")
	public void verifyUserLoginWithValidCredentials() throws IOException {

		/*
		 * WebElement username =
		 * driver.findElement(By.xpath("//input[@name='username']"));
		 * username.sendKeys("admin"); WebElement password =
		 * driver.findElement(By.xpath("//input[@name='password']"));
		 * password.sendKeys("admin"); WebElement signinButton =
		 * driver.findElement(By.xpath("//button[@type='submit']"));
		 * signinButton.click();
		 */

		String usernameValue = ExcelUtility.getStringData(0, 0, "SignInPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "SignInPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		home = login.clickOnSigninButton();

		// Assertion
		boolean dashboardDisplay = login.isDashboardDisplayed();
		// Assert.assertTrue(dashboardDisplay, "User was unable to Login with Valid
		// Credentials");
		// OR
		Assert.assertTrue(dashboardDisplay, Constants.validCredentailError);
	}

	// Negative Case: Valid Username and Invalid Password
	@Test(priority = 2, description = "Validating userlogin with Invalid credentials")
	public void verifyUserLoginWithInValidCredentials() throws IOException {

		String usernameValue = ExcelUtility.getStringData(1, 0, "SignInPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "SignInPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue)
				.clickOnSigninButton();

		boolean errorDisplay = login.alertError();
		// Assert.assertTrue(errorDisplay, "Error Alert is not Dispalyed");
		Assert.assertTrue(errorDisplay, Constants.inValidUsernameandPasswordCredentailError);

	}

	// Negative Case: Invalid Username and Valid Password
	@Test(priority = 3, description = "Validating userlogin with Invalid Username And Valid Password")
	public void verifyUserLoginWithInValidUsernameAndValidPassword() throws IOException {

		String usernameValue = ExcelUtility.getStringData(2, 0, "SignInPage");
		String passwordValue = ExcelUtility.getStringData(2, 1, "SignInPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue)
				.clickOnSigninButton();

		// Assertion
		boolean errorDisplay = login.alertError();
		// Assert.assertTrue(errorDisplay, "Error Alert is not Dispalyed");
		Assert.assertTrue(errorDisplay, Constants.inValidUsernameCredentailError);
	}

	// Negative Case: Invalid Username and Invalid Password
	@Test(priority = 4, description = "Validating userlogin with Valid Username And Invalid Password", groups = {
			"smoke" }, dataProvider = "loginProvider")
	public void verifyUserLoginWithValidUsernameAndInvalidPassword(String usernameValue, String passwordValue)
			throws IOException {

		// String usernameValue = ExcelUtility.getStringData(3, 0, "SignInPage");
		// String passwordValue = ExcelUtility.getStringData(3, 1, "SignInPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue)
				.clickOnSigninButton();

		// Assertion
		boolean errorDisplay = login.alertError();
		// Assert.assertTrue(errorDisplay, "Error Alert is not Dispalyed");
		Assert.assertTrue(errorDisplay, Constants.inValidPasswordCredentailError);

	}

	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
	}

}
