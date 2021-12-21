package poi;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Elements {

	@FindBy(xpath = "//input[@class=\'_2IX_2- VJZDxU\']")
	public static WebElement userName;

	@FindBy(xpath = "//*[@class=\'_2IX_2- _3mctLh VJZDxU\']")
	public static WebElement passWord;

	@FindBy(name = "q")
	public static WebElement search;

	@FindBy(xpath = "//*[@class=\\'_1xHGtK _373qXS\\'])")
	public static WebElement product;

	@FindBy(xpath = "//*[@class=\'G6XhRU\']")
	public static WebElement productName;

	@FindBy(xpath = "//*[@class=\'_30jeq3 _16Jk6d\']")
	public static WebElement amount;
	
	@FindBy(xpath = "//*[@class=\'col col-11-12 _2cLjiM\']")
	public static WebElement dropdetails;
	
	@FindBy(xpath = "(//*[@class=\'col col-9-12 _2vZqPX\'])[1]")
	public static WebElement type;
	
	@FindBy(xpath = "(//*[@class=\'col col-9-12 _2vZqPX\'])[2]")
	public static WebElement sleeve;
	
	@FindBy(xpath = "(//*[@class=\'col col-9-12 _2vZqPX\'])[3]")
	public static WebElement fit;
	
	@FindBy(xpath = "(//*[@class=\'col col-9-12 _2vZqPX\'])[4]")
	public static WebElement fabric;
	
}
