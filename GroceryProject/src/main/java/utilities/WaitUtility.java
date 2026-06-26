package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

	// Task: define 5 explicit waits
	public static int explicitwait = 5;

	public void waitUntilElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitwait)); // giving explicit wait
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitUntilElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitwait)); // giving explicit wait
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	public void waitUntilElementToBeSelected(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitwait)); // giving explicit wait
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	public void waitUntilElementTextToBePresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitwait)); // giving explicit wait
		wait.until(ExpectedConditions.textToBePresentInElementValue(element,"7rmart supermarket" ));
	}
	
	public void waitUntilElementStateToBeEnable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitwait)); // giving explicit wait
		wait.until(ExpectedConditions.elementSelectionStateToBe(element, true));
	}

}
