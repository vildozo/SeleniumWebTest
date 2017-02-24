import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;




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
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
       
        //close Firefox
        driver.close();
       
        // exit the program explicitly
        System.exit(0);
    }
	

}
