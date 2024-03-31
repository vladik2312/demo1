package com.example.demo;

import com.example.demo.MySQLConnection;

public class CreateService {
    private final MySQLConnection mySQLConnection;

    public CreateService(MySQLConnection mySQLConnection) {
        this.mySQLConnection = mySQLConnection;
    }

    public void createRecord(String data) {
        mySQLConnection.createRecord(data);
    }
}
