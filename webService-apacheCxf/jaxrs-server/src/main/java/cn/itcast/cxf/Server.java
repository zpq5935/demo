package cn.itcast.cxf;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

import cn.itcast.cxf.service.UserServiceImpl;

public class Server {
	public static void main(String[] args) {
		JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
		factoryBean.setAddress("http://127.0.0.1:8080/ws/");
		factoryBean.setServiceBean(new UserServiceImpl());
		//
		factoryBean.getInInterceptors().add(new LoggingInInterceptor());
		factoryBean.getOutInterceptors().add(new LoggingOutInterceptor());
		factoryBean.create();
		System.out.println("发布成功。。。");
	}
}
