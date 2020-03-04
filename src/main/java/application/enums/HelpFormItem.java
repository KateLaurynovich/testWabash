package application.enums;

public enum  HelpFormItem {
    NAME("Name"),
    COMPANY("Company"),
    EMAIL("Email"),
    PHONE("Phone"),
    COMMENTS("Comments");

    private String title;

    HelpFormItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static void main(String[] args) {
        System.out.println("Company".toUpperCase().replace(" ", "_"));
    }
}
