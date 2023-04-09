package orangehrm_saf;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_Test {
	@Test
	public void TestCase_2_VerifyUserCanAddPayGrades() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

//		1. Navigate
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//		2. Type the following credentials:
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("Admin");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin123");

//		3. Click Login button
		WebElement login_button = driver.findElement(By.className("oxd-button"));
		login_button.click();
//		4. Click on Admin from side menu bar
		WebElement Admin_Button = driver.findElement(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']"));
		Admin_Button.click();
//		5. Click Job dropdown
		WebElement Job_Dropdown = driver
				.findElement(By.xpath("//span[normalize-space()='Job']//i[@class='oxd-icon bi-chevron-down']"));
		Job_Dropdown.click();
//		6. Click Pay Grades
		WebElement Pay_Grade = driver.findElement(By.xpath("(//a[normalize-space()='Pay Grades'])[1]"));
		Pay_Grade.click();

//		7. Click green +Add button
		WebElement Add_Button = driver.findElement(By.xpath("//button[normalize-space()='Add']"));
		Add_Button.click();

//		8. Type "Indian Rupee" in the name input field
		WebElement Name_Input = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
		Name_Input.sendKeys("Indian Rupee");

//		9. Click green Save button
		WebElement Save_Button = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
		Save_Button.click();

//		10. Click green + Add button on the Currencies section 
		WebElement Add_currencies = driver.findElement(By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']"));
		Add_currencies.click();

//		12. Type Minimum Salary as 30000
		WebElement Minimum_Salary = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]"));
		Minimum_Salary.sendKeys("30000");

//		11. Select Indian Rupee from Current dropdown
		WebElement Current_Dropdown = driver.findElement(By.xpath("//div[@class='oxd-select-text-input']"));
		Current_Dropdown.click();
		Current_Dropdown.sendKeys("iii" + Keys.ENTER);

//		13. Type Maximum Salary as 100000
		WebElement maximum_Salary = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[4]"));
		maximum_Salary.sendKeys("100000");

//		14. Click green Save button on Currencies section
		WebElement Save_Button_currencies = driver
				.findElement(By.xpath("(//button[@type='submit'][normalize-space()='Save'])[2]"));
		Save_Button_currencies.click();

//		Expected Result
//		1. Verify user can observe the added records in the Currencies section
		WebElement addedCurrency = driver.findElement(By.xpath("//div[normalize-space()='Indian Rupee']"));
		Assert.assertNotNull(addedCurrency);

		Thread.sleep(5000);
		driver.close();
	}

	@Test
	public void TestCase_1_SearchUserWithPartialTextMatch() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

//		1. Navigate
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//		2. Type the following credentials:
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("Admin");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin123");

//		3. Click Login button
		WebElement login_button = driver.findElement(By.className("oxd-button"));
		login_button.click();

//		4. Click on PIM from side menu bar
		WebElement PIM = driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']"));
		PIM.click();
//		Thread.sleep(500);

//		5. Type "ch" in the Employee Name text input field
		WebElement Employee_Name = driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]"));
		Employee_Name.sendKeys("ch");
		
//		Expected Results:
//		Verify user can see a list of predicted users that has "ch" in their names
//		(ignore case/not case sensitive)
//	    List<WebElement> employeeList = driver.findElements(By.xpath("//div[@class='ac_results']//li"));
//	    boolean isEmployeeListDisplayed = false;
//	    for (WebElement employee : employeeList) {
//	        String employeeName = employee.getText();
//	        if (employeeName.toLowerCase().contains("ch")) {
//	            isEmployeeListDisplayed = true;
//	        } else {
//	            isEmployeeListDisplayed = false;
//	            break;
//	        }
//	    }
//	    System.out.println(isEmployeeListDisplayed);
//	   Assert.assertTrue(isEmployeeListDisplayed);

//		6. Click on green Search button
		WebElement Search_Button = driver.findElement(By.xpath("(//button[normalize-space()='Search'])[1]"));
		Search_Button.click();

//			Expected Results:
//			2. The system will display results of records found - from there verify that at least the first 3 should have ch in either First or Last name column
//
//		List<WebElement> employeeTableRows = driver.findElements(By.cssSelector("XYZ"));
//		 for (int i = 1; i <= 3; i++) {
//		        String firstName = driver.findElement(By.xpath("XYZ")).getText();
//		        String lastName = driver.findElement(By.xpath("XYZ"))
//		                .getText();
//		 }
		Thread.sleep(5000);
		driver.close();

	}

}
