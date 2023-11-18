package entity;

public class Recruit {
	private int id;
	private String companyName;
	private String selectionDetails;
	private String result;
	private String note;
	private int ownerId;
	private int recruitCategoryId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getSelectionDetails() {
		return selectionDetails;
	}
	public void setSelectionDetails(String selectionDetails) {
		this.selectionDetails = selectionDetails;
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
	public int getRecruitCategoryId() {
		return recruitCategoryId;
	}
	public void setRecruitCategoryId(int recruitCategoryId) {
		this.recruitCategoryId = recruitCategoryId;
	}
}
