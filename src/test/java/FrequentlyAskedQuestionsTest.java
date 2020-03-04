import application.enums.HelpFormItem;
import application.enums.MainMenuItem;
import application.enums.SupportItems;
import application.enums.WeAreWabashItems;
import application.pageObject.FrequentlyAskedQuestionsPage;
import application.pageObject.MainPage;
import framework.browsers.BrowserActions;
import framework.logger.MyLogger;
import framework.utils.PropertiesManager;
import framework.utils.RandomGeneration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FrequentlyAskedQuestionsTest {
    private static MyLogger LOGGER = new MyLogger();

    @BeforeTest
    private void setUp() {
        PropertiesManager.loadProperties("config");
        PropertiesManager.loadProperties("log4j");
    }

    @AfterMethod
    private void afterTest() {
        BrowserActions.quitBrowser();
    }

    @Test
    public void testFirst() {
        LOGGER.step(0, "Go to the Page: http://qa.yotec.net/");
        BrowserActions.goToPage(PropertiesManager.getProperty("URL"));

        MainPage mainPage = new MainPage();
        String homeUrl = mainPage.getCurrentURL();
        mainPage.getMainMenu().moveToMenuItem(MainMenuItem.WE_ARE_WABASH).moveToMenuItem(WeAreWabashItems.SUPPORT.getTitle())
                .clickSubMenuItem(SupportItems.FREQUENTLY_ASKED_QUESTIONS.getTitle());

        LOGGER.step(1, "Check breadcrumbs and URL of the open page ");
        FrequentlyAskedQuestionsPage frequentlyAskedQuestionsPage = new FrequentlyAskedQuestionsPage();
        assertEquals(frequentlyAskedQuestionsPage.getMainMenu().moveToMenuItem(MainMenuItem.WE_ARE_WABASH)
                        .moveToMenuItem(WeAreWabashItems.SUPPORT.getTitle())
                        .getMenuItemURL(SupportItems.FREQUENTLY_ASKED_QUESTIONS.getTitle()), frequentlyAskedQuestionsPage.getCurrentURL(),
                "urls is not equals");
        assertTrue(frequentlyAskedQuestionsPage.getCurrentURL().contains(frequentlyAskedQuestionsPage.getBreadcrumb().getBreadcrumbURL(WeAreWabashItems.SUPPORT.getTitle())),
                "Breadcrumb is not contains previous page url");
        assertTrue(frequentlyAskedQuestionsPage.getCurrentURL().contains(frequentlyAskedQuestionsPage.getBreadcrumb().getBreadcrumbURL(MainMenuItem.WE_ARE_WABASH.getTitle())),
                "Breadcrumb is not contains previous page url");
        assertEquals(frequentlyAskedQuestionsPage.getBreadcrumb().getBreadcrumbURL("Home"), homeUrl, "home url is not equals");

        frequentlyAskedQuestionsPage.choiceRandomSelectOne();
        frequentlyAskedQuestionsPage.choiceRandomCountry();
        frequentlyAskedQuestionsPage.setFieldInput(HelpFormItem.NAME, RandomGeneration.randomString(7));
        frequentlyAskedQuestionsPage.setFieldInput(HelpFormItem.COMPANY, RandomGeneration.randomString(7));
        frequentlyAskedQuestionsPage.setFieldInput(HelpFormItem.EMAIL, RandomGeneration.randomString(7));
        frequentlyAskedQuestionsPage.setFieldInput(HelpFormItem.PHONE, RandomGeneration.randomString(10));
        frequentlyAskedQuestionsPage.setCommentInput(RandomGeneration.randomString(250));
        frequentlyAskedQuestionsPage.clickSubmitBtn();
        assertTrue(frequentlyAskedQuestionsPage.submittedFormSuccessfully(), "the form didn't submitted");

    }
}
