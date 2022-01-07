package dbHelpers;

import static connection.SingleConnection.getConnection;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import model.Photo;

public class GetPhoto {

	private ResultSet results;

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
}
