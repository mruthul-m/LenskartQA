package com.ust.lenskart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.ust.lenskart.base.ReusableFunctions;
import com.ust.lenskart.utils.Helper;

public class SearchItemPage extends ReusableFunctions{
	
	//initializes a JavascriptExecutor object named js
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	//identifies search text element
	@FindBy(css = "h1[class='TryOnSectionStyles__Title-sc-18funms-2 YfnFD']")
	public WebElement searchItem;
	
	//identifies invalid search text element
	@FindBy(css = "div[class='ListingStyles__NoResultHeader-sc-hgixc8-7 dsTwbT']")
	public WebElement invalidSearchItem;
	
	//identifies frametype element
	@FindBy(xpath = "//div[@id='frametype_id']//label[@id='filter-item-image-0']/div")
	public WebElement frametype;

	//identifies frameshape element
	@FindBy(xpath = "//div[@id='frame_shape_id']//label[@id='filter-item-image-0']/div")
	public WebElement frameshape;

	//identifies dropdown for framecolor element
	@FindBy(xpath = "//div[@id='frame_color_id']/div[1]")
	public WebElement dropdown1;

	//identifies framecolor element
	@FindBy(xpath = "//div[@id='frame_color_id']/div[2]/div/div[2]/label")
	public WebElement colour;

	//identifies dropdown for brand element
	@FindBy(xpath = "//div[@id='brandname_id']/div[1]")
	public WebElement dropdown2;

	//identifies brand element
	@FindBy(xpath = "//div[@id='brandname_id']/div[2]/div/div[2]/label")
	public WebElement brand;

	//identifies dropdown for framesize element
	@FindBy(xpath = "//div[@id='frame_size_id']/div[1]")
	public WebElement dropdown3;

	//identifies framesize element
	@FindBy(xpath = "//div[@id='frame_size_id']/div[2]/div/div[3]/label")
	public WebElement frameSize;

	//identifies dropdown for price element
	@FindBy(xpath = "//div[@id='lenskart_price']/div[1]")
	public WebElement dropdown4;

	//identifies price element
	@FindBy(xpath = "//div[@id='lenskart_price']/div[2]/div/div[1]/label")
	public WebElement price;

	//identifies dropdown for gender element
	@FindBy(xpath = "//div[@id='gender_id']/div[1]")
	public WebElement dropdown5;

	//identifies gender element
	@FindBy(xpath = "//div[@id='gender_id']/div[2]/div/div[1]/label")
	public WebElement gender;

	//identifies dropdown for glasscolour element
	@FindBy(xpath = "//div[@id='glass_color_id']/div[1]")
	public WebElement dropdown6;

	//identifies glasscolour element
	@FindBy(xpath = "//div[@id='glass_color_id']/div[2]/div/div[1]/label")
	public WebElement glassColour;

	//identifies dropdown for frameweight element
	@FindBy(xpath = "//div[@id='frame_weight_group_id']/div[1]")
	public WebElement dropdown7;

	//identifies frameweight element
	@FindBy(xpath = "//div[@id='frame_weight_group_id']/div[2]/div/div[1]/label")
	public WebElement frameWeight;

	//identifies dropdown for prescription type element
	@FindBy(xpath = "//div[@id='prescription_type_id']/div[1]")
	public WebElement dropdown8;

	//identifies prescription type element
	@FindBy(xpath = "//div[@id='prescription_type_id']/div[2]/div/div[1]/label")
	public WebElement prescriptionType;

	//identifies dropdown for supported power element
	@FindBy(xpath = "//div[@id='supported_powers_id']/div[1]")
	public WebElement dropdown9;

	//identifies supported power element
	@FindBy(xpath = "//div[@id='supported_powers_id']/div[2]/div/div[2]/label")
	public WebElement supportedPower;

	//identifies dropdown for material element
	@FindBy(xpath = "//div[@id='material_id']/div[1]")
	public WebElement dropdown10;

	//identifies material element
	@FindBy(xpath = "//div[@id='material_id']/div[2]/div/div[1]/label")
	public WebElement material;

	//identifies dropdown for sub-brand element
	@FindBy(xpath = "//div[@id='sub_brand_id']/div[1]")
	public WebElement dropdown11;
	
	//identifies sub-brand element
	@FindBy(xpath = "//div[@id='sub_brand_id']/div[2]/div/div[1]/label")
	public WebElement subBrand;
	
	//identifies dropdown for framewidth element
	@FindBy(xpath = "//div[@id='frame_width_id']/div[1]")
	public WebElement dropdown13;

	//identifies framewidth element
	@FindBy(xpath = "//div[@id='frame_width_id']/div[2]/div/div[1]/label")
	public WebElement frameWidth;

	//identifies dropdown for product type element
	@FindBy(xpath = "//div[@id='product_type']/div[1]")
	public WebElement dropdown14;

	//identifies product type element
	@FindBy(xpath = "//div[@id='product_type']/div[2]/div/div[1]/label")
	public WebElement productType;

	//identifies element containing all applied filters 
	@FindBy(xpath = "//div[starts-with(@class,'SelectedFiltersStyles__ActiveFiltersContainer')]")
	public WebElement nofilters;

	//identifies list of all filters titles element
	@FindBy(xpath = "//span[starts-with(@class,'Title')]")
	public List<WebElement> filterTitles;

	//identifies list of all filters in the no filter element
	@FindBy(xpath = "//span[starts-with(@class,'SelectedFiltersStyles')]/b")
	public List<WebElement> filterNames;

	//identifies the sidebar
	@FindBy(tagName = "aside")
	public WebElement sidebar;

	//identifies reset filters button
	@FindBy(xpath = "//span[starts-with(@class,'SelectedFiltersStyles__ResetFilters')]")
	public WebElement resetFilters;
	
	//identifies sort dropdown
	@FindBy(css = "label+select")
	public WebElement selectsort;
	
	//identifies list of all prices of the listings
	@FindBy(css = "span[class='SpecialPriceSpan--1mh26ry gDbhuM']")
	public List<WebElement> priceList;
	
	//identifies element containing total number products loaded in the site 
	@FindBy(css = "div[data-cy='showing-result-desktop']>span:nth-child(2)")
	public WebElement itemCountLHS;
	
	//identifies element containing total number of products in the site
	@FindBy(css = "div[data-cy='showing-result-desktop']>span:nth-child(4)")
	public WebElement itemCountRHS;
	
	//identifies wishlist element
	@FindBy(xpath = "//div[starts-with(@class,'ActionLinksContainer')]/div[3]/span")
	public WebElement wishList;

	//identifies wishlist box
	@FindBy(xpath = "//div[@id='wishlistView']")
	public WebElement wishListBox;

	//identifies element containing total number of products in the wishlist
	@FindBy(xpath = "//div[starts-with(@class,'HeaderText')]/span")
	public WebElement wishListProductCount;

	//identifies list of heart icons selected products
	@FindBy(css = "svg[class='wishlist-icon']")
	public List<WebElement> productWishList;

	//identifies list of names of all  products in the wishlist
	@FindBy(xpath = "//h5[starts-with(@class,'BrandName')]")
	public List<WebElement> wishListProductTitle;

	//identifies list of names of products to be selected
	@FindBy(xpath = "//p[starts-with(@class,'ProductTitle')]")
	public List<WebElement> productTitle;

	//identifies the cross icon for each product in the wishlist
	@FindBy(xpath = "//a[starts-with(@class,'Cross')]")
	public List<WebElement> cross;
	
	//identifies clear list button
	@FindBy(xpath = "//a[starts-with(@class,'ClearButton')]")
	public WebElement clearList;
	
	//method to return the inner text of search-item element as string
	public String getSearchItemText() {
		return searchItem.getText();
	}
	
	//method to return the inner text of invalid-search-item element as string
	public String getinvalidSearchItemText() {
		return invalidSearchItem.getText();
	}
	//method to click frame type element
	public SearchItemPage setFrameType() {
		frametype.click();
		return this;
	}
	//method to click frame shape element
	public SearchItemPage setFrameShape() {
		frameshape.click();
		return this;
	}
	//method to set frame colour
	public SearchItemPage setColour() {
		wait.until(ExpectedConditions.visibilityOf(dropdown1));
		dropdown1.click();
		delay(1);
		wait.until(ExpectedConditions.elementToBeClickable(colour));
		colour.click();
		dropdown1.click();
		delay(2);
		return this;
	}

	//method to set brand
	public SearchItemPage setBrand() {
		wait.until(ExpectedConditions.visibilityOf(dropdown2));
		dropdown2.click();
		delay(1);
		wait.until(ExpectedConditions.elementToBeClickable(brand));
		brand.click();
		wait.until(ExpectedConditions.elementToBeClickable(dropdown2));
		dropdown2.click();
		delay(2);
		return this;
	}
	
	//method to set frame size
	public SearchItemPage setFrameSize() {
		wait.until(ExpectedConditions.visibilityOf(dropdown3));
		dropdown3.click();
		delay(1);
		wait.until(ExpectedConditions.elementToBeClickable(frameSize));
		frameSize.click();
		wait.until(ExpectedConditions.elementToBeClickable(dropdown3));
		dropdown3.click();
		delay(2);
		return this;
	}

	//method scroll to specific point and set price 
	public SearchItemPage setPrice() {
		wait.until(ExpectedConditions.visibilityOf(dropdown4));
		dropdown4.click();
		delay(1);
		wait.until(ExpectedConditions.elementToBeClickable(price));
		price.click();
		Helper.scrollThePage(driver, sidebar);
		wait.until(ExpectedConditions.elementToBeClickable(dropdown4));
		dropdown4.click();
		delay(2);
		return this;
	}

	//method scroll to specific point and set gender
	public SearchItemPage setGender() {
		wait.until(ExpectedConditions.visibilityOf(dropdown5));
		dropdown5.click();
		delay(1);
		wait.until(ExpectedConditions.elementToBeClickable(gender));
		gender.click();
		Helper.scrollThePage(driver, sidebar);
		wait.until(ExpectedConditions.elementToBeClickable(dropdown5));
		dropdown5.click();
		delay(2);
		return this;
	}

	//method scroll to specific point and set glass colour
	public SearchItemPage setGlassColour() {
		wait.until(ExpectedConditions.visibilityOf(dropdown6));
		dropdown6.click();
		delay(1);
		wait.until(ExpectedConditions.elementToBeClickable(glassColour));
		glassColour.click();
		Helper.scrollThePage(driver, sidebar);
		wait.until(ExpectedConditions.elementToBeClickable(dropdown6));
		dropdown6.click();
		delay(2);
		return this;
	}

	//method scroll to specific point and set frame weight
	public SearchItemPage setFrameWeight() {
		wait.until(ExpectedConditions.visibilityOf(dropdown7));
		dropdown7.click();
		delay(1);
		wait.until(ExpectedConditions.elementToBeClickable(frameWeight));
		frameWeight.click();
		Helper.scrollThePage(driver, sidebar);
		wait.until(ExpectedConditions.elementToBeClickable(dropdown7));
		dropdown7.click();
		delay(2);
		return this;
	}

	//method scroll to specific point and set prescription type 
	public SearchItemPage setPrescriptionType() {
		wait.until(ExpectedConditions.visibilityOf(dropdown8));
		dropdown8.click();
		delay(1);
		wait.until(ExpectedConditions.elementToBeClickable(prescriptionType));
		prescriptionType.click();
		Helper.scrollThePage(driver, sidebar);
		wait.until(ExpectedConditions.elementToBeClickable(dropdown8));
		dropdown8.click();
		delay(2);
		return this;
	}
	
	//method scroll to specific point and set supported power
	public SearchItemPage setSupportedPower() {
		wait.until(ExpectedConditions.visibilityOf(dropdown9));
		dropdown9.click();
		delay(1);
		wait.until(ExpectedConditions.elementToBeClickable(supportedPower));
		supportedPower.click();
		Helper.scrollThePage(driver, sidebar);
		delay(1);
		wait.until(ExpectedConditions.elementToBeClickable(dropdown9));
		dropdown9.click();
		delay(2);
		return this;
	}

	//method scroll to specific point and set material
	public SearchItemPage setMaterial() {
		wait.until(ExpectedConditions.visibilityOf(dropdown10));
		dropdown10.click();
		delay(1);
		wait.until(ExpectedConditions.elementToBeClickable(material));
		material.click();
		delay(1);
		Helper.scrollThePage(driver, sidebar);
		wait.until(ExpectedConditions.elementToBeClickable(dropdown10));
		dropdown10.click();
		delay(2);
		return this;
	}

	//method scroll to specific point and set sub brand
	public SearchItemPage setSubBrand() {
		wait.until(ExpectedConditions.visibilityOf(dropdown11));
		dropdown11.click();
		delay(1);
		wait.until(ExpectedConditions.elementToBeClickable(subBrand));
		subBrand.click();
		delay(1);
		Helper.scrollThePage(driver, sidebar);
		wait.until(ExpectedConditions.elementToBeClickable(dropdown11));
		dropdown11.click();
		delay(2);
		return this;
	}


	//method scroll to specific point and set frame width 
	public SearchItemPage setFrameWidth() {
		wait.until(ExpectedConditions.visibilityOf(dropdown13));
		dropdown13.click();
		delay(1);
		wait.until(ExpectedConditions.elementToBeClickable(frameWidth));
		frameWidth.click();
		delay(1);
		Helper.scrollThePage(driver, sidebar);
		wait.until(ExpectedConditions.elementToBeClickable(dropdown13));
		dropdown13.click();
		delay(2);
		return this;
	}

	//method scroll to specific point and set product type 
	public SearchItemPage setProductType() {
		wait.until(ExpectedConditions.visibilityOf(dropdown14));
		dropdown14.click();
		delay(1);
		wait.until(ExpectedConditions.elementToBeClickable(productType));
		productType.click();
		delay(1);
		Helper.scrollThePage(driver, sidebar);
		wait.until(ExpectedConditions.elementToBeClickable(dropdown14));
		dropdown14.click();
		delay(2);
		return this;
	}

	//method to click reset filters button
	public SearchItemPage resetFilters() {
		wait.until(ExpectedConditions.visibilityOf(resetFilters));
		resetFilters.click();
		return this;
	}

	//method to validate filters are applied correctly
	public boolean validateFilters() {
		for (int i = 0; i < filterTitles.size(); i++) {
			String title = filterTitles.get(i).getText().trim();
			String names = filterNames.get(i).getText().replace(":", "").trim();
			if (!(title.equalsIgnoreCase(names))) {
				return false;
			}
		}
		return true;
	}

	//method to return current url as string
	public String getUrl() {
		return driver.getCurrentUrl();
	}

	//method to validate whether filters are displayed
	public boolean isFiltersDisplayed() {
		return nofilters.isDisplayed();
	}
	
	//method to set sort to Low to high
	public SearchItemPage setSortLowToHigh() {
		Select drop = new Select(selectsort);
		drop.selectByVisibleText("Price: Low to High");
		return this;
	}

	//method to set sort to High to low
	public SearchItemPage setSortHighToLow() {
		Select drop = new Select(selectsort);
		drop.selectByVisibleText("Price: High to Low");
		return this;
	}

	//method to scroll the webpage by a specific amount until a condition is met
	public SearchItemPage showAllProducts() {
		for(int i =0;i<100;i++) {
		js.executeScript("window.scrollBy(0, 500);");
		delay(2);
		if(Integer.parseInt(itemCountLHS.getText()) == Integer.parseInt(itemCountRHS.getText())) {
			break;
		}
		}
		
		return this;
	}

	//method to check sorting is in ascending order
	public boolean checkSortAsc() {
		int j = 0;
		for (int i = 0; i < priceList.size() - 1; i++) {
			j = i + 1;

			if (Integer.parseInt(priceList.get(i).getText().replace("₹", "").replaceAll(",", "")) > Integer
					.parseInt(priceList.get(j).getText().replace("₹", "").replaceAll(",", ""))) {
				return false;
			}
		}
		return true;
	}
	
	//method to check sorting is in decending order
	public boolean checkSortDesc() {
		int j = 0;
		for (int i = 0; i < priceList.size() - 1; i++) {
			j = i + 1;

			if (Integer.parseInt(priceList.get(i).getText().replace("₹", "").replaceAll(",", "")) < Integer
					.parseInt(priceList.get(j).getText().replace("₹", "").replaceAll(",", ""))) {
				return false;
			}
		}
		return true;
	}
	
	//method to click wishlist button
	public SearchItemPage clickWishList() {
		wishList.click();
		return this;
	}

	public boolean isWishListBoxVisible() {
		if (wishListBox.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	//method to return no of products in wishlist as integer
	public int getWishListProductCount() {
		delay(1);
		String count = wishListProductCount.getText().replace("(", "").replace(")", "");
		delay(1);
		return Integer.parseInt(count);
	}
	
	//method to add products to wishlist
	public SearchItemPage addProductsToWishList(int num) {
		for (int i = 0; i < num; i++) {
			delay(2);
			productWishList.get(0).click();
			delay(2);
		}
		return this;
	}

	//method to validate if products selected and products added in the wishlist are the same
	public boolean checkProductTitle(int num) {
		delay(2);
		List<WebElement> tempList = new ArrayList<WebElement>();
		for(int i=wishListProductTitle.size()-1; i>=0;i--) {
			tempList.add(wishListProductTitle.get(i));
		}
		for (int i = 0; i < num; i++) {
			if (!(productTitle.get(i).getText().equalsIgnoreCase(tempList.get(i).getText()))) {
				return false;
			}
		}
		return true;
	}

	//method to remove products from wishlist
	public SearchItemPage removeProductsFromWishList(int num) {
		for(int i =1;i<=num;i++) {
		delay(1);
		setActions(driver).moveToElement(wishListProductTitle.get(0)).perform();
		delay(2);
		setActions(driver).moveToElement(cross.get(0)).click().perform();
		delay(1);
		 }
		delay(2);
		return this;
	}

	//method to click clear list button in wishlist
	public SearchItemPage clickClearList() {
		delay(2);
		wait.until(ExpectedConditions.elementToBeClickable(clearList));
		setActions(driver).moveToElement(clearList).click().perform();
		delay(3);
        return this;
	}
	
}
