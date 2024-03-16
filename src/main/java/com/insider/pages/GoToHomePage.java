package com.insider.pages;

import static com.insider.core.PropertiesFile.*;
import static com.insider.core.DriverManager.*;
import static com.insider.base.Base.*;

public class GoToHomePage {

    public static void goToHomePage(){

        driver.navigate().to(homePage);
        log.info("*** Ana sayfa aciliyor. ***");
    }
}
