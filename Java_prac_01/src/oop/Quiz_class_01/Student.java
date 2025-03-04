package oop.Quiz_class_01;

public class Student {
    private String name;
    private String studentID;
    private String department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name==null || name.isEmpty()){
            return;
        }
        this.name = name;
    }

    public String getStudentId() {
        return studentID;
    }

    public void setStudentId(String studentID) {
        if(studentID==null || studentID.isEmpty()){
            return;
        }
        this.studentID = studentID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if(department==null || department.isEmpty()){
            return;
        }
        this.department = department;
    }
}
