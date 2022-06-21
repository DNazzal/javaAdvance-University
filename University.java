package university;

import university.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {
        String result = null;

        if (getStudentCount() >= getCapacity()) {
            result = "No seats in the university";
        }

        if (getStudent(student.getFirstName(), student.getLastName()) != null) {
            result = "Student is already in the university";
        }

        if (result == null) {
            students.add(student);
            result = "Added student " + student.getFirstName() + " " + student.getLastName();
        }
        return result;
    }

    public String dismissStudent(Student student) {
        String result = null;
        if (getStudent(student.getFirstName(), student.getLastName()) != null) {
            students.remove(student);
            result = "Removed student " + student.getFirstName() + " " + student.getLastName();
        } else {
            result = "Student not found";
        }
        return (result);
    }

    public Student getStudent(String firstName, String lastName) {

        for (Student student : students) {
            if (firstName.equals(student.getFirstName()) && lastName.equals(student.getLastName())) {
                return student;
            }
        }
        return null;
    }

    public String getStatistics() {
        return students.stream()
                .map(s -> String.format("==Student: First Name = %s," +
                        " Last Name = %s, Best Subject = %s", s.getFirstName(), s.getLastName(), s.getBestSubject()))
                .collect(Collectors.joining(System.lineSeparator()));

    }
}