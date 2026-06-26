/*package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import pages.AddNewNewsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;


public class AddNewNewsTest extends BaseClass{
	
	@Test(description = "Validating User is able to Add new News(Hardcoded value)")
	public void verifyUserIsAbleToEnterNewNews() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0, 0, "SignInPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "SignInPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernameValue);
		login.enterPasswordOnPasswordField(passwordValue);
		login.clickOnSigninButton();
		
		HomePage home = new HomePage(driver);
		home.clickOnManageNewsMoreInfoButton();
		
		
		ManageNewsPage manageNews = new ManageNewsPage(driver);
		manageNews.clickOnNewButton();
		
		AddNewNewsPage newNews = new AddNewNewsPage(driver);
		newNews.enterNewTextInTheField(); //  here the Hardcoded value will come from AddNewNewsPage
		newNews.clickOnNewsSaveButton();
		
		boolean successNews = newNews.alertNewsMessageIsSuccess();
		Assert.assertTrue(successNews, "User is unable to create a new News");
		
	}
	//------trying to generate random news
	
	@Test(description = "Validating User is able to add random news using Faker class")
	public void verifyUserIsAbleToEnterNewNewsWithFaker() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0, 0, "SignInPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "SignInPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernameValue);
		login.enterPasswordOnPasswordField(passwordValue);
		login.clickOnSigninButton();
		
		HomePage home = new HomePage(driver);
		home.clickOnManageNewsMoreInfoButton();
		
		FakerUtility faker = new FakerUtility();
		
		ManageNewsPage manageNews = new ManageNewsPage(driver);
		manageNews.clickOnNewButton();
		
		String fakeNews = faker.generateRandomText();
		
		AddNewNewsPage newNews = new AddNewNewsPage(driver);
		newNews.enterNewTextInTheFieldFaker(fakeNews, "sen");
		newNews.clickOnNewsSaveButton();
		
		boolean successNews = newNews.alertNewsMessageIsSuccess();
		Assert.assertTrue(successNews, "User is unable to create a new News");
		
	}
	
	//---- NOTE need to create Search and Reset- DONE 
	// NOTE: is should be added in the ManageNews Page and ManageNewsTest- DONE
	

}*/
