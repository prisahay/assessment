package Assignment_2.library;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;

public class Keywords2 {

	Operations2 operations = new Operations2();

	public void perform(String keyword, String object, String type, String test_data, Properties props) {
		switch (keyword) {
		case "GOTOURL":
			operations.gotoUrl(props.getProperty(test_data));
			break;

		case "SELECTCATEGORY":
			String property = props.getProperty(object);
			WebElement element;
			if (type.equalsIgnoreCase("id"))
				element = operations.findById(property);
			else if (type.equalsIgnoreCase("cssSelector"))
				element = operations.findByCss(property);
			else 
				element = operations.findByXpath(property);
			operations.click(element);
			break;

		case "SELECTSUBCATEGORY":
			property = props.getProperty(object);
			if (type.equalsIgnoreCase("id"))
				element = operations.findById(property);
			else if (type.equalsIgnoreCase("cssSelector"))
				element = operations.findByCss(property);
			else 
				element = operations.findByXpath(property);
			operations.click(element);
			break;

		case "SELECTFINCATEGORY":
			property = props.getProperty(object);
			if (type.equalsIgnoreCase("id"))
				element = operations.findById(property);
			else if (type.equalsIgnoreCase("cssSelector"))
				element = operations.findByCss(property);
			else 
				element = operations.findByXpath(property);
			operations.click(element);
			break;
			
		case "NAVIGATETOITEM":
			property = props.getProperty(object);
			if (type.equalsIgnoreCase("id"))
				element = operations.findById(property);
			else if (type.equalsIgnoreCase("cssSelector"))
				element = operations.findByCss(property);
			else 
				element = operations.findByXpath(property);
			operations.click(element);
			operations.window();
			break;

		case "RATING":
			//operations.window();
			 property = props.getProperty(object);
				if (type.equalsIgnoreCase("id"))
					element = operations.findById(property);
				else if (type.equalsIgnoreCase("cssSelector"))
					element = operations.findByCss(property);
				else 
					element = operations.findByXpath(property);
				String rate = operations.value(element);
				System.out.println("Rating is " + rate);
			break;

		case "AMOUNT":
			//operations.window();
			property = props.getProperty(object);
			if (type.equalsIgnoreCase("id"))
				element = operations.findById(property);
			else if (type.equalsIgnoreCase("cssSelector"))
				element = operations.findByCss(property);
			else 
				element = operations.findByXpath(property);
			String amount = operations.value(element);
			System.out.println("Total amount is " + amount);
		    break;
		    
		case "ADDTOCART":
			//operations.window();
			property = props.getProperty(object);
			if (type.equalsIgnoreCase("id"))
				element = operations.findById(property);
			else if (type.equalsIgnoreCase("cssSelector"))
				element = operations.findByCss(property);
			else 
				element = operations.findByXpath(property);
			operations.click(element);
			System.out.println("Added to cart");
			break;

		}
	}
}
