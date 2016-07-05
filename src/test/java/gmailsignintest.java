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
	usernameTextbox.sendKeys("udemy.syed@gmail.com");
	WebElement nextBox=driver.findElement(By.id("next"));
	nextBox.click();
	WebDriverWait wait=new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
	WebElement passwdTextbox=driver.findElement(By.id("Passwd"));
	passwdTextbox.sendKeys("youwish123");
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
	@Test
	public void gmailsendrcvcheck(){
		
		
		//go to gmail
		//username
		//wait
		//password
		//click next
		//confirm sign in 
	
		WebDriver driver=new FirefoxDriver();
		driver.get("http://gmail.com");
		
		WebElement usernameTextbox=driver.findElement(By.id("Email"));
		usernameTextbox.clear();
		usernameTextbox.sendKeys("udemy.syed@gmail.com");
		WebElement nextBox=driver.findElement(By.id("next"));
		nextBox.click();
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
		WebElement passwdTextbox=driver.findElement(By.id("Passwd"));
		passwdTextbox.sendKeys("youwish123");
		driver.findElement(By.id("signIn")).click();
		
		//Wait again for page to load
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
		//Verify page load
		Assert.assertTrue("Inbox should exist",(( driver.findElements(By.partialLinkText("Inbox")).size()>0)));
		
		//locate and click compose
		WebElement composebox=driver.findElement(By.cssSelector("div[role='button'][gh='cm']"));
		composebox.click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("To")));
		//fill in user
		WebElement totextarea=driver.findElement(By.cssSelector("textarea[name='to']"));
		totextarea.sendKeys("udemy.syed@gmail.com");
		//fill in subject
		WebElement subjectarea=driver.findElement(By.cssSelector("input[name='subjectbox']"));
		String subject="Test message";
		subjectarea.sendKeys(subject);
		//fill in email body
	
		
		WebElement messagebox=driver.findElement(By.cssSelector("div[role='textbox'][aria-label='Message Body']"));
		String message="This is a test message";
		messagebox.sendKeys(message);
		//locate and click send
		WebElement sendbutton=driver.findElement(By.cssSelector("div[role='button'][aria-label='Send ‪(Ctrl-Enter)‬'"));
		sendbutton.click();
		//wait till received and verify email subject and body
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Inbox (1)")));
		WebElement inboxlink=driver.findElement(By.linkText("Inbox (1)"));
		inboxlink.click();
		
		//Click email
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='y6'] span[id] b")));
		WebElement newmail=driver.findElement(By.cssSelector("div[class='y6'] span[id] b"));
		newmail.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2[class='hP']")));
		WebElement subjectchk=driver.findElement(By.cssSelector("h2[class='hP']"));
		Assert.assertEquals("Subjects should match",subject, subjectchk.getText());
		//sign out
		//verify signed out
		WebElement profile=driver.findElement(By.cssSelector("span[class='gb_3a gbii']"));
		profile.click();
		driver.findElement(By.id("gb_71")).click();
		
		//verify signed out
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Sign in")));
		
		
	}
	
	
	
	
	

}
