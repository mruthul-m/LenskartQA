FEATURE 1:SignUp&Login(Excel)
----------------------

	SCENARIO 1:(Positive)
		Signup Using Valid Data
	*Click Sign In icon
	*Uncheck Get whatsapp update checkbox(click)
	*Enter valid Phone number and click signin
	*Enter OTP
	*Click Login button



	SCENARIOS 2:(Negative)
		Login Using Invalid Data
	*Click Sign In icon
	*Uncheck Get whatsapp update checkbox(click)
	*Enter empty Phone number and click signin and gets error message
	*Enter invalid Phone number/Email and click signin and gets error message


FEATURE 2:Store Locator
-----------------------

	SCENARIOS 3:(Positive)
		Using store locator to identify a store and book an appoinment
	* Move element to Store Locator
	* Click Locate a Store button
	* Locate the search box and click the suggestion	css->input[placeholder="Search by state/pincode/Locality"]+div>div:first-child

	SCENARIOS 4:
		Using store locator and use current location to identy wether all the store are present Thiruvanathapuram


	SCENARIOS 5:(Negative)
		Giving a location where there is no store

FEATURE 3:Search bar
--------------------

	SCENARIOS 6:(Positive)
		Giving a valid item Shows us the listing and displays the item name


	SCENARIOS 7:(Negative)
		Searching an invalid item and gets "Oops No Result Found" message



FEATURE 4:Home Page
-------------------

	SCENARIO 8:
		Applying all necessary filter and resetting the filter and validate if filters are removed



	SCENARIO 9:
		Sorting all products and validate if they are sorted



	SCENARIO 10:
		Navigating different tabs and validating if the elements are displayed




FEATURE 5:Wishlist
------------------

	SCENARIO 11:(Negative)
		Click Whishlist without entering any and get a pop up message 

	SCENARIO 12:(Positive)
		Adding an item to wishlist and validate if it is present

	SCENARIO 13:(Negative)
		Clicking remove item and validate if it is removed
		


FEATURE 6:Cart
--------------

	SCENARIO 14:(Negative)
		Click Cart without entering any and get a Message on screen

	SCENARIO 15:(Positive)
		Adding an item to cart and validate if it is present

	SCENARIO 16:(Negative)
		Clicking remove item and validate if it is removed
	
	SCENARIO 17:(Positive)
		Adding an item to cart and validate if it is present