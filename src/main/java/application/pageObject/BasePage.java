package application.pageObject;

import application.pageObject.forms.MainMenu;
import framework.browsers.BrowserActions;
import framework.logger.MyLogger;

public abstract class BasePage {
    protected static final MyLogger LOGGER = new MyLogger();

    public MainMenu getMainMenu() {
        return new MainMenu();
    }

    public String getCurrentURL() {
        return BrowserActions.getBrowser().getCurrentUrl();
    }
}
