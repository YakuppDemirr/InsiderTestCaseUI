package com.insider;

import com.insider.base.Base;
import com.insider.util.Utility;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.insider.pages.Careers.*;
import static com.insider.pages.GoToHomePage.*;
import static com.insider.pages.JobDetails.*;

public class InsiderTestCasesUI extends Base {

    @BeforeMethod()
    public void openHomePage(){
        goToHomePage();
        Assert.assertTrue(Utility.getHomePageControl());
        log.info("*** Ana sayfa basarili bir sekilde acildi. ***");
    }

   /* @Test()
    public void insiderStudyCase(){
        goToCareersPageControl();
        goJobDetails();
    }*/

    @Test()
    public void insiderStudyCase2(){
        goToHomePage();
    }
}

