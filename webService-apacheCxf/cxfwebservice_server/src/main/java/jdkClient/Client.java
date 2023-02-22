package jdkClient;

public class Client {
	public static void main(String[] args) {
		HelloServiceImplService helloService =  new HelloServiceImplService();
		HelloService helloService2 = helloService.getHelloServiceImplPort();
		System.out.println(helloService2.sayHello("zz"));
	}
}
