package yandex_taxi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        YandexTaxi yandexTaxi = new YandexTaxi();
        boolean a = true;

        while (a) {
            System.out.println("Select one of the menus: ");
            UserType[] values = UserType.values();
            for (int i = 0; i < values.length; i++) {
                System.out.println((i + 1) + " -> " + values[i]);
            }
            System.out.println("3 -> Monitoring; 0 -> Sign out");

            int n = in.nextInt();
            switch (n) {
                case 1 -> {
                    yandexTaxi.driverMenu();
                }
                case 2 -> {
                    yandexTaxi.passengerMenu();
                }
                case 3 -> {
                    yandexTaxi.monitoring();
                }
                case 0 -> {
                    a = false;
                }
            }
        }
    }
}