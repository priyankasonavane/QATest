package com.ui.BranchFinal;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BranchTest {
	private WebDriver driver;

	int deptCt = 0;
	int count2, count3, count4, count5, count6 = 0;
	WebElement io, io2, io3, allTab, dataTab, engineeringTab, marketingTab, powerGrowthTab, operationsTab, productTab,
			recruitingTab;

	List<String> employeesDeptNames = new ArrayList<String>();
	List<String> allEmployeesNames = new ArrayList<String>();
	List<String> OtherListEmployeeNameandDept = new ArrayList<String>();
	Map<String, String> allEmployeeNameandDept = new Hashtable<String, String>();
	Map<String, String> OtherDeptMap = new Hashtable<String, String>();
	List<String> allOtherDepartmentNames = new ArrayList<String>();
	List<String> duplicatevalues = new ArrayList<String>();
	List<String> uniquevalues = new ArrayList<String>();
	List<WebElement> employeesName, employeeDepartment, dataemployeesName, dataDepartment, engineeringemployeesName,
			engineeringDepartment, marketingemployeesName, marketingDeptName, operationsemployeesName,
			operationsDeptName, powerGrowthemployeesName, powerGrowthDeptName, productemployeesName, productDeptName,
			recruitingemployeesName, recruitinDeptName;
	List<String> recrutingCompare = new ArrayList<String>();
	List<String> powerGrowthCompare = new ArrayList<String>();
	Actions actions;

	@BeforeSuite
	public void beforeClass() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/p.sonavane/Documents/JarFiles/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Branch Metrics");
		driver.findElement(By.name("btnK")).click();
		// Step 2. Navigate to branch website
		io = driver.findElement(By.xpath("//div[@class='rc']/h3/a"));
		io.click();

		// System.out.println("Navigating to footnotes");
		Thread.sleep(1000);
		io2 = driver.findElement(By.xpath("//div[@class='right-content']/ul/li[1]/ul/li[5]/a"));
		io3 = driver.findElement(By.xpath("//div[@class='right-content']/ul/li[1]/ul/li[2]/a"));
		actions = new Actions(driver);
		actions.moveToElement(io2).perform();
		actions.moveToElement(io3).click().perform();
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, 250)");

		// actions = new Actions(driver);
		allTab = driver.findElement(By.xpath("//a[@href='#all']"));
		actions = new Actions(driver);
		actions.moveToElement(allTab).click().perform();
		// System.out.println("Navigated to All");
		// System.out.println("finished");

		actions.moveToElement(allTab).click().perform();
		employeesName = driver.findElements(By.xpath("//div[@class='info-block']/h2"));
		employeeDepartment = driver.findElements(By.xpath("//div[@class='info-block']/h4"));
		for (WebElement element : employeesName) {
			allEmployeesNames.add(element.getText());
		}
		for (WebElement ele : employeeDepartment) {
			employeesDeptNames.add(ele.getText());
		}
		for (int i = 0; i < employeesName.size(); i++) {
			allEmployeeNameandDept.put(allEmployeesNames.get(i), employeesDeptNames.get(i));
		}

		dataTab = driver.findElement(By.xpath("//a[@href='#data']"));
		actions = new Actions(driver);
		actions.moveToElement(dataTab).click().perform();
		dataemployeesName = driver.findElements(By.xpath("//div[@class='info-block']/h2"));
		dataDepartment = driver.findElements(By.xpath("//div[@class='info-block']/h4"));
		for (WebElement ele : dataemployeesName) {
			OtherListEmployeeNameandDept.add(ele.getText());
		}
		for (WebElement element : dataDepartment) {
			allOtherDepartmentNames.add(element.getText());
			if (element.getText().equals("Data")) {
				deptCt = deptCt + 1;
			}
		}

		engineeringTab = driver.findElement(By.xpath("//a[@href='#engineering']"));
		actions.moveToElement(engineeringTab).click().perform();
		engineeringemployeesName = driver.findElements(By.xpath("//div[@class='info-block']/h2"));
		engineeringDepartment = driver.findElements(By.xpath("//div[@class='info-block']/h4"));
		for (WebElement ele : engineeringemployeesName) {
			OtherListEmployeeNameandDept.add(ele.getText());
		}
		for (WebElement element : engineeringDepartment) {
			allOtherDepartmentNames.add(element.getText());
			if (element.getText().equals("Engineering") || element.getText().equals("Co-Founder / Engineering")
					|| element.getText().equals("Co-Founder / CEO")) {
				deptCt = deptCt + 1;
			}
		}

		marketingTab = driver.findElement(By.xpath("//a[@href='#marketing']"));
		actions.moveToElement(marketingTab).click().perform();
		marketingemployeesName = driver.findElements(By.xpath("//div[@class='info-block']/h2"));
		marketingDeptName = driver.findElements(By.xpath("//div[@class='info-block']/h4"));
		for (WebElement ele : marketingemployeesName) {
			OtherListEmployeeNameandDept.add(ele.getText());
		}
		for (WebElement element : marketingDeptName) {
			allOtherDepartmentNames.add(element.getText());
			if (element.getText().equals("Co-Founder / Marketing") || element.getText().equals("Marketing")) {
				deptCt = deptCt + 1;
			}
		}

		operationsTab = driver.findElement(By.xpath("//a[@href='#operations']"));
		actions.moveToElement(operationsTab).click().perform();
		operationsemployeesName = driver.findElements(By.xpath("//div[@class='info-block']/h2"));
		operationsDeptName = driver.findElements(By.xpath("//div[@class='info-block']/h4"));

		for (WebElement ele : operationsemployeesName) {
			OtherListEmployeeNameandDept.add(ele.getText());
		}
		for (WebElement element : operationsDeptName) {
			allOtherDepartmentNames.add(element.getText());
			if (element.getText().equals("Operations")) {
				deptCt = deptCt + 1;
			}
		}

		powerGrowthTab = driver.findElement(By.xpath("//a[@href='#partner-growth']"));
		actions.moveToElement(powerGrowthTab).click().perform();

		powerGrowthemployeesName = driver.findElements(By.xpath("//div[@class='info-block']/h2"));
		powerGrowthDeptName = driver.findElements(By.xpath("//div[@class='info-block']/h4"));
		for (WebElement ele : powerGrowthemployeesName) {
			OtherListEmployeeNameandDept.add(ele.getText());
		}
		for (WebElement element : powerGrowthDeptName) {
			allOtherDepartmentNames.add(element.getText());
			if (element.getText().equals("Partner Growth") || element.getText().equals("Partner growth")
					|| element.getText().equals("Co-Founder / COO")) {
				deptCt = deptCt + 1;
			}
		}

		productTab = driver.findElement(By.xpath("//a[@href='#product']"));
		actions.moveToElement(productTab).click().perform();
		productemployeesName = driver.findElements(By.xpath("//div[@class='info-block']/h2"));
		productDeptName = driver.findElements(By.xpath("//div[@class='info-block']/h4"));
		for (WebElement ele : productemployeesName) {
			OtherListEmployeeNameandDept.add(ele.getText());
		}
		for (WebElement element : productDeptName) {
			allOtherDepartmentNames.add(element.getText());
			if (element.getText().equals("Product")) {
				deptCt = deptCt + 1;
			}
		}

		recruitingTab = driver.findElement(By.xpath("//a[@href='#recruiting']"));
		actions.moveToElement(recruitingTab).click().perform();
		recruitingemployeesName = driver.findElements(By.xpath("//div[@class='info-block']/h2"));
		recruitinDeptName = driver.findElements(By.xpath("//div[@class='info-block']/h4"));
		for (WebElement ele : recruitingemployeesName) {
			OtherListEmployeeNameandDept.add(ele.getText());
		}
		for (WebElement element : recruitinDeptName) {
			allOtherDepartmentNames.add(element.getText());
			if (element.getText().equals("Recruiting")) {
				deptCt = deptCt + 1;
			}
		}

	}

	
	@Test
	public void getEmpDeptMatchNum() {
		for (int i = 0; i < OtherListEmployeeNameandDept.size(); i++) {
			OtherDeptMap.put(OtherListEmployeeNameandDept.get(i), allOtherDepartmentNames.get(i));
		}

		int num = 0;

		for (Map.Entry<String, String> entry : OtherDeptMap.entrySet()) {
			String allTabEmp = allEmployeeNameandDept.get(entry.getKey());
			String deptTab = entry.getValue();
			if (allTabEmp != null && deptTab != null && allTabEmp.equals(deptTab)) {
				num = num + 1;
			}

		}
		// System.out.println(num);
		assertTrue(num == 125);
	}

	@Test
	public void getEmployeesMatchNum() {

		for (String item : allEmployeesNames) {
			if (OtherListEmployeeNameandDept.contains(item)) {
				duplicatevalues.add(item);
			} else {
				uniquevalues.add(item);
			}
		}
		// System.out.println(duplicatevalues.size());
		assertTrue(duplicatevalues.size() == 125);
	}

	@Test
	public void getRecruitmentMatchEmp() {
		for (WebElement element : employeeDepartment) {
			recrutingCompare.add(element.getText());
			if (element.getText().equals("Recruiting")) {
				count2 = count2 + 1;
			}
		}

		for (WebElement element : recruitinDeptName) {
			allOtherDepartmentNames.add(element.getText());
			if (element.getText().equals("Recruiting")) {
				count3 = count3 + 1;
			}
		}
		Assert.assertEquals(count2, count3);

	}

	@Test
	public void getProductMatchEmp() {
		for (WebElement element : employeeDepartment) {
			recrutingCompare.add(element.getText());
			if (element.getText().equals("Product")) {
				count4 = count4 + 1;
			}
		}

		for (WebElement element : recruitinDeptName) {
			allOtherDepartmentNames.add(element.getText());
			if (element.getText().equals("Product")) {
				count5 = count5 + 1;
			}
		}
		Assert.assertEquals(count4, count5);

	}

	// Failing a test as part of assignment
	@Test
	public void gettwitterlinksFromAllTabs() {
		allTab = driver.findElement(By.xpath("//a[@href='#all']"));
		actions.moveToElement(allTab).click().perform();
		List<WebElement> twitterLink = driver
				.findElements(By.xpath("//a[@class='profile-link']/img[@src='/img/team/link_icons/ic_twitter.svg']"));
		// System.out.println(twitterLink.size());

		Assert.assertEquals(twitterLink.size(), employeesName.size());

		// The reason for failing the test is each employee doesn't have Twitter link associated with his/her profile
	}
}
