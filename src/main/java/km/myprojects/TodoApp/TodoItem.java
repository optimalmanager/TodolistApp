package km.myprojects.TodoApp;

public class TodoItem {

	private String title;
	private String body;
	private Boolean done;
	
	public TodoItem(String title, String body, Boolean done) {
		super();
		this.title = title;
		this.body = body;
		this.done = done;
	}

	public TodoItem() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}

	public Boolean getDone() {
		return done;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

}
