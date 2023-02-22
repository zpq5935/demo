package client;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cn.itcast.cxf.User;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;

import java.util.List;

public class Client4SpringServer {
//	private String baseURI = "http://127.0.0.1:8080/jaxrs-spring-server/webservice/userService/user";//Tomcat
	private String baseURI = "http://127.0.0.1:8012/jaxrs-spring-producer/webservice/userService/user";//Jetty


	@Test
	public void testFindAll() {
		WebClient.create(baseURI).encoding("utf-8").get();
		String response = WebClient.create(baseURI).encoding("utf-8").accept(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println(response);
	}
}
