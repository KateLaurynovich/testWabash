package application.models;

public class Dealer {
    String name;
    Double distance;
    String address;
    String phone;
    String service;

    public Dealer(String name, Double distance, String address, String phone, String service) {
        this.name = name;
        this.distance = distance;
        this.address = address;
        this.phone = phone;
        this.service = service;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", service='" + service + '\'' +
                '}';
    }
}
