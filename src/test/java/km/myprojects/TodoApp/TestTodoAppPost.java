package km.myprojects.TodoApp;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TestTodoAppPost {

	public static void main(String[] args) {

		try {
	 
			Client client = Client.create();
	 
			WebResource webResource = client
			   .resource("http://powerful-sands-7127.herokuapp.com/todoapp/post");
	 
			String input = "{\"body\":\"Task to do 2\",\"title\":\"New Task 2\",\"done\":\"false\"}";
	 
			ClientResponse response = webResource.type("application/json")
			   .post(ClientResponse.class, input);
	 
			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
				     + response.getStatus());
			}
	 
			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);
					
			WebResource webResource2 = client
					   .resource("http://powerful-sands-7127.herokuapp.com/todoapp/get");
			 
			
			ClientResponse response2 = webResource2.type("application/json")
					   .get(ClientResponse.class);
			
			System.out.println(response2.getEntity(String.class));
	 
		  } catch (Exception e) {
	 
			e.printStackTrace();
	 
		  }
	 
		}
}
