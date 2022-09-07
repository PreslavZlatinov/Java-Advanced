package university;

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

    public int getStudentCount(){
        return students.size();
    }

    public String registerStudent(Student student){

        String result = "";

        if(getStudentCount() < capacity){
            students.add(student);
            result = String.format("Added student %s %s",student.getFirstName(),student.getLastName());
        } else{
            result = "No seats in the university";
        }

        for (Student s : students) {
            if(student.getFirstName().equals(s.getFirstName()) && student.getLastName().equals(s.getLastName())){
                result = "Student is already in the university";
            }
        }

       return result;
    }

    public String dismissStudent(Student student){
        for (Student s : students) {
            if(student.getFirstName().equals(s.getFirstName()) && student.getLastName().equals(s.getLastName())){
                students.remove(student);
                return String.format("Removed student %s %s",student.getFirstName(),student.getLastName());
            }
        }
        return "Student not found";
    }

    public Student getStudent(String firstName, String lastName){
        for (Student student : students) {
            if(student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
                return student;
            }
        }
        return null;
    }

    public String getStatistics(){
        return students.stream()
                .map(student -> String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s", student.getFirstName(),student.getLastName(),student.getBestSubject()))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
