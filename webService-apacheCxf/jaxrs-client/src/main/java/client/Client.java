package client;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.cxf.User;

public class Client {
	private final String url = "http://127.0.0.1:8080/ws/user";

	@Before
	public void init() {
	}

	@Test
	public void testSave() {
		User user = new User();
		user.setCity("上饶");
		user.setUsername("zpq");
		WebClient.create(url).encoding("utf-8").type(MediaType.APPLICATION_JSON).post(user);
	}

	@Test
	public void findAllUsers() {
		WebClient.create(url).encoding("utf-8").accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).get();
	}
}
