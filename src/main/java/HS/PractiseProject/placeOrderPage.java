package HS.PractiseProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import HS.PractiseProject.Abstract.Abstract;

public class placeOrderPage extends Abstract{
	
	WebDriver driver;
	 public placeOrderPage(WebDriver driver)
	 {
		 super(driver);
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(css="input[placeholder='Select Country']")
	 WebElement countryDropdown;
	 
	 @FindBy(xpath = "(//span[@class='ng-star-inserted'])[2]")
	 WebElement countrySelection;
	 
	 @FindBy(css="a[class*='btnn action__submit']")
	 WebElement placeorderbutton;
	 
	 By dropdownBackgorund = By.cssSelector("section[class*='ta-results']");
	 
	 public WebElement countryDropdown()
	 {
		return countryDropdown;
	 }
	 
	 public void countrySelection(String countyAbbr)
	 {
		 	Actions a = new Actions(driver);
			a.sendKeys(countryDropdown, countyAbbr).build().perform();
			waitForElementVisible(dropdownBackgorund);
			countrySelection.click();
			
	 }
	 
	 public confirmationPage placeOrderButton()
	 {
		 placeorderbutton.click();
		 confirmationPage confirmationpageobj = new confirmationPage(driver);
		 return confirmationpageobj;
	 }
	 

}
