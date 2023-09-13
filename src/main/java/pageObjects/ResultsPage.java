package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ResultsPage {

	public WebDriver driver;
    //a. There is a box that allow you to order by Price, Departure and Arrival.
	By benefitsBtn = By.cssSelector(".login-aggressive--button.login-aggressive--button-close.shifu-3-btn-ghost");
    By priceFilter = By.cssSelector(".priceRange .filters-text-label.item-label > span");
    By departureFilter = By.cssSelector("filter-group#filter-time  .container-filter.dropdown-item-container  .filters-text-label.item-label > span");
    By durationFilter = By.cssSelector(".duration .filters-text-label.item-label > span");
    By resultsList = By.cssSelector("#clusters span .cluster-pricebox-container .btn-text");
   
    By BuyBtnFirstOption =  By.cssSelector("#clusters > span:nth-of-type(1) buy-button");
			
	public ResultsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public WebElement getBenefitsBtn() {
		return driver.findElement(benefitsBtn);
	}

    public WebElement getPriceFilter() {
        return driver.findElement(priceFilter);
    }

    public WebElement getDepartureFilter() {
        return driver.findElement(departureFilter);
    }

    public WebElement getDurationFilter() {
        return driver.findElement(durationFilter);
    }
    
    public List<WebElement> getResultsList() {
		return driver.findElements(resultsList);
	}
    
    public WebElement getBuyBtnFirstOption() {
        return driver.findElement(BuyBtnFirstOption);
    }
}
