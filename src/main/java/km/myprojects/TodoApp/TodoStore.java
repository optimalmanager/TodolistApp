package km.myprojects.TodoApp;

import java.util.HashMap;

public class TodoStore {

	private HashMap<HashMap<String, String>,Boolean> listOfTodos = new HashMap<HashMap<String, String>,Boolean>();

	public HashMap<HashMap<String, String>, Boolean> getListOfTodos() {
		return listOfTodos;
	}

	public void setListOfTodos(String title, String body, Boolean done) {
		HashMap<String, String> list = new HashMap<String, String>();
		list.put(title, body);
		
		listOfTodos.put(list, done);

	}
	
	
}
