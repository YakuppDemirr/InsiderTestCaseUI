package com.insider.core;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {

    public static String homePage;
    public static String browser;
    public static String jobTitle;
    public static String jobLocation;
    public static String careerUrl;
    public static String jobsLeverUrl;
    public static int defaultTimeout;

    public static Properties getProperties(){
        Properties prop = new Properties();

        try {
            InputStream inputStream = new FileInputStream(".properties");
            prop.load(inputStream);
            return prop;
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return null;
    }

    public static void readProperties(){
        Properties prob = PropertiesFile.getProperties();
        homePage = prob.getProperty("homePage");
        browser = prob.getProperty("browser");
        jobTitle = prob.getProperty("jobTitle");
        jobLocation = prob.getProperty("jobLocation");
        careerUrl = prob.getProperty("careerUrl");
        jobsLeverUrl = prob.getProperty("jobsLeverUrl");
        defaultTimeout = Integer.parseInt((prob.getProperty("defaultTimeout")));
    }
}
