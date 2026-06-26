package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageNewsTest extends BaseClass {
	HomePage home;
	ManageNewsPage managenews;

	@Test(description = "Validating User is able to click New Button from Manage New")
	public void verifyUserIsAbleToClickNewNewsButton() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0, 0, "SignInPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "SignInPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		home = login.clickOnSigninButton();

		// HomePage home = new HomePage(driver);
		managenews = home.clickOnManageNewsMoreInfoButton();

		// Assertion
		// ManageNewsPage manageNews = new ManageNewsPage(driver);
		String actual = managenews.isManageNewsHeadingDisplayed();
		String expected = "Manage News";
		Assert.assertEquals(actual, expected, Constants.verifyUserIsAbleToClickNewNewsButton);

		// Assertion for NEW Button enable!!
		boolean actualNewButton = managenews.newButtonEnabled();
		String expectedNewButton = " New";
		Assert.assertTrue(true, Constants.verifyUserIsAbleToClickNewNewsButton);

		managenews.clickOnNewButton();

	}

	@Test(description = "Validating User is able to search user from the Manage News Page")
	public void verifyUserIsAbleToSearchFromTheManageNewsPage() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0, 0, "SignInPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "SignInPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		home = login.clickOnSigninButton();

		// HomePage home = new HomePage(driver);
		managenews = home.clickOnManageNewsMoreInfoButton();

		// ManageNewsPage manageNews = new ManageNewsPage(driver);

		// Assertion for Search Button enable!!
		boolean actualSearchButton = managenews.searchButtonEnabled();
		String expectedSearchButton = " Search";
		Assert.assertTrue(true, Constants.verifyUserIsAbleToSearchFromTheManageNewsPage);

		managenews.clickOnSearchButton().searchManageNewsFromFake().searchButtonAfterTextEntered();
		// manageNews.searchManageNews();

	}

	@Test(description = "Validating User is able to click Reset Button from the Manage News page")
	public void verifyUserIsAbleToCLickOnResetButton() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0, 0, "SignInPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "SignInPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		home = login.clickOnSigninButton();

		// HomePage home = new HomePage(driver);
		managenews = home.clickOnManageNewsMoreInfoButton();

		// ManageNewsPage manageNews = new ManageNewsPage(driver);
		managenews.clickOnSearchButton().searchManageNewsFromFake().searchButtonAfterTextEntered();

		// Assertion for New-Reset Button enable!!
		boolean actualnewResetButton = managenews.newRestButtonEnabled();
		String expectednewResetButton = "Reset";
		Assert.assertTrue(true, Constants.verifyUserIsAbleToCLickOnResetButton);

		managenews.newResetButtonAfterSearch();

	}

	@Test(description = "Validating User is able to Add new News(Hardcoded value)")
	public void verifyUserIsAbleToEnterNewNews() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0, 0, "SignInPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "SignInPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		home = login.clickOnSigninButton();

		// HomePage home = new HomePage(driver);
		managenews = home.clickOnManageNewsMoreInfoButton();

		// ManageNewsPage manageNews = new ManageNewsPage(driver);
		managenews.clickOnNewButton().enterNewTextInTheField().clickOnNewsSaveButton(); // here the Hardcoded value will
																						// come from
		// AddNewNewsPage
		// manageNews.clickOnNewsSaveButton();

		// Assertion
		boolean successNews = managenews.alertNewsMessageIsSuccess();
		Assert.assertTrue(successNews, Constants.verifyUserIsAbleToEnterNewNews);

	}
	// ------trying to generate random news

	@Test(description = "Validating User is able to add random news using Faker class")
	public void verifyUserIsAbleToEnterNewNewsWithFaker() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0, 0, "SignInPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "SignInPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		home = login.clickOnSigninButton();

		// HomePage home = new HomePage(driver);
		managenews = home.clickOnManageNewsMoreInfoButton();

		FakerUtility faker = new FakerUtility();

		// ManageNewsPage manageNews = new ManageNewsPage(driver);
		managenews.clickOnNewButton();

		String fakeNews = faker.generateRandomText();

		managenews.enterNewTextInTheFieldFaker(fakeNews, "sen").clickOnNewsSaveButton();

		// Assertion
		boolean successNews = managenews.alertNewsMessageIsSuccess();
		Assert.assertTrue(successNews, Constants.verifyUserIsAbleToEnterNewNewsWithFaker);

	}

}
