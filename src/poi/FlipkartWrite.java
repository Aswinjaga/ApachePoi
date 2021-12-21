package poi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;



public class FlipkartWrite {

	public static void main(String[] args) throws IOException , FileNotFoundException {
		// TODO Auto-generated method stub


		// String url=Base.properties().getProperty("URL"); 
		/* username=Base.properties().getProperty("username"); String
		 * password=Base.properties().getProperty("Password"); String
		 * search=Base.properties().getProperty("searchcontent");
		 */

		Base.init();
		Base.driver.get(Base.properties().getProperty("URL"));

		Elements.userName.sendKeys(Base.properties().getProperty("username"));
		Elements.passWord.sendKeys(Base.properties().getProperty("Password"),Keys.ENTER);
		Elements.search.sendKeys(Base.properties().getProperty("searchcontent"),Keys.ENTER);

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

		//            List<WebElement> allelement= Base.driver.findElements(By.xpath("(//*[@class=\'_1xHGtK _373qXS\'])[]"));
		//            for (WebElement newproduct : allelement) {
		int j=1;
		for (int i=1; i<=5;i++) {

			WebElement product1=Base.driver.findElement(By.xpath("(//*[@class='_1xHGtK _373qXS'])["+i+"]"));
			product1.click();

			String oldwindow=Base.driver.getWindowHandle();
			Set<String> handles= Base.driver.getWindowHandles();
			for (String newwindow : handles) {
				Base.driver.switchTo().window(newwindow);

			}
			String product=  Elements.productName.getText();
			String amount= Elements.amount.getText();
			Elements.dropdetails.click();
			String type=  Elements.type.getText();
			String sleeve=  Elements.sleeve.getText();
			String fit=  Elements.fit.getText();
			String fabric=  Elements.fabric.getText();

			XSSFRow row1=sheet.createRow(j);
			cell.setCellType(CellType.STRING);// converting to string
			row1.createCell(0).setCellValue(j);
			row1.createCell(1).setCellValue(product);
			row1.createCell(2).setCellValue(amount);
			row1.createCell(3).setCellValue(type);
			row1.createCell(4).setCellValue(sleeve);
			row1.createCell(5).setCellValue(fit);
			row1.createCell(6).setCellValue(fabric);

			FileOutputStream fo=new FileOutputStream("D:\\pom.xlsx");
			wb.write(fo);
			Base.driver.close();
			Base.driver.switchTo().window(oldwindow);
			j++;
		}
		    wb.close();
		    Base.driver.quit();
	}
}
