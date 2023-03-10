package cxfClient;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.4
 * 2020-02-19T12:38:08.754+08:00
 * Generated source version: 3.1.4
 * 
 */
@WebService(targetNamespace = "http://service/", name = "HelloService")
@XmlSeeAlso({ObjectFactory.class})
public interface HelloService {

    @WebMethod
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://service/", className = "cxfClient.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://service/", className = "cxfClient.SayHelloResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String sayHello(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );
}
