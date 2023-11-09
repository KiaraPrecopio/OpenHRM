import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_BonusTrack1b {
	String url = "https://opensource-demo.orangehrmlive.com/";
	@Test
	public void ChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64/chromedriver.exe");
		WebDriver navegador = new ChromeDriver();
		navegador.get(url);
		navegador.manage().window().maximize();
		
		navegador.findElement(By.id("txtUsername")).sendKeys("Admin");
		navegador.findElement(By.id("txtPassword")).sendKeys("admin123");
		
		navegador.findElement(By.className("oxd-button oxd-button--medium oxd-button--main orangehrm-login-button")).click();
	}
}
