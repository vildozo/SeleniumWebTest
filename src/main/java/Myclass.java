import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.*;




public class Myclass {

    public static void main(String[] args) {
    	System.setProperty("webdriver.gecko.driver", "/home/jv/Desktop/SeleniumBrowserDrivers/browserMozila/geckodriver");
    	int testPassed=0;
    	int testFailed=0;
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
        
        WebElement myElement = driver.findElement(By.name("userName"));
        myElement.sendKeys("Javier");
        driver.findElement(By.name("login")).click();
        
        
        
        

        /*
         * compare the actual title of the page witht the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            testPassed++;
        } else {
            testFailed++;
        }
        
        
        //@Test 
        try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        expectedTitle = "Sign-on: Mercury Tours";
        String secondTitle="";
        secondTitle = driver.getTitle();
        
        System.out.println(expectedTitle +"   +    "+ secondTitle);
        
        
        if (secondTitle.contentEquals(expectedTitle)){
            testPassed++;
        } else {
            testFailed++;
        }
        
        
        
        
        System.out.println("Test Passed: "+testPassed);
        System.out.println("Test Failed: "+testFailed);
       
        //close Firefox
        driver.close();
       
        // exit the program explicitly
        System.exit(0);
    }
	

}
