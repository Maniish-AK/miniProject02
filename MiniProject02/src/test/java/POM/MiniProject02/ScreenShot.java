package POM.MiniProject02;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	
	
	public void takeScreenshot(WebDriver driver, String testName) {
	    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    try {
	        FileUtils.copyFile(screenshot, new File("screenshots/" + testName + ".png"));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

}
