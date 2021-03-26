# Demo_WebAutomationTask_Selenium_BDD
WebAutomation_Simple_Tests (BDD framework for automation using Selenium Cucumber)

### repository url


### Use the testng.xml file to run the test cases
1. simply checkout or clone this project from github
2. build the project
3. go to run configuration and run by testNG, below screenshot for ref
4. Add Run time environment variables -Dbrowser=chrome -DEmailAddress=youremail and -DPassword=12345
![img_2.png](https://github.com/JawaharKanagaraj-AutomationTesting/Demo_WebAutomationTask_Selenium_BDD/blob/master/src/test/resources/resultimage/img1.png)


### To see this whole thing running simply checkout this project and run this command:
1. simply checkout or clone this project from github
2. build the project
3. `mvn clean verify`-Dbrowser=chrome -DEmailAddress and -DPassword

### Cucumber Report

There is a feature overview page:
![feature overview page](https://github.com/JawaharKanagaraj-AutomationTesting/Demo_WebAutomationTask_Selenium_BDD/blob/master/src/test/resources/resultimage/img3.png)

And there are also feature specific results pages:
![feature_detailed_page](https://github.com/JawaharKanagaraj-AutomationTesting/Demo_WebAutomationTask_Selenium_BDD/blob/master/src/test/resources/resultimage/img2.png)


### Framework enhancement - To do
1. repeat(duplicate) methods to put in common utils for reuse
2. exception handling
3. handle ff, chrome, ie and edge browser support
4. log4j for logging
5. helper class to handle web components such as buttons,link,..
6. remote webdriver (selenium grid) for multiple browser execution
7. screenshot capture for passed/failed tests




