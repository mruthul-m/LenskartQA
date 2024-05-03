@Booking
Feature: book an appointment
	As a user I want to book an appointment
	
	@bookingPositive
	Scenario: Appointment booking functionality
		Given User already on homepage
		When User hover over store locator and clicks locate a store
		Then User on store page
		And User searches "Murinjapalam" and selects the first suggestion
		Then User book a free appointment from the top most list
	
	
	