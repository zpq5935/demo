package webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class WsByJDK {
	public static void main(String[] args) {
		System.out.println("webService is publishing...");
		String address = "http://localhost:9000/HelloWorld";
		Object wSObject = new WsByJDK();
		Endpoint.publish(address, wSObject);
	}

	@WebMethod
	public String sayHello(String name) {
		return "hello " + name;
	}
}
