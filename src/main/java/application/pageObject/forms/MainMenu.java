package application.pageObject.forms;

import application.enums.MainMenuItem;
import framework.elements.Label;
import framework.forms.BaseForm;
import framework.logger.MyLogger;
import org.openqa.selenium.By;


public class MainMenu extends BaseForm {
    private static final MyLogger LOGGER = new MyLogger();
    private static final String MAIN_MENU_LOC = "//div[@id='ContentPlaceHolderMenu_TB28884E1005_Col01']";
    private static final String MAIN_MENU_ITEM_LOC = "//div[@id='ContentPlaceHolderMenu_TB28884E1005_Col01']//a[contains(text(), '%s')]";

    public MainMenu() {
        super(By.xpath(MAIN_MENU_LOC), "Main menu");
    }

    private Label getMenuItem(MainMenuItem mainMenuItem) {
        String nameMenuItem = mainMenuItem.getTitle();
        return new Label(By.xpath(String.format(MAIN_MENU_ITEM_LOC, nameMenuItem)), nameMenuItem);
    }

    public SubMainMenu moveToMenuItem(MainMenuItem mainMenuItem) {
        LOGGER.info("move to MainMenuItem - " + mainMenuItem.getTitle());
        getMenuItem(mainMenuItem).moveToElement();
        return new SubMainMenu(mainMenuItem.getTitle());
    }

    public void clickMenuItem(MainMenuItem mainMenuItem) {
        getMenuItem(mainMenuItem).clickElement();
    }

    public String getMenuItemURL(String subMenuItem) {
        return new Label(By.xpath(String.format(MAIN_MENU_ITEM_LOC, subMenuItem)), subMenuItem).getAttribute("href");
    }
}
