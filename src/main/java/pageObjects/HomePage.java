package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;

	By originField = By.xpath(
			"/html//div[@id='searchbox-sbox-box-flights']/div/div[@class='sbox5-layout']/div[@class='sbox5-box-container--1Ro43']/div[@class='sbox5-box-content--2pcCl sbox5-flightType-roundTrip--fSJm8']/div[@class='sbox5-segments--lzKBc']/div[1]/div[@class='sbox5-places-component--1i-wZ']/div[@class='sbox-places-container--3kBK7 sbox-places-origin-destination']/div[1]/div[1]/div[@class='input-container']/input[@type='text']");
	By originBtn = By.cssSelector("div:nth-of-type(1) > .ac-group-items > li:nth-of-type(1)");
	
	By destinationField = By.xpath("(//input[@placeholder='Ingresa hacia dónde viajas'])[1]");
	By destinationBtn = By.cssSelector("div:nth-of-type(1) > .ac-group-items > li:nth-of-type(1)");
	
	By cookiesBtn = By.xpath("//*[@id=\"lgpd-banner\"]/div/div");
	By benefitsBtn = By.cssSelector("body > nav > div.login-incentive.login-wrapper.shifu-3-card.-shifu-3-shadow-static.-one-loyalty.login-branch-new-design.-show > div.login-incentive--content > div.login-incentive--button.login-incentive--button-close.shifu-3-btn-ghost");
	
	By departureDateField = By.cssSelector(".sbox5-segments--lzKBc > div:nth-of-type(1)  .sbox5-dates-container > .sbox5-dates-input1-container > .sbox5-dates-input1-flex > .sbox5-dates-input1 .input-tag");
	By departureDateBtn = By.cssSelector("div:nth-of-type(1) > .sbox5-3-floating-tooltip-datepicker-wrapper > div > div:nth-of-type(2) > .sbox5-monthgrid-dates.sbox5-monthgrid-dates-31 > div:nth-of-type(15) > .sbox5-monthgrid-datenumber-number");
	
	By calendarNextBtn = By.cssSelector("div:nth-of-type(1) > .sbox5-3-floating-tooltip-datepicker-wrapper  .calendar-arrow-right");
	By arrivalDateField = By.cssSelector("div:nth-of-type(1) > .sbox5-dates-component--3dTHh > .sbox5-dates-container > .sbox5-dates-input2-container > .sbox5-dates-input2-flex > .sbox5-dates-input2");
	By arrivalDateBtn = By.cssSelector("div:nth-of-type(1) > .sbox5-3-floating-tooltip-datepicker-wrapper .sbox5-monthgrid-dates.sbox5-monthgrid-dates-31 > div:nth-of-type(15) > .sbox5-monthgrid-datenumber-number");
	
	By applyDatesBtn = By.cssSelector("div#component-modals > div:nth-of-type(1) .-md.-primary.sbox5-3-btn");
	
	By searchBtn = By.cssSelector(".-icon.-lg.-secondary.sbox5-3-btn.sbox5-box-button-ovr--3LK5x.sbox5-button"); 
	
	By benefitsBtn2 = By.cssSelector(".login-aggressive--button.login-aggressive--button-close.shifu-3-btn-ghost");
			
			
			
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	
	public WebElement getbenefitsBtn2() {
		return driver.findElement(benefitsBtn2);
	}
	
	public WebElement getOriginField() {
		return driver.findElement(originField);
	}
	
	
	public WebElement getOriginBtn() {
		return driver.findElement(originBtn);
	}
	
	public WebElement getDestinationBtn() {
		return driver.findElement(destinationBtn);
	}
	
	public WebElement getCookiesBtn() {
		return driver.findElement(cookiesBtn);
	}

	public WebElement getBenefitsBtn() {
		return driver.findElement(benefitsBtn);
	}

	public WebElement getDestinationField() {
		return driver.findElement(destinationField);
	}

    public WebElement getDepartureDateField() {
        return driver.findElement(departureDateField);
    }

    public WebElement getDepartureDateBtn() {
        return driver.findElement(departureDateBtn);
    }

    public WebElement getcalendarNextBtn() {
        return driver.findElement(calendarNextBtn);
    }

    public WebElement getArrivalDateBtn() {
        return driver.findElement(arrivalDateBtn);
    }
    
    public WebElement getarrivalDateField() {
        return driver.findElement(arrivalDateField);
    }
    
    public WebElement getApplyDatesBtn() {
        return driver.findElement(applyDatesBtn);
    }
    
    public WebElement getSearchBtn() {
        return driver.findElement(searchBtn);
    }
   
}
