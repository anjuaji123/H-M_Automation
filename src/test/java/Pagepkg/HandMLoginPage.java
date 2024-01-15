package Pagepkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandMLoginPage {
	
	WebDriver driver;
	
	public HandMLoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void setValues(String emailf,String passf) throws InterruptedException 
	{
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//header/nav[1]/div[1]/ul[1]/li[1]/div[1]/button[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(emailf);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(passf);
		driver.findElement(By.xpath("//body/div[@id='portal']/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/button[1]")).click();
	}
	

}
