@AddToCart
Feature: Add to cart functionality
	As a user i want to add item to cart and remove item from the cart
	
	@itemAdding
	Scenario: Adding item to the cart functionality
		Given User already on homepage
		When User search for Aviator
		Then User selects a Product 
		Then User on product page
		And User clicks on Buy Now
		Then User will successfully add item to the Cart
		
	@removeItemNegative
	Scenario: Removing item from an empty cart functionality
		Given User already on homepage
		When User clicks on cart link
		Then User sees "Your shopping cart is empty! !"
		
	@removeItemPositive
	Scenario: Removing item from cart functionality
		Given User already on homepage
		When User clicks on cart link
		
		
	
	 