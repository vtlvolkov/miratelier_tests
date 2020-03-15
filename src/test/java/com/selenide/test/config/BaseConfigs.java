package com.selenide.test.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.restassured.RestAssured;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class BaseConfigs extends ScreenshotListener {
  private static final String CHROMEDRIVER_PATH_FORMAT = "ChromeDriver/chromedriver_%s";
  private static final String CHROMEDRIVER_PATH_MAC =
    String.format(CHROMEDRIVER_PATH_FORMAT, "mac64/chromedriver");
  private static final String CHROMEDRIVER_PATH_LINUX =
    String.format(CHROMEDRIVER_PATH_FORMAT, "linux64/chromedriver");
  private static final String CHROMEDRIVER_PATH_WINDOWS =
    String.format(CHROMEDRIVER_PATH_FORMAT, "win32/chromedriver.exe");
  public WebDriver webDriver;

  //style for fields messages
  public static final String FIELD_TEXT_MESSAGE_VISIBLE="opacity: 1; margin-top: 0px;";
  public static final String FIELD_TEXT_INCORRECT_LIGHT_RGB="rgb(236, 65, 59)";
  public static final String FIELD_TEXT_INCORRECT_LIGHT_RGBA="rgba(236, 65, 59, 1)";
  public static final String FIELD_TEXT_INCORRECT_LIGHT_RADIOBATTONS_RGB="rgb(213, 0, 0)";


  @BeforeMethod
  public void setBrowser () throws IOException {
    String chromeBinaryPath = "";
    String osName = System.getProperty("os.name").toUpperCase();

    if (osName.contains("WINDOWS")) {
      chromeBinaryPath = CHROMEDRIVER_PATH_WINDOWS;
    } else if (osName.contains("MAC")) {
      chromeBinaryPath = CHROMEDRIVER_PATH_MAC;
    } else if (osName.contains("LINUX")) {
      chromeBinaryPath = CHROMEDRIVER_PATH_LINUX;
    }

    File chromedriver = new File(ClassLoader.getSystemResource(chromeBinaryPath).getPath());

    // set application user permissions to 455
    chromedriver.setExecutable(true);

    System.setProperty("webdriver.chrome.driver", chromedriver.getPath());

    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--no-sandbox");
    chromeOptions.addArguments("--disable-dev-shm-usage");
    chromeOptions.addArguments("--aggressive-cache-discard");
    chromeOptions.addArguments("--disable-cache");
    chromeOptions.addArguments("--disable-application-cache");
    chromeOptions.addArguments("--disable-offline-load-stale-cache");
    chromeOptions.addArguments("--disk-cache-size=0");
    chromeOptions.addArguments("--headless");
    chromeOptions.addArguments("--disable-gpu");
    chromeOptions.addArguments("--dns-prefetch-disable");
    chromeOptions.addArguments("--no-proxy-server");
    chromeOptions.addArguments("--log-level=3");
    chromeOptions.addArguments("--silent");
    chromeOptions.addArguments("--disable-browser-side-navigation");
    chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
    chromeOptions.setProxy(null);
    WebDriver webDriver = new ChromeDriver( chromeOptions );
    WebDriverRunner.setWebDriver(webDriver);

    Configuration.reportsFolder = "target/screenshots";
    Configuration.timeout=8000;
  }

  @AfterMethod
  public void shutdown() {
    Selenide.close();
  }
}
