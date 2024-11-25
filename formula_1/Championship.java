package formula_1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Championship {
    // Driver
    private MyArray<Driver> drivers = new MyArray<>();

    // Grand Pri
    private MyArray<GP> grandPri = new MyArray<>();

    // Time
    private MyArray<Time> times = new MyArray<>();

    public Driver createDriver(String name) {
        Driver driver = new Driver(name);
        drivers.add(driver);
        return driver;
    }

    public MyArray<Driver> getDrivers() {
        return drivers;
    }


    public Driver getDriver(String name) {
        for (Driver driver : drivers) {
            if (driver != null && driver.getName().equals(name)) {
                return driver;
            }
        }
        return null;
    }


    public GP defineGrandPri(String name) {
        GP gp = new GP(name);
        grandPri.add(gp);
        return gp;
    }

    public GP getGrandPri(String name) {
        for (GP gp : grandPri) {
            if (gp != null && gp.getName().equals(name)) {
                return gp;
            }
        }
        return null;
    }

    public Time setTime(GP gp, Driver driver, int hours, int min, int sec, int cent) {
        Time time = new Time(driver, gp, hours, min, sec, cent);
        times.add(time);
        driver.addGpList(time);
        gp.addTime(time);
        return time;
    }


    public MyArray<Driver> getChampionshipRanking() {
        Driver[] driver = drivers.toArray(new Driver[0]);

        Comparator<Driver> comparator = Comparator.comparingInt(Driver::getPoints).reversed();

        Arrays.sort(driver, comparator);

        MyArray<Driver> drivers1 = new MyArray<>();
        for(Driver driver1 : drivers){
            drivers1.add(driver1);
        }
        return new MyArray<>(driver);
    }
}
