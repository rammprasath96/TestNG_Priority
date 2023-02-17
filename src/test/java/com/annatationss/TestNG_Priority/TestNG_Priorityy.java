package com.annatationss.TestNG_Priority;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestNG_Priorityy 
{
	static WebDriver site; 
	
	@Test(priority=1)
	public void broswerLaunch() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","D:\\TESTING AND AUTOMATION\\JAVA\\ECLIPSE-TestNG\\TestNG_Priority\\Driver\\chromedriver.exe");
		site=new ChromeDriver();
		site.manage().window().maximize();
		System.out.println("*ChromeLaunched*");
		site.get("https://www.nykaa.com/");
		Thread.sleep(2000);	
	}
	
	@Test(priority=2)
	public void signINN() throws InterruptedException 
	{
		System.out.println("**LYKAA IS OPeNED**");
		WebElement email = site.findElement(By.xpath("//button[@kind='secondary'][1]"));
		Actions mob=new Actions(site);
		mob.click(email).build().perform();
		Thread.sleep(2000);
		site.findElement(By.xpath("//input[@name='emailMobile']")).sendKeys("9597998784");
		site.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(20000);
		site.findElement(By.xpath("//button[text()='verify']")).click();

	}
	
	@Test(priority=3)
	public void productSearch() throws InterruptedException, AWTException
	{
		System.out.println("***SIGNED IN SUCESSFULLY***");
		Thread.sleep(5000);
		
		WebElement search = site.findElement(By.xpath("//input[@placeholder='Search on Nykaa']"));
		search.sendKeys("Sunglasses");
		
		Thread.sleep(2000);
		Robot serr=new Robot();
		
		serr.keyPress(KeyEvent.VK_ENTER);
		serr.keyRelease(KeyEvent.VK_ENTER);	
	}
	
	@Test(priority=4)
	public void selectProduct() throws InterruptedException
	    {
		System.out.println("****PRODUCT FOUNDED****");
		
		Thread.sleep(2000);
		site.findElement(By.xpath("//div[text()='Vogue Eyewear 0VO4092BI Brown Timeless Pilot Sunglasses (56 ...']"))
.click();
		
		Set<String> nextwin = site.getWindowHandles();
		for (String newwin : nextwin)
		{
		site.switchTo().window(newwin);
		}
		System.out.println("*****NEW WINDOW SWITCHED*****");
		
		}
	@Test(priority=5)
	public void addCart() throws InterruptedException
	{
		Thread.sleep(2000);
		site.findElement(By.xpath("//span[text()='Add to Bag']")).click();
//		site.findElement(By.xpath("//div[@class='AddBagIcon']")).click();
		System.out.println("******CART ADDED******");
		Thread.sleep(5000);
		site.quit();
		System.out.println("WINDOW CLOSED");
	}
}
