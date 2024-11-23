package university_Manager;
import java.time.LocalDate;

public class Event {
    private Integer id;
    private String name;
    private Professor professorId;
    private LocalDate localDate;

    public Event(Integer id, String name, Professor professorId) {
        this.id = id;
        this.name = name;
        this.professorId = professorId;
        this.localDate = LocalDate.now();
    }

    public Event(){}

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Professor getProfessorId() {
        return professorId;
    }

    @Override
    public String toString() {
        return "id: " + id + " -> " + "createdDate: " + localDate;
    }
}