package Assignment_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Assignment1 {
	static WebDriver driver = null;

	@Given("^Browser is open$")
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/PriSahay/Documents/Projects/Selenium/Driver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@When("^amazon.com is searched$")
	public void goToAmazon() {
		driver.navigate().to("https://www.amazon.com/");
	}

	@Then("^amazon.com opens successfully$")
	public void validateWebsite() {

		if (driver.getTitle().contains("Amazon.com")) {
			System.out.println("Test 1: Amazon webpage open Pass");
		} else {
			System.out.println("Test 1: Amazon webpage open Fail");
		}
	}

	// Scenario 2
	@Given("^amazon.com is open$")
	public void pageCheck() {
		System.out.println("Test 2: amazon.com is open");
	}

	@When("^Search for a book called appium$")
	public void itemSearch() {

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Appium book");
		driver.findElement(By.xpath("//input [@type = 'submit'] [@value = 'Go']")).click();
	}

	@Then("^books with title including appium are listed$")
	public void itemSearchCheck() {
		String textCheck = driver.findElement(By.xpath("//span [@class = 'a-color-state a-text-bold'] ['Appium book']"))
				.getText();
		if (textCheck.contains("Appium")) {
			System.out.println("Test 2: Book search Pass");
		} else {
			System.out.println("Test 2: Book search Fail");
		}
	}

	// Scenario 3
	@Given("^required book listed$")
	public void pageValidate() {
		System.out.println("Test 3: All appium books are listed");
	}

	@When("^select 10th book$")
	public void itemSelect() {

		driver.findElement(By.cssSelector("[data-image-index=\"10\"]")).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^the selected book's page opens$")
	public void itemPage() {
		String bookTitle = driver.findElement(By.xpath("//span [@id = 'productTitle']")).getText();
		System.out.println("Test 3: Name of the 10th book is " + bookTitle);
	}
//Scenario 4

	@Given("^the selected book's page is open$")
	public void selectedItem() {
		System.out.println("Test 4: Selected appium book's page is displayed");
	}

	@When("^query the rating of the book$")
	public void selectedBookRating() {

		String rating = driver.findElement(By.xpath("//span [@id = 'acrPopover']")).getAttribute("title");
		System.out.println("Test 4: Rating of the selected Appium book is " + rating);
	}

	@Then("^the rating is fetched successfully$")
	public void displayRating() {

		System.out.println("Test 4: Fetch rating successful");

	}
//Scenario 5

	@Given("^the selected book's page is open and rating fetched$")
	public void webPageOpen() {
		System.out.println("Test 5: Selected appium book's page is open");
	}

	@When("^click on add to cart$")
	public void addToCart() {

		driver.findElement(By.id("rentButton")).click();
		// System.out.println("Test 4: Rating of the selected Appium book is " +
		// rating);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^the book is added to cart$")
	public void checkCart() {
		String cart = driver.findElement(By.xpath("//h1 [@class = 'a-size-medium a-text-bold']")).getText();
		if (cart.equalsIgnoreCase("Added to cart")) {
			System.out.println("Test 5: Adding book to cart successful");
		} else {
			System.out.println("Test 5: Adding book to cart fail");
		}

	}

	// Scenario 6

	@Given("^the book is in the cart$")
	public void finalStep() {
		System.out.println("Test 6: Book is added to the cart");
	}

	@When("^search for the price of the book$")
	public void bookPrice() {

		String price = driver
				.findElement(By.xpath("//span [@class = 'a-color-price hlb-price a-inline-block a-text-bold']"))
				.getText();
		System.out.println("Test 6: Price of the book is " + price);

	}

	@Then("^price of the book is retrieved$")
	public void printPrice() {
		System.out.println("Test 6: Price retrieval of the book successful");

	}
}

//	// driver.close();