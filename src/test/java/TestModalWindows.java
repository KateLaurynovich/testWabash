
import application.enums.*;
import application.pageObject.*;
import application.pageObject.forms.MainMenu;
import framework.browsers.BrowserActions;
import framework.logger.MyLogger;
import framework.utils.PropertiesManager;
import framework.utils.RandomGeneration;
import org.apache.log4j.lf5.util.ResourceUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestModalWindows {
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
        mainPage.getMainMenu().moveToMenuItem(MainMenuItem.WE_ARE_WABASH).clickSubMenuItem(WeAreWabashItems.OUR_CULTURE.getTitle());

        OurCulturePage ourCulturePage = new OurCulturePage();
        assertEquals(ourCulturePage.getMainMenu().moveToMenuItem(MainMenuItem.WE_ARE_WABASH).getMenuItemURL(WeAreWabashItems.OUR_CULTURE.getTitle()), ourCulturePage.getCurrentURL(),
                "urls is not equals");
        assertTrue(ourCulturePage.getCurrentURL().contains(ourCulturePage.getBreadcrumb().getBreadcrumbURL(MainMenuItem.WE_ARE_WABASH.getTitle())),
                "Breadcrumb is not contains previous page url");
        assertEquals(ourCulturePage.getBreadcrumb().getBreadcrumbURL("Home"), homeUrl, "home url is not equals");

        ourCulturePage.getMainMenu().moveToMenuItem(MainMenuItem.WE_ARE_WABASH).moveToMenuItem(WeAreWabashItems.CORPORATE_RESPONSIBILITY.getTitle())
                .clickSubMenuItem(SustainabilityItems.FUEL_ECONOMY.getTitle());
        FuelEconomyPage fuelEconomyPage = new FuelEconomyPage();
        assertEquals(fuelEconomyPage.getMainMenu().moveToMenuItem(MainMenuItem.WE_ARE_WABASH).getMenuItemURL(WeAreWabashItems.CORPORATE_RESPONSIBILITY.getTitle()), fuelEconomyPage.getCurrentURL(),
                "urls is not equals");
        assertTrue(fuelEconomyPage.getCurrentURL().contains(fuelEconomyPage.getBreadcrumb().getBreadcrumbURL(CorporateResponsibilityItems.SUSTAINABILITY.getTitle())),
                "Breadcrumb is not contains previous page url");
        assertEquals(fuelEconomyPage.getBreadcrumb().getBreadcrumbURL("Home"), homeUrl, "home url is not equals");

        fuelEconomyPage.getMainMenu().moveToMenuItem(MainMenuItem.TRADITION_OF_INNOVATION).clickSubMenuItem(TraditionOfInnovationItem.RESPONSIBILITY_TO_OUR_CUSTOMERS.getTitle());
        ResponsibilityToOurCustomersPage responsibilityToOurCustomersPage = new ResponsibilityToOurCustomersPage();
        assertEquals(responsibilityToOurCustomersPage.getMainMenu().moveToMenuItem(MainMenuItem.TRADITION_OF_INNOVATION)
                        .getMenuItemURL(TraditionOfInnovationItem.RESPONSIBILITY_TO_OUR_CUSTOMERS.getTitle()),
                responsibilityToOurCustomersPage.getCurrentURL(),
                "urls is not equals");
        assertTrue(responsibilityToOurCustomersPage.getCurrentURL().contains(responsibilityToOurCustomersPage.getBreadcrumb()
                        .getBreadcrumbURL(CorporateResponsibilityItems.SUSTAINABILITY.getTitle())),
                "Breadcrumb is not contains previous page url");
        assertEquals(responsibilityToOurCustomersPage.getBreadcrumb().getBreadcrumbURL("Home"), homeUrl, "home url is not equals");

        responsibilityToOurCustomersPage.getMainMenu().moveToMenuItem(MainMenuItem.OUR_PRODUCTS).clickSubMenuItem(OurProductsItem.STAINLESS_TANKS.getTitle());
        StainlessTanksPage stainlessTanksPage = new StainlessTanksPage();
        assertEquals(stainlessTanksPage.getMainMenu().moveToMenuItem(MainMenuItem.OUR_PRODUCTS)
                        .getMenuItemURL(OurProductsItem.STAINLESS_TANKS.getTitle()),
                stainlessTanksPage.getCurrentURL(),
                "urls is not equals");
        assertTrue(stainlessTanksPage.getCurrentURL().contains(stainlessTanksPage.getBreadcrumb()
                        .getBreadcrumbURL(MainMenuItem.OUR_PRODUCTS.getTitle())),
                "Breadcrumb is not contains previous page url");
        assertEquals(stainlessTanksPage.getBreadcrumb().getBreadcrumbURL("Home"), homeUrl, "home url is not equals");

    }

}
