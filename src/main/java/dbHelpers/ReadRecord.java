package dbHelpers;

import model.Department;
import model.Faculty;
import model.Major;
import model.Students;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadRecord {

    private Connection conn;
    private ResultSet results;

    private Students student = new Students();
    private Faculty faculty = new Faculty();
    private Department department = new Department();
    private Major major = new Major();

    private int id;


    public ReadRecord(int id) {

        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("dbConn.properties")).getPath();
        InputStream input = null;

        try {
            input = new FileInputStream(rootPath);
        } catch (FileNotFoundException e) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, e);
        }
        Properties props = new Properties();

        try {
            props.load(input);
        } catch (IOException e) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            input.close();
        } catch (IOException e) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, e);
        }

        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");

        this.id = id;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException e) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, e);

        }

    }

    public void doRead() {


        String query = "SELECT * FROM student WHERE id= ?";

        try {
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, id);

            this.results = ps.executeQuery();

            this.results.next();

            student.setId(this.results.getInt("id"));
            student.setFirstname(this.results.getString("firstname"));
            student.setLastname(this.results.getString("lastname"));
            student.setGender(Students.gender.valueOf(this.results.getString("gender")));
            student.setBday(this.results.getDate("bday"));
            student.setFirstfather(this.results.getString("firstfather"));
            student.setFirstmaiden(this.results.getString("firstmaiden"));
            student.setLastmaiden(this.results.getString("lastmaiden"));

            faculty.setName(this.results.getString("faculty"));
            faculty.setUniversity("Constantine 2 University");
            student.setFaculty(faculty);

            department.setName(this.results.getString("department"));
            department.setFaculty(faculty.getName());
            student.setDepartment(department);

            student.setCourse(this.results.getString("course"));
            student.setLevel(this.results.getString("level"));

            major.setName(this.results.getString("major"));
            major.setDepartment(department.getName());
            student.setMajor(major);

            student.setLastyear(this.results.getInt("lastyear"));
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);

        }


    }

    public Students getStudent(){
        return this.student;
    }
}
