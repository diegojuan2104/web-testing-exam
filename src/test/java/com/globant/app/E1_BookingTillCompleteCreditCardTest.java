package com.globant.app;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//STEP 1. Search for a flight from LAS to LAX
		HomePage home = new HomePage(driver);
		wait.until(ExpectedConditions.visibilityOf(home.getFlightsBtn()));
		home.getFlightsBtn().click();
		wait.until(ExpectedConditions.visibilityOf(home.getOriginBtn()));
		home.getOriginBtn().click();
		wait.until(ExpectedConditions.visibilityOf(home.getOriginField()));
		home.getOriginField().click();
		home.getOriginField().sendKeys("LAS");
		
		System.out.println(home.getOriginsList().size());
		for(WebElement origin:home.getOriginsList()) {
			if(origin.getText().contains("Las Vegas (LAS - Harry Reid Intl.)")) {
				origin.click();
			}
		}
		
		Thread.sleep(10000);
	}
	
}
