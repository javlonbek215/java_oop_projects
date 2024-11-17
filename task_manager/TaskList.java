package task_manager;

import java.util.Scanner;

public class TaskList {
    Task[] taskArray = new Task[10];
    int currentIndex = 0;

    int GeneralID = 1;

    public void start() {

        boolean b = true;

        while (b) {
            Menu();
            int n = getMenuNumber();

            switch (n) {
                case 1 -> {
                    Task task = AddTask();
                    isTask(task);
                    TaskToArray(task);
                }
                case 2 -> allTask();
                case 3 -> {
                    String title = ChangeStatusByName();
                    for (Task t : taskArray) {
                        if (t != null && t.getTitle().equals(title)) {
                            if (t.getTitle().equals("Active")) {
                                t.setStatus("Done");
                            } else {
                                t.setStatus("Active");
                            }
                            break;
                        }
                    }
                }
                case 4 -> {
                    int id = ChangeStatusByID();
                    for (Task t : taskArray) {
                        if (t != null && t.getId() == id) {
                            if (t.getTitle().equals("Active")) {
                                t.setStatus("Done");
                            } else {
                                t.setStatus("Active");
                            }
                            break;
                        }
                    }
                }
                case 5 -> printActiveTaskList();
                case 0 -> b = false;
                default -> System.out.println("Choose current number please: ");
            }
        }
    }

    public void Menu() {
        System.out.println("**** Menu ****");
        System.out.println("1 - Add Task");
        System.out.println("2 - TaskList");
        System.out.println("3 - ChangeStatus by name");
        System.out.println("4 - ChangeStatus by id");
        System.out.println("5 - Active Task list");
        System.out.println("0 - Exit");
    }

    public int getMenuNumber() {
        System.out.print("Choose menu: ");

        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public Task AddTask() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter title: ");
        String title = in.nextLine();

        System.out.print("Enter content: ");
        String content = in.nextLine();

        Task addTask = new Task();
        addTask.setTitle(title);
        addTask.setContent(content);

        return addTask;
    }

    public boolean isTask(Task addTask) {
        if (addTask.getTitle().length() < 3 || addTask.getTitle() == null) {
            System.out.println("Title length must be at least 3 characters!");
            return false;
        }
        if (addTask.getContent().length() < 3 || addTask.getContent() == null) {
            System.out.println("Content length must be at least 3 characters!");
            return false;
        }
        return true;
    }

    public void TaskToArray(Task addTask) {
        addTask.setStatus("Active");
        addTask.setId(GeneralID++);
        if (taskArray.length == currentIndex) {
            Task[] newArray = new Task[taskArray.length * 2];
            for (int i = 0; i < taskArray.length; i++) {
                newArray[i] = taskArray[i];
            }
            taskArray = newArray;
        }
        taskArray[currentIndex] = addTask;
        currentIndex++;
    }

    public void allTask() {
        System.out.printf("--------------------------------------------------------------------------%n");
        System.out.printf("|                                  Task List                              |%n");
        System.out.printf("--------------------------------------------------------------------------%n");
        System.out.printf("| %-3s | %-15s | %-40s | %-6s |%n", "Id", "Title", "Content", "Status");

        for (Task task : taskArray) {
            if (task != null) {
                System.out.printf("| %-3d | %-15s | %-40s | %-6s |%n",
                        task.getId(), task.getTitle(), task.getContent(), task.getStatus());
            }
        }
        System.out.printf("--------------------------------------------------------------------------%n");
    }

    public String ChangeStatusByName() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter title: ");
        return in.nextLine();
    }

    public int ChangeStatusByID() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter ID: ");
        return in.nextInt();
    }

    public void printActiveTaskList() {
        for (Task task : taskArray) {
            if (task != null && task.getStatus().equals("Active")) {
                System.out.println(task.getId() + " " + task.getTitle() + " " +
                        task.getContent() + " " + task.getStatus());
            }
        }
    }
}