package salesforce;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewOppourtunity {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.className("slds-icon-waffle")).click();
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		driver.findElement(By.xpath("//one-app-nav-bar-item-root[@data-id='0Qk5g0000079gY0CAI']")).click();
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by Kalpana");
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("08/08/2022");
		driver.findElement(By.xpath("//button[@aria-label='Stage, --None--']")).click();
		List<WebElement> StageDropDown = driver.findElements(By.xpath("(//span[@class='slds-media__body']//span)"));
		for (WebElement SDD1 : StageDropDown) {
			String Sddtxt = SDD1.getText();
			if (Sddtxt.equals("Needs Analysis")) {
				SDD1.click();
			}
		}
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();

	}
}
