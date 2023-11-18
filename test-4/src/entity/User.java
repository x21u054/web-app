package entity;
import java.sql.Blob;

public class User {
	private int id;
	private String email;
	private String password;
	private String name;
	private Blob iconImg;
	private String note;
	private int roleId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Blob getIconImg() {
		return iconImg;
	}
	public void setIconImg(Blob iconImg) {
		this.iconImg = iconImg;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "id: " + this.id + ", email: " + this.email +
				", password: " + this.password;
	}
}
