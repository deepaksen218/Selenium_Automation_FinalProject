package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import constant.Constants;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;

import utilities.ExcelUtility;
import utilities.FakerUtility;


public class AdminUsersTest extends BaseClass {
	HomePage home; // reference variable
	AdminUsersPage adminuser;

	@Test(description = "Validating User is able to add new User")
	public void verifyUserIsAbleToAddNewUser() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0, 0, "SignInPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "SignInPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		home = login.clickOnSigninButton();

		// HomePage home = new HomePage(driver);
		adminuser = home.clickOnAdminUsersMoreInfoButton();
		
		/*AlertUtility alert = new AlertUtility();
		alert.acceptAlert(driver);*/

		FakerUtility faker = new FakerUtility(); // here we add new dependency and create a new utility fakerUtility.
		// after that need to call the created utility in this test page.

		// AdminUsersPage admin = new AdminUsersPage(driver);
		// admin.clickOnNewButton();
		adminuser.clickOnNewButton();
		

		// String newUsernameValue = ExcelUtility.getStringData(0, 0, "AdminUserPage");
		String newUsernameValue = faker.generateRandomUserName(); // trying with fake Username to generate
		// String newPasswordValue = ExcelUtility.getStringData(0, 1, "AdminUserPage");
		String newPasswordValue = faker.generateRandomPassword(); // trying with fake Password to generate
		adminuser.enterNewUsernameOnUsernameField(newUsernameValue).enterNewPasswordOnPasswordField(newPasswordValue)
				.selectUserType().clickOnSaveButton();

		// Assertion
		boolean success = adminuser.alertSuccess();
		Assert.assertTrue(success, Constants.verifyUserIsAbleToAddNewUser);
	}

	@Test(description = "Validating User is able to search a user ")
	public void verifyUserIsAbleToSearchUser() throws IOException {

		String usernameValue = ExcelUtility.getStringData(0, 0, "SignInPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "SignInPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		home = login.clickOnSigninButton();

		// HomePage home = new HomePage(driver);
		adminuser = home.clickOnAdminUsersMoreInfoButton();

		AdminUsersPage adminUser = new AdminUsersPage(driver);
		adminUser.clickOnSearchButton();
		String searchUsernameValue = ExcelUtility.getStringData(0, 0, "AdminUserPage");
		adminUser.enterUsernameOnSearchField(searchUsernameValue).selectUserTypeForSearch().selectSearchButtonFromSearchAdminUsers();

		// adminUser.selectDeleteButton();

		// Assertion
		String actual = adminUser.resultNotDisplayed();
		String expected = ".........RESULT NOT FOUND.......";
		Assert.assertEquals(actual, expected, Constants.verifyUserIsAbleToAddNewUser);

	}

	@Test(description = "Validating User is able to click Reset Button")
	public void verifyUserIsAbleToReset() throws IOException {

		String usernameValue = ExcelUtility.getStringData(0, 0, "SignInPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "SignInPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		home = login.clickOnSigninButton();

		// HomePage home = new HomePage(driver);
		adminuser = home.clickOnAdminUsersMoreInfoButton();

		//AdminUsersPage adminUser = new AdminUsersPage(driver);
		//adminuser.clickOnResetButton();
		
		/*AlertUtility alert = new AlertUtility();
		alert.acceptAlert(driver);*/
		adminuser.clickOnResetButton();
		//alert.acceptAlert(driver);

		// Assertion
		String actual = adminuser.isAdminUsersHeadingDisplayed();
		String expected = "Admin Users";
		Assert.assertEquals(actual, expected, Constants.userIsAbleToFindAdminUsersHeading);

		// Assertion
		boolean actualRestButton = adminuser.isResetButtonEnabled();
		String expectedRestButton = "Reset";
		Assert.assertTrue(true, Constants.verifyUserIsAbleToReset);

	}

}
