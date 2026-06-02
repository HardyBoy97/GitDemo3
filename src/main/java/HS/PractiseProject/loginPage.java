package HS.PractiseProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HS.PractiseProject.Abstract.Abstract;

public class loginPage extends Abstract {
	
	WebDriver driver;
	
	public loginPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement username;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement loginbtn;
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	}
	
	public ProductKatalog login(String uname, String pass)
	{
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginbtn.click();
		ProductKatalog productcatalogobj = new ProductKatalog(driver);
		return productcatalogobj;
	}
	
	

}
