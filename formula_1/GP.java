package formula_1;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class GP {
    private String name;
    private MyArray<Time> timeList = new MyArray<>();

    public GP(String name) {
        this.name = name;
    }

    public GP() {
    }

    public String getName() {
        return name;
    }

    public void addTime(Time time) {
        timeList.add(time);
    }

    public MyArray<Driver> getGPRanking() {
        Time[] times = timeList.toArray(new Time[0]);
//        for (int i = 0; i < timeList.size(); i++) {
//            times[i] = timeList.get(i);
//        }

//        timeList.toArray(new Time[0]);

        Comparator<Time> comparator = (o1, o2) -> {
            int n = o1.getHours() - o2.getHours();
            if (n == 0) {
                n = o1.getMin() - o2.getMin();
                if (n == 0) {
                    n = o1.getSec() - o2.getSec();
                    if (n == 0) {
                        n = o1.getCent() - o2.getCent();
                    }
                }
            }
            return n;
        };

        Arrays.sort(times, comparator);

        MyArray<Driver> myArray = new MyArray<>();
        for (Time time : times) {
            myArray.add(time.getDriver());
        }

        return myArray;
    }

    public int getPosition(Driver driver) {
        MyArray<Driver> drivers = getGPRanking();
        int index = drivers.indexOf(driver);
        return index + 1;
    }
}
