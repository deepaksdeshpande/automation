Feature: Login Test 
#If you want to data drive your cucumber BDD test case you have to use 
#'Scenario Outline' instead of just 'Scenario' and Use 'Examples' 
#to data drive your BDD Test case

Scenario Outline: Positive test for login 

	Given Initialize driver with chrome browser 
	And Navigate to "https://QAClickAcademy.com" site 
	And click on login link on home page to land on secure sign in page 
	When user enters <username> and <password> 
	And user clicks on login button 
	Then verify user is successfully logged in 
	And close browsers
	
	Examples: 
		|username					  |password|
		|deepak.s.deshpande@gmail.com |abc123|
		|test99@gmail.com			  |123456|