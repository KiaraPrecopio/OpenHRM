package paginas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class paginaFormulario {
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]")
	WebElement userRole;
	@FindBy(className= "div.oxd-select-dropdown")
	WebElement userRoledesplegable;
	@FindBy(xpath="//div[contains(text(),'-- Select --')]")
	WebElement status;
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]")
	WebElement password;
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/div[2]/input[1]")
	WebElement passwordC;
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[2]/input[1]")
	WebElement usuario;
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	WebElement employee;
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/button[2]")
	WebElement save;
	WebDriver driver;
	WebDriverWait wait;
	
	public paginaFormulario(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory (driver, 30), this);
		wait = new WebDriverWait(driver, Duration.ofSeconds((30)));
	}
	
	public void selectUserRole() {
		wait.until(ExpectedConditions.elementToBeClickable(userRole)).click();
		wait.until(ExpectedConditions.elementToBeClickable(userRole));
		userRole.sendKeys(Keys.ARROW_DOWN);
		userRole.sendKeys(Keys.ENTER);
	}
	public void selectStatus() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(status));
		status.click();
	    /*WebElement option = driver.findElement(By.xpath("//div[contains(text(),'Enabled')]"));
	    option.click();
	    status.sendKeys(Keys.ARROW_DOWN);*/
	    
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.oxd-select-dropdown")));
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]")).sendKeys(Keys.ENTER);
	    
	    
	}
	public void setContraseñas(String nPassword) {
		wait.until(ExpectedConditions.elementToBeClickable(password));
		password.sendKeys(nPassword);
		passwordC.sendKeys(nPassword);
	}
	public void setUsuario(String nUsuario) {
		usuario.click();
		usuario.sendKeys(nUsuario);
	}
	public void setEmpleado(String nEmployee) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(employee)).click();
		employee.sendKeys(nEmployee);
		Thread.sleep(3000);
	    WebElement select = driver.findElement(By.cssSelector("div.oxd-autocomplete-dropdown > div:first-child"));
	    select.click();
	}
	public void clickSave() {
		save.click();
	}
	
}
