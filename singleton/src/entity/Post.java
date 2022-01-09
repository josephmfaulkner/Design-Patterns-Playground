package entity;

public class Post {
	
	private int id;
	private String title;
	private String content;
	
	private  Post() {}
	
	public Post(int id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public Post(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
		
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + "]";
	}
	
	
	
}
