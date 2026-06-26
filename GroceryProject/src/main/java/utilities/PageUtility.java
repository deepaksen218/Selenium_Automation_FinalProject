package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

// Its is helper class
// here we declare the drowpdown, Checkbox, mouse actions will be decleared here and will call from here
// NOTE: .click or .sendkey should not be decleared here

public class PageUtility {

	public void selectByValue(WebElement element, String Value) {
		Select select = new Select(element);
		select.selectByValue(Value);
	}

	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void windowScrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}

	public void windowScrollUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)", "");
	}
	
	public void rightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	

}
