package booking;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BookMyFlight extends TestData {
	public BookMyFlight() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{
		WebDriver driver= null;
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.yatra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		WebElement fromCity= driver.findElement(By.xpath("//*[@id='BE_flight_origin_city']"));
		fromCity.click();
		fromCity.sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		WebElement result=driver.findElement(By.xpath("//*[@class='viewport']"));
		if(result.getText()== "Bangalore")
		{
			   result.click();
		}
		
		WebElement toCity = driver.findElement(By.xpath("//*[@id='BE_flight_arrival_city']"));
		toCity.sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
        WebElement result2=driver.findElement(By.xpath("//*[@class='viewport']"));
		if(result.getText()== "Delhi")
		{
			   result2.click();
		}
 
		//Select date
		String depdate = sheet.getRow(1).getCell(3).getStringCellValue();
		String[] dt;
		String delimiter = "-";
		dt = depdate.split(delimiter);
		for (int i = 0; i < dt.length; i++)
		System.out.println(dt[i]);
		driver.findElement(By.xpath("//*[@id='BE_flight_origin_date']")).click();
		Select slc = new Select(driver.findElement(By.className("month-head BE_flight_origin_date")));
		slc.selectByVisibleText(dt[1]);
		WebElement dayWidget = driver.findElement(By.xpath("//[@class='day-container']"));
		List<WebElement> rows = dayWidget.findElements(By.tagName("tr"));
		List<WebElement> columns = dayWidget.findElements(By.tagName("td"));
		for (WebElement cell : columns) {
		// Select Date
		if (cell.getText().equals(dt[0])) 
		{
		cell.findElement(By.linkText(dt[0])).click();
		break;
		}
	  }
		
		//Click on search button
		driver.findElement(By.xpath("//*[@id=\"BE_flight_flsearch_btn\"]")).click();
	}
	
}
