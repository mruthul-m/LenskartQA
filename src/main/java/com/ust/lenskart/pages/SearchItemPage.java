package com.ust.lenskart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.ust.lenskart.base.TestBase;
import com.ust.lenskart.utils.Helper;

public class SearchItemPage extends TestBase{
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(css = "h1[class='TryOnSectionStyles__Title-sc-18funms-2 YfnFD']")
	public WebElement searchItem;
	
	@FindBy(css = "div[class='ListingStyles__NoResultHeader-sc-hgixc8-7 dsTwbT']")
	public WebElement invalidSearchItem;
	
	@FindBy(xpath = "//div[@id='frametype_id']//label[@id='filter-item-image-0']/div")
	public WebElement frametype;

	@FindBy(xpath = "//div[@id='frame_shape_id']//label[@id='filter-item-image-0']/div")
	public WebElement frameshape;

	@FindBy(xpath = "//div[@id='frame_color_id']/div[1]")
	public WebElement dropdown1;

	@FindBy(xpath = "//div[@id='frame_color_id']/div[2]/div/div[2]/label")
	public WebElement colour;

	@FindBy(xpath = "//div[@id='brandname_id']/div[1]")
	public WebElement dropdown2;

	@FindBy(xpath = "//div[@id='brandname_id']/div[2]/div/div[2]/label")
	public WebElement brand;

	@FindBy(xpath = "//div[@id='frame_size_id']/div[1]")
	public WebElement dropdown3;

	@FindBy(xpath = "//div[@id='frame_size_id']/div[2]/div/div[3]/label")
	public WebElement frameSize;

	@FindBy(xpath = "//div[@id='lenskart_price']/div[1]")
	public WebElement dropdown4;

	@FindBy(xpath = "//div[@id='lenskart_price']/div[2]/div/div[1]/label")
	public WebElement price;

	@FindBy(xpath = "//div[@id='gender_id']/div[1]")
	public WebElement dropdown5;

	@FindBy(xpath = "//div[@id='gender_id']/div[2]/div/div[1]/label")
	public WebElement gender;

	@FindBy(xpath = "//div[@id='glass_color_id']/div[1]")
	public WebElement dropdown6;

	@FindBy(xpath = "//div[@id='glass_color_id']/div[2]/div/div[1]/label")
	public WebElement glassColour;

	@FindBy(xpath = "//div[@id='frame_weight_group_id']/div[1]")
	public WebElement dropdown7;

	@FindBy(xpath = "//div[@id='frame_weight_group_id']/div[2]/div/div[1]/label")
	public WebElement frameWeight;

	@FindBy(xpath = "//div[@id='prescription_type_id']/div[1]")
	public WebElement dropdown8;

	@FindBy(xpath = "//div[@id='prescription_type_id']/div[2]/div/div[1]/label")
	public WebElement prescriptionType;

	@FindBy(xpath = "//div[@id='supported_powers_id']/div[1]")
	public WebElement dropdown9;

	@FindBy(xpath = "//div[@id='supported_powers_id']/div[2]/div/div[2]/label")
	public WebElement supportedPower;

	@FindBy(xpath = "//div[@id='material_id']/div[1]")
	public WebElement dropdown10;

	@FindBy(xpath = "//div[@id='material_id']/div[2]/div/div[1]/label")
	public WebElement material;

	@FindBy(xpath = "//div[@id='sub_brand_id']/div[1]")
	public WebElement dropdown11;

	@FindBy(xpath = "//div[@id='sub_brand_id']/div[2]/div/div[1]/label")
	public WebElement subBrand;
	
	@FindBy(xpath = "//div[@id='frame_width_id']/div[1]")
	public WebElement dropdown13;

	@FindBy(xpath = "//div[@id='frame_width_id']/div[2]/div/div[1]/label")
	public WebElement frameWidth;

	@FindBy(xpath = "//div[@id='product_type']/div[1]")
	public WebElement dropdown14;

	@FindBy(xpath = "//div[@id='product_type']/div[2]/div/div[1]/label")
	public WebElement productType;

	@FindBy(xpath = "//div[starts-with(@class,'SelectedFiltersStyles__ActiveFiltersContainer')]")
	public WebElement nofilters;

	@FindBy(xpath = "//span[starts-with(@class,'Title')]")
	public List<WebElement> filterTitles;

	@FindBy(xpath = "//span[starts-with(@class,'SelectedFiltersStyles')]/b")
	public List<WebElement> filterNames;

	@FindBy(tagName = "aside")
	public WebElement sidebar;

	@FindBy(linkText = "Eyewear")
	public WebElement eyewear;

	@FindBy(xpath = "//span[starts-with(@class,'SelectedFiltersStyles__ResetFilters')]")
	public WebElement resetFilters;
	
	@FindBy(css = "label+select")
	public WebElement selectsort;
	
	@FindBy(css = "span[class='SpecialPriceSpan--1mh26ry gDbhuM']")
	public List<WebElement> priceList;
	
	@FindBy(css = "div[data-cy='showing-result-desktop']>span:nth-child(2)")
	public WebElement itemCountLHS;
	
	@FindBy(css = "div[data-cy='showing-result-desktop']>span:nth-child(4)")
	public WebElement itemCountRHS;
	
	@FindBy(xpath = "//div[starts-with(@class,'ActionLinksContainer')]/div[3]/span")
	public WebElement wishList;

	@FindBy(xpath = "//div[@id='wishlistView']")
	public WebElement wishListBox;

	@FindBy(xpath = "//div[starts-with(@class,'HeaderText')]/span")
	public WebElement wishListProductCount;

	@FindBy(css = "svg[class='wishlist-icon']")
	public List<WebElement> productWishList;

	@FindBy(xpath = "//h5[starts-with(@class,'BrandName')]")
	public List<WebElement> wishListProductTitle;

	@FindBy(xpath = "//p[starts-with(@class,'ProductTitle')]")
	public List<WebElement> productTitle;

	@FindBy(xpath = "//a[starts-with(@class,'Cross')]")
	public List<WebElement> cross;
	
	@FindBy(xpath = "//a[starts-with(@class,'ClearButton')]")
	public WebElement clearList;
	
	public String getSearchItemText() {
		return searchItem.getText();
	}
	
	public String getinvalidSearchItemText() {
		return invalidSearchItem.getText();
	}
	
	public SearchItemPage setFrameType() {
		frametype.click();
		return this;
	}

	public SearchItemPage setFrameShape() {
		frameshape.click();
		return this;
	}

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

	public SearchItemPage resetFilters() {
		wait.until(ExpectedConditions.visibilityOf(resetFilters));
		resetFilters.click();
		return this;
	}

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

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public boolean isFiltersDisplayed() {
		return nofilters.isDisplayed();
	}
	
	public SearchItemPage setSortLowToHigh() {
		Select drop = new Select(selectsort);
		drop.selectByVisibleText("Price: Low to High");
		return this;
	}

	public SearchItemPage setSortHighToLow() {
		Select drop = new Select(selectsort);
		drop.selectByVisibleText("Price: High to Low");
		return this;
	}

	public SearchItemPage showAllProducts() {
		for(int i =0;i<100;i++) {
		js.executeScript("window.scrollBy(0, 500);");
		delay(2);
		if(Integer.parseInt(itemCountLHS.getText()) == Integer.parseInt(itemCountRHS.getText())) {
			break;
		}
		}
		delay(3);
		return this;
	}

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

	public int getWishListProductCount() {
		delay(1);
		String count = wishListProductCount.getText().replace("(", "").replace(")", "");
		return Integer.parseInt(count);
	}

	public SearchItemPage addProductsToWishList(int num) {
		for (int i = 0; i < num; i++) {
			delay(1);
			productWishList.get(0).click();
			delay(1);
		}
		return this;
	}

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

	public SearchItemPage removeProductsFromWishList() {
		setActions(driver).moveToElement(wishListProductTitle.get(0)).perform();
		delay(1);
		setActions(driver).moveToElement(cross.get(0)).click().perform();
		delay(1);
		return this;
	}

	public SearchItemPage clickClearList() {
		delay(2);
		wait.until(ExpectedConditions.elementToBeClickable(clearList));
		setActions(driver).moveToElement(clearList).click().perform();
        return this;
	}
	
}
