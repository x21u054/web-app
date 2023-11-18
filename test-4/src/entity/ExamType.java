package entity;

public class ExamType {
	private int id;
	private String name;
	private int examCategoryId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getExamCategoryId() {
		return examCategoryId;
	}
	public void setExamCategoryId(int examCategoryId) {
		this.examCategoryId = examCategoryId;
	}
}
