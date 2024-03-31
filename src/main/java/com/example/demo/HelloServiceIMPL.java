package com.example.demo;

import javax.jws.WebService;

@WebService(
        serviceName = "HelloService",
        portName = "HelloPort",
        targetNamespace = "http://services.ws.sample",
        endpointInterface = "com.example.demo.HelloService"
)
public class HelloServiceIMPL implements HelloService {

    @Override
    public String sayHello(String name) {

        return "Helllo "+ name;
    }
}