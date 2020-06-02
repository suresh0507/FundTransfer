package DBLogin;

	import java.awt.AWTException;
import java.sql.Connection;
	import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class DB_Login {
		
		static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	    static final String DB_URL = "http://elastic.rapidtestpro.com:8086/index";
	    static final String USER = "belitypi";
	    static final String PASSWORD = "47GWrkhPknA3";
	    static WebDriver driver;

	    //public static LinkedList<String>names = new LinkedList<>();

	public static void main(String[] args) throws ClassNotFoundException, SQLException, AWTException  {
	    Connection connection = null;
	    Statement statement = null;
	    
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
	    
	    statement = connection.createStatement();


	    String query = "SELECT * FROM Vayu where ScriptName ='Suresh_Transfer';";

	    ResultSet results = statement.executeQuery(query);
	    
	    while(results.next()) {

	 

	    String username = results.getString("UserName");
	    String password = results.getString("Password");
	    WebDriverManager.firefoxdriver().setup();
	    driver = new ChromeDriver();
	    driver.get("http://demo.guru99.com/test/newtours/login.php");
	    driver.manage().window().maximize();
	    driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	    
	    }
	}
	}