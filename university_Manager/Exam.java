package university_Manager;

import java.time.LocalDateTime;

public class Exam {
    private Integer id;
    private Student studentId;
    private Subject subjectId;
    private Integer grade;
    private final LocalDateTime createdDate;


    public Exam(Integer id, Student studentId, Subject subjectId, Integer grade) {
        this.id = id;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.grade = grade;
        this.createdDate = LocalDateTime.now();
    }



    public Integer getId() {
        return id;
    }

    public Student getStudentId() {
        return studentId;
    }

    public Subject getSubjectId() {
        return subjectId;
    }

    public Integer getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "id: " + id + " -> " + "studentId: " + studentId + " -> " + "subjectId: " + subjectId + " -> " + "grade: " + grade + " -> " + "createdDate: " + createdDate;
    }
}