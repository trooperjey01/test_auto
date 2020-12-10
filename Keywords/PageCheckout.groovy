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

public class PageCheckout {

	@Keyword
	boolean isDisplayed() {
		boolean res = false
		if (WebUI.getUrl() == GlobalVariable.URL_Checkout)
			res = true
		return res
	}

	@Keyword
	void setFirstName(String firstName){
		WebUI.setText(findTestObject('Object Repository/Page_Checkout_Form/input_first-name'), firstName)
	}

	@Keyword
	void setLastName(String lastName){
		WebUI.setText(findTestObject('Object Repository/Page_Checkout_Form/input_last-name'), lastName)
	}

	@Keyword
	void setStreetAdress(String adress){
		WebUI.setText(findTestObject('Object Repository/Page_Checkout_Form/input_adress-1'), adress)
	}

	@Keyword
	void setPostcode(String zip){
		WebUI.setText(findTestObject('Object Repository/Page_Checkout_Form/input_postcode'), zip)
	}

	@Keyword
	void setCity(String city){
		WebUI.setText(findTestObject('Object Repository/Page_Checkout_Form/input_city'), city)
	}

	@Keyword
	void setPhone(String phone){
		WebUI.setText(findTestObject('Object Repository/Page_Checkout_Form/input_phone'), phone)
	}

	@Keyword
	void setMail(String mail){
		WebUI.setText(findTestObject('Object Repository/Page_Checkout_Form/input_mail'), mail)
	}

	@Keyword
	void checkAgreeTermsAndConditions(){
		String attribute = WebUI.getAttribute(findTestObject('Object Repository/Page_Checkout_Form/p_terms-conditions'), 'class')
		if (!attribute.contains('woocommerce-validated')) {
			WebUI.click(findTestObject('Object Repository/Page_Checkout_Form/checkbox_agree-conditions'))
		}
	}

	@Keyword
	void clickOnBtnPlaceOrder(){
		WebUI.click(findTestObject('Object Repository/Page_Checkout_Form/btn_place-order'))
	}
}
