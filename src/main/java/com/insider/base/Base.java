package com.insider.base;

import com.insider.core.*;
import org.apache.log4j.*;
import org.testng.ITestResult;
import org.testng.annotations.*;
import static com.insider.core.PropertiesFile.*;
import static com.insider.database.MySqlConnection.insertMySql;
import static com.insider.util.Utility.*;

public class Base extends DriverManager {

    public static Logger log = Logger.getLogger("InsiderTestCaseUI");

    @Parameters({"browser"})
    @BeforeTest()
    public void initialize(@Optional String browser) {
        PropertyConfigurator.configure("log4j.properties");
        readProperties();
        setUpDriver(PropertiesFile.browser);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        String testName = result.getName();
        String instanceName = result. getInstanceName();
        String status = "";

        if (result.getStatus() == ITestResult.FAILURE)
        {
            takeScreenShot(driver,result.getName());
            status = "FAIL";
            String stackTrace = result.getThrowable().toString();
            System.out.println(stackTrace);
        }
         else if (result.getStatus() == ITestResult.SUCCESS) {
            status = "SUCCESS";

        } else if (result.getStatus() == ITestResult.SKIP) {
            status = "SKIP";
        }
         //Testin süresi ms cinsinden alınır
         String duration = String.valueOf(result.getEndMillis() - result.getStartMillis());

        insertMySql(testName,instanceName, status, duration);
        log.info("*** Browser kapatildi. ***");
        quitDriver();
    }
}
