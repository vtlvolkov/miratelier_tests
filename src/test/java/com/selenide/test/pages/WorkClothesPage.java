package com.selenide.test.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class WorkClothesPage {

    /**
     * Page Title
     */
    @FindBy(xpath = "//li[@class='current-menu-item']")
    public SelenideElement currentMenuItem;

    @Step("Verify that Pager Title contains Clothes")
    public void verifyThatCorrectPageIsOpen() {
        Assert.assertEquals(currentMenuItem.getText(), "РАБОТЫ");
    }
}
