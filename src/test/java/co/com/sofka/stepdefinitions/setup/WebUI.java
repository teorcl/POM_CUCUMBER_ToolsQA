package co.com.sofka.stepdefinitions.setup;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;
import static co.com.sofka.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;

public class WebUI {
    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String WEBDRIVER_CHROME_DRIVER_PATH = "src/test/resources/driver/windows/chrome/chromedriver.exe";
    private static final String DEMO_TOOLSQA_URL = "https://www.demoqa.com/automation-practice-form";

    protected WebDriver driver;

    protected void setUpWebDriver(){
        System.setProperty(WEBDRIVER_CHROME_DRIVER,WEBDRIVER_CHROME_DRIVER_PATH);
    }

    protected void setUpWebDriverUrl(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(DEMO_TOOLSQA_URL);
    }

    protected void setUpLog4j2(){
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }


    protected void generalSetUp(){
        setUpLog4j2();
        setUpWebDriver();
        setUpWebDriverUrl();
    }

    protected void quitDriver(){
        driver.quit();
    }
}
