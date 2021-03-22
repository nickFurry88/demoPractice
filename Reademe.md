The project is created using Selenium webdriver + Maven + testNG
This project is capable to run on both Chrome and Firefox. 
Option of Browser can be given in */configFiles/demo.properties file, with attribute "*.browser=chrome", where * is environment name like Production, staging etc.
Login email, otp and baseUrlare also in the same file.

Chrome driver will support Chrome browser version -  89.0.4389.90 (Official Build) (64-bit)
if you have another version, then have to download applicable version of Chrome driver.
Both Chrome and firefox drivers are in folder */driver/

Steps to run project:
1) Install selenium 4.0.*
2) Install Maven (Follow instrunction here https://www.eclipse.org/m2e/)
3) Clone the project from git repository
4) Import the project in Selenium as maven project
5) Right click on Project -> Run As -> Maven build
6) Give "clean install" as Goal in the pop up box. 
7) Uncheck "Skip test" option is checked.
8) Click Run

Test Run:
The test will
1) Open login page and enter email id
2) Click on Submit otp
3) Create a Poll with Anonymous group and OPEN type
4) Publish the Poll
5) Logout from the site
6) Close the browser

Note: There are few sample Assertions done just to mention that some kind of verifications can be done during test and Step logs are created.

Report Generation:
Once test run is complete, report can be seen under */test-output/emailable-report.html
It will show the steps logged and tests run.
