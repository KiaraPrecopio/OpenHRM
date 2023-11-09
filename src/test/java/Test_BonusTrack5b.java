import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import Utilidades.DatosExcel;
import paginas.paginaFormulario;
import paginas.paginaLogin;
import paginas.paginaPrincipal;

public class Test_BonusTrack5b {
	WebDriver driver;
	String url ="https://opensource-demo.orangehrmlive.com/";
	String urlChrome = "../EducacionIT/Drivers/chromedriver.exe";
	String directorioDatos = "C:\\Users\\kprec\\eclipse-workspace\\OpenHRM\\datos\\";
	String nombreArchivoDatos = "datos.xlsx";
	String nombreHoja = "Hoja1";
	Faker fake = new Faker();
	
	@BeforeTest
	@Parameters("navegador")
	public void setUp() {
		System.setProperty(urlChrome, "webdriver.chrome.driver");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	@Test(dataProvider="Datos Login Excel")
	public void crearUsuario(String userIngreso, String passwordIngreso, String password, String usuario, String empleado) throws InterruptedException {
		paginaLogin login = new paginaLogin(driver);
		login.setUsername(userIngreso);
		login.setPassword(passwordIngreso);
		login.clickLogin();
		
		paginaPrincipal principal = new paginaPrincipal(driver);
		principal.clickAdmin();
		principal.clickUserManagement();
		principal.clickUsers();
		principal.clickAdd();
		
		paginaFormulario form = new paginaFormulario(driver);
		form.selectUserRole();
		form.selectStatus();
		form.setContraseñas(password);
		form.setUsuario(usuario);
		form.setEmpleado(empleado);
		form.clickSave();
		
		Thread.sleep(10000);
		principal.clickUserManagement();
		principal.clickUsers();
	}
	@Test(dataProvider="Cambio de User")
	public void editarDatos(String nUser) throws InterruptedException {
		Thread.sleep(10000); 
		WebElement editar = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div[6]/div[1]/button[2]"));
		editar.click();
		WebElement user = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[2]/input[1]"));
		user.click();
		user.sendKeys(nUser);
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/button[2]")).click();
	}
	
	@DataProvider(name="Cambio de User")
	public Object[][] datoUser(){
		Object[][] datos = new Object[1][1];
		datos[0][0] = fake.internet().password();
		return datos;
	}
	@DataProvider(name="Datos Login Excel")
	public Object[][] datosLogin () throws Exception {
		return DatosExcel.leerExcel(directorioDatos + nombreArchivoDatos, nombreHoja);
	}
	
	@AfterTest
	public void setDown() {
		driver.close();
	}
	
	
	
}
