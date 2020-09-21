package Assignment_3.library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Operations {
	static WebDriver driver = null;

	public Operations() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/PriSahay/Documents/Projects/Selenium/Driver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	/**
	 * @brief Mapping for Keyword GOTOURL
	 */
	public void gotoUrl(String url)
	{
		System.out.println("URL: " + url);
		driver.navigate().to(url);
	}
	
	/**
	 * @return WebElement
	 * @brief Mapping for SEARCH
	 */
	public WebElement findById(String id)
	{
		return driver.findElement(By.id(id));
	}

	/**
	 * @return WebElement
	 * @brief Mapping for SEARCH
	 */
	public WebElement findByXpath(String xpath)
	{
		return driver.findElement(By.xpath(xpath));
	}
	
	/**
	 * @brief  Type text in an element
	 */
	public void type(WebElement e, String text)
	{
		e.sendKeys(text);
	}
	
	/**
	 * @brief  Click action
	 */
	public void click(WebElement e)
	{
		e.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException f) {
			// TODO Auto-generated catch block
			f.printStackTrace();
		}
	}
	
	/**
	 * @brief  Display action
	 */
	public boolean display (WebElement e)
	{
		return e.isDisplayed();
	}
	
	/**
	 * @brief  Return multiple functions
	 */
	public List<WebElement> mFunctions (String text)
	{
		return driver.findElements(By.tagName(text));
		
	}
	
	/**
	 * @brief  Get Attribute action
	 */
	public String value (WebElement e)
	{
		return e.getText();
	}
	}
