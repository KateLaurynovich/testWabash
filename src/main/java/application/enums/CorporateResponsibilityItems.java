package application.enums;

public enum CorporateResponsibilityItems {

    ENVIRONMENTAL_HEALTH_SAFETY_POLICY("Environmental, Health & Safety Policy"),
    WABASH_NATIONAL_ISO_REGISTRATIONS_AND_RECOGNITIONS("Wabash National ISO Registrations and Recognitions"),
    SUSTAINABILITY("Sustainability");

    private String title;

    CorporateResponsibilityItems(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
