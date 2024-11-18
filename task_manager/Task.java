package task_manager;

public class Task {

    int id;
    public String title;
    public String description;
    public String status;

    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = "Not_Active";
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", title: " + title + '\'' +
                ", description: " + description + '\'' +
                ", status: " + status + '\'';
    }
}