import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Test_BonusTrack2b {
	String url = "https://opensource-demo.orangehrmlive.com/";
	@Test
	public void IngresoUsuario () throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kprec\\eclipse-workspace\\SauceDemo\\Drivers\\chromedriver.exe");
		WebDriver navegador = new ChromeDriver();
		navegador.get(url);
		navegador.manage().window().maximize();
		
		WebDriverWait navegadorWait = new WebDriverWait(navegador, Duration.ofSeconds((80)));
		
		// Ingreso de usuario
		navegadorWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		navegador.findElement(By.name("username")).sendKeys("Admin");
		
		navegadorWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		navegador.findElement(By.name("password")).sendKeys("admin123");
		
		navegadorWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		navegador.findElement(By.xpath("//button[@type='submit']")).click();
		
		// ADMIN - USER MANAGEMENT - USERS
		navegadorWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")));
		navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")).click();
	
		navegadorWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]")));
		navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]")).click();
	
		navegadorWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]/ul/li/a")));
		navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]/ul/li/a")).click();
	
		// BOTON ADD
		navegadorWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")));
		navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
		
		// Esperar que cargue el formulario
		navegadorWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.oxd-select-text")));
		
		// Hacer clic en el cuadro desplegable para abrir las opciones de USER ROLE
		navegadorWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.oxd-select-text"))).click();
		// Esperar a que aparezcan las opciones
		navegadorWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.oxd-select-dropdown")));		
		// Identificar y hacer clic en la opción ADMIN
		WebElement adminOption = navegador.findElement(By.xpath("//div[text()='-- Select --']"));
		adminOption.sendKeys(Keys.ARROW_DOWN);
		adminOption.sendKeys(Keys.ENTER);
		
		// El recuadro pasa a clickeado y muestra las opciones de STATUS. Esperar a que se vea.
		navegadorWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.oxd-select-dropdown")));
		// Usar las flechas para seleccionar ENABLED
		navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]")).sendKeys(Keys.ARROW_DOWN);
		navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]")).sendKeys(Keys.ENTER);
		
		// Se ingresa el usuario, contraseña y confirmación de contraseña
		navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")).sendKeys("usuario0");
		navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")).sendKeys("ABCdef_123");
		navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")).sendKeys("ABCdef_123");
		
		// Se ingresa un texto que se autocomplete y se utiliza el primer usuario		
		navegadorWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Type for hints...']"))).click();
		navegador.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("A");
		Thread.sleep(5000);
		navegador.findElement(By.cssSelector("div.oxd-autocomplete-dropdown > div:first-child")).click();
		
		// Se selecciona SAVE
		navegador.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
}


