package model;

import java.util.Date;

public class Students {

    private static gender gender;
    private int id;
    private String firstname;
    private String lastname;
    private Date bday;
    private String firstfather;
    private String firstmaiden;
    private String lastmaiden;
    private University university;
    private Faculty faculty;
    private Department department;
    private String course;
    private String level;
    private Major major;
    private int lastyear;
    
    public Students() {
        this.id = 0;
        this.firstname = "";
        this.lastname = "";
        // this.gender = gender.valueOf("");
        this.bday = new Date(0);
        this.firstfather = "";
        this.firstmaiden = "";
        this.lastmaiden = "";
        this.faculty = null;
        this.department = null;
        this.course = "";
        this.level = "";
        this.major = null;
        this.lastyear = 0;
    }

    public Students(int id, String firstname, String lastname, gender gender, Date bday, String firstfather, String firstmaiden, String lastmaiden, Faculty faculty, Department department, String course, String level, Major major, int lastyear) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.bday = bday;
        this.firstfather = firstfather;
        this.firstmaiden = firstmaiden;
        this.lastmaiden = lastmaiden;
        this.faculty = faculty;
        this.department = department;
        this.course = course;
        this.level = level;
        this.major = major;
        this.lastyear = lastyear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public gender getGender() {
        return gender;
    }

    public void setGender(gender gender) {
        this.gender = gender;
    }

    public Date getBday() {
        return bday;
    }

    public void setBday(Date bday) {
        this.bday = bday;
    }

    public String getFirstfather() {
        return firstfather;
    }

    public void setFirstfather(String firstfather) {
        this.firstfather = firstfather;
    }

    public String getFirstmaiden() {
        return firstmaiden;
    }

    public void setFirstmaiden(String firstmaiden) {
        this.firstmaiden = firstmaiden;
    }

    public String getLastmaiden() {
        return lastmaiden;
    }

    public void setLastmaiden(String lastmaiden) {
        this.lastmaiden = lastmaiden;
    }
    
    public Faculty getFaculty(){return faculty;}
    
    public void setFaculty(Faculty faculty){this.faculty=faculty;}
    
    public Department getDepartment(){return department;}
    
    public void setDepartment(Department department){this.department=department;}
    
    public String getCourse() {
        return course;
    }
    
    public void setCourse(String course) {
        this.course = course;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Major getMajor(){return major;}

    public void setMajor(Major major){this.major = major;}
    
    public int getLastyear() {
        return lastyear;
    }

    public void setLastyear(int lastyear) {
        this.lastyear = lastyear;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender='" + gender + '\'' +
                ", bday=" + bday +
                ", firstfather='" + firstfather + '\'' +
                ", firstmaiden='" + firstmaiden + '\'' +
                ", lastmaiden='" + lastmaiden + '\'' +
                ", faculty='" + faculty + '\'' +
                ", department='" + department + '\'' +
                ", course='" + course + '\'' +
                ", level='" + level + '\'' +
                ", major='" + major + '\'' +
                ", lastyear=" + lastyear +
                '}';
    }

    public enum gender {
        Male,
        Female;
    }

}
