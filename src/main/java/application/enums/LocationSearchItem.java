package application.enums;

public enum LocationSearchItem {

    RESULT("Result"),
    DEALER("Dealer"),
    TEST("test");

    private String title;

    LocationSearchItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}


