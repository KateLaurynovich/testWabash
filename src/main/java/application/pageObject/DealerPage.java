package application.pageObject;

import application.models.Dealer;
import application.enums.LocationFilterItem;
import framework.browsers.BrowserActions;
import framework.elements.Button;
import framework.elements.Label;
import framework.utils.RegEx;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class DealerPage extends BasePage {
    private static final String LOCATION_BTN_LOC = "//span[contains(text(), '%s')]/..";
    private static final String LOCATION_STATUS_BTN_LOC = "//span[contains(text(), 'Sales')]/../..//span[contains(@class, 'checked')]";
    private static final String DEALER_ITEM_LOC = "//div[@class = 'w__dealer_item']";
    private static final String DEALER_ITEM_NAME_LOC = "//div[@class = 'adress']//h2";
    private static final String DEALER_ITEM_DISTANCE_LOC = "//div[@class = 'w__dealer_distance']//div";
    private static final String DEALER_ITEM_ADDRESS_LOC = "//div[@class = 'w_address1']";
    private static final String DEALER_ITEM_PHONE_LOC = "//div[@class = 'phone']";
    private static final String DEALER_ITEM_SERVICE_LOC = "//div[@class = 'service']";
    private static final String DEALER_RADIUS_LOC = "//div[@class = 'w__relative']//span";

    private static final String REG_EX = "\\d{1,3}.{0,1}\\d{0,3}";

    private Button getLocationFilterBtn(LocationFilterItem locationFilterItem) {
        return new Button(By.xpath(String.format(LOCATION_BTN_LOC, locationFilterItem.getTitle())), locationFilterItem.getTitle());
    }

    public void clickLocationFilter(LocationFilterItem locationFilterItem) {
        getLocationFilterBtn(locationFilterItem).clickElement();
    }

    public boolean isCheckedLocationFilter(LocationFilterItem locationFilterItem) {
        return new Button(By.xpath(String.format(LOCATION_STATUS_BTN_LOC, locationFilterItem.getTitle())), locationFilterItem.getTitle()).isDisplayed();
    }

    private ArrayList<WebElement> getListDealers() {
        ArrayList<WebElement> dealers = new ArrayList<>();
        for (WebElement dealer : BrowserActions.getBrowser().findElements(By.xpath(DEALER_ITEM_LOC))) {
            dealers.add(dealer);
        }
        return dealers;
    }

    public ArrayList<Dealer> getDealers() {
        ArrayList<Dealer> dealers = new ArrayList<>();
        for (WebElement element : getListDealers()) {
            Dealer dealer = new Dealer(
                    element.findElement(By.xpath(DEALER_ITEM_NAME_LOC)).getText(),
                    Double.valueOf(RegEx.findMatcher(REG_EX, element.findElement(By.xpath(DEALER_ITEM_DISTANCE_LOC)).getText())),
                    element.findElement(By.xpath(DEALER_ITEM_ADDRESS_LOC)).getText(),
                    element.findElement(By.xpath(DEALER_ITEM_PHONE_LOC)).getText(),
                    element.findElement(By.xpath(DEALER_ITEM_SERVICE_LOC)).getText());
            dealers.add(dealer);
        }
        return dealers;
    }

    private Double getRadius() {
        return Double.valueOf(RegEx.findMatcher(REG_EX, new Label(By.xpath(DEALER_RADIUS_LOC), "Radius").getText()));
    }

    public boolean checkLocationFilter(LocationFilterItem locFilter) {
        boolean res = false;
        for (Dealer dealer : getDealers()) {
            if (dealer.getService().contains(locFilter.getTitle())) {
                res = true;
            }
        }
        return res;
    }

    public boolean checkRadiusFilter() {
        boolean res = false;
        for (Dealer dealer : getDealers()) {
            if (dealer.getDistance() <= getRadius()) {
                res = true;
            }
        }
        return res;
    }
}
