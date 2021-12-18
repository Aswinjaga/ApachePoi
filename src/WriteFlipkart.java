//@ author- Jagadeshwaran J
//@ Description- Reading 20 products in flipkart using Apache Poi

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WriteFlipkart {

	public static void main(String[] args) throws IOException, NoSuchElementException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\adm\\selenium\\jar file\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions action=new Actions(driver);

		WebElement username=driver.findElement(By.xpath("//input[@class=\'_2IX_2- VJZDxU\']"));
		username.sendKeys("7373992282");

		WebElement password=driver.findElement(By.xpath("//*[@class=\'_2IX_2- _3mctLh VJZDxU\']"));
		password.sendKeys("Aswin@12345", Keys.ENTER);

		WebElement search= driver.findElement(By.name("q"));
		search.sendKeys("t-shirt", Keys.ENTER);


		XSSFWorkbook  wb=new XSSFWorkbook();
		XSSFSheet sheet=wb.createSheet("Product");
		XSSFRow row=sheet.createRow(0);
		XSSFCell cell=row.createCell(0);
		cell.setCellType(CellType.STRING);// converting to string
		cell.setCellValue("s.no");
		row.createCell(1).setCellValue("ProductName");
		row.createCell(2).setCellValue("Amount");
		row.createCell(3).setCellValue("type");
		row.createCell(4).setCellValue("sleeve");
		row.createCell(5).setCellValue("fit");
		row.createCell(6).setCellValue("fabric");


		int j=1; // row
		int k=1; // s.no
		for (int i=2; i<=3;i++){ //row
			for(int s=1;s<=4;s++) { //column

				WebElement product=driver.findElement(By.xpath(
						"//*[@id=\'container\']/div/div[3]/div[1]/div[2]/div["+i+"]/div/div["+s+"]"));
				action.moveToElement(product).click().perform();

				String oldwindow=driver.getWindowHandle();

				Set<String> handles= driver.getWindowHandles();
				
				
				for (String newwindow : handles) {
					driver.switchTo().window(newwindow);	
				}

				WebElement tShirtname=driver.findElement(By.xpath("//*[@class=\"B_NuCI\"]"));
				String shirtname=tShirtname.getText();
				System.out.println(shirtname);

				WebElement amount=driver.findElement
						(By.xpath("//*[@class=\"_30jeq3 _16Jk6d\"]"));
				String Price=	amount.getText();
				System.out.println(Price);

				WebElement details=driver.findElement
						(By.xpath("//*[@id=\'container\']/div/div[3]/div[1]/div[2]/div[6]/div[3]/div/div/div[1]/div[1]"));
				details.click();

				WebElement type=driver.findElement
						(By.xpath("//*[@id=\'container\']/div/div[3]/div[1]/div[2]/div[6]/div[3]/div/div/div[2]/div/div/div[1]/div[2]"));
				String type1=type.getText();
				System.out.println(type1);

				WebElement sleeve=driver.findElement
						(By.xpath("//*[@id=\'container\']/div/div[3]/div[1]/div[2]/div[6]/div[3]/div/div/div[2]/div/div/div[2]/div[2]"));
				String sleeve1=sleeve.getText();
				System.out.println(sleeve1);

				WebElement fit=driver.findElement
						(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[6]/div[3]/div/div/div[2]/div/div/div[3]/div[2]"));
				String fit1=fit.getText();
				System.out.println(fit1);

				WebElement fabric=driver.findElement
						(By.xpath("//*[@id=\'container\']/div/div[3]/div[1]/div[2]/div[6]/div[3]/div/div/div[2]/div/div/div[4]/div[2]"));
				String fabric1=fabric.getText();
				System.out.println(fabric1);

				driver.close();
				driver.switchTo().window(oldwindow);
				
				XSSFRow row1=sheet.createRow(j);
				XSSFCell cell1=row1.createCell(0);
				cell1.setCellType(CellType.STRING);// converting to string
				cell1.setCellValue(k++);
				row1.createCell(1).setCellValue(shirtname);
				row1.createCell(2).setCellValue(Price);
				row1.createCell(3).setCellValue(type1);
				row1.createCell(4).setCellValue(sleeve1);
				row1.createCell(5).setCellValue(fit1);
				row1.createCell(6).setCellValue(fabric1);

				FileOutputStream fileOut = new FileOutputStream("D://product.xlsx");
				wb.write(fileOut);
				j++;


			}
			
		}
		        driver.quit();       
	}
}

