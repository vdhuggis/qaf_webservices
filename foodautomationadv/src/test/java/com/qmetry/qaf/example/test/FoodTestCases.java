package com.qmetry.qaf.example.test;

import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.automation.step.CommonStep.verifyText;
import static com.qmetry.qaf.example.steps.StepsLibrary.*;

import org.testng.annotations.Test;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;

/**
 *  Go to food.com and create 6 test cases ( 3 positive and 3 negative) for recipes section 
 *  ( think what could be the most important features in those section ) 
 * @author vdhuggis
 */

public class FoodTestCases extends WebDriverTestCase {

 	/**
	 * Positive Test case : 1
	 * Verify food recipe page title
	 */
	
	@Test(priority = 0)
	public void verifyTestFoodReceipeTitle() {
		get("/");
    	navigateToRecipes();
    	verifyText("text.recipe","RECIPES");
	}

	/**
	 * Positive Test case : 2
	 * Verify SEARCH Button functionality
	 */
	@Test(priority = 1)
	public void verifySearchResults() {
		get("/");
		navigateToRecipePage();
		navigateToSearchPage();
		searchRecipe("Biriyani");
		verifyResultCount();		
    }
	
	/**
	 * Positive Test case : 3
	 * Verify SAVES Button functionality
	 */
	@Test(priority = 5)
	public void verifySaveForRegUser() {
		get("/");
		SignInUser("vdhuggis@gmail.com","Arjun@17");
		navigateToRecipePage();
		navigateToSearchPage();
		searchRecipe("breakfast pizza");
		selectPizzaRecipe();
		saveRecipe();
		verifySavedMsgForRegUser();
	}
	
	/**
	 * Negative Test case : 1
	 * Verify Search on Invalid recipe
	 */
	@Test(priority = 2)
	public void verifyInvalidSearch() {
		get("/");
		navigateToRecipePage();
		navigateToSearchPage();
		searchRecipe("Iphone");			
		verifyNoMatchMsg();	
	}
	
	/**
	* Negative Test case : 2
	* Verify "Save recipe" Fails for unregistered users  (verify login message is displayed for unregistered user while save)
	*/
	@Test(priority = 3)
	public void verifySaveForGuest() {
		get("/");
		navigateToRecipePage();
		navigateToSearchPage();
		searchRecipe("breakfast pizza");
		selectPizzaRecipe();
		saveRecipe();
		verifyLoginMsg();	
	}
	/**
	* Negative Test case : 3
	* Verify Recipe Review Fails for unregistered users (verify login message is displayed for unregistered user while review)
	*/		
	@Test(priority = 4)
	public void verifyReviewForGuest() {
		get("/");
		navigateToRecipePage();
		navigateToSearchPage();
		searchRecipe("breakfast pizza");
		selectPizzaRecipe();
		clickReviewRecipe();
		writeReviewRecipe("Good");
		verifyLoginMsg();	
	}
	
}
