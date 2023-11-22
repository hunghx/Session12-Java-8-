package ra.model;

import ra.inf.IOFile;

public class Student implements IOFile {
    @Override
    public void inputData() {

    }


    @Override
    public void displayData() {

    }

    @Override
    public int sum(int a, int b) {
        return a*a+b*b;
    }

    private int studentId;
    private  String studentName;
    private int age;

    public Student() {
    }

    public Student(int studentId, String studentName, int age) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", age=" + age +
                '}';
    }
}
