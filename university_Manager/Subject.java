package university_Manager;

public class Subject{
    private Integer id;
    private String name;
    private Integer semester;

    public Subject(Integer id, String name, Integer semester) {
        this.id = id;
        this.name = name;
        this.semester = semester;
    }

    public Subject() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "id: " + id + " -> " + "name: " + name + " -> " + "semester: " + semester;
    }
}