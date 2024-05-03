@SignUp
Feature: Sign Up functionality
	As a user i want to creare a new account
	
	@signupPositive
	Scenario: Creating a new Account
		Given User already on homepage
		When User clicks on the signup Link.
		Then new window pop ups
		And User fills all required feilds
		
			| firstname | krishna |
			| lastname |	kumar	|
			|mobile  | 9834231223 |
			| email |  kkrishnatells@gmail.com |
			|password |  67_&gtweolw  |
			
#		And User clicks on Create an Account
#		Then New user will be created
		
		@signupNegative
		Scenario: Creating a new account with already existing email
		Given User already on homepage
		When User clicks on the signup Link.
		Then new window pop ups
		And User fills all required feilds
		
			| firstname | Dummy |
			| lastname |	User	|
			|mobile  | 7897236601 |
			| email |  vivekvishwanandan89@gmail.com |
			|password |  -df-erfss  |
			
		And User clicks on Create an Account
		Then User gets "Email Id already exists: " as error
			
	