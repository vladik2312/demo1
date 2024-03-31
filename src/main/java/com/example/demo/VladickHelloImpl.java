package com.example.demo;

import javax.jws.WebService;

@WebService(
        serviceName = "VladickHelloImpl",
        portName = "HelloPort",
        targetNamespace = "http://services.ws.sample",
        endpointInterface = "com.example.demo.SayVladickHello"
)
public class VladickHelloImpl implements SayVladickHello {

    @Override
    public String sayVladickHello(String name) {

        return "Helllo Vladick "+ name;
    }
}