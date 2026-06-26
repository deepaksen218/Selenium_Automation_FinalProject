/*package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewNewsPage {
	
	public WebDriver driver;

	public AddNewNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
		// Element locators for New Button and related fields
	
		@FindBy(xpath = "//textarea[@id='news']")
		WebElement enterNewsText;
		
		@FindBy(xpath = "//textarea[@id='news']")
		WebElement enterNewsTextFake;
		
		@FindBy(xpath = "//button[@type='submit']")
		WebElement newsSaveButton;
		
		@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
		WebElement newsSuccess;
		
		
		
//---------------------------------------------------------------
		
		public AddNewNewsPage enterNewTextInTheField() {
			enterNewsText.sendKeys("Dummy Sample News- HardCoded");
			return this;
		}
		
		public AddNewNewsPage enterNewTextInTheFieldFaker(String fakeNews, String sen ) {
			enterNewsTextFake.sendKeys(fakeNews, sen);
			return this;
		}
		
		public AddNewNewsPage clickOnNewsSaveButton() {
			newsSaveButton.click();
			return this;
		}
		
		// Assertion
		public  boolean alertNewsMessageIsSuccess() {
			return newsSuccess.isDisplayed();
		}
		
		
}*/


