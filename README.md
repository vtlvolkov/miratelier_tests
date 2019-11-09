# HomeBeatLive automated tests

This set of testes covers the most basic functionality to run on daily basis or after any new commit

## Overview
* [Selenium Web Driver](http://www.seleniumhq.org/download/) is used for browsers interactions.
* [Maven](https://maven.apache.org/) is used for dependencies management, project build and reporting.
* SetupDriver class is used for initial setup of the web driver to indicate which browser is to be used, project url etc..
* pom.xml contains all required dependencies, build setup and Allure report integration
* testng.xml describes test suite that will be running.
````
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="SmokeTest">
    <test name="Login" preserve-order="true">
        <classes>
            <class name="TestLogin"/>
        </classes>
    </test>
    <test name="Links" preserve-order="true">
        <classes>
            <class name="TestLinksClick"/>
        </classes>
    </test>
    <test name="Emergency" preserve-order="true">
        <classes>
            <class name="TestReportEmergency"/>
        </classes>
    </test>
    <test name="Apartments" preserve-order="true">
        <classes>
            <class name="TestAddApartments"/>
        </classes>
    </test>
</suite>
````
## Prerequisites
* [JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)  
* [Maven](https://maven.apache.org/)  
* [Selenium](http://www.seleniumhq.org/download/)
`Chromedriver` is already present in `resources` directory. By default `headless` option is set for Chrome. It can be set up in SetupDriver class.  
````

## Installation
* Ensure JAVA_HOME environment variable is set and points to your JDK installation
````
echo $JAVA_HOME
/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home
````
* Extract distribution archive in any directory
````
tar xzvf apache-maven-3.5.2-bin.tar.gz
````
* Add the bin directory of the created directory apache-maven-3.5.2 to the PATH environment variable
````
export PATH=/opt/apache-maven-3.5.2/bin:$PATH
````


## Running the tests
To run the tests you simply need to run the following command:
````
mvn clean test site
````
`clean` - removes /target directory  
`test` - runs test suite defined in testng.xml  
`site` - generates Allure report in /target directory  