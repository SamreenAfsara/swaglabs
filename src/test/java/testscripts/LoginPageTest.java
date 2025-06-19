package testscripts;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.swaglabs.pages.LoginPage;
import com.swaglabs.pages.ProductPage;
import com.swaglabs.utils.Browser;
import com.swaglabs.utils.ConfigConstants;
import com.swaglabs.utils.ReadTestData;
import com.swaglabs.utils.SmartFunctions;

public class LoginPageTest  extends Browser{

	
	@BeforeMethod(alwaysRun = true)
	@Parameters("browsername")
	public void setup(String bname)
	{
		launchBrowser(bname);
		openURL();
	}
	
	@AfterMethod(alwaysRun = true)
	public void teardown()
	{
		close();
	}
	
	
	@Test(enabled=true,groups="sanity")
	public void verifyLoginBtnFunctionalityWithBlankUsernameAndPassword()
	{
		LoginPage loginpage= new LoginPage(driver,"loginpage");
		loginpage.clickonLoginbtn();
		String actualresult=loginpage.getErrorMSg();
		String expectedresult=ConfigConstants.BLANK_USERNAME_ERRMSG;
		Assert.assertEquals(actualresult,expectedresult);
	}
	
	@Test(enabled=true,groups="sanity")
	public void verifyLoginBtnFunctionalityWithBlankPassword() throws InterruptedException
	{
		LoginPage loginpage= new LoginPage(driver,"loginpage");
		ReadTestData read = new ReadTestData("loginpage");
		String uname=read.getData(2, 0);
		loginpage.enterUsername(uname);
		loginpage.clickonLoginbtn();
		String actualresult=loginpage.getErrorMSg();
		String expectedresult=ConfigConstants.BLANK_PASSWORD_ERRMSG;
		Thread.sleep(3000);
		Assert.assertEquals(actualresult,expectedresult);
	}
	
	@Test(enabled=true)
	public void verifyLoginBtnFunctionalityWithInvalidUsernamePassword() throws InterruptedException
	{
		LoginPage loginpage= new LoginPage(driver,"loginpage");
		ReadTestData read = new ReadTestData("loginpage");
		List<String> logindata=read.getData(8);
		loginpage.enterUsername(logindata.get(0));
		loginpage.enterPassword(logindata.get(1));
		loginpage.clickonLoginbtn();
		String actualresult=loginpage.getErrorMSg();
		String expectedresult=ConfigConstants.INVALIDUSERNAMEPASWORD_ERRMSG;
		Thread.sleep(3000);
		Assert.assertEquals(actualresult,expectedresult);
	}
	
	@Test(enabled=true,groups="smoke")
	public void verifyLoginBtnFunctionalityWithValidUsernamePassword() throws InterruptedException
	{
		LoginPage loginpage= new LoginPage(driver,"loginpage");
		ReadTestData read = new ReadTestData("loginpage");
		List<String> logindata=read.getData(1);
		loginpage.enterUsername(logindata.get(0));
		loginpage.enterPassword(logindata.get(1));
		loginpage.clickonLoginbtn();
		ProductPage productpage = new ProductPage(driver,"productspage");
		boolean status = productpage.isProductTitleVisible();
		Thread.sleep(3000);
		Assert.assertTrue(status,"Product title not visible");
	}
	
	@Test(enabled=true,dataProvider="logindata",groups="sanity")
	public void verifyLoginBtnFunctionalityWithValidUsernamePassword(String uname,String pass) throws InterruptedException
	{
		LoginPage loginpage= new LoginPage(driver,"loginpage");
		loginpage.enterUsername(uname);
		loginpage.enterPassword(pass);
		loginpage.clickonLoginbtn();
		loginpage.clickonLoginbtn();
		ProductPage productpage = new ProductPage(driver,"productspage");
		boolean status = productpage.isProductTitleVisible();
		Thread.sleep(3000);
		Assert.assertTrue(status,"Product title not visible");
	}
	
	@DataProvider(name="logindata")
	public String[][] testdata()
	{
		ReadTestData read = new ReadTestData("loginpage");
		return read.getData();
	}
	
	@Test(enabled=true, invocationCount = 3,groups="smoke")
	@Parameters({"username","password"})
	public void verifyLoginBtnFunctionality(String uname,String pass) throws InterruptedException
	{
		LoginPage loginpage= new LoginPage(driver,"loginpage");
		loginpage.enterUsername(uname);
		loginpage.enterPassword(pass);
		loginpage.clickonLoginbtn();
		loginpage.clickonLoginbtn();
		ProductPage productpage = new ProductPage(driver,"productspage");
		boolean status = productpage.isProductTitleVisible();
		Thread.sleep(3000);
		Assert.assertTrue(status,"Product title not visible");
	}
	
	
}
