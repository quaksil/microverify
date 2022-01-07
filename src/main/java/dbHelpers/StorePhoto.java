package dbHelpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static connection.SingleConnection.getConnection;

public class StorePhoto {

	public static void main(String[] args) throws SQLException, IOException {

		File file = new File("/home/aksil/Desktop/lezzar.jpg");
		FileInputStream fis = new FileInputStream(file);
		PreparedStatement ps = getConnection().prepareStatement(
				"INSERT INTO photos (imgname, img, studentid) VALUES (?, ?, ?)");

		ps.setString(1, file.getName());
		ps.setBinaryStream(2, fis, file.length());
		ps.setInt(3, 44);
		ps.executeUpdate();

		System.out.println("Done");
		ps.close();
		fis.close();

	}
}