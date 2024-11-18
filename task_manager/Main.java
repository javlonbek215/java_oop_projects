package task_manager;

import java.util.Scanner;

public class Main {
    static Task[] taskArr = new Task[10];
    static int index = 0;
    static int generalId = 1;
    static Scanner scanner = new Scanner(System.in);
    static Scanner str = new Scanner(System.in);

    public static void main(String[] args) {

        boolean b = true;
        while (b) {
            menu();
            int n = option();

            switch (n) {
                case 1: {
                    Task task = addTask();
                    isTask(task);
                    taskArr[index++] = task;
                    break;
                }

                case 2: {
                    showTasks();
                    break;
                }
                case 3: {
                    editTask();
                    break;
                }
                case 4: {
                    getId();
                    break;
                }

                case 5: {
                    int id = changeByIdStatus();
                    for (Task task : taskArr) {
                        if (task != null && task.id == id) {
                            if (task.title.equals(task.status)) {
                                task.status = "Active";
                            }
                            break;
                        }
                    }
                    break;
                }

                case 6: {
                    System.out.print("Enter keyword: ");
                    String keyword = str.nextLine();
                    search(keyword);
                    break;
                }
                case 7: {
                    deleteTask();
                    break;
                }
                case 8: {
                    statusActive();
                    break;
                }

                case 9: {
                    statusNotActive();
                    break;
                }


                case 10: {
                    String title = changeByStatusName();
                    for (Task task : taskArr) {
                        if (task != null && task.title.equals(title)) {
                            if (task.title.equals(task.status)) {
                                task.status = "Active";
                            }
                            break;
                        }
                    }
                    break;
                }

                case 0: {
                    b = false;
                    break;
                }
            }
        }
    }

    public static void menu() {
        System.out.println("Welcome to the Task Manager");
        String str = """
                +--------OPTIONS---------+
                 | 1.Add Task             |
                 | 2.Show Task            |
                 | 3.Edit Task            |
                 | 4.Get ID               |
                 | 5.ChangeStat by ID     |
                 | 6.Search               |
                 | 7.Delete               |
                 | 8.Status Active        |
                 | 9.Status Not Active    |
                
                 | 10.ChangeStat by name  |
                 +------------------------|
                 | 0.Log out              |
                 +------------------------+
                 Enter option ->\s""";
        System.out.print(str);
    }

    public static int option() {
        return scanner.nextInt();
    }

    public static Task addTask() {
        System.out.print("Enter title: ");
        String title = str.nextLine();
        System.out.print("Enter description: ");
        String description = str.nextLine();

        Task[] newArr = new Task[taskArr.length * 2];
        System.arraycopy(taskArr, 0, newArr, 0, taskArr.length);
        taskArr = newArr;

        return new Task(generalId++, title, description);
    }

    public static void isTask(Task task) {
        if (task.title.trim().length() < 3) {
            System.out.println("Title length must be at least 3 characters!");
            return;
        }
        if (task.description.trim().length() < 3) {
            System.out.println("Description length must be at least 3 characters!");
        }
    }

    public static Task[] search(String keyword) {
        Task[] newArr = new Task[taskArr.length];
        int index = 0;

        for (Task task : taskArr) {
            if (task != null && (task.title.contains(keyword) || task.description.contains(keyword))) {
                newArr[index++] = task;
            }
        }

        if (index == 0) {
            System.out.println("No tasks found with the keyword: " + keyword);
        } else {
            System.out.println("Search results:");
            for (int i = 0; i < index; i++) {
                System.out.println(newArr[i]);
            }
        }
        return newArr;
    }

    public static void statusActive() {
        for (Task task : taskArr) {
            if (task != null && task.status.equals("Active")) {
                System.out.println(task);
            }
        }
    }

    public static void statusNotActive() {
        for (Task task : taskArr) {
            if (task != null && !(task.status.equals("Active"))) {
                System.out.println(task);
            }
        }
    }

    public static void deleteTask() {
        System.out.print("Enter ID task to delete: ");
        int id = scanner.nextInt();
        boolean deleted = false;

        for (int i = 0; i < taskArr.length; i++) {
            if (taskArr[i] != null && taskArr[i].id == id) {
                taskArr[i] = null;
                deleted = true;
                System.out.println("Task with ID " + id + " has been deleted.");
                break;
            }
        }
        if (!deleted) {
            System.out.println("Task with ID " + id + " not found.");
        }
    }

    public static void editTask() {
        System.out.print("Enter the edit ID: ");
        int id = scanner.nextInt();

        boolean a = false;
        for (Task task : taskArr) {
            if (task != null && task.id == id) {
                a = true;
                System.out.println("Current title: " + task.title);
                System.out.print("Enter new title: ");
                String newTitle = scanner.nextLine();

                System.out.println("Current description: " + task.description);
                System.out.print("Enter new description: ");
                String newDescription = scanner.nextLine();

                if (!newTitle.trim().isEmpty()) {
                    task.title = newTitle;
                }
                if (!newDescription.trim().isEmpty()) {
                    task.description = newDescription;
                }

                System.out.println("Success:)");
                break;
            }
        }

        if (!a) {
            System.out.println("Task ID not found.");
        }
    }

    public static void getId() {
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        for (Task task : taskArr) {
            if (task.id == id) {
                System.out.println(task);
            }
        }
    }

    public static String changeByStatusName() {
        System.out.print("Enter title: ");
        return str.nextLine();
    }

    public static int changeByIdStatus() {
        System.out.print("Enter id: ");
        return scanner.nextInt();
    }

    public static void showTasks() {
        System.out.printf("--------------------------------------------------------------------------%n");
        System.out.printf("|                                  Task List                              |%n");
        System.out.printf("--------------------------------------------------------------------------%n");
        System.out.printf("| %-3s | %-25s | %-60s | %-10s |%n", "Id", "Title", "Content", "Status");

        for (Task task : taskArr) {
            if (task != null) {
                System.out.printf("| %-3d | %-25s | %-60s | %-10s |%n",
                        task.id, task.title, task.description, task.status);
            }
        }
        System.out.printf("--------------------------------------------------------------------------%n");
    }


}