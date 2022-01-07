package model;


public class Department {

  private String name;
  private String faculty;

  public Department() {
    this.name = "";
    this.faculty = "";
  }
  public Department(String name, String faculty) {
    this.name = name;
    this.faculty = faculty;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getFaculty() {
    return faculty;
  }

  public void setFaculty(String faculty) {
    this.faculty = faculty;
  }

}
