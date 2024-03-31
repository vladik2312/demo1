package com.example.demo;

public class DeleteService {
    private final MySQLConnection mySQLConnection;

    public DeleteService(MySQLConnection mySQLConnection) {
        this.mySQLConnection = mySQLConnection;
    }

    public void deleteRecord(String id) {
        mySQLConnection.deleteRecord(id);
    }
}
