
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test_BonusTrack3b {
	String url = "https://opensource-demo.orangehrmlive.com/";
	WebDriver navegador = new ChromeDriver();
	Faker fake = new Faker();
	String evidencias = "..//OpenHRM//Evidencias//";
	File captura;
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "..\\SauceDemo\\Drivers\\chromedriver.exe");
		navegador.get(url);
		navegador.manage().window().maximize();
	}
	
	@Test
	public void IngresoUsuario () throws InterruptedException, IOException {
		WebDriverWait navegadorWait = new WebDriverWait(navegador, Duration.ofSeconds((80)));
		
		// Ingreso de usuario
		navegadorWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		navegador.findElement(By.name("username")).sendKeys("Admin");
		navegador.findElement(By.name("password")).sendKeys("admin123");
		capturaPantalla("00_IngresoUsuario.jpg");
		
		navegador.findElement(By.tagName("button")).click();
		
		// ADMIN - USER MANAGEMENT - USERS
		navegadorWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-main-menu-item")));
		navegador.findElement(By.className("oxd-main-menu-item")).click();
		navegadorWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-topbar-body-nav-tab-item")));
		navegador.findElement(By.className("oxd-topbar-body-nav-tab-item")).click();
		navegadorWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Users")));
		navegador.findElement(By.linkText("Users")).click();
	
		navegadorWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")));
		capturaPantalla("01_SolapaAdminUser.jpg");
		navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
		
		navegadorWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.oxd-select-text")));
		capturaPantalla("02_FormularioVacio.jpg");

		navegadorWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.oxd-select-text"))).click();
		navegadorWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.oxd-select-dropdown")));		
		WebElement opcion = navegador.findElement(By.xpath("//div[text()='-- Select --']"));
		opcion.sendKeys(Keys.ARROW_DOWN);
		opcion.sendKeys(Keys.ENTER);
		
		navegador.findElement(By.xpath("//div[contains(text(),'-- Select --')]")).click();
		navegadorWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.oxd-select-dropdown")));
		navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]")).sendKeys(Keys.ARROW_DOWN);
		navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]")).sendKeys(Keys.ENTER);
		
		String password = fake.internet().password();
		navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")).sendKeys(fake.internet().password());
		navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")).sendKeys(password);
		navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")).sendKeys(password);
			
		navegadorWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Type for hints...']"))).click();
		navegador.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("A");
		Thread.sleep(3000);
		navegador.findElement(By.cssSelector("div.oxd-autocomplete-dropdown > div:first-child")).click();
		capturaPantalla("03_FormularioCompleto.jpg");
		
		navegador.findElement(By.xpath("//button[@type='submit']")).click();
		
		navegadorWait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h5")));
		Assert.assertEquals(navegador.getTitle(), "OrangeHRM");
		capturaPantalla("04_PaginaFinal.jpg");
	}
	public void capturaPantalla(String nombreArchivo) throws IOException {
		captura = ((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(captura, new File(evidencias + nombreArchivo + ".png"));
	}
	@AfterSuite
	public void setDown() {
		navegador.close();
	}
}




