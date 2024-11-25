package formula_1;

import java.util.Collection;

public class Driver {
    private String name;
    private MyArray<Time> gpList = new MyArray<>();
    private int points[] = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};

    public Driver(String name) {
        this.name = name;
    }

    public Driver() {
    }

    public String getName() {
        return name;
    }

    public void addGpList(Time time) {
        gpList.add(time);
    }

    public MyArray<GP> getRaced() {
        MyArray<GP> gp = new MyArray<>();
        for (Time time : gpList) {
            gp.add(time.getGp());
        }
        return gp;
    }

    public int getPoints() {
        int total = 0;
        for (Time time : gpList) {
            GP gp = time.getGp();
            int position = gp.getPosition(this);

            total += points[position - 1];
        }
        return total;
    }
}