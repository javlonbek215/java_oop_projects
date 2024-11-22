package yandex_taxi;

import java.util.Arrays;
import java.util.Scanner;

public class YandexTaxi {
    private Driver[] drivers = new Driver[100];
    private int dCount = 0;
    private Passenger[] passagers = new Passenger[100];
    private int pCount = 0;
    private Monitor[] monitors = new Monitor[100];
    private int mCount = 0;
    Scanner in = new Scanner(System.in);

    public void driverMenu() {
        boolean a = true;

        while (a) {
            System.out.println("1 -> Registration; 2 -> Login; 0 -> Sign out");
            int n = in.nextInt();
            switch (n) {
                case 1 -> {
                    System.out.print("Car number: ");
                    String number = in.next();

                    System.out.print("Car model: ");
                    String model = in.next();

                    System.out.println("Choose status type: ");
                    StatusType[] values = StatusType.values();
                    for (int i = 0; i < values.length; i++) {
                        System.out.println((i + 1) + " -> " + values[i]);
                    }
                    int ChooseStatusType = in.nextInt() - 1;
                    StatusType value = values[ChooseStatusType];

                    System.out.print("Enter your phoneNumber: ");
                    String phoneNumber = in.next();

                    System.out.print("Password: ");
                    String password = in.next();

                    Driver driver = new Driver(number, model, value, phoneNumber, password);
                    drivers[dCount++] = driver;

                }
                case 2 -> {
                    System.out.print("Enter your phoneNumber: ");
                    String phoneNumber = in.next();

                    System.out.print("Password: ");
                    String password = in.next();

                    int dIndex = -1;

                    for (int i = 0; i < dCount; i++) {
                        if (drivers[i].phoneNumber.equals(phoneNumber) && drivers[i].password.equals(password)) {
                            dIndex = i;
                            break;
                        }
                    }
                    if (dIndex == -1) {
                        System.out.println("Driver not found!");
                    } else {
                        System.out.println(drivers[dIndex].number + " Welcome to the system! ");
                        driverTaxi(dIndex);
                    }
                }
                case 0 -> {
                    a = false;
                }
            }
        }
    }

    public void driverTaxi(int index) {
        boolean a = true;
        Driver driver = drivers[index];
        while (a) {
            System.out.println(" 1 -> To deliver the passenger to the destination; 2 -> Current passenger information ;0 -> Exit ");

            int n = in.nextInt();

            switch (n) {
                case 1 -> {
                    for (int i = 0; i < mCount; i++) {
                        if(monitors[i].driver == driver && !monitors[i].isFinished){
                            monitors[i].isFinished = true;
                        }
                    }
                }
                case 2 -> {
                    for (int i = 0; i < mCount; i++) {
                        if(monitors[i].driver == driver && monitors[i].isFinished){
                            System.out.println(monitors[i].passenger);
                        }
                    }
                }
                case 0 -> {
                    a = false;
                }
            }
        }
    }

    public void passengerMenu() {
        boolean a = true;
        while (a) {
            System.out.println(" 1 -> Registration; 2 -> Login; 0 -> Exit ");

            int n = in.nextInt();
            switch (n) {
                case 1 -> {
                    System.out.print("Enter your name: ");
                    String name = in.next();

                    System.out.print("Enter your phone number: ");
                    String phoneNumber = in.next();

                    System.out.print("Password: ");
                    String password = in.next();

                    Passenger passenger = new Passenger(name, phoneNumber, password);
                    passagers[pCount++] = passenger;
                }
                case 2 -> {
                    System.out.print("Enter your phone number: ");
                    String phoneNumber = in.next();

                    System.out.print("Password: ");
                    String password = in.next();

                    int pIndex = -1;

                    for (int i = 0; i < pCount; i++) {
                        if (passagers[i].phoneNumber.equals(phoneNumber) && passagers[i].password.equals(password)) {
                            pIndex = i;
                            break;
                        }
                    }

                    if (pIndex == -1) {
                        System.out.println("Driver not found!");
                    } else {
                        System.out.println(passagers[pIndex].name + " Welcome to the system! ");
                        passengerTaxi(pIndex);
                    }

                }
                case 0 -> {
                    a = false;
                }
            }
        }
    }

    public void passengerTaxi(int index) {
        boolean a = true;
        while (a) {
            System.out.println(" 1 -> Call a taxi; 2 -> Exit ");

            int n = in.nextInt();

            switch (n) {
                case 1 -> {
                    Passenger passenger = passagers[index];
                    StatusType[] values = StatusType.values();
                    for (int i = 0; i < values.length; i++) {
                        System.out.println((i + 1) + " -> " + values[i]);
                    }
                    int n1 = in.nextInt() - 1;
                    StatusType value = values[n1];
                    Object[] freeDrivers = Arrays.stream(drivers, 0, dCount).filter(driver -> driver.statusType == value && !driver.isFree).toArray();
                    for (int i = 0; i < freeDrivers.length; i++) {
                        Driver driver = (Driver) freeDrivers[i];
                        System.out.println((i + 1) + " -> " + driver.number + " " + driver.model);
                    }
                    int n2 = in.nextInt() - 1;
                    Driver drivers = (Driver) freeDrivers[n2];
                    drivers.isFree = true;

                    System.out.print(" Standing place: ");
                    String currentPlace = in.next();

                    System.out.print(" The place you want to go: ");
                    String targetPlace = in.next();

                    Monitor monitor = new Monitor(passenger, drivers, currentPlace, targetPlace);
                    monitors[mCount++] = monitor;

                }
                case 2 -> {
                    a = false;
                }
            }
        }
    }

    public void monitoring() {
        for (int i = 0; i < mCount; i++) {
            Monitor monitor = monitors[i];
            System.out.println(monitor);
        }
    }

    private class Driver {
        private String number;
        private String model;
        private StatusType statusType;
        private String password;
        private String phoneNumber;
        private boolean isFree;

        public Driver(String number, String model, StatusType statusType, String password, String phoneNumber) {
            this.number = number;
            this.model = model;
            this.statusType = statusType;
            this.password = password;
            this.phoneNumber = phoneNumber;
        }
    }

    private class Passenger {
        private String name;
        private String phoneNumber;
        private String password;

        public Passenger(String name, String phoneNumber, String password) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.password = password;
        }

        @Override
        public String toString() {
            return "Passenger{" +
                    "name='" + name + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }

    private class Monitor {
        private Passenger passenger;
        private Driver driver;
        private String currentPlace;
        private String targetPlace;
        private boolean isFinished;

        public Monitor(Passenger passenger, Driver driver, String currentPlace, String targetPlace) {
            this.passenger = passenger;
            this.driver = driver;
            this.currentPlace = currentPlace;
            this.targetPlace = targetPlace;
        }

        @Override
        public String toString() {
            return "Monitor{" +
                    "passenger=" + passenger.name +
                    ", driver=" + driver.number +
                    ", currentPlace='" + currentPlace + '\'' +
                    ", targetPlace='" + targetPlace + '\'' +
                    ", isFinished=" + isFinished +
                    '}';
        }
    }
}