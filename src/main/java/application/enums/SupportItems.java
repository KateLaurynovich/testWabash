package application.enums;

public enum  SupportItems {

    FREQUENTLY_ASKED_QUESTIONS("Frequently Asked Questions");

    private String title;

    SupportItems(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
