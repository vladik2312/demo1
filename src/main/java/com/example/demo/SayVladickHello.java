package com.example.demo;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(targetNamespace = "",name = "VladickHello")
public interface SayVladickHello {
	@WebResult(name="return",targetNamespace = "")
	@RequestWrapper(
			localName = "vladickSayHello",
			targetNamespace = "http://services.ws.sample",
			className = "com.example.demo.HelloService")
	@WebMethod(action = "urn:seyVladickHello")
	@ResponseWrapper(
			localName = "seyHelloResponse",
			targetNamespace = "http://services.ws.sample",
			className = "com.example.demo.sayHelloResponse")
	String sayVladickHello(@WebParam(name = "name", targetNamespace = "") String name );

}