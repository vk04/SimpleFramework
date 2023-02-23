package Pages;

import static org.testng.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import com.test.SimpleFramework.simpleFramework.Base;

public class HomePage extends Base {
	// Page Factory - OR:

	@FindBy(xpath = "//a[@class='ico-registe']")

	WebElement verifyLink;

	@FindBy(xpath = "//button[@name='login']")
	WebElement verifyLoginLink;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);

	}

	// Actions:

	public void verifyRegLink(String RegUrl) {
		String regurl = RegUrl;

		// driver.get(Url);
		// driver.manage().window().maximize();
		// verifyLink=driver.findElement(By.xpath(linkLocator));
		verifyLink.click();
		String url = driver.getCurrentUrl();
		assertEquals(url, regurl);
		// driver.close();
	}

}
