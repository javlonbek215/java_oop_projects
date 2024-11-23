package university_Manager;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // write your code here
        UniversityManager universityManager = new UniversityManager("Milliy");
        String universityName = universityManager.getUniversityName();
        System.out.println(universityName);

        // create Subject
        Subject subject = universityManager.createSubject("Math", 4);
        Subject subject1 = universityManager.createSubject("Physic", 4);
        System.out.println(subject);
        System.out.println(subject1);

        // getSubjectById
        Subject subject2 = universityManager.getSubjectById(subject.getId());
        Subject subject3 = universityManager.getSubjectById(subject1.getId());
        System.out.println(subject2);
        System.out.println(subject3);

        System.out.println(universityManager.getSubjectByName("Math"));

        // create Dean
        Dean dean1 = universityManager.createDean("Javlonbek", "Abdurazzoqov", 20, "12.08.2004", "IT", 1000d);
        Dean dean2 = universityManager.createDean("Og`abek", "Abdurazzoqov", 20, "16.10.2004", "Kibersport", 1100d);
        Dean dean3 = universityManager.createDean("Baxtiyor", "Yusupov", 19, "05.07.2005", "Math", 1200d);
        Dean dean4 = universityManager.createDean("Izzat", "Jakbarov", 20, "06.08.2004", "Tarix", 1500d);

        System.out.println(dean1);
        System.out.println(dean2);
        System.out.println(dean3);
        System.out.println(dean4);

        // Dean Employed Date By Id
        System.out.println(universityManager.getDeanEmployedDateById(dean1.getId()));

        Security security1 = universityManager.createSecurity("Ali", "Aliyev", 25, "28.03.1999", 200d, "Serjant");
        Security security2 = universityManager.createSecurity("Vali", "Valiyev", 20, "21.05.2004", 250d, "Leytenant");
        Security security3 = universityManager.createSecurity("Sanjar", "Vohobov", 30, "14.12.1996", 400d, "Kapitan");
        Security security4 = universityManager.createSecurity("Anvar", "Akbarov", 27, "27.07.1997", 250d, "Leytenant");

        System.out.println(security1);
        System.out.println(security2);
        System.out.println(security3);
        System.out.println(security4);

        // get Security List By MilitaryRank
        Security[] securityArrayTemp = universityManager.getSecurityListByMilitaryRank("Leytenant");
        for (Security s : securityArrayTemp) {
            if (s != null) {
                System.out.println(s);
            }
        }

        //// create Professor
        Professor professor = universityManager.createProfessor("Boltaxo`ja", "Umrzakov", 68, "26.07.1956", subject1.getId(), 3500d);
        Professor professor2 = universityManager.createProfessor("Jane", "Smith", 45, "05.08.1978", 2, 4000d);
        Professor professor1 = universityManager.getProfessorById(professor.getId());
        System.out.println(professor);
        System.out.println(professor2);

        // get Professor By Name And By Surname
        Professor professor3 = universityManager.getProfessorByNameAndBySurname("Boltaxo`ja", "Umrzakov");
        System.out.println(professor3);

        // get Professor List By SubjectId
        Professor[] tempProfessorArray = universityManager.getProfessorListBySubjectId(subject1.getId());
        for (Professor p : tempProfessorArray) {
            if (p != null) {
                System.out.println(p);
            }
        }

        //// create Student
        Student student1 = universityManager.createStudent("Javlonbek", "Abdurazzoqov", 20, "12.08.2004", 3);
        Student student2 = universityManager.createStudent("Baxtiyor", "Yusupov", 19, "05.07.2005", 3);
        Student student3 = universityManager.createStudent("Og`abek", "Abdurazzoqov", 20, "16.10.2004", 2);
        Student student4 = universityManager.createStudent("Izzat", "Jakbarov", 20, "06.08.2004", 1);

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(student4);

        // get Student By Id
        Student tempStudent1 = universityManager.getStudentById(student1.getId());
        System.out.println(tempStudent1);
        Student tempStudent2 = universityManager.getStudentById(student2.getId());
        System.out.println(tempStudent2);
        Student tempStudent3 = universityManager.getStudentById(student3.getId());
        System.out.println(tempStudent3);
        Student tempStudent4 = universityManager.getStudentById(student4.getId());
        System.out.println(tempStudent4);

        // add Subject To Student
        universityManager.addSubjectToStudent(student1.getId(), subject.getId());
        universityManager.addSubjectToStudent(student1.getId(), subject1.getId());
        universityManager.addSubjectToStudent(student1.getId(), subject.getId());
        universityManager.addSubjectToStudent(student2.getId(), subject.getId());
        universityManager.addSubjectToStudent(student2.getId(), subject1.getId());
        universityManager.addSubjectToStudent(student2.getId(), subject.getId());
        universityManager.addSubjectToStudent(student3.getId(), subject1.getId());
        universityManager.addSubjectToStudent(student3.getId(), subject1.getId());
        universityManager.addSubjectToStudent(student4.getId(), subject.getId());
        universityManager.addSubjectToStudent(student4.getId(), subject1.getId());

        //// get Student List By Level
        Student[] students = universityManager.getStudentListByLevel(3);
        for (Student student : students) {
            if (student != null) {
                System.out.println(student);
            }
        }

        //// get Student List By Subject ID
        Student[] tempStudentArray = universityManager.getStudentListBySubjectId(subject1.getId());
        for (Student student : tempStudentArray) {
            if (student != null) {
                System.out.println(student);
            }
        }

        //// create Exam
        Exam exam1 = universityManager.createExam(student1.getId(), subject1.getId(), 5);
        Exam exam2 = universityManager.createExam(student2.getId(), subject.getId(), 5);
        Exam exam3 = universityManager.createExam(student3.getId(), subject.getId(), 4);
        Exam exam4 = universityManager.createExam(student1.getId(), subject.getId(), 3);

        System.out.println(exam1);
        System.out.println(exam2);
        System.out.println(exam3);
        System.out.println(exam4);

        //// get Student Exam List
        Exam[] student1Exams = universityManager.getStudentExamList(student1.getId());
        System.out.println("Exams attended by student: " + student1.getName());
        for (Exam student1Exam : student1Exams) {
            if (student1Exam != null) {
                System.out.println(student1Exam);
            }
        }

        //// get Student List By Exam Subject ID
        Student[] mathStudents = universityManager.getStudentListByExamSubjectId(subject.getId());
        System.out.println("Students who attended exams for subject: " + subject.getName());
        for (Student student : mathStudents) {
            if (student != null) {
                System.out.println(student);
            }
        }

        //// get Student List By Exam Grate
        Student[] mathTopStudents = universityManager.getStudentListByExamGrate(subject1.getId(), 5);

        System.out.println("Students who scored 5 in subject: " + subject1.getName());
        for (Student student : mathTopStudents) {
            if (student != null) {
                System.out.println(student);
            }
        }

        //// Create event
        Event event1 = universityManager.createEvent("AI Conference", professor1.getId());
        Event event2 = universityManager.createEvent("Data Science Workshop", professor1.getId());
        Event event3 = universityManager.createEvent("Machine Learning Symposium", professor2.getId());

        System.out.println(event1);
        System.out.println(event2);
        System.out.println(event3);

        //// get Event List By Professor ID
        System.out.println("\nProfessor ID " + professor1.getId() + " tomonidan o'tkazilgan Eventlar:");
        Event[] professorEvents = universityManager.getEventListByProfessorId(professor1.getId());
        for (Event event : professorEvents) {
            if (event != null) {
                System.out.println(event);
            }
        }

        System.out.println("\nProfessor ID " + professor2.getId() + " tomonidan o'tkazilgan Eventlar:");
        Event[] professor2Events = universityManager.getEventListByProfessorId(professor2.getId());
        for (Event event : professor2Events) {
            if (event != null) {
                System.out.println(event);
            }
        }

        //// get All Employee List
        System.out.println("\nBarcha xodimlar ro'yxati:");
        Object[] allEmployees = universityManager.getAllEmployeeList();
        for (Object employee : allEmployees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }

        //// get All Employee List Salary
        Double totalSalary = universityManager.getAllEmployeeListSalary();
        System.out.println("\nBarcha xodimlarning umumiy oyligi: " + totalSalary);
    }
}