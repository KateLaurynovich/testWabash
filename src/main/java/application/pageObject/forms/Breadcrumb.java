package application.pageObject.forms;

import framework.elements.Label;
import org.openqa.selenium.By;

public class Breadcrumb {
    private static final String BREADCRUMB_LOC = "//div[contains(@id, 'Breadcrumb')]";
    private static final String BREADCRUMB_PART_LOC = "//div[contains(@id, 'Breadcrumb')]//a[contains(text(), '%s')]";

    public String getBreadcrumbText() {
        return new Label(By.xpath(BREADCRUMB_LOC), "Breadcrumb").getText();
    }

    private Label getBreadcrumb(String previousPage) {
        return new Label(By.xpath(String.format(BREADCRUMB_PART_LOC, previousPage)), "Breadcrumb");
    }

    public String getBreadcrumbURL(String previousPage) {
        return getBreadcrumb(previousPage).getAttribute("href");
    }

    public void clickBreadcrumbURL(String previousPage) {
        getBreadcrumb(previousPage).clickElement();
    }
}
