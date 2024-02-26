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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.maximizeWindow()

WebUI.verifyElementPresent(findTestObject('FlightAware/FA_Header_Label_FlightAware'), 15)

WebUI.doubleClick(findTestObject('FlightAware/FA_Header_Label_FlightAware'), FailureHandling.STOP_ON_FAILURE)

WebUI.takeFullPageScreenshot()

WebUI.setText(findTestObject('FlightAware/FA_FlightAware_TextBox_SearchByFlight'), 'AAL2578')

WebUI.scrollToElement(findTestObject('FlightAware/FA_FlightAware_FlightSearchTypeList_FlightDescription'), 10)

WebUI.mouseOver(findTestObject('FlightAware/FA_FlightAware_FlightSearchTypeList_FlightDescription'))

WebUI.click(findTestObject('FlightAware/FA_FlightAware_FlightSearchTypeList_FlightDescription'))

WebUI.verifyTextPresent('AAL2578', false)

WebUI.takeFullPageScreenshot()

