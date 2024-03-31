package com.example.demo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class ReadService {

    @WebMethod
    public String getRecordById(@WebParam(name = "id") String id, @WebParam(name = "column") String column) {
        // Логіка отримання запису за ідентифікатором "id"
        return "Record with ID: " + id;
    }
}
