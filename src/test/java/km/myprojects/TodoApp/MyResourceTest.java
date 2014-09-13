package km.myprojects.TodoApp;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import km.myprojects.TodoApp.TodoApp;

public class MyResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(TodoApp.class);
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {
        final String responseMsg = target().path("todoapp").request().get(String.class);

        assertEquals("Hello, TodoApp!", responseMsg);
    }
}
