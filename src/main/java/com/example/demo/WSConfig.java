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
    public EndpointImpl createEndpoint(MySQLConnection mySQLConnection) {
        EndpointImpl endpoint = new EndpointImpl(bus, new CreateService(mySQLConnection));
        endpoint.publish("/create");
        return endpoint;
    }

    @Bean
    public EndpointImpl readEndpoint(MySQLConnection mySQLConnection) {
        EndpointImpl endpoint = new EndpointImpl(bus, new ReadService());
        endpoint.publish("/read");
        return endpoint;
    }

    @Bean
    public EndpointImpl updateEndpoint(MySQLConnection mySQLConnection) {
        EndpointImpl endpoint = new EndpointImpl(bus, new UpdateService(mySQLConnection));
        endpoint.publish("/update");
        return endpoint;
    }

    @Bean
    public EndpointImpl deleteEndpoint(MySQLConnection mySQLConnection) {
        EndpointImpl endpoint = new EndpointImpl(bus, new DeleteService(mySQLConnection));
        endpoint.publish("/delete");
        return endpoint;
    }

    @Bean
    public MySQLConnection mySQLConnection() {
        return new MySQLConnection();
    }
}
