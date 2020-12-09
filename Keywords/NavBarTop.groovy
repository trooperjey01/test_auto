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

import internal.GlobalVariable

public class NavBarTop {

	@Keyword
	int getNumberItemsInCart() {
		WebUI.waitForElementPresent(findTestObject('Object Repository/Navbar_Top/cart_item-count'), 2)
		String strCart = WebUI.getText(findTestObject('Object Repository/Navbar_Top/cart_item-count'))
		println("STRCART = "+strCart)
		String strNumberItem = strCart.substring(strCart.indexOf("(")+1, strCart.indexOf(")"))
		println("valeur strNumberItem = "+ strNumberItem)
		return Integer.parseInt(strNumberItem)
	}

	@Keyword
	double getTotalPriceItemsInCart() {
		String strTotalPrice = WebUI.getText(findTestObject('Object Repository/Navbar_Top/cart_total-price'))
		//remove currency symbol before convert str to double
		return Double.parseDouble(strTotalPrice.substring(1))
	}
}
