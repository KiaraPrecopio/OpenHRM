package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class paginaLogin {
	
	@FindBy(name="username")
	WebElement username;
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[2]/div[1]/div[2]/input[1]")
	WebElement password;
	@FindBy(tagName="button")
	WebElement btnLogin;
	WebDriver driver;
	WebDriverWait wait;
	
	public paginaLogin(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory (driver, 60), this);
	}
	
	public void setUsername (String nUsername) {
		username.sendKeys(nUsername);}
	
	public void setPassword (String nPassword) {
		password.sendKeys(nPassword);
	}
	public void clickLogin() {
		btnLogin.click();
	}
}

