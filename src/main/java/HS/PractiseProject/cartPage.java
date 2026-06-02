package HS.PractiseProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HS.PractiseProject.Abstract.Abstract;

public class cartPage extends Abstract{
	
	WebDriver driver;
	public cartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div[class='cartSection'] h3")
	List<WebElement> cartProducts;
	
	@FindBy(css="li[class='totalRow'] button")
	WebElement checkoutbutton;
	
	public List<WebElement> getCartProducts()
	{
		return cartProducts;
	}
	
	public Boolean verifyCartProduct(String productName)
	{
		Boolean match = getCartProducts().stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public placeOrderPage checkoutButton()
	{
		checkoutbutton.click();
		placeOrderPage placeorderpageobj = new placeOrderPage(driver);
		return placeorderpageobj;
	}

}
