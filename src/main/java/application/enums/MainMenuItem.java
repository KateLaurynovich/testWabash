package application.enums;

public enum MainMenuItem {
    WE_ARE_WABASH("We Are Wabash"),
    TRADITION_OF_INNOVATION("Tradition of Innovation"),
    OUR_PRODUCTS("Our Products"),
    OUR_BRANDS("Our Brands"),
    WORK_WITH_WABASH("Work With Wabash"),
    TIMELINE("Timeline"),
    LOCATION_SEARCH("Location Search");

    private String title;

    MainMenuItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
