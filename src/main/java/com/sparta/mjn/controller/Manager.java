package com.sparta.mjn.controller;

import com.sparta.mjn.model.DAOStudent;
import com.sparta.mjn.model.Student;
import com.sparta.mjn.model.StudentReader;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Map;

public class Manager {

    private static final String LOG_PROPERTIES_FILE = "resources/log4j.properties";
    private static Logger log = Logger.getLogger(Manager.class.getName());

    public void runStudentReader(String file){
        initialiseLogging();
        StudentReader studentReader = new StudentReader();
        Map<String, Student> students = studentReader.readStudent(file);
        DAOStudent daoStudent = new DAOStudent();
        daoStudent.runThreadQuery(students);

    }
    private void initialiseLogging() {
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);
        log.trace("Logging initialised");
    }
}
