package org.qsp.Generick;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConst{
     public WebDriver driver = null;
	
	@BeforeMethod
	public void openBrowser() {
		if(Browser_Name.equalsIgnoreCase("chrome")) {
			System.setProperty(chromeKey, ChromeValue);
			driver = new ChromeDriver();
		}
		 if(Browser_Name.equalsIgnoreCase("opera")) {
			System.setProperty(operaKey, OperaValue);
			driver = new OperaDriver();
		}
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void closeBrowser(ITestResult result) throws IOException {
		String name = result.getName();
		int status = result.getStatus();
		if (status==1) {
			Reporter.log("Test Case : "+ name +"is passed", true);
		}
        else {
        	ScreenShot.screenShot(driver, imgPath+ name +".png");
			Reporter.log("Test Case : "+ name +"is fail", true);
        }
		
		
		driver.close();
	}

}
