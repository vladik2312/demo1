package com.example.demo;

import com.example.demo.*;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WSConfig {

    @Autowired
    private Bus bus;

    @Bean
    public EndpointImpl helloEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new HelloServiceIMPL());
        endpoint.publish("/ServiceHello");

        return endpoint;
    }
    @Bean
    public EndpointImpl helloVladick() {
        EndpointImpl endpoint = new EndpointImpl(bus, new VladickHelloImpl());
        endpoint.publish("/ServiceVladick");

        return endpoint;
    }
}
