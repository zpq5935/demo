package client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import service.HelloService;

public class Client {
	public static void main4(String[] args) {
		JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
		factoryBean.setAddress("http://localhost:8081/ws/hello");
		factoryBean.setServiceClass(HelloService.class);
		HelloService service = factoryBean.create(HelloService.class);
		System.out.println(service.sayHello("zpq"));
	}

	public static void main(String[] args) throws Exception {
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		org.apache.cxf.endpoint.Client client = dcf.createClient("http://localhost:8081/ws/hello?wsdl");
		Object[] result = client.invoke("sayHello", "zpq");
		System.out.println(result);
	}
}
