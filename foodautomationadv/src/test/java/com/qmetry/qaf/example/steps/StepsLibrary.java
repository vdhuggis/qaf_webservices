package com.qmetry.qaf.example.steps;

import static com.qmetry.qaf.automation.step.CommonStep.assertText;
import static com.qmetry.qaf.automation.step.CommonStep.assertVisible;
import static com.qmetry.qaf.automation.step.CommonStep.click;
import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;
import static com.qmetry.qaf.automation.step.CommonStep.verifyLinkWithPartialTextPresent;
import static com.qmetry.qaf.automation.step.CommonStep.verifyText;
import static com.qmetry.qaf.automation.step.CommonStep.waitForEnabled;
import static com.qmetry.qaf.automation.step.CommonStep.waitForVisible;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;

public class StepsLibrary {
	
	/**
	 * @param navigateToRecipes : navigate To Recipes page
	 */
	@QAFTestStep(description = "navigate To Recipes page")
	public static void navigateToRecipes() {
		sleep();
		// waitForEnabled("button.recipe");
		click("button.recipe");
		sleep();
	}
	
	/**
	 * @param navigateToSearchPage  : navigate to search page
	 */
	@QAFTestStep(description = "navigate to search page")
	public static void navigateToSearchPage() {
		sleep();
		waitForVisible("recipe.search");
		click("recipe.search");
		waitForVisible("recipetype.search");
	}
	
	/**
	 * @param searchRecipe : search recipe
	 */
	@QAFTestStep(description = "search recipe {0}")
	public static void searchRecipe(String keyword) {
		waitForVisible("recipetype.search");
		click("recipetype.search");		
		sendKeys(keyword+Keys.ENTER, "recipetype.search");
		sleep();	
	}
	
	/**
	 * @param selectPizzaRecipe : select a recipe
	 */
	@QAFTestStep(description = "select a recipe")
	public static void selectPizzaRecipe() {
		sleep();
		waitForVisible("pizzaRecipeImg.click");
		click("pizzaRecipeImg.click");
		sleep();	
	}
	
	/**
	 * @param saveRecipe  : save a recipe
	 */
	@QAFTestStep(description = "save a recipe")
	public static void saveRecipe() {
		waitForVisible("saveReceipeBtn.click");
		click("saveReceipeBtn.click");
		sleep();
	}
	
	/**
	 * @param verifyLoginMsg  : verify login message for unregistered user while 
	 *                          save/review
	 */
	@QAFTestStep(description = "verify login message for unregistered user while save/review")
	public static void verifyLoginMsg() {
		waitForVisible("saveMessageText.verify");
		sleep();
		assertVisible("saveMessageText.verify");
	}
	
	/**
	 * @param searchTerm : search term to be searched
	 */
	@QAFTestStep(description = "search for {0}")
	public static void searchFor(String searchTerm) {
		sendKeys(searchTerm + Keys.ENTER, "input.search");
	}
	
	/**
	 * @param click : click button
	 */
	@QAFTestStep(description = "click search button")
	public static void clickSearch() {
		waitForEnabled("button.search");
		click("button.search");
		waitForEnabled("input.searchAttr");
	}
	
	/**
	 * @param searchTerm   : search term to be searched
	 */
	@QAFTestStep(description = "search for {0}")
	public static void searchForRecipe(String searchTerm) {
		sleep();
		sendKeys(searchTerm, "input.searchAttr");
		sleep();
		sleep();
		click("input.searchIcon");
		sleep();
	}
	
	/**
	 * @param clickReviewRecipe : click on review btn
	 */
	@QAFTestStep(description = "click on review btn")
	public static void clickReviewRecipe() {
		waitForVisible("reviewBtn.click");
		click("reviewBtn.click");
		sleep();
	}
	
	/**
	 * @param writeReviewRecipe : write a review
	 */
	@QAFTestStep(description = "write a review {0}")
	public static void writeReviewRecipe(String Review) {
		waitForVisible("writeReview.click");
		sleep();
		sendKeys(Review+Keys.ENTER, "writeReview.click");
		sleep();
		
	}
	
	/**
	 * @param clickPostBtn : click on post btn
	 */
	@QAFTestStep(description = "click on Post btn")
	public static void clickPostBtn() {
		waitForVisible("postBtn.click");
		click("postBtn.click");
		sleep();
	}
	
	/**
	 * @param SignInUser   : login as Reg User
	 */
	@QAFTestStep(description = "login as Reg User {0} {1}")
	public static void SignInUser(String userName, String password){
		sleep();
		click("signInBtn.click");
		waitForVisible("logInBtn.click");
		click("logInBtn.click");
		waitForVisible("emailTxt.click");
		click("emailTxt.click");
		sendKeys(userName, "emailTxt.click");
		waitForVisible("pwdTxt.click");
		click("pwdTxt.click");
		sendKeys(password+Keys.ENTER, "pwdTxt.click");
		sleep();
	}
	
	/**
	 * @param verifyTextIsPresent : verify Text Is Present
	 */
	@QAFTestStep(description = "verify text is present {0}")
	public static void verifyTextIsPresent(String text) {
		verifyLinkWithPartialTextPresent(text);
	}
	
	/**
	 * @param verifyResultCount : verify result count
	 */
	@QAFTestStep(description = "verify result count")
	public static void verifyResultCount() {
		waitForVisible("resultCountText.verify");
		scrollDownToBottom();
		WebDriverTestBase	d= new WebDriverTestBase();
		QAFExtendedWebDriver driver=d.getDriver();
		List<WebElement> results=driver.findElementsByXPath("//h2/a[@href[contains(.,'/recipe/')]]");
		assertText("resultCountText.verify",String.valueOf(results.size())+" RESULTS");
	}

	/**
	 * @param scrollDownToBottom : scroll Down To Bottom
	 */
	@QAFTestStep(description = "scroll Down To Bottom")
	public static void scrollDownToBottom() {
		WebDriverTestBase	d= new WebDriverTestBase();
	    QAFExtendedWebDriver driver=d.getDriver();
	    JavascriptExecutor js = (JavascriptExecutor) driver ;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	/**
	 * @param verifyNoMatchMsg  : verify no match message
	 */
	@QAFTestStep(description = "verify no match message")
	public static void verifyNoMatchMsg() {
		waitForVisible("noMatchRecipeMsg.verify");
		assertVisible("noMatchRecipeMsg.verify");
	}

	/**
	 * @param sleep : sleep
	 */
	public static void sleep() {
		try {
			Thread.sleep(10000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @param navigateToRecipePage : navigate to recipe page
	 */
	@QAFTestStep(description = "navigate to recipe page")
	public static void navigateToRecipePage() {
		waitForVisible("recipeLink.click");
		click("recipeLink.click");
	}
	
	/**
	 * @param verifySavedMsgForRegUser
	 *            : verify saved recipe msg for Reg User
	 */
	@QAFTestStep(description = "verify saved recipe msg for Reg User")
	public static void verifySavedMsgForRegUser() {
		waitForVisible("savedTxt.verify");
		assertVisible("savedTxt.verify");	
		sleep();
	}

	/**
	 * @param verifyTextIsRECIPES  : verify text is RECIPES
	 */
	@QAFTestStep(description="verify text is RECIPES {0}")
	public void verifyTextIsRECIPES(String text){
		//waitForVisible("recipeLink.click");
		//click("recipeLink.click");
		//Assert.assertEquals("text.recipe", "RECIPES");
		verifyText("text.recipe",text);
	}
}
