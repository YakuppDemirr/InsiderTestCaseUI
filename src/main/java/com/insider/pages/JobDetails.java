package com.insider.pages;

import com.insider.core.PropertiesFile;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import static com.insider.base.Base.*;
import static com.insider.util.Utility.*;

public class JobDetails {

    public static By locationFilterElement =  By.id("select2-filter-by-location-container");
    public static By totalResultValue = By.id("deneme");
    public static By jobTitleElement = By.cssSelector(".position-department.text-large.font-weight-600.text-primary");
    public static By jobLocationElement = By.cssSelector(".position-location.text-large");
    public static By controlViewRoleButton = By.cssSelector(".btn.btn-navy.rounded.pt-2.pr-5.pb-2.pl-5");
    public static By selectJob = By.cssSelector(".position-list-item.col-12.col-lg-4.qualityassurance.istanbul-turkey.full-timeremote:first-child");
    public static By viewRoleElement = By.xpath("(//*[text()='View Role'])[1]");

    //Alternative Web Element
    //public static By totalResultValueAlternative = By.className(".totalResult");
    //public static By controlViewRoleButtonAlternative = By.xpath("(//*[text()='View Role'])");
    //public static By selectJobAlternative = By.xpath("(//div[@class='position-list-item col-12 col-lg-4 qualityassurance istanbul-turkey full-timeremote'])[1]");
    //public static By viewRoleElementAltervative = By.cssSelector(".btn.btn-navy.rounded.pt-2.pr-5.pb-2.pl-5[href='https://jobs.lever.co/useinsider/78ddbec0-16bf-4eab-b5a6-04facb993ddc']");

    public static void goJobDetails(){

        clickElement(locationFilterElement);
        Select select = new Select(driver.findElement(By.id("filter-by-location")));
        select.selectByVisibleText(PropertiesFile.jobLocation);
        log.info("*** Lokasyon olarak Istanbul, Turkey secildi. ***");
        waitBySeconds(2);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");

        String textElement = getText(totalResultValue);
        Integer count = Integer.valueOf(textElement);

        hoverElement(selectJob);

        log.info("*** Istanbul, Turkey lokasyonundan donen tüm QA joblari için title ve lokasyon icin value degeri alindi. ***");

        for (int i=0; i<count; i++)
        {
            Assert.assertEquals(getText(jobTitleElement), PropertiesFile.jobTitle);
            Assert.assertEquals(getText(jobLocationElement),PropertiesFile.jobLocation);
            Assert.assertTrue(isElementVisible(controlViewRoleButton));
        }

        if (count != 0) {
            clickElement(viewRoleElement);
            log.info("*** View Role butonlarindan sonuncusuna tiklandi tiklandi. ***");

            switchToNewTab();
            log.info("*** Yonlendirilen sayfaya gecis yapildi. ***");

            Assert.assertTrue(getLeverUrlControl());
            log.info("*** Yonlendirilen sayfanin Url kontrolu yapildi. ***");
        }
    }
}
