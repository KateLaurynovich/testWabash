package application.enums;

public enum  LocationFilterItem {

    SALES("Sales"),
    WARRANTY("Warranty"),
    MANUFACTURING("Manufacturing"),
    CORPORATE("Corporate"),
    SERVICE("Service"),
    PARTS("Parts");

    private String title;

    LocationFilterItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
