package com.example.demo;

public class UpdateService {
    private final MySQLConnection mySQLConnection;

    public UpdateService(MySQLConnection mySQLConnection) {
        this.mySQLConnection = mySQLConnection;
    }

    public void updateRecord(String id, String newData) {
        mySQLConnection.updateRecord(id, newData);
    }
}
