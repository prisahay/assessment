package Assignment_3.library;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;

public class Keywords {

	Operations operations = new Operations();

	public void perform(String keyword, String object, String type, String test_data, Properties props) {
		switch (keyword) {
		case "GOTOURL":
			operations.gotoUrl(props.getProperty(test_data));
			break;

		case "SEARCH":
			String property = props.getProperty(object);
			WebElement element;
			System.out.println("ID is" + type);
			if (type.equalsIgnoreCase("id"))
				element = operations.findById(property);
			else
				element = operations.findByXpath(property);
			operations.type(element, props.getProperty(test_data));
			break;

		case "CLICK":
			property = props.getProperty(object);
			if (type.equalsIgnoreCase("id"))
				element = operations.findById(property);
			else
				element = operations.findByXpath(property);
			operations.click(element);
			break;

		case "GOTOITEM":
			property = props.getProperty(object);
			if (type.equalsIgnoreCase("id"))
				element = operations.findById(property);
			else
				element = operations.findByXpath(property);
			operations.click(element);
			break;

		case "COMPCHART":
			property = props.getProperty(object);
			if (type.equalsIgnoreCase("id"))
				element = operations.findById(property);
			else
				element = operations.findByXpath(property);
			Boolean chart = operations.display(element);
			System.out.println("Comparison table display is " + chart);
			// assertTrue (operations.isDisplayed(element));

			break;

		case "RATING":
			property = props.getProperty(object);
			List<WebElement> ratingelements = operations.mFunctions("span");
			// System.out.println(ratingelements.size());
			String rtxt = null;
			for (int i = 1; i < ratingelements.size(); i++) {
				try {
					String ratingtxt = ratingelements.get(i).getAttribute("class");

					String rt = "out of 5";
					if (ratingtxt.equals("a-icon-alt"))
			
						rtxt = ratingelements.get(i).getAttribute("innerText");
					if (rtxt.contains(rt))
						System.out.println("Rating is" + rtxt);
					break;
				} catch (Exception e) {
					
					continue;
				}

			}
			break;

		case "AMOUNT":
			property = props.getProperty(object);
			if (type.equalsIgnoreCase("id"))
				element = operations.findById(property);
			else
				element = operations.findByXpath(property);
			String amount = operations.value(element);
			System.out.println("Total amount is " + amount);
			// assertTrue (operations.isDisplayed(element));

		}
	}
}
