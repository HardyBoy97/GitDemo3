package StepDefinations;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Base;
import HS.PractiseProject.ProductKatalog;
import HS.PractiseProject.cartPage;
import HS.PractiseProject.confirmationPage;
import HS.PractiseProject.loginPage;
import HS.PractiseProject.placeOrderPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepdeDefiImp extends Base{
	
	public loginPage loginpageobj;
	public ProductKatalog productcatalogobj;
	public cartPage cartpageobj;
	public placeOrderPage placeorderpageobj;
	public confirmationPage confirmationpageobj;
	
	@Given("The user is landed on the ECommerce page")
	public void The_user_is_landed_on_the_ECommerce_page() throws IOException
	{
		loginpageobj = lunchApplication();
	}
	
	@Given("^Logged in with the username (.+) and password (.+)$")
	public void Logged_in_with_the_username_and_password(String username, String password)
	{
		productcatalogobj = loginpageobj.login(username, password);
	}
	
	@When("^I add the product (.+) to cart$")
	public void I_add_the_product_to_cart(String productName)
	{
		productcatalogobj.addToCart(productName);
	}
	
	@And("^checkout (.+) and select the country (.+) Submit the order$")
	public void checkout_and_Submit_the_order(String productName, String countryAbbr)
	{
	 cartpageobj = productcatalogobj.cartButtonlink();

		Boolean match = cartpageobj.verifyCartProduct(productName);
		Assert.assertTrue(match);
		 placeorderpageobj = cartpageobj.checkoutButton();

		
		placeorderpageobj.countrySelection(countryAbbr);
		 confirmationpageobj = placeorderpageobj.placeOrderButton();
	}
	
	@Then("{string} message is displayed")
	public void message_is_displayede(String msg)
	{
		String actualText = confirmationpageobj.verifyMessage();
		Assert.assertTrue(actualText.equalsIgnoreCase(msg));
		
		
		driver.close();
		System.out.println("Pass");
	}

}
