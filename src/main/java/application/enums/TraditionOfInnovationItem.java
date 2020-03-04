package application.enums;

public enum TraditionOfInnovationItem {

    RESPONSIBILITY_TO_OUR_CUSTOMERS("Responsibility to Our Customers"),
    PATENTS_AND_R_D_TEST_CENTER("Patents and R&D Test Center"),
    TRANSFORMATIONAL_INNOVATIONS_AND_BENEFITS("Transformational Innovations and Benefits"),
    FUTURE_FOCUS("Future Focus");

    private String title;

    TraditionOfInnovationItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
