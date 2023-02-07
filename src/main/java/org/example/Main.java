package org.example;

import java.sql.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:h2:file:~/db/h2/testdb;INIT=runscript from 'src/main/resources/sql/create.sql'\\;runscript from 'src/main/resources/sql/init.sql'";

    String username = "sa";
    String password = "1234";

        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Conected to H2 database");

        String sql = "SELECT * FROM STUDENTS";

        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql);

        int count = 0;

        while (resultset.next()) {
            count ++;

            int id = resultset.getInt("id");
            String name = resultset.getString("name");
            Date date = resultset.getDate("join_at");

            System.out.println("Student #: "+ count +" ID: "+ id + " Name: " + name + " Join date: " + date);

        }

        connection.close();
        System.out.println("Connection Closed");

    }
}