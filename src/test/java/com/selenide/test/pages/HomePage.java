package com.selenide.test.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class HomePage {

    /**
     * Home Page Title
     */
    @FindBy(xpath = "//title")
    public SelenideElement pageTitle;

    /**
     * Home Page Bit Title
     */
    @FindBy(xpath = "//strong[@class='big-title']")
    public SelenideElement homePageBigTitle;

    /**
     * About Us link of site menu
     */
    @FindBy(xpath = "//div[@id='site-menu']//a[@href='about.html']")
    public SelenideElement siteMenuAboutUsLink;

    /**
     * WorkClothes menu item
     */
    @FindBy(xpath = "//a[contains(text(),'Работы')]")
    public SelenideElement worksMenuItem;

    @Step("Enter URL with verification of page loading")
    public HomePage openURL() {
        open(System.getProperty("url"), HomePage.class);
        page(HomePage.class).homePageBigTitle.waitUntil(visible.because("Home Page hasn't been found after specifying the URL"), 20000);
        return page(HomePage.class);
    }

    @Step("Click Clothes menu item and verify that Work-Clothes page is opened")
    public WorkClothesPage openWorkClothesPage() {
        worksMenuItem.waitUntil(visible.because("Works link hasn't been found after 20 seconds"), 20000);
        worksMenuItem.waitUntil(enabled.because("Works link hasn't been found after 20 seconds"), 20000);
        worksMenuItem.click();
        page(WorkClothesPage.class).currentMenuItem.waitUntil(visible.because("WorkClothes page didn't open during 20 sec"), 20000);
        return page(WorkClothesPage.class);
    }
}
