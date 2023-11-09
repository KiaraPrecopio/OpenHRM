package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import com.github.javafaker.Faker;
import paginas.paginaFormulario;
import paginas.paginaLogin;
import paginas.paginaPrincipal;


public class Test_BonusTrack4b {
	WebDriver driver;
	String url ="https://opensource-demo.orangehrmlive.com/";
	String urlChrome = "../EducacionIT/Drivers/chromedriver.exe";
	String urlFirefox = "../EducacionIT/Drivers/geckodriver.exe";
	Faker fake = new Faker();
	@BeforeTest
	@Parameters("navegador")
	public void setUp (String navegador) {
		if (navegador.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", urlChrome);
			driver = new ChromeDriver();
		} else if (navegador.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", urlFirefox);
			driver = new FirefoxDriver();
		}
	driver.get(url);
	driver.manage().window().maximize();
	}
	@Test
	public void crearUsuario() throws InterruptedException {
		paginaLogin login = new paginaLogin(driver);
		login.setUsername("Admin");
		login.setPassword("admin123");
		login.clickLogin();
		
		paginaPrincipal principal = new paginaPrincipal(driver);
		principal.clickAdmin();
		principal.clickUserManagement();
		principal.clickUsers();
		principal.clickAdd();
		
		paginaFormulario form = new paginaFormulario(driver);
		form.selectUserRole();
		form.selectStatus();
		form.setContraseñas(fake.internet().password());
		form.setUsuario(fake.internet().password());
		form.setEmpleado("A");
		form.clickSave();	
	}
	@AfterTest
	public void setDown() {
		driver.close();
	}
	
	
	
}