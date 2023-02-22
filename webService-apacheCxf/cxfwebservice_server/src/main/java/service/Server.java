package service;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class Server {
	public static void main(String[] args) {
		// 发布服务的工厂
		JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
		// 发布地址
		factoryBean.setAddress("http://localhost:8081/ws/hello");
		// 设置服务类
		factoryBean.setServiceBean(new HelloServiceImpl());
		// 设置输入、输出的拦截器，观察soap请求、响应
		factoryBean.getInInterceptors().add(new LoggingInInterceptor());
		factoryBean.getOutInterceptors().add(new LoggingOutInterceptor());
		// 发布服务
		factoryBean.create();
		System.out.println("服务发布成功。。。");
	}
}
