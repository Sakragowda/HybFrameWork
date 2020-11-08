package org.qsp.Test;


import org.qsp.Generick.BaseTest;
import org.qsp.Generick.XL;
import org.qsp.POM.LoginPage;
import org.qsp.POM.ValidateHomepage;
import org.testng.annotations.Test;

public class Login extends BaseTest {
 @Test
 public void TC_01() throws Exception {

	    String user = XL.readCell(XI_Path, Sheet_name, 2, 0);
	    String pass = XL.readCell(XI_Path, Sheet_name, 2, 1);
	   
	    LoginPage lp = new LoginPage(driver);
	    lp.sentusername(user);
	    lp.sendPassword(pass);
	    lp.loginClick();
	    ValidateHomepage vh = new ValidateHomepage(driver);
	    vh.verifyPageisDisplaying(driver, eto, "Enter");
	
 }
}
