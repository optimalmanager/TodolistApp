package km.myprojects.TodoApp;

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
    @Produces(MediaType.TEXT_PLAIN)
    public TodoItem getList() {
   	
    	TodoItem todoitem = new TodoItem();
    	todoitem.setTitle("New Task");
    	todoitem.setBody("Task to do");
    	todoitem.setDone(false);
    	
    	return todoitem;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/post")
	public Response  createItem (TodoItem todoitem) {
 
		String result = "Item saved : "+todoitem;
		return Response.status(201).entity(result).build();
	}
}
