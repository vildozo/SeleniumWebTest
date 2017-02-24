import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;




public class Myclass {

    public static void main(String[] args) {
    	System.setProperty("webdriver.gecko.driver", "/home/jv/Desktop/SeleniumBrowserDrivers/browserMozila/geckodriver");

    	//Now you can Initialize marionette driver to launch firefox
    	DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    	capabilities.setCapability("marionette", true);
    	WebDriver driver = new FirefoxDriver(capabilities);
    	
   
    	
        String baseUrl = "http://newtours.demoaut.com";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";
        

        // launch Firefox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();
        
        
        
        
        
        

        /*
         * compare the actual title of the page witht the expected one and print
         * the result as "Passed" or "Failed"
         */
        
//@Test1
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test1 passed");
        } else {
            System.out.println("Test1Failed");
        }
       
        
        
        
        
    	
//@Test2 Sign-on: Mercury Tours 
    	
    	WebElement myElement = driver.findElement(By.name("userName"));
        myElement.sendKeys("Javier");
        driver.findElement(By.name("login")).click();
        
        
        //declaring implicit wait     		
      	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        
        
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.titleContains("Sign-on: Mercury Tours"));
        
        
      	expectedTitle = "Sign-on: Mercury Tours";
        String secondTitle="";
        secondTitle = driver.getTitle();
        
        System.out.println("EXPECTED:"+expectedTitle +"        GOT: "+ secondTitle);
        
        
        if (secondTitle.contentEquals(expectedTitle)){
        	System.out.println("Test2 passed");
        } else {
        	System.out.println("Test2 failed");
        }
        
        
        
    
       
        //close Firefox
        driver.close();
       
        // exit the program explicitly
        System.exit(0);
    }
	

}
