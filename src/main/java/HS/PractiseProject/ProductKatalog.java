package HS.PractiseProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import HS.PractiseProject.Abstract.Abstract;

public class ProductKatalog extends Abstract {
	
	WebDriver driver;
	public ProductKatalog(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(css="div[class*='mb-3']")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By byname = By.cssSelector("div[class*='mb-3']");
	By addtocartbutton = By.cssSelector("div[class='card-body'] button:last-of-type");
	By toast = By.id("toast-container");
	
	public List<WebElement> getProducts()
	{
		waitForElementVisible(byname);
		return products;
	}
	
	public WebElement getProduct(String productName)
	{
		WebElement product = getProducts().stream().filter(p -> p.findElement(By.tagName("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		return product;
	}
	
	public void addToCart(String productName)
	{
		WebElement product = getProduct(productName);
		product.findElement(addtocartbutton).click();
		waitForElementVisible(toast);
		invisibilityOfElement(spinner);
	}

}
