package CustomizedListners;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.test.SimpleFramework.simpleFramework.*;


public class ExtentManager extends Base {

	private static ExtentReports extent;
	public static String fileName;
	
	
	

	    public static ExtentReports createInstance(String fileName) {
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
	       
	        
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle(fileName);
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName(fileName);
	        
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Automation Tester", "Vasant K");
	        extent.setSystemInfo("Organization", "SimpleFrame");
	        extent.setSystemInfo("Build no", "OR-21");
	        
	        
	        return extent;
	    }

	    
	  /*  public static String screenshotPath;
		public static String screenshotName;
		
		public static void captureScreenshot() {

			File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

			Date d = new Date();
			screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

			try {
				FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\reports\\" + screenshotName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		}*/
	    /*public static void captureScreenshot() {
	    	Date d = new Date();
			String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				destFile = "F:\\MyFiles\\Selenium\\My Project\\simpleFramework\\simpleFramework\\Screenshots" + fileName;
				FileUtils.copyFile(screenshot, new File(destFile));
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.setProperty("org.uncommons.reportng.escape-output", "false");

	    }*/
	    public static void captureScreenshot() {
	        Date d = new Date();
	        String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
	        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	        try {
	            destFile = "F:\\MyFiles\\Selenium\\My Project\\simpleFramework\\Screenshots\\" + fileName;
	            FileUtils.copyFile(screenshot, new File(destFile));

	            // Load the screenshot image into a BufferedImage
	            BufferedImage image = ImageIO.read(screenshot);

	            // Create a graphics object for the image
	            Graphics2D graphics = image.createGraphics();

	            // Set the highlight color and stroke
	            graphics.setColor(Color.RED);
	            graphics.setStroke(new BasicStroke(5));

	            // Draw a rectangle around the error area (adjust these values as needed)
	            graphics.drawRect(50, 60, 60, 60);

	            // Write the modified image to a file
	            File modifiedScreenshotFile = new File("F:\\MyFiles\\Selenium\\My Project\\simpleFramework\\Screenshots\\" + fileName);
	            ImageIO.write(image, "jpg", modifiedScreenshotFile);

	            // Add the modified screenshot to the Extent report
	            ExtentTest test = extent.createTest("Test Name");
	            test.addScreenCaptureFromPath(modifiedScreenshotFile.getAbsolutePath());

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        System.setProperty("org.uncommons.reportng.escape-output", "false");
	    }

	

	}
