package com.globant.app;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BasePage;
import pageObjects.DetailsPage;
import pageObjects.HomePage;
import pageObjects.ResultsPage;

public class E1_BookingTillCompleteCreditCardTest extends BasePage {
	
	
	public E1_BookingTillCompleteCreditCardTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeTest
	public void setup() throws IOException {
		driver = getDriver();
		driver.get(getUrl());
	}
	
	@AfterTest
	public void tearDown() {
	driver.close();
	driver = null;
	}
	
	
	@Test(priority=1)
	public void searchFlight() throws InterruptedException {
		
	    FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
	                .withTimeout(Duration.ofSeconds(30))
	                .pollingEvery(Duration.ofSeconds(1))
	                .ignoring(NoSuchElementException.class);
	    
	     WebDriverWait wait = new WebDriverWait(driver, 10); 
	    
	    
		//STEP 1. Search for a flight from LAS to LAX
		HomePage home = new HomePage(driver);
		home.getBenefitsBtn().click();
		home.getCookiesBtn().click();
		
		//Select Origin
		home.getOriginField().click();
		home.getOriginField().clear();
		home.getOriginField().sendKeys("LAS");
		
		
		Function<WebDriver, WebElement> getOriginBtnCondition = webDriver -> home.getOriginBtn();
		fluentWait.until(getOriginBtnCondition);
		home.getOriginBtn().click();
		
		//Select destination 
		Function<WebDriver, WebElement> getDestinationFieldCondition = webDriver -> home.getDestinationField();
		fluentWait.until(getDestinationFieldCondition);
		home.getDestinationField().click();
		home.getDestinationField().clear();
		home.getDestinationField().sendKeys("L");
		home.getDestinationField().sendKeys("A");
		home.getDestinationField().sendKeys("X");
			
		Function<WebDriver, WebElement> getDestinationBtnCondition = webDriver -> home.getDestinationBtn();
		fluentWait.until(getDestinationBtnCondition);
		home.getDestinationBtn().click();
		
		//Select departure date
		home.getDepartureDateField().click();
		home.getDepartureDateBtn().click();
		
		
		//Select arrival date
		home.getarrivalDateField().click();
		home.getcalendarNextBtn().click();
		home.getcalendarNextBtn().click();
		home.getArrivalDateBtn().click();
		home.getApplyDatesBtn().click();
		
		
		//Search 
		home.getSearchBtn().click();
	}
	
	
	@Test(priority=2)
	public void filterOptions() throws InterruptedException {
		
		ResultsPage resultsPage = new ResultsPage(driver);
		
	    FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
	    
	    
	    
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		if(tabs.size() > 1) {
			  driver.switchTo().window(tabs.get(1));
		}
		
     
		Function<WebDriver, WebElement>getbenefitsBtnCondition = webDriver ->	resultsPage.getBenefitsBtn();
		fluentWait.until(getbenefitsBtnCondition);
		
		resultsPage.getBenefitsBtn().click();
		
		//Change to the second tab Sometimes the page creates another tab with the results 

		//STEP 2. Verify the result page using the following:
		
		//a. There is a box that allow you to order by Price, Departure, Arrival and Duration.
		
		Function<WebDriver, WebElement> getPriceFilterCondition = webDriver ->	resultsPage.getPriceFilter();
		fluentWait.until(getPriceFilterCondition);
		
		resultsPage.getPriceFilter();
		resultsPage.getDepartureFilter();
		resultsPage.getDepartureFilter();
		resultsPage.getDurationFilter();
		

	}
	
	@Test(priority=3)
	public void selectButtonPresentOnEveryResult() {
		
		//b. The select button is present on every result
		ResultsPage resultsPage = new ResultsPage(driver);
			
		for (WebElement item: resultsPage.getResultsList()) {
			if(!item.getText().equalsIgnoreCase("Comprar")) {		
				throw new RuntimeException("This element do not have a select button correct because the text is => " + item.getText());
			}
		}
		
	}
	
	@Test(priority=4)
	public void verifyTripDetails() {
	ResultsPage resultsPage = new ResultsPage(driver);
	DetailsPage detailsPage = new DetailsPage(driver);
	  FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
	    
	 
	
	   
	   resultsPage.getBuyBtnFirstOption().click(); 
	   
	   //6. Verify trip details in the new page, by:
	   //a. Trip total price is present
	   
	   Function<WebDriver, WebElement> getTotalPriceTextCondition = webDriver -> detailsPage.getTotalPriceText();
	   fluentWait.until(getTotalPriceTextCondition);
	   detailsPage.getTotalPriceText();
	   
	   //b. Departure and return information is present
	   
	   detailsPage.getReturnDateText();
	   detailsPage.getReturnDateText();
	   
	   
	}
	
	
	
	
}
