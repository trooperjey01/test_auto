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
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import java.util.concurrent.TimeoutException

import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory

import internal.GlobalVariable

public class PageHome {

	@Keyword
	void clickOnFirstProduct() {
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> listProducts = WebUiCommonHelper.findWebElements(findTestObject("Page_Home/div_product-item"), GlobalVariable.Timeout_Small)
		if (listProducts.size() > 0) {
			WebElement productItem = listProducts.get(0)
			//need to focus productItem to click on hyperlink
			Actions action = new Actions(driver)
			action.moveToElement(productItem).perform()
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10)
				WebElement hyperlinkDetailProduct = wait.until(ExpectedConditions.elementToBeClickable(productItem.findElement(By.xpath("//a[@data-product_sku]"))))
				hyperlinkDetailProduct.click()
			} catch(TimeoutException e) {
				println("Timeout, no hyperlink clickable")
			}
		}
		else {
			throw new Exception("No product found")
		}
	}
}
