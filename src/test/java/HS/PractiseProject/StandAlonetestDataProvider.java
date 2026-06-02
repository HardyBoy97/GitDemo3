package HS.PractiseProject;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import Base.Base;
import Base.Retry;


public class StandAlonetestDataProvider extends Base {

	
		/*@Test(dataProvider="getData")
		public void submitOrder(String username, String password, String productName, String countyAbbr) throws IOException
		{
		
		
		
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
		
		@DataProvider
		public Object[][] getData()
		{
			return new Object[][] {{"hardiksonigra97@gmail.com", "Test1234", "iphone 13 pro", "Ind"}, {"hardyboy959595@gmail.com", "Test1234", "ADIDAS ORIGINAL", "New"}};
		}*/
	//---------------------------------------------------------------------------------------
	
	/*@Test(dataProvider="getData")
	public void submitOrder(HashMap<String, String> input) throws IOException
	{
	
	
	
	loginPage loginpageobj = lunchApplication();
	
	
	ProductKatalog productcatalogobj = loginpageobj.login(input.get("username"), input.get("password"));
	
	productcatalogobj.addToCart(input.get("productName"));
	cartPage cartpageobj = productcatalogobj.cartButtonlink();

	Boolean match = cartpageobj.verifyCartProduct(input.get("productName"));
	Assert.assertTrue(match);
	placeOrderPage placeorderpageobj = cartpageobj.checkoutButton();

	
	placeorderpageobj.countrySelection(input.get("countryAbbr"));
	confirmationPage confirmationpageobj = placeorderpageobj.placeOrderButton();
	
	String actualText = confirmationpageobj.verifyMessage();
	Assert.assertTrue(actualText.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
	
	driver.close();
	System.out.println("Pass");
	

	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("username", "hardiksonigra97@gmail.com");
		map.put("password", "Test1234");
		map.put("productName", "iphone 13 pro");
		map.put("countryAbbr", "Ind");
		
		HashMap map2 = new HashMap();
		map2.put("username", "hardyboy959595@gmail.com");
		map2.put("password", "Test1234");
		map2.put("productName", "ADIDAS ORIGINAL");
		map2.put("countryAbbr", "New");
		
		return new Object[][] {{map}, {map2}};
	}*/
	//---------------------------------------------------
	
	@Test(dataProvider="getData", retryAnalyzer = Retry.class)
	public void submitOrder(HashMap<String, String> input) throws IOException
	{
	
	
	
	loginPage loginpageobj = lunchApplication();
	
	
	ProductKatalog productcatalogobj = loginpageobj.login(input.get("username"), input.get("password"));
	
	productcatalogobj.addToCart(input.get("productName"));
	cartPage cartpageobj = productcatalogobj.cartButtonlink();

	Boolean match = cartpageobj.verifyCartProduct(input.get("productName"));
	Assert.assertTrue(match);
	placeOrderPage placeorderpageobj = cartpageobj.checkoutButton();

	
	placeorderpageobj.countrySelection(input.get("countryAbbr"));
	confirmationPage confirmationpageobj = placeorderpageobj.placeOrderButton();
	
	String actualText = confirmationpageobj.verifyMessage();
	Assert.assertTrue(actualText.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
	
	driver.close();
	System.out.println("Pass");
	

	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>> data = getJsonData();
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}
	
	// for the Jenkins Schedule:
	//*          *      *                   *              *
	//(Minutes) (Hour) (Date of the Month) (Month Number) (Day number of week) 
}
