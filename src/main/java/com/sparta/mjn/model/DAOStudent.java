package com.sparta.mjn.model;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Map;

public class DAOStudent {

    private static Logger log = Logger.getLogger(DAOStudent.class.getName());

    private final String QUERY = "INSERT INTO students VALUES (?,?,?,?,?,?,?,?,?)";
    private final String URL = "jdbc:mysql://localhost/sakila?user=root&password=eXoSparta2019";
    int index = 0;

    public void runThreadQuery(Map<String,Student> studentsList){
        Student[] studentList = studentsList.values().toArray(new Student[studentsList.size()]);
        Runnable runnable = () -> runSQLQuery(studentList);
        Thread[] thread = new Thread[10];
        while(index < thread.length) {
            thread[index] = new Thread(runnable, "Thread " + index );
            thread[index].start();
            try {
                thread[index].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    public void runSQLQuery(Student[] studentList){
        try(Connection connection = DriverManager.getConnection(URL)){
            PreparedStatement statement = connection.prepareStatement(QUERY);
            int size = studentList.length;
            while(index < size){
                statement.setString(1,studentList[index].getStudentID());
                statement.setString(2,studentList[index].getFirstName());
                statement.setString(3,studentList[index].getMidInitial());
                statement.setString(4,studentList[index].getLastName());
                statement.setString(5,studentList[index].getGender());
                statement.setString(6,studentList[index].geteMail());
                statement.setDate(7, Date.valueOf(studentList[index].getDateOfBirth()));
                statement.setInt(8, studentList[index].getSchoolYeah());
                statement.setString(9, String.valueOf(studentList[index].getMainSubject()));

                statement.executeUpdate();
                index++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
