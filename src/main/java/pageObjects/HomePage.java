package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;

	By originField = By.xpath(
			"/html//div[@id='searchbox-sbox-box-flights']/div/div[@class='sbox5-layout']/div[@class='sbox5-box-container--1Ro43']/div[@class='sbox5-box-content--2pcCl sbox5-flightType-roundTrip--fSJm8']/div[@class='sbox5-segments--lzKBc']/div[1]/div[@class='sbox5-places-component--1i-wZ']/div[@class='sbox-places-container--3kBK7 sbox-places-origin-destination']/div[1]/div[1]/div[@class='input-container']/input[@type='text']");
	By originsList = By.xpath("//body/div[8]/div/div[1]/ul[@class='ac-group-items']/li[1]/span[@class='item-text']");
	By destinationField = By.xpath("(//input[@placeholder='Ingresa hacia dónde viajas'])[1]");
	By destinationList = By
			.xpath("//body/div[8]/div/div[1]/ul[@class='ac-group-items']/li[1]/span[@class='item-text']");
	By cookiesBtn = By.xpath("//*[@id=\"lgpd-banner\"]/div/div");
	By benefitsBtn = By.xpath("/html/body/nav/div[4]/div[2]/span");

	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getOriginField() {
		return driver.findElement(originField);
	}

	public List<WebElement> getOriginsList() {
		return driver.findElements(originsList).size() != 0 ? driver.findElements(originsList) : null;
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

	public List<WebElement> getDestinationList() {
		List<WebElement> item = driver.findElements(destinationList);
		System.out.println(item);
		return item.size() != 0 && item.get(0).getText().replaceAll("\\s", "") != "" ? item : null;
	}
}
