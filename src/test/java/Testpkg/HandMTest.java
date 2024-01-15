package Testpkg;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pagepkg.HandMCheckOutPage;
import Pagepkg.HandMHomePage;
import Pagepkg.HandMLoginPage;
import Utilities.ExcelutilsHandM;

@Test(priority=0)
public class HandMTest {
	WebDriver driver;
	
	public void setUp() throws IOException, InterruptedException
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.get("https://www2.hm.com/en_in/index.html");
		HandMLoginPage login = new HandMLoginPage(driver);
		String link = "C:\\Users\\anjua\\OneDrive\\Desktop\\Book15.xlsx"; 
		String sheet = "Sheet1";
		int rowCount = ExcelutilsHandM.getRowCount(link, sheet);
	
		for (int i = 1; i <= rowCount; i++)
		{
			ExcelutilsHandM ex = new ExcelutilsHandM();
			String userName = ex.getCellValue(link, sheet, i, 0);
			System.out.println(userName);
			String userPassword = ex.getCellValue(link, sheet, i, 1);
			System.out.println(userPassword);
			login.setValues(userName, userPassword);
			driver.navigate().refresh();
			Thread.sleep(1000);
		}
	}
	@Test(priority=1)
	public void addToCart() throws InterruptedException
	{
		HandMHomePage home=new HandMHomePage(driver);
		home.addProductToCart();
	}
	
	@Test(priority=2)
	public void checkOutPage() throws InterruptedException
	{
		HandMCheckOutPage check=new HandMCheckOutPage(driver);
		//Thread.sleep(2000);
		check.clickCheckOut();
		check.fillup();
		check.dropdown();
	}
}
