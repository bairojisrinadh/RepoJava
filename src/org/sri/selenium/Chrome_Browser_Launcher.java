package org.sri.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome_Browser_Launcher {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Ddrive\\Software\\selenium\\Browser_Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
	}

}
