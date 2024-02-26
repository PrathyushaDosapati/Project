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
import org.testng.Assert as Assert

WebUI.comment('Verifying if there is flight delay and Upcoming flights if user missed the flight')

WebUI.callTestCase(findTestCase('FA_Screens/FA_SearchFlight'), [('FlightID') : FlightID], FailureHandling.STOP_ON_FAILURE)

String statusOfFlight = WebUI.getText(findTestObject('FlightAware/FA_FlightSummary_Label_OriginDelayedStatus'), FailureHandling.OPTIONAL)

boolean flag = false

if (statusOfFlight.contains('late')) {
    WebUI.verifyTextPresent('late', false)

    flag = true
}

Assert.assertTrue(flag, 'Flight is delayed')

WebUI.comment('Flight is delayed')

WebUI.comment('Verify if there is any upcoming flight')

WebUI.verifyElementPresent(findTestObject('FlightAware/FA_FlightSummary_Header_UpcomingFlights'), 15)

WebUI.mouseOver(findTestObject('FlightAware/FA_FlightSummary_Header_UpcomingFlights'), FailureHandling.STOP_ON_FAILURE)

WebUI.doubleClick(findTestObject('FlightAware/FA_FlightSummary_Header_UpcomingFlights'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Upcoming Flights', false)

WebUI.takeFullPageScreenshot()

