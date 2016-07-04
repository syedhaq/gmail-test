import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class gmailsignintest {
	
	@Test
	public void gmailloginsuccesschk(){
	WebDriver driver=new FirefoxDriver();
	driver.get("http://gmail.com");
	
	WebElement usernameTextbox=driver.findElement(By.id("Email"));
	usernameTextbox.clear();
	usernameTextbox.sendKeys("dip491@gmail.com");
	WebElement nextBox=driver.findElement(By.id("next"));
	nextBox.click();
	WebDriverWait wait=new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
	WebElement passwdTextbox=driver.findElement(By.id("Passwd"));
	passwdTextbox.sendKeys("youwish");
	driver.findElement(By.id("signIn")).click();
	
	//Wait again for page to load
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//Verify page load
	Assert.assertTrue("Inbox should exist",(( driver.findElements(By.partialLinkText("Inbox")).size()>0)));
	WebElement profile=driver.findElement(By.cssSelector("span[class='gb_3a gbii']"));
	profile.click();
	//click signout
	driver.findElement(By.id("gb_71")).click();
	
	//verify signed out
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Sign in")));
	
	}

}
