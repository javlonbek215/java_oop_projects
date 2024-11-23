package university_Manager;
import java.time.LocalDate;

public class UniversityManager {
    private Integer generalId = 1;

    // Subject array
    private Subject[] subjects = new Subject[10];
    private int subIndex = 0;

    // Dean array
    private Dean[] deans = new Dean[10];
    private int deanIndex = 0;

    // Security array
    private Security[] securities = new Security[10];
    private int securityIndex = 0;

    // Professor array
    private Professor[] professors = new Professor[10];
    private int professorIndex = 0;

    // Student array
    private Student[] students = new Student[10];
    private int studentIndex = 0;

    // Exam array
    private Exam[] exams = new Exam[10];
    private int examIndex = 0;

    // Event array
    private Event[] events = new Event[10];
    private int eventIndex = 0;

    private String universityName;

    public UniversityManager(String universityName) {
        this.universityName = universityName;
    }

    public UniversityManager() {

    }


    public String getUniversityName() {
        return universityName;
    }

    /**
     * Subject
     */
    public Subject createSubject(String name, int semester) {
        for (Subject subject : subjects) {
            if (subject != null && subject.getName().equals(name)) {
                return null;
            }
        }
        Subject subject = new Subject(generalId++, name, semester);
        if (subIndex == subjects.length) {
            Subject[] newArr = new Subject[subjects.length * 2];
            System.arraycopy(subjects, 0, newArr, 0, subjects.length);
            subjects = newArr;
        }
        subjects[subIndex++] = subject;
        return subject;
    }

    public Subject getSubjectById(int id) {
        for (Subject subject : subjects) {
            if (subject != null && subject.getId().equals(id)) {
                return subject;
            }
        }
        return null;
    }

    public Subject getSubjectByName(String name) {
        for (Subject subject : subjects) {
            if (subject != null && subject.getName().equals(name)) {
                return subject;
            }
        }
        return null;
    }

    /**
     * Dean
     */
    public Dean createDean(String name, String surname, int age, String birthDate, String faculty, Double salary) {

        Dean exists = getDeanByFaculty(faculty);

        if (exists != null) {
            System.out.println("Bu fakultetda dekan bor");
            return null;
        }

        Dean dean = new Dean(generalId++, name, surname, age, birthDate, faculty, salary, LocalDate.now());

        if (deans.length == deanIndex) {
            Dean[] newArr = new Dean[deans.length * 2];
            System.arraycopy(deans, 0, newArr, 0, deans.length);
            deans = newArr;
        }
        deans[deanIndex++] = dean;
        return dean;
    }

    public Dean getDeanByFaculty(String faculty) {
        for (Dean d : deans) {
            if (d != null && d.getFaculty().equals(faculty)) {
                return d;
            }
        }
        return null;
    }

    public LocalDate getDeanEmployedDateById(Integer id) {
        for (Dean dean : deans) {
            if (dean != null && dean.getId().equals(id)) {
                return dean.getEmployedDate();
            }
        }
        return null;
    }

    /**
     * Security
     */
    public Security createSecurity(String name, String surname, Integer age, String birthDate, Double salary, String militaryRank) {
        Security security = new Security(generalId++, name, surname, age, birthDate, salary, militaryRank);

        if (securityIndex == securities.length) {
            Security[] newArr = new Security[securities.length * 2];
            System.arraycopy(securities, 0, newArr, 0, securities.length);
            securities = newArr;
        }
        securities[securityIndex++] = security;
        return security;
    }

    public Security[] getSecurityListByMilitaryRank(String militaryRank) {
        Security[] tempArr = new Security[securityIndex];
        int index = 0;
        for (Security security : securities) {
            if (security != null && security.getMilitaryRank().contains(militaryRank)) {
                tempArr[index++] = security;
            }
        }
        return tempArr;
    }

    /**
     * Professor
     */
    public Professor createProfessor(String name, String surname, Integer age, String birthDate, Integer subject, Double salary) {
        Subject subject1 = getSubjectById(subject);
        if (subject1 == null) {
            System.out.println("Subject not found");
            return null;
        }

        Professor professor = new Professor(generalId++, name, surname, age, birthDate, subject1, salary);

        if (professorIndex == professors.length) {
            Professor[] newArr = new Professor[professors.length * 2];
            System.arraycopy(professors, 0, newArr, 0, professors.length);
            professors = newArr;
        }
        professors[professorIndex++] = professor;
        return professor;
    }

    public Professor getProfessorById(Integer id) {
        for (Professor professor : professors) {
            if (professor != null && professor.getId().equals(id)) {
                return professor;
            }
        }
        return null;
    }

    public Professor getProfessorByNameAndBySurname(String name, String surname) {
        for (Professor professor : professors) {
            if (professor != null && professor.getName().equals(name) && professor.getSurname().equals(surname)) {
                return professor;
            }
        }
        return null;
    }

    public Professor[] getProfessorListBySubjectId(Integer subjectId) {
        Professor[] tempArr = new Professor[professorIndex];
        int tempIndex = 0;

        for (Professor professor : professors) {
            if (professor != null && professor.getSubject().getId().equals(subjectId)) {
                tempArr[tempIndex++] = professor;
            }
        }

        return tempArr;
    }

    /**
     * Student
     */
    public Student createStudent(String name, String surname, Integer age, String birthDate, Integer level) {
        Student student = new Student(generalId++, name, surname, age, birthDate, level);
        if (studentIndex == students.length) {
            Student[] newArr = new Student[students.length * 2];
            System.arraycopy(students, 0, newArr, 0, students.length);
            students = newArr;
        }
        students[studentIndex++] = student;
        return student;
    }

    public Student getStudentById(Integer id) {
        for (Student student : students) {
            if (student != null && student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public Student[] getStudentListByLevel(Integer level) {
        Student[] tempArr = new Student[studentIndex];
        int tempIndex = 0;
        for (Student student : students) {
            if (student != null && student.getLevel().equals(level)) {
                tempArr[tempIndex++] = student;
            }
        }
        return tempArr;
    }

    public Student addSubjectToStudent(Integer studentId, Integer subjectId) {
        Student student = getStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found");
            return null;
        }

        Subject subject = getSubjectById(subjectId);
        if (subject == null) {
            System.out.println("Subject not found");
        }
        student.addSubject(subject);
        return student;
    }

    public Student[] getStudentListBySubjectId(Integer subjectId) {
        Student[] tempArray = new Student[studentIndex];
        int tempIndex = 0;

        for (Student student : students) {
            if (student == null) {
                continue;
            }
            for (Subject subject : student.getSubjectList()) {
                if (subject != null && subject.getId().equals(subjectId)) {
                    if (tempIndex == tempArray.length) {
                        Student[] newArr = new Student[tempArray.length * 2];
                        System.arraycopy(tempArray, 0, newArr, 0, tempArray.length);
                        tempArray = newArr;
                    }
                    tempArray[tempIndex++] = student;
                    break;
                }
            }
        }
        Student[] resultArr = new Student[tempIndex];
        System.arraycopy(tempArray, 0, resultArr, 0, tempIndex);
        return resultArr;
    }

    /**
     * Exam
     */
    public Exam createExam(Integer studentId, Integer subjectId, Integer grade) {
        Student student = getStudentById(studentId);
        Subject subject = getSubjectById(subjectId);

        if (student == null) {
            System.out.println("Student not found with ID: " + studentId);
            return null;
        }
        if (subject == null) {
            System.out.println("Subject not found with ID: " + subjectId);
            return null;
        }
        if (grade < 1 || grade > 5) {
            System.out.println("Grade must be between 1 and 5");
            return null;
        }

        Exam exam = new Exam(generalId++, student, subject, grade);

        if (examIndex == exams.length) {
            Exam[] newArr = new Exam[exams.length * 2];
            System.arraycopy(exams, 0, newArr, 0, exams.length);
            exams = newArr;
        }

        exams[examIndex++] = exam;
        return exam;
    }

    public Exam[] getStudentExamList(Integer studentId) {
        Exam[] tempArr = new Exam[examIndex];
        int tempIndex = 0;
        for (Exam exam : exams) {
            if (exam != null && exam.getStudentId().getId().equals(studentId)) {
                tempArr[tempIndex++] = exam;
            }
        }
        return tempArr;
    }

    public Student[] getStudentListByExamSubjectId(Integer subjectId) {
        Student[] tempArr = new Student[examIndex];
        int tempIndex = 0;
        for (Exam exam : exams) {
            if (exam != null && exam.getSubjectId().getId().equals(subjectId)) {
                boolean isAdded = false;
                for (int i = 0; i < tempIndex; i++) {
                    if (tempArr[i] != null && tempArr[i].getId().equals(exam.getStudentId().getId())) {
                        isAdded = true;
                        break;
                    }
                }
                if (!isAdded) {
                    tempArr[tempIndex++] = exam.getStudentId();
                }
            }
        }

        Student[] resultArr = new Student[tempIndex];
        System.arraycopy(tempArr, 0, resultArr, 0, tempIndex);

        return resultArr;
    }

    public Student[] getStudentListByExamGrate(Integer subjectId, Integer grade) {
        Student[] tempArr = new Student[examIndex];
        int tempIndex = 0;

        for (Exam exam : exams) {
            if (exam != null &&
                    exam.getSubjectId().getId().equals(subjectId) &&
                    exam.getGrade().equals(grade)) {

                boolean isAlreadyAdded = false;
                for (int i = 0; i < tempIndex; i++) {
                    if (tempArr[i] != null && tempArr[i].getId().equals(exam.getStudentId().getId())) {
                        isAlreadyAdded = true;
                        break;
                    }
                }

                if (!isAlreadyAdded) {
                    tempArr[tempIndex++] = exam.getStudentId();
                }
            }
        }
        Student[] resultArr = new Student[tempIndex];
        System.arraycopy(tempArr, 0, resultArr, 0, tempIndex);

        return resultArr;
    }

    /**
     * Event
     */
    public Event createEvent(String name, Integer professorId) {
        Professor professor = getProfessorById(professorId);
        if (professor == null) {
            System.out.println("Professor not found");
            return null;
        }
        Event event = new Event(generalId++, name, professor);
        if (eventIndex == events.length) {
            Event[] newArr = new Event[events.length * 2];
            System.arraycopy(events, 0, newArr, 0, events.length);
            events = newArr;
        }
        events[eventIndex++] = event;
        return event;
    }

    public Event[] getEventListByProfessorId(Integer professorId) {
        int count = 0;
        for (Event event : events) {
            if (event != null && event.getProfessorId().getId().equals(professorId)) {
                count++;
            }
        }
        Event[] result = new Event[count];
        int index = 0;
        for (Event event : events) {
            if (event != null && event.getProfessorId().getId().equals(professorId)) {
                result[index++] = event;
            }
        }
        return result;
    }

    /* Last one */
    public Object[] getAllEmployeeList() {
        int size = professorIndex + deanIndex + securityIndex;
        Object[] allEmployees = new Object[size];
        int index = 0;

        for (Professor professor : professors) {
            if (professor != null) {
                allEmployees[index++] = professor;
            }
        }

        for (Dean dean : deans) {
            if (dean != null) {
                allEmployees[index++] = dean;
            }
        }

        for (Security security : securities) {
            if (security != null) {
                allEmployees[index++] = security;
            }
        }
        return allEmployees;
    }

    public Double getAllEmployeeListSalary() {
        double totalSalary = 0.0;
        for (Professor professor : professors) {
            if (professor != null) totalSalary += professor.getSalary();
        }
        for (Dean dean : deans) {
            if (dean != null) totalSalary += dean.getSalary();
        }
        for (Security security : securities) {
            if (security != null) totalSalary += security.getSalary();
        }
        return totalSalary;
    }
}

// 1072

// after inheritance => 934