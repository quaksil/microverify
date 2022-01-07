package model;


public class Major {

  private String name;
  private String department;

  public Major() {
    this.name = "";
    this.department = "";
  }
  public Major(String name, String department) {
    this.name = name;
    this.department = department;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

}
