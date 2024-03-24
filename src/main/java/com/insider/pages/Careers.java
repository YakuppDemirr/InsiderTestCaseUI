package com.insider.pages;

import org.openqa.selenium.*;
import org.testng.Assert;
import static com.insider.base.Base.*;
import static com.insider.util.Utility.*;

public class Careers {
    public static By acceptCookies = By.cssSelector("[id=wt-cli-accept-all-btn]");
    public static By companyTabElement = By.xpath("(//*[@id='navbarDropdownMenuLink'][contains(text(),'Company')])");
    public static By clickCareersElement = By.cssSelector("a[href='https://useinsider.com/careers/']");
    public static By teamsElement = By.cssSelector("div[data-id='b6c45b2']");
    public static By locationElement = By.cssSelector("div[data-id='b1a909d']");
    public static By lifeAtInsiderElement = By.cssSelector("div[data-id='87842ec']");
    public static By allTeamsElement = By.cssSelector(".btn.btn-outline-secondary.rounded.text-medium.mt-5.mx-auto.py-3.loadmore");
    public static By qualityAssuranceElement =  By.cssSelector(".job-title.mt-0.mt-lg-2.mt-xl-5>a[href='https://useinsider.com/careers/quality-assurance/']");
    public static By allQaJobElement = By.xpath("//*[text()='See all QA jobs']");

    //Alternative Web Elements
    //public static By teamsElementAlternative = By.cssSelector(".elementor-section.elementor-top-section.elementor-element.elementor-element-b6c45b2.elementor-section-full_width.elementor-section-height-default.elementor-section-height-default");
    //public static By locationElementAlternative = By.cssSelector("elementor-column.elementor-col-100.elementor-top-column.elementor-element.elementor-element-b1a909d");
    //public static By lifeAtInsiderElementAlternative = By.cssSelector(".elementor-column.elementor-col-100.elementor-top-column.elementor-element.elementor-element-87842ec");
    //public static By qualityAssuranceElementAlternative =  By.xpath("//*[text()='Quality Assurance']");
    //public static By allQaJobElementAlternative = By.cssSelector(".button-group.d-flex.flex-row");

    public static void goToCareersPageControl(){

        clickElement(acceptCookies);
        log.info("*** Cookies kabul edildi. ***");

        clickElement(companyTabElement);
        log.info("*** Company tabina tiklandi. ***");

        clickElement(clickCareersElement);
        log.info("*** Career sayfasina yonlendirildi. ***");

        Assert.assertTrue(getCareerPageControl());
        log.info("*** Career sayfasinin acilip acilmadigi kontrol edildi. ***");

        Assert.assertTrue(isElementVisible(teamsElement));
        log.info("*** Teams blok yuklenip yuklenmedigi kontrol edildi. ***");

        Assert.assertTrue(isElementVisible(locationElement));
        log.info("*** Location blok yuklenip yuklenmedigi kontrol edildi. ***");

        Assert.assertTrue(isElementVisible(lifeAtInsiderElement));
        log.info("*** Life at Insider blok yuklenip yuklenmedigi kontrol edildi. ***");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,2600)");

        waitBySeconds(2);
        clickElement(allTeamsElement);
        log.info("*** See all teams butonuna tiklandi. ***");

        js.executeScript("window.scrollBy(0,2000)");
        waitBySeconds(2);
        clickElement(qualityAssuranceElement);
        log.info("*** Quality Assurance containerina tiklandi. ***");

        clickElement(allQaJobElement);
        log.info("*** See all Qa jobs butonuna tiklandi. ***");
    }
}
