package HS.PractiseProject;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Base;



public class StandAlonetest extends Base {

	
		@Test
		public void submitOrder() throws IOException
		{
		
		
		String productName = "iphone 13 pro";
		String countyAbbr = "Ind";
		String username = "hardiksonigra97@gmail.com";
		String password = "Test1234";
		
		loginPage loginpageobj = lunchApplication();
		
		
		ProductKatalog productcatalogobj = loginpageobj.login(username, password);
		
		productcatalogobj.addToCart(productName);
		cartPage cartpageobj = productcatalogobj.cartButtonlink();
	
		Boolean match = cartpageobj.verifyCartProduct(productName);
		Assert.assertTrue(match);
		placeOrderPage placeorderpageobj = cartpageobj.checkoutButton();

		
		placeorderpageobj.countrySelection(countyAbbr);
		confirmationPage confirmationpageobj = placeorderpageobj.placeOrderButton();
		
		String actualText = confirmationpageobj.verifyMessage();
		Assert.assertTrue(actualText.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
		driver.close();
		System.out.println("Pass");
		
	
		}
}
