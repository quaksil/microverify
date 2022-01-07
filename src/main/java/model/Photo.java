package model;

public class Photo {

	int id;
	int studentId;
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	private String name;
	private String base64Image;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBase64Image() {

		return base64Image;

	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
