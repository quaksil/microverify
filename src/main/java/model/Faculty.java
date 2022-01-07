package model;


public class Faculty {

  private String name;
  private String university;

  public Faculty() {
    this.name = "";
    this.university = "";
  }

  public Faculty(String name, String university) {
    this.name = name;
    this.university = university;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getUniversity() {
    return university;
  }

  public void setUniversity(String university) {
    this.university = university;
  }

}
