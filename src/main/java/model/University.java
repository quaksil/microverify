package model;


public class University {

  private String name;
  private long year;

  public University(String name, long year) {
    this.name = name;
    this.year = year;
  }

  public University() {
    this.name = "";
    this.year = 0;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getYear() {
    return year;
  }

  public void setYear(long year) {
    this.year = year;
  }

}
