package com.example.demo;

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
    public EndpointImpl createEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new CreateService());
        endpoint.publish("/create");
        return endpoint;
    }
    @Bean
    public EndpointImpl readEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new ReadService());
        endpoint.publish("/read");
        return endpoint;
    }

    @Bean
    public EndpointImpl updateEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new UpdateService());
        endpoint.publish("/update");
        return endpoint;
    }

    @Bean
    public EndpointImpl deleteEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new DeleteService());
        endpoint.publish("/delete");
        return endpoint;
    }
}