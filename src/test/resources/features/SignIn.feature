@SignIn
Feature: Login functionality
	As a user i want to login to my account
	
	@loginPositive
	Scenario: Login to existing account
		Given User already on homepage
		When User clicks on signIn Link
		Then User enters email and password and logins
			| email | vivekvishwanandan89@gmail.com |
			| password | oiW45rf |
		And 'Vivek' will be loggedIn to their homepage

	@loginWrongEmail
	Scenario: User tries to login with Invalid Email
		Given User already on homepage
		When User clicks on signIn Link
		Then User enters wrong email 'fakeusertest@gmail.com'
		And User get "Account doesn't exist. Use different phone number or email." as error

	@loginWrongPassword
	Scenario: User tries to login with Invalid password
		Given User already on homepage
		When User clicks on signIn Link
		Then User enters email and password and logins
			| email | vivekvishwanandan89@gmail.com |
			| password | fakeTy6 |
		And User get "Either Email or Password is Incorrect" as error




			
#	7897456601
#	Vivek
#	Vishwanandan