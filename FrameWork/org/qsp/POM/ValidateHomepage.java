package org.qsp.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidateHomepage {
   public void verifyPageisDisplaying(WebDriver driver,long eto , String title) {
	   WebDriverWait ww = new WebDriverWait(driver, eto);
	   ww.until(ExpectedConditions.titleContains(title));
   }
	public ValidateHomepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
}
