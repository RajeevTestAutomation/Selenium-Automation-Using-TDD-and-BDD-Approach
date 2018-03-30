Feature: Test  Yahoo smoke scenario

Scenario Outline: Test login with valid credentials
 Given Open firefox and start application
 When I entered valid "<username>" and valid "<password>"
 Then User should able to login successfully
 
Examples:
|              username         | password    |   
|qtpautomation                   | 289052@@  | 