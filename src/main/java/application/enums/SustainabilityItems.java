package application.enums;

public enum  SustainabilityItems {
    FUEL_ECONOMY("Fuel Economy"),
    ENERGY_CONSERVATION("Energy Conservation"),
    WASTE_REDUCTION_AND_RECYCLING("Waste Reduction and Recycling");

    private String title;

    SustainabilityItems(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
