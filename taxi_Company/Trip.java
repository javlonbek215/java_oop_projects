package taxi_Company;

public class Trip {
    private Place from;
    private Place to;

    public Trip(Place from, Place to) {
        this.from = from;
        this.to = to;
    }

    public String toString() {
        return this.from + " , " + this.to;
    }

}
