package dbHelpers;

import model.Department;

import model.Faculty;
import model.Photo;
import model.Major;
import model.Students;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Base64;

import static connection.SingleConnection.getConnection;

public class SearchQuery {

	private ResultSet results;
	ArrayList<Students> students = new ArrayList<Students>();

	public static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public Photo getPhoto(int studentid) throws SQLException, IOException {

		Photo photo = null;

		String queryImage = "SELECT * FROM photos WHERE studentid = ?";

		PreparedStatement ps = getConnection().prepareStatement(queryImage);

		ps.setInt(1, studentid);
		this.results = ps.executeQuery();

		while (this.results.next()) {

			photo = new Photo();

			byte[] imgBytes = this.results.getBytes("img");

			String base64Image = Base64.getEncoder().encodeToString(imgBytes);
			photo.setBase64Image(base64Image);

			photo.setId(this.results.getInt("id"));
			photo.setName(this.results.getString("imgname"));
			photo.setStudentId(this.results.getInt("studentid"));

		}
		return photo;

	}

	public ArrayList<Students> doSearch(String queryS) throws SQLException, IOException {

		String firstname = "";
		String lastname = "";

		String query = null;
		String queryCurrentYear = null;
		boolean isAuthorized = false;

		PreparedStatement ps = null;

		if (isNumeric(queryS)) {

			int id = Integer.parseInt(queryS);
			query = "SELECT * FROM student WHERE id=" + id;

			try {

				ps = getConnection().prepareStatement(query);
				this.results = ps.executeQuery();

			} catch (SQLException e) {
				Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, e);
			}

		}

		else {

			String[] fullname = queryS.split(" ");

			if (fullname.length > 1) {

				firstname = fullname[0];
				lastname = fullname[1];

				query = "SELECT * FROM student WHERE UPPER (firstname) LIKE ? OR UPPER (lastname) LIKE ? ORDER BY id ASC";

				try {

					ps = getConnection().prepareStatement(query);
					ps.setString(1, "%" + firstname.toUpperCase() + "%");
					ps.setString(2, "%" + lastname.toUpperCase() + "%");

					this.results = ps.executeQuery();

				} catch (SQLException e) {
					Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, e);
				}
			}

			else {

				query = "SELECT * FROM student WHERE UPPER (firstname) LIKE ? OR UPPER (lastname) LIKE ? ORDER BY id ASC";

				try {

					ps = getConnection().prepareStatement(query);
					ps.setString(1, "%" + queryS.toUpperCase() + "%");
					ps.setString(2, "%" + queryS.toUpperCase() + "%");

					this.results = ps.executeQuery();

				} catch (SQLException e) {
					Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, e);
				}

			}
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
			/*
			 * queryCurrentYear =
			 * "SELECT year FROM university WHERE name = 'Constantine 2 University - Abdelhamid Mehri'"
			 * ;
			 * 
			 * this.results = ps.executeQuery(queryCurrentYear); if (this.results.next()) {
			 * 
			 * int year = this.results.getInt("year");
			 * 
			 * }
			 */

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
