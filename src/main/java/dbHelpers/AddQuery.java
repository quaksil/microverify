package dbHelpers;

import model.Students;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import static connection.SingleConnection.getConnection;

public class AddQuery {

    public void doAdd(Students student) {

        String query = "INSERT INTO student (firstname, lastname, gender, bday, firstfather, firstmaiden, lastmaiden, faculty, department, course, level, major, lastyear) VALUES (?,?,CAST(? AS gender),?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = getConnection().prepareStatement(query);


            ps.setString(1, student.getFirstname());
            ps.setString(2, student.getLastname());
            ps.setString(3, student.getGender().toString());
            ps.setDate(4, (Date) student.getBday());
            ps.setString(5, student.getFirstfather());
            ps.setString(6, student.getFirstmaiden());
            ps.setString(7, student.getLastmaiden());
            ps.setString(8, student.getFaculty().getName());
            ps.setString(9, student.getDepartment().getName());
            ps.setString(10, student.getCourse());
            ps.setString(11, student.getLevel());
            ps.setString(12, student.getMajor().getName());
            ps.setInt(13, student.getLastyear());

            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, e);
        }

    }

}
