package com.TestSuits;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.QAF.Base.QAFBaseTest;
import com.QAF.Driver.Options.QAFDriverManager;
import com.QAF.Utils.DataTransformer;
import com.QAF.Utils.Reporter;
import com.QAF.annotations.QAFTest;
import com.SupportUtils.StepStatus;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;

public class AppTests extends QAFBaseTest {
	private static final Logger log = Logger.getLogger(AppTests.class);

	@QAFTest(key = "T_Key_1")
	@Test(dataProvider = "ExcelProvider", dataProviderClass = DataTransformer.class)
	public void f1(HashMap<String, String> data) {
		try {
			QAFDriverManager qafDriverManager = new QAFDriverManager();
			WebDriver driver = qafDriverManager.getDriver();
			driver.get("http://www.google.com");
			System.out.println(driver.getTitle());
			Reporter.reportStep("Step1", driver.getTitle(), StepStatus.PASS);

		} catch (Exception e) {
			Reporter.reportStep("End", "Test Failed due to follwing exception -" + e.getLocalizedMessage(), StepStatus.FAIL);
			log.error("Exception Occoured", e);

		}
		if (Reporter.hasTestFailed())
            assertTrue(false, "Test run failed");

	}

	@QAFTest(key = "T_Key_2")
	@Test(dataProvider = "ExcelProvider", dataProviderClass = DataTransformer.class)
	public void f2(HashMap<String, String> data) {
		try {
			QAFDriverManager qafDriverManager = new QAFDriverManager();
			WebDriver driver = qafDriverManager.getDriver();
			driver.get("http://thedemosite.co.uk/addauser.php");
			System.out.println(driver.getTitle());
			Reporter.reportStep("Step1", driver.getTitle(), StepStatus.FAIL);
		} catch (Exception e) {
			Reporter.reportStep("End", "Test Failed due to follwing exception -" + e.getLocalizedMessage(), StepStatus.FAIL);
			log.error("Exception Occoured", e);
            assertTrue(false, "Test run failed");

		}
		if (Reporter.hasTestFailed())
            assertTrue(false, "Test run failed");

	}
}
