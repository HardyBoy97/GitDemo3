package HS.PractiseProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class confirmationPage {
	
	WebDriver driver;
	
	public confirmationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="h1[class='hero-primary']")
	WebElement message;
	
	public String verifyMessage()
	{
		String actualText = message.getText();
		return actualText;
	}

}
