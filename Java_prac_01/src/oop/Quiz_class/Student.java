package oop.Quiz_class;

public class Student {
    private String name;
    private String studentID;
    private String department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.equals(null) || name.isEmpty()){
            return;
        }
        this.name = name;
    }

    public String getStudentId() {
        return studentID;
    }

    public void setStudentId(String studentID) {
        if(studentID.equals(null) || studentID.isEmpty()){
            return;
        }
        this.studentID = studentID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if(department.equals(null) || department.isEmpty()){
            return;
        }
        this.department = department;
    }
}
