package Tests;

import java.io.IOException;
import java.util.logging.Logger;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.SimpleFramework.simpleFramework.Base;

import DataProvider.DataProviderHomePage;

import Pages.HomePage;

public class HomepageTest extends Base {
	 private static final Logger logger = Logger.getLogger(HomepageTest.class.getName());

	HomePage homepage;

	public HomepageTest() {
		super();
	}

	@DataProvider
	public static Object[][] getBrowserNames() {
		return new Object[][] { { "chrome" }, { "firefox" }, { "edge" } };
	}

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	@BeforeMethod
	@Parameters({"browser"})
	public void createBrowserObject(String browser) throws IOException {
		homepage = initialization(browser);

	}

	@Test(dataProvider = "getData", priority = 1, dataProviderClass = DataProviderHomePage.class)
	public void Registerlink(String Regurl) {
		logger.info("Starting RegisterLink");
		homepage.verifyRegLink(Regurl);
		logger.info("Completed RegisterLink sucessfully...");

	}

	// @Test(dataProvider = "getData2",priority =
	// 2,dataProviderClass=DataProviderHomePage.class)
	/*
	 * public void Loginbtn(String url, String Regurl) { homepage.verifyLgnLink(url,
	 * Regurl);
	 * 
	 * }
	 */

	@AfterMethod
	public void takeScreenshot() {
		tearDown();
	}
	@AfterClass
    public static void cleanup() {
        logger.info("All tests completed.");
    }
}
