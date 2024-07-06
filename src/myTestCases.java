import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mysql.cj.xdevapi.Statement;

public class myTestCases {
	
	Connection con;
	
	java.sql.Statement stmt;
	
	ResultSet rs;
	
	String url="https://magento.softwaretestingboard.com/customer/account/create/";
	
	WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	public void Setup() throws SQLException {
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "RAMA");
	}
	
	@Test
	public void getData() throws SQLException {
		
		stmt = con.createStatement();
		rs = stmt.executeQuery("select * from employees where employeeNumber=1002");
		int employeeNumber;
		String lastName = null, firstName=null, email=null, extension=null;

		while (rs.next()) {
			employeeNumber = rs.getInt("employeeNumber");
			lastName = rs.getNString("lastName");
			firstName = rs.getNString("firstName");
			email =rs.getNString("email");
			extension = rs.getNString("extension");

		}
		
		driver.get(url);
		driver.findElement(By.id("firstname")).sendKeys(firstName);
		driver.findElement(By.id("lastname")).sendKeys(lastName);
		driver.findElement(By.id("email_address")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(extension);
		driver.findElement(By.id("password-confirmation")).sendKeys(extension);
		//driver.findElement(By.className("action submit primary")).click();
		
	}
	
}
