import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

int index = 1
int quantity = 4

// prérequis: être sur une page produit 
assert CustomKeywords.'PageDetailProduct.isDisplayed'()

int totalItemBefore = CustomKeywords.'NavBarTop.getNumberItemsInCart'()
double totalPriceBefore = CustomKeywords.'NavBarTop.getTotalPriceItemsInCart'()
double productPrice = CustomKeywords.'PageDetailProduct.getProductPrice'()

CustomKeywords.'PageDetailProduct.selectColorByIndex'(index)
CustomKeywords.'PageDetailProduct.selectSizeByIndex'(index)
CustomKeywords.'PageDetailProduct.setQuantity'(quantity)
CustomKeywords.'PageDetailProduct.clickOnAddToCart'()

// critères d'acceptation : les informations paniers ont bien été mises à jour et le message d'ajout produit apparait
assert CustomKeywords.'PageDetailProduct.isSuccessMessageDisplayed'()
assert totalItemBefore + quantity == CustomKeywords.'NavBarTop.getNumberItemsInCart'()
assert totalPriceBefore + quantity * productPrice == CustomKeywords.'NavBarTop.getTotalPriceItemsInCart'()
