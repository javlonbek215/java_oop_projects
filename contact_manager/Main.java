package contact_manager;

import task_manager.TaskList;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ContactManager contactManager = new ContactManager();
        TaskList taskList = new TaskList();

        boolean b = true;

        while (b) {
            Menu();
            int n = getMenuNumber();

            switch (n) {
                case 1 -> {
                    contactManager.start();
                }
                case 2 -> {
                    taskList.start();
                }

                case 0 -> b = false;
                default -> System.out.println("There is no such project: ");
            }
        }
    }

    public static void Menu() {
        System.out.println("**** Menu ****");
        System.out.println("1 - Contact Manager");
        System.out.println("2 - TaskList");
        System.out.println("0 - Exit");
    }

    public static int getMenuNumber() {
        System.out.print("Choose menu: ");

        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
}