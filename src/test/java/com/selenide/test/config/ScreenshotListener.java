package com.selenide.test.config;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import ru.yandex.qatools.allure.annotations.Attachment;

public class ScreenshotListener extends TestListenerAdapter {

  @Override
  public void onTestSuccess(ITestResult result) {
    makeScreenshot();
    if (result.getThrowable()!=null) {
      result.getThrowable().printStackTrace();
    }
  }

  @Override
  public void onTestFailure(ITestResult result) {
    makeScreenshot();
    if (result.getThrowable()!=null) {
      result.getThrowable().printStackTrace();
    }
  }

  @Attachment(value = "Page screenshot", type = "image/png")
  public byte[] makeScreenshot() {
    return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
  }
}
