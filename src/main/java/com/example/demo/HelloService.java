package com.example.demo;

import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "",name = "Hello")

public interface HelloService {
    @WebResult(name="return",targetNamespace = "")
    @RequestWrapper(
            localName = "seyHello",
            targetNamespace = "http://services.ws.sample",
            className = "com.example.demo.HelloService")
    @WebMethod(action = "urn:seyHello")
    @ResponseWrapper(
            localName = "seyHelloResponse",
            targetNamespace = "http://services.ws.sample",
            className = "com.example.demo.sayHelloResponse")
    String sayHello(@WebParam(name = "name", targetNamespace = "") String name );

}