package application.enums;

public enum OurProductsItem {

    TRAILERS("Trailers"),
    TRUCK_BODIES("Truck Bodies"),
    STAINLESS_TANKS("Stainless Tanks");

    private String title;

    OurProductsItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
