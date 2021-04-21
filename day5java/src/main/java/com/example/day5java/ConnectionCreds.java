package com.example.day5java;

import lombok.Data;

@Data
public class ConnectionCreds {

    private String url = "jdbc:mysql://127.0.0.1:3306/jdbc";
    private String user = "root";
    private String password = "root";

}
