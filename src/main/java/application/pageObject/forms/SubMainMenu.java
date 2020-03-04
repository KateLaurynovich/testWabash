package application.pageObject.forms;

import application.enums.MainMenuItem;
import framework.elements.Label;
import framework.forms.BaseForm;
import framework.logger.MyLogger;
import org.openqa.selenium.By;

public class SubMainMenu extends BaseForm {
    private static final MyLogger LOGGER = new MyLogger();
    private static final String SUBMENU_LOC = "//li[@class='dropdown']";
    private static final String SUBMENU_ITEM_LOCATOR = "//a[contains(text(), '%s')]/..//a[contains(text(), '%s')]";
    private static String menuItem;

    public SubMainMenu(String mainMenuItem) {
        super(By.xpath(SUBMENU_LOC), "SubMain menu");
        menuItem = mainMenuItem;
    }

    private Label getSubMenuItem(String subMenuItem) {
        return new Label(By.xpath(String.format(SUBMENU_ITEM_LOCATOR, menuItem, subMenuItem)), subMenuItem);
    }

    public SubMainMenu moveToMenuItem(String subMenuItem) {
        getSubMenuItem(subMenuItem).moveToElement();
        return new SubMainMenu(menuItem);
    }

    public void clickSubMenuItem(String subMenuItem) {
        getSubMenuItem(subMenuItem).clickElement();
    }


    public String getMenuItemURL(String title) {
        return getSubMenuItem(title).getAttribute("href");
    }
}
