package com.selenide.test.tests;

import com.selenide.test.config.BaseConfigs;
import com.selenide.test.config.ScreenshotListener;
import com.selenide.test.pages.HomePage;
import com.selenide.test.pages.WorkClothesPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;


@Features("Opening Support Pages Tests")
@Listeners({ScreenshotListener.class})
public class OpenPagesTest extends BaseConfigs {

    /**
     * 1.1. Open Work Clothes page
     * test of opening Work Clothes page
     */
    @Test(priority = 1)
    @Description("1.1. Verification of Work Clothes page existence")
    @Title("Verification of Work Clothes page existence")
    @Stories("Verification of Work Clothes page existence")
    @Severity(SeverityLevel.CRITICAL)
    public void openWorkClothesPage() {
        HomePage homePage = new HomePage();
        homePage = homePage.openURL();
        System.out.println("Opening WorkClothes page");
        WorkClothesPage workClothesPage = homePage.openWorkClothesPage();
        workClothesPage.verifyThatCorrectPageIsOpen();
    }
}
