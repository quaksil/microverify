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
import java.util.ArrayList;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import static connection.SingleConnection.getConnection;

public class ReadQuery {

	private ResultSet results;
	ArrayList<Students> students = new ArrayList<Students>();

	public ArrayList<Students> doRead() {

		String query = "SELECT * FROM student ORDER BY id ASC";
		PreparedStatement ps = null;
		try {
			ps = getConnection().prepareStatement(query);
		} catch (SQLException e) {
			Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, e);
		}
		try {
			this.results = ps.executeQuery();
		} catch (SQLException e) {
			Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, e);
		}

		try {
			while (this.results.next()) {

				Students student = new Students();
				Faculty faculty = new Faculty();
				Department department = new Department();
				Major major = new Major();

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

				students.add(student);

			}
		}

		catch (SQLException e) {
			Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, e);
		} finally {

			try {
				results.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return students;

	}
}
