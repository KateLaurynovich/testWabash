import application.enums.LocationFilterItem;
import application.enums.LocationSearchItem;
import application.enums.MainMenuItem;
import application.pageObject.DealerPage;
import application.pageObject.MainPage;
import framework.browsers.BrowserActions;
import framework.logger.MyLogger;
import framework.utils.PropertiesManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DealersTest {
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
        LOGGER.step(3, " Add some tests for Location Search -> Dealer");
        mainPage.getMainMenu().moveToMenuItem(MainMenuItem.LOCATION_SEARCH).clickSubMenuItem(LocationSearchItem.DEALER.getTitle());
        DealerPage dealerPage = new DealerPage();
        assertEquals(dealerPage.getMainMenu().moveToMenuItem(MainMenuItem.LOCATION_SEARCH).getMenuItemURL(LocationSearchItem.DEALER.getTitle()), dealerPage.getCurrentURL(),
                "urls is not equals");

        dealerPage.clickLocationFilter(LocationFilterItem.SALES);
        assertTrue(dealerPage.isCheckedLocationFilter(LocationFilterItem.SALES), " 'Sales' filter is not checked");
        assertTrue(dealerPage.checkLocationFilter(LocationFilterItem.SALES), "Not all dealers contain 'Sales' location type");
        assertTrue(dealerPage.checkRadiusFilter(), "There are not all dealers in the Search Radius");

    }
}
