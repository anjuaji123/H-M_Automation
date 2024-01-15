package Pagepkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandMCheckOutPage {
	
	WebDriver driver;
	public HandMCheckOutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void clickCheckOut()throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Thread.sleep(2000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[2]/section[2]/div[1]/div[1]/div[1]/div[3]/button[1]")).click();
	}
	public void fillup()
	{
		driver.findElement(By.id("firstName")).sendKeys("sonakshi");
		driver.findElement(By.id("lastName")).sendKeys("sinha");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/div/div[1]/section[1]/div/div/div/div/form/div[2]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"line1\"]")).sendKeys("Puthanambalam-Nediyavila Road");
		driver.findElement(By.xpath("//*[@id=\"town\"]")).sendKeys("Kunnathur");
		driver.findElement(By.xpath("//*[@id=\"postalCode\"]")).sendKeys("690540");
	}
	public void dropdown()
	{
		WebElement stateelement=driver.findElement(By.xpath("//*[@id=\"province\"]"));
		Select state=new Select(stateelement);
		state.selectByValue("Kerala");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/div/div[1]/section[2]/div/div/div/div/form/div/div[2]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/div/div[1]/section[2]/div/div/div/div/div/div[3]/button[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"cellPhone\"]")).sendKeys("2657890432");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/main/div/div[1]/section[3]/div/div/div/div/form/div[2]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"sidebar-sticky-boundary\"]/section[2]/div/div/div[1]/div[3]/button[1]")).click();
	}
	
}
