package com.sparta.mjn.model;

import org.apache.log4j.Logger;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class StudentReader {

    Map<String, Student>
            studentsList;
    private static Logger log = Logger.getLogger(StudentReader.class.getName());


    public Map<String, Student> readStudent(final String file) {
        studentsList = new HashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            bufferedReader.readLine();
            Stream<String> studentStream = bufferedReader.lines();
            studentStream
                    .forEach(fields -> createStudentStream(fields));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentsList;
    }

    private static Student createStudent(String file) {
        String studentID = null;
        String firstName = null;
        String midInitial = null;
        String lastName = null;
        String gender = null;
        String eMail = null;
        LocalDate dob;
        int schoolYear =0;
        Subjects mainSubject = null;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        String[] array = file.split(",");

        if (array[0].matches("^[1-9][0-9]+$")) {
            studentID = array[0];
        } else {
            log.error("Invalid Entry " + array[0] + " for Student ID");
        }

        if (array[1].matches("^[A-Z][a-z]+$")) {
            firstName = array[1];
        } else {
            log.error("Invalid Entry " + array[1] + " for Student first name");
        }

        if (array[2].matches("^[A-Z]$")) {
            midInitial = array[2];
        } else {
            log.error("Invalid Entry " + array[2] + " for Student initial");
        }

        if (array[3].matches("^[A-Z][a-z]+$")) {
            lastName = array[3];
        } else {
            log.error("Invalid Entry " + array[3] + " for Student last name");
        }

        if (array[4].matches("^[FM]$")) {
            gender = array[4];
        } else {
            log.error("Invalid Entry " + array[4] + " for Student gender");
        }

        if (array[5].matches("^[a-z+.]+@(.+)$")) {
            eMail = array[5];
        } else {
            log.error("Invalid Entry " + array[5] + " for Student e-mail");
        }

        dob = LocalDate.parse(array[6], formatter);
        if(array[7].matches("^[1-9]+$")){
            schoolYear = Integer.parseInt(array[7]);
        } else {
            log.error("Invalid Entry " + array[7] + " for Student school year");
        }

        mainSubject = Subjects.selectSubject(array[8]);
        if (mainSubject == null) {
            log.error("Invalid Entry " + array[8] + " for Student main subject");
        }

        Student student = new Student(studentID, firstName, midInitial, lastName, gender, eMail, dob, schoolYear, mainSubject);

        return student;
    }

    private Student createStudentStream(String fields) {
        Student student = createStudent(fields);
        String key = student.getStudentID();

        if (studentsList.containsKey(key)) {
            log.warn("This Student " + key + " has been used");
        } else {
            studentsList.put(key, student);
        }

        return student;
    }
}
