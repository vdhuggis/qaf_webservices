package com.qmetry.qaf.example.test;

import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.automation.step.CommonStep.verifyText;
import static com.qmetry.qaf.example.steps.StepsLibrary.SignInUser;
import static com.qmetry.qaf.example.steps.StepsLibrary.clickReviewRecipe;
import static com.qmetry.qaf.example.steps.StepsLibrary.navigateToRecipePage;
import static com.qmetry.qaf.example.steps.StepsLibrary.navigateToRecipes;
import static com.qmetry.qaf.example.steps.StepsLibrary.navigateToSearchPage;
import static com.qmetry.qaf.example.steps.StepsLibrary.saveRecipe;
import static com.qmetry.qaf.example.steps.StepsLibrary.searchRecipe;
import static com.qmetry.qaf.example.steps.StepsLibrary.selectPizzaRecipe;
import static com.qmetry.qaf.example.steps.StepsLibrary.verifyLoginMsg;
import static com.qmetry.qaf.example.steps.StepsLibrary.verifyNoMatchMsg;
import static com.qmetry.qaf.example.steps.StepsLibrary.verifyResultCount;
import static com.qmetry.qaf.example.steps.StepsLibrary.verifySavedMsgForRegUser;
import static com.qmetry.qaf.example.steps.StepsLibrary.writeReviewRecipe;

import java.util.Map;

import org.testng.annotations.Test;

import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class FoodTestCasesAdv extends WebDriverTestCase {

 	/**
	 * Positive Test case : 1
	 * Verify food recipe page title
	 */
	@QAFDataProvider(dataFile="resources/testdata.csv")
	@Test(priority = 0, groups = {"key=metadata"})
	public void verifyTestFoodReceipeTitle(Map<String, String> data) {
		get("/");
    	navigateToRecipes();
    	verifyText("text.recipe",data.get("recipeTittle"));
	}
	
	/**
	 * Positive Test case : 2
	 * Verify SEARCH Button functionality
	 */
	@QAFDataProvider(dataFile="resources/testdata.csv")
	@Test(priority = 1, groups = {"key=metadata"})
	public void verifySearchResults(Map<String, String> data) {
		get("/");
		navigateToRecipePage();
		navigateToSearchPage();
		searchRecipe(data.get("searchRecipe"));
		verifyResultCount();		
    }
	
	/**
	 * Positive Test case : 3
	 * Verify SAVES Button functionality
	 */
	@QAFDataProvider(dataFile="resources/testdata.csv")
	@Test(priority = 5, groups = {"key=metadata"})
	public void verifySaveForRegUser(Map<String, String> data) {
		get("/");
		SignInUser(data.get("username"),data.get("password"));
		navigateToRecipePage();
		navigateToSearchPage();
		searchRecipe(data.get("searchtext"));
		selectPizzaRecipe();
		saveRecipe();
		verifySavedMsgForRegUser();
	}
	
	/**
	 * Negative Test case : 1
	 * Verify Search on Invalid recipe
	 */
	@QAFDataProvider(dataFile="resources/testdata.csv")
	@Test(priority = 2, groups = {"key=metadata"})
	public void verifyInvalidSearch(Map<String, String> data) {
		get("/");
		navigateToRecipePage();
		navigateToSearchPage();
		searchRecipe(data.get("Invalidsearch"));			
		verifyNoMatchMsg();	
	}
	
	/**
	* Negative Test case : 2
	* Verify "Save recipe" Fails for unregistered users  (verify login message is displayed for unregistered user while save)
	*/
	@QAFDataProvider(dataFile="resources/testdata.csv")
	@Test(priority = 3, groups = {"key=metadata"})
	public void verifySaveForGuest(Map<String, String> data) {
		get("/");
		navigateToRecipePage();
		navigateToSearchPage();
		searchRecipe(data.get("searchtext"));
		selectPizzaRecipe();
		saveRecipe();
		verifyLoginMsg();	
	}
	
	/**
	* Negative Test case : 3
	* Verify Recipe Review Fails for unregistered users (verify login message is displayed for unregistered user while review)
	*/		
	@QAFDataProvider(dataFile="resources/testdata.csv")
	@Test(priority = 4, groups = {"key=metadata"})
	public void verifyReviewForGuest(Map<String, String> data) {
		get("/");
		navigateToRecipePage();
		navigateToSearchPage();
		searchRecipe(data.get("searchtext"));
		selectPizzaRecipe();
		clickReviewRecipe();
		writeReviewRecipe(data.get("Reviewcomment"));
		verifyLoginMsg();	
	}
}
