package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;

	
	By flightsBtn = By.xpath("//span[normalize-space()='Vuelos']");
	By originBtn = By.xpath("//button[@aria-label='Origen']");
	By originField = By.cssSelector(".uitk-typeahead-input-v2");
	By originsList = By.cssSelector("[data-stid] [data-stid='origin_select-result-item'] span strong");
	
	
	
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public WebElement  getFlightsBtn() {
		return driver.findElement(flightsBtn);
	}
	

	public WebElement  getOriginBtn() {
		return driver.findElement(originBtn);	
	}

    public WebElement  getOriginField() {
        return driver.findElement(originField);
    }
    
    public List<WebElement>  getOriginsList() {
        return driver.findElements(originsList);
    }
}


