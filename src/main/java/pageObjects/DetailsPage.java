package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class DetailsPage {

	public WebDriver driver;
    By totalPriceText = By.cssSelector(".-eva-3-tr.-sm-8.col .amount");
    By departureDateText = By.cssSelector("div:nth-of-type(1) > product-dates-v2 > .-eva-3-mt-md.-no-gutter.eva-3-row  .-eva-3-bold.-eva-3-mb-xsm.dm-date");
    By returnDateText = By.cssSelector("div:nth-of-type(2) > product-dates-v2 > .-eva-3-mt-md.-no-gutter.eva-3-row  .-eva-3-bold.-eva-3-mb-xsm.dm-date");
    
    
    
	public DetailsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	

    public WebElement getDepartureDateText() {
        return driver.findElement(departureDateText);
    }

    public WebElement getReturnDateText() {
        return driver.findElement(returnDateText);
    }

    public WebElement getTotalPriceText() {
        return driver.findElement(totalPriceText);
    }
}
