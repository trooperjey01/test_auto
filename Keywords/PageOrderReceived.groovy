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

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory

import internal.GlobalVariable

public class PageOrderReceived {

	@Keyword
	boolean isDisplayed() {
		return WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Order_Received/div_order-detail'), GlobalVariable.Timeout_Medium, FailureHandling.OPTIONAL)
	}

	@Keyword
	boolean isSuccessMessageDisplayed() {
		return WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Order_Received/msg_order-received'), GlobalVariable.Timeout_Small, FailureHandling.OPTIONAL)
	}

	@Keyword
	boolean isOrderDetailsDisplayed() {
		boolean res = false
		if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Order_Received/table_order-details'), GlobalVariable.Timeout_Small, FailureHandling.OPTIONAL)){
			WebDriver driver = DriverFactory.getWebDriver()
			WebElement table = WebUiCommonHelper.findWebElement(findTestObject("Object Repository/Page_Order_Received/table_order-details"), GlobalVariable.Timeout_Small)
			List<WebElement> listProducts = table.findElements(By.cssSelector('tbody>tr'))
			if (listProducts.size() > 0) {
				println "total size : " + listProducts.size()
				res = true
			}
		}
		return res
	}
}
