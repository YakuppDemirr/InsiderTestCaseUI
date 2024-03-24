package com.insider.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;

import java.time.Duration;
import static com.insider.base.Base.*;

public class DriverManager {

    public static WebDriver driver = null;

    public static void setUpDriver(String browserType){
        switch (browserType){
            case "chrome":
                log.info("*** Chrome Browser Baslatiliyor ***");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                log.info("*** Firefox Browser Baslatiliyor ****");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PropertiesFile.defaultTimeout));
    }

    public static void quitDriver(){
        if (driver != null){
            driver.close();
            driver.quit();
        }
    }
}
