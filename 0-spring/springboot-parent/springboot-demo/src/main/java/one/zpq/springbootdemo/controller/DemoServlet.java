package one.zpq.springbootdemo.controller;

import org.apache.catalina.ContainerServlet;
import org.apache.catalina.Wrapper;

public class DemoServlet implements ContainerServlet {
    Wrapper wrapper;

    @Override
    public Wrapper getWrapper() {
        return wrapper;
    }

    @Override
    public void setWrapper(Wrapper wrapper) {
        this.wrapper = wrapper;
    }
}
