import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import org.openqa.selenium.Keys as Keys

import internal.GlobalVariable

public class PageDetailProduct {

	@Keyword
	boolean isDisplayed(){
		return WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Detail_Product/body'), GlobalVariable.Timeout_Small, FailureHandling.OPTIONAL)
	}

	@Keyword
	void selectColorByIndex(int idx) {
		WebUI.selectOptionByIndex(findTestObject('Object Repository/Page_Detail_Product/select_color'), idx)
	}

	@Keyword
	void selectSizeByIndex(int idx) {
		WebUI.selectOptionByIndex(findTestObject('Object Repository/Page_Detail_Product/select_size'), idx)
	}

	@Keyword
	void clickOnAddToCart() {
		WebUI.click(findTestObject('Object Repository/Page_Detail_Product/btn_add-to-cart'))
	}

	@Keyword
	void setQuantity(int qty) {
		String strQty = String.valueOf(qty)
		TestObject inputQty = findTestObject('Object Repository/Page_Detail_Product/input_qty')
		WebUI.sendKeys(inputQty, Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(inputQty, Keys.chord(Keys.BACK_SPACE))
		WebUI.sendKeys(inputQty, strQty)
	}

	@Keyword
	double getProductPrice() {
		return Double.parseDouble(WebUI.getText(findTestObject('Object Repository/Page_Detail_Product/product_price')).substring(1))
	}

	@Keyword
	String getProductName() {
		return WebUI.getText(findTestObject('Object Repository/Page_Detail_Product/product_name'))
	}

	@Keyword
	boolean isSuccessMessageDisplayed() {
		String successMsg = WebUI.getText(findTestObject('Object Repository/Page_Detail_Product/success_message'))
		boolean res = false
		// can be has been added or have been added (depends of quantity)
		if (successMsg.matches('(?s)(?i)(.*)'+getProductName() + '(.*) been added to your cart.')) {
			res = true
		}
		return res
	}

	@Keyword
	void clickOnViewCart() {
		WebUI.click(findTestObject('Object Repository/Page_Detail_Product/btn_view-cart'))
	}

}
