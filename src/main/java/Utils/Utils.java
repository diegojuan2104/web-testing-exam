package Utils;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

public class Utils {
	
	
	public static void mangeFluentWait(WebDriver driver, WebElement webElement ) {
		  FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
	                .withTimeout(Duration.ofSeconds(30))
	                .pollingEvery(Duration.ofSeconds(1))
	                .ignoring(NoSuchElementException.class);
		  
		  Function<WebDriver, WebElement> condition = webDriver -> webElement;
			fluentWait.until(condition);
	}
}
