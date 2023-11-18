package entity;
import java.sql.Timestamp;

public class Thread {
	private int id;
	private String title;
	private Timestamp timestamp;
	private int ownerId;
	private int threadCategoryId;
	
	public Thread() {
		super();
	}
	public Thread(String title) {
		super();
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public int getThreadCategoryId() {
		return threadCategoryId;
	}
	public void setThreadCategoryId(int threadCategoryId) {
		this.threadCategoryId = threadCategoryId;
	}
	@Override
	public String toString() {
		return "id: " + this.id + ", title: " + this.title +
				", ownerId: " + this.ownerId;
	}
}
