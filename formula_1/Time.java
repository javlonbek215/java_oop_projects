package formula_1;

public class Time {
    private GP gp;
    private Driver driver;

    private int hours;
    private int min;
    private int sec;
    private int cent;

    public Time(Driver driver, GP gp, int hours, int min, int sec, int cent) {
        this.driver = driver;
        this.gp = gp;
        this.hours = hours;
        this.min = min;
        this.sec = sec;
        this.cent = cent;
    }

    public Time() {}

    public Driver getDriver() {
        return driver;
    }

    public GP getGp() {
        return gp;
    }

    public int getHours() {
        return hours;
    }

    public int getMin() {
        return min;
    }

    public int getSec() {
        return sec;
    }

    public int getCent() {
        return cent;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d.%02d", hours, min, sec, cent);
    }
}
