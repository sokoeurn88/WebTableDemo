package webtabledemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablesDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sokoeurn chhay\\Selenium_Java_Review\\WebTableDemo\\Driver97\\chromedriver.exe");
//		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		//switch to frame that has particular table
		//get the number of rows
		//get the number of columns
		//iterate rows and columns to get text and print
		//tr=row, td=columns, 
		/*WebElement frame1 = driver.findElement(By.id(""));
		driver.switchTo().frame(0);
		
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[3]/td[1]
		//*[@id="customers"]/tbody/tr[4]/td[1]
		
		//*[@id="customers"]/tbody/tr[7]/td[1]*/
		
		//for dynamic table
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr"));
		int rowCount = rows.size();
		System.out.println("Total rows in the table : "+rowCount);
		
		
		String beforeXpath = "//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath ="]/td[1]";
		
		//for(;;){}
		for(int i=2;i<=rowCount;i++){
			String actualXpath = beforeXpath+i+afterXpath;
			WebElement element=driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getSize());
				if(element.getText().equals("Island Trading")) {
					System.out.println("company name : "+ element.getText()+ " is found");
					break;
				}
		}
		
		System.out.println("**********************");
		//*[@id="customers"]/tbody/tr[2]/td[2]
		String contactXpath = "]/td[2]";
		for(int i=2;i<=rowCount;i++){
			String actualXpath = beforeXpath+i+contactXpath;
			WebElement element=driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getSize());
			
		}
		
		//handle webtable columns
		
		//*[@id="customers"]/tbody/tr[1]/th[1]
		//*[@id="customers"]/tbody/tr[1]/th[2]
		//*[@id="customers"]/tbody/tr[1]/th[3]
		
		String colBeforeXpath="//*[@id=\"customers\"]/tbody/tr[1]/th[";
		String colAfterXpath="]";
		List<WebElement> cols=driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr[1]/th"));
		int colCount=cols.size();
		System.out.println("Total number of columns are : "+colCount+".");
		
		for(int i=1;i<=colCount;i++) {
			WebElement element=driver.findElement(By.xpath("colBeforeXpath+i+colAfterXpath"));
			String colText=element.getText();
			System.out.println("colText");
		}
		
		
		
	driver.close();
	driver.quit();

	}
	
}
