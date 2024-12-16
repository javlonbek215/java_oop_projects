package taxi_Company;

public class Place {
    private String address;
    private String distric;

    public Place(String ind, String quart) {
        this.address = ind;
        this.distric = quart;
    }

    public String toString() {
        return this.address;
    }

    public String getDistric() {
        return distric;
    }
}