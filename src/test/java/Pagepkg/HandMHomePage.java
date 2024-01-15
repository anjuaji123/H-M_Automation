package Pagepkg;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HandMHomePage {
	
	WebDriver driver;
	public HandMHomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void addProductToCart() throws InterruptedException
	{
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//*[@id='__next']/header/nav/div[3]/div/div[2]/div[1]/div/div/div[2]/div/input")).sendKeys("croptops",Keys.ENTER);
		Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		driver.findElement(By.xpath("//body/main[@id='main-content']/div[2]/div[1]/div[1]/ul[1]/li[3]/article[1]/div[1]/a[1]/img[1]")).click();
		Thread.sleep(2000);
		Set<String> window = driver.getWindowHandles();
		for (String handle : window) 
		{
			if (!handle.equalsIgnoreCase(parent)) 
			{

				driver.switchTo().window(handle);
				//driver.findElement(By.xpath("//body/main[@id='main-content']/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/hm-size-selector[1]/ul[1]/li[4]/label[1]")).click();
				//Thread.sleep(2000);
				//driver.findElement(By.xpath("//span[contains(text(),'Add')]")).click();
				//Thread.sleep(2000);
				String title=driver.getTitle();
				System.out.println(title);
				
				if(title.contains("Cropped zip-through hoodie")) 
				{
					System.out.println("pass");
				}
				else 
					
				{
					System.out.println("fail");
				}
			}
		}
		driver.findElement(By.xpath("//body/main[@id='main-content']/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/hm-size-selector[1]/ul[1]/li[4]/label[1]")).click();//size
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 1000)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Add')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//header/nav[1]/div[1]/ul[1]/li[4]/div[1]/a[1]/span[1]")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();

	}

}
