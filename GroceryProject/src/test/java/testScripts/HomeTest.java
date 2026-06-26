package testScripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends BaseClass {
	HomePage home;

	@Test( description = "Validating User is Successfully logged out")
	public void verifyUseranSuccessfullyLogout() throws IOException {

		String usernameValue = ExcelUtility.getStringData(0, 0, "SignInPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "SignInPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		home = login.clickOnSigninButton();

		// HomePage home = new HomePage(driver);
		home.clickOnAdminButton();
		login = home.clickOnLogoutButton();

		// Assertion
		Boolean actual = home.isSignInButtonEnabled();
		Assert.assertTrue(actual, Constants.logoutSuccessful);
		
		//retryAnalyzer = retryMechanism.Retry.class,

	}

}
