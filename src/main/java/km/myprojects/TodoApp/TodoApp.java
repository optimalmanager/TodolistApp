package km.myprojects.TodoApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "todoapp" path)
 */
@Path("todoapp")
public class TodoApp {

	 /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/get")
    public List<TodoItem> getList() {

    	List<TodoItem> todoItems = new ArrayList<TodoItem>();
    	HashMap<HashMap<String, String>,Boolean> listOfTodos = new HashMap<HashMap<String, String>,Boolean>();
    	
    	TodoStore todoStore = new TodoStore();
    	listOfTodos=todoStore.getListOfTodos();
    	
    	if(listOfTodos.isEmpty())
    		todoItems.add(new TodoItem("null","null",false));
    	
    	for(Map.Entry<HashMap<String, String>, Boolean> todoItem: listOfTodos.entrySet())
    	{
    		HashMap<String, String> titleDesc = new HashMap<String,String>();
    		titleDesc = todoItem.getKey();
    		
    		for(Map.Entry<String, String> items: titleDesc.entrySet())
    			todoItems.add(new TodoItem(items.getKey(),items.getValue(),todoItem.getValue()));
    	}
    	return todoItems;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/post")
	public Response  createItem (TodoItem todoitem) {
 
    	TodoStore todoStore = new TodoStore();
    	
    	todoStore.setListOfTodos(todoitem.getTitle(), todoitem.getBody(), todoitem.getDone());
		String result = "Item saved : "+todoitem;
		return Response.status(201).entity(result).build();
	}
}
