//@ author- Jagadeshwaran J
//@ Description- Login to flipkart using apache poi reading

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
public class ReadDataFromExcel
{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	// setting file location and reading WorkBook	
		
		File file=new File("D:\\java.xlsx");
		FileInputStream fs = new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(fs);
		XSSFSheet sheet=workbook.getSheetAt(0);
		XSSFRow row=sheet.getRow(1);
		XSSFCell cell = row.getCell(0);		
		String cellval=cell.getRawValue();
		System.out.println(cellval);
		
		XSSFRow row1=sheet.getRow(1);
		XSSFCell cell1 = row1.getCell(1);
		String cellval1 = cell1.getStringCellValue();
		System.out.println(cellval1);
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\adm\\selenium\\jar file\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//WebElement loginbutton=driver.findElement(By.xpath("//*[@id=\'container\']/div/div[1]/div[1]/div[2]/div[3]/div/div/div/a"));
		//loginbutton.click();
		
		WebElement username=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input"));
		username.sendKeys(cellval);
		
		WebElement password=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input"));
		password.sendKeys(cellval1+ Keys.ENTER);
		
		driver.close();
		
		}

}
