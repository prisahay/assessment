package Assignment_2.library;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Operations2 {
	static WebDriver driver = null;

	public Operations2() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/PriSahay/Documents/Projects/Selenium/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	/**
	 * @brief Mapping for GOTOURL
	 */
	public void gotoUrl(String url) {
		System.out.println("URL: " + url);
		driver.navigate().to(url);
	}

	/**
	 * @return WebElement
	 * @brief Mapping for SEARCH by ID
	 */
	public WebElement findById(String id) {
		return driver.findElement(By.id(id));
	}

	/**
	 * @return WebElement
	 * @brief Mapping for SEARCH by XPATH
	 */
	public WebElement findByXpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	/**
	 * @return WebElement
	 * @brief Mapping for SEARCH by CSSSELECTOR
	 */
	public WebElement findByCss(String css) {
		return driver.findElement(By.cssSelector(css));
	}

	/**
	 * @brief Click action
	 */
	public void click(WebElement e) {
		e.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException f) {
			// TODO Auto-generated catch block
			f.printStackTrace();
		}
	}

	/**
	 * @brief Get Attribute action
	 */
	public String value(WebElement e) {
		return e.getText();
	}
//	/**
//	 * @brief  Return multiple functions
//	 */
//	public List<WebElement> mFunctions (String text)
//	{
//		return driver.findElements(By.tagName(text));
//		
//	}
	/**
	 * @brief Handling multiple windows
	 */
	public void window() {
		for (String windowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException f) {
				// TODO Auto-generated catch block
				f.printStackTrace();
			}
		}
	}

}
