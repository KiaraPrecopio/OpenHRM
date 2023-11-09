package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class paginaPrincipal {
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]")
	WebElement btnAdmin;
	@FindBy(xpath="//header/div[2]/nav[1]/ul[1]/li[1]")
	WebElement btnUserM;
	@FindBy(xpath="//header/div[2]/nav[1]/ul[1]/li[1]/ul[1]")
	WebElement btnUsers;
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/button[1]")
	WebElement btnAdd;
	WebDriver driver;
	
	public paginaPrincipal(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory (driver, 60), this);
	}
	public void clickAdmin() {
		btnAdmin.click();
	}
	public void clickUserManagement() {
		btnUserM.click();
	}
	public void clickUsers() {
		btnUsers.click();
	}
	public void clickAdd() {
		btnAdd.click();
	}
}
