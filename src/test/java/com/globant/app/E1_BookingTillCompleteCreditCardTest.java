package com.globant.app;

import java.io.IOException;
import java.time.Duration;
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
import pageObjects.HomePage;

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
//		driver.close();
//		driver = null;
	}
	
	@Test
	public void endToEndTest() throws InterruptedException {
		
	    FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
	                .withTimeout(Duration.ofSeconds(30))
	                .pollingEvery(Duration.ofSeconds(1))
	                .ignoring(NoSuchElementException.class);
	    
	    
		//STEP 1. Search for a flight from LAS to LAX
		HomePage home = new HomePage(driver);
		home.getBenefitsBtn().click();
		
		home.getCookiesBtn().click();
		
		home.getOriginField().click();
		home.getOriginField().clear();
		home.getOriginField().sendKeys("LAS");
//		
//		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		
		Function<WebDriver, List<WebElement>> getOriginsListCondition = webDriver -> home.getOriginsList();
		fluentWait.until(getOriginsListCondition);
		
		
		System.out.println(home.getOriginsList());
		for(WebElement origin:home.getOriginsList()) {
			if(origin.getText().contains("Las Vegas, Nevada, Estados Unidos")) {
				origin.click();
			}
		}
		
		home.getDestinationField().click();
		home.getDestinationField().sendKeys("L");
		home.getDestinationField().sendKeys("A");
		home.getDestinationField().sendKeys("X");
		
		
	    FluentWait<WebDriver> fluentWait2 = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
		
		Function<WebDriver, List<WebElement>> getDestinationListCondition = webDriver -> home.getDestinationList();
		fluentWait2.until(getDestinationListCondition);
		
		Thread.sleep(500);
		for(WebElement destination:home.getDestinationList()) {
			System.out.println(destination.getText());
			if(destination.getText().contains("Los Ángeles, California, Estados Unidos")) {
				destination.click();
			}
		}
//		
//         Thread.sleep(5000);
	}
	
}
