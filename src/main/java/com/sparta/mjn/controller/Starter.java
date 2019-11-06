package com.sparta.mjn.controller;

import com.sparta.mjn.model.Student;
import com.sparta.mjn.model.StudentReader;

import java.io.File;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class Starter
{
    public static void main( String[] args )
    {
        Manager manager = new Manager();
        manager.runStudentReader("resources/StudentRecords.csv");

    }
}
