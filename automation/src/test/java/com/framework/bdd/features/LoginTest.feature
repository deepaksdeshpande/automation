Feature: Login Test

Scenario: Positive test for login

Given Initialize driver with chrome browser
And Navigate to "https://QAClickAcademy.com" site
And click on login link on home page to land on secure sign in page
When user enters "deepak.s.deshpande@gmail.com" and "abc123"
And user clicks on login button
Then verify user is successfully logged in