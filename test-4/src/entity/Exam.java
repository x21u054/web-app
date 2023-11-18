package entity;

public class Exam {
	private int id;
	private int score;
	private String result;
	private String note;
	private int ownerId;
	private int examTypeId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public int getExamTypeId() {
		return examTypeId;
	}
	public void setExamTypeId(int examTypeId) {
		this.examTypeId = examTypeId;
	}
}
