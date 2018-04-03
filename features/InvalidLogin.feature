Feature: Test  Flipkart smoke scenario

 Scenario Outline: Test login with Invalid credentials
 Given Open firefox and start application
 When I entered invalid "<username>" and valid "<password>"
 Then User should get Incorrect username or password message
 
Examples:
|              username         | password    |   
|demousername                   | july17$1234  | 

Scenario Outline: Test login with Invalid credentials
 Given Open firefox and start application
 When I entered valid "<username>" and Invalid "<password>"
 Then User should get incorrect username or password message
 
Examples:
|              username         | password    |   
|demouser2                      | may17$1234  | 
