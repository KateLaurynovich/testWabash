package application.enums;

public enum WeAreWabashItems {
    OUR_HERITAGE("Our Heritage"),
    OUR_CULTURE("Our Culture"),
    OUR_LEADERSHIP("Our Leadership"),
    CORPORATE_RESPONSIBILITY("Corporate Responsibility"),
    PURSUIT_OF_EXCELLENCE("Pursuit of Excellence"),
    MANUFACTURING_LOCATIONS("Manufacturing Locations"),
    TEAMWORK("Teamwork"),
    SUPPORT("Support");

    private String title;

    WeAreWabashItems(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
