package com.sparta.mjn.model;

public enum Subjects {
    PHYSICS("Physics"),
    MATHS("Maths"),
    ENGLISH("English"),
    COMPUTERSCIENCE("Computer Science"),
    MUSIC("Music"),
    BIOLOGY("Biology"),
    CHEMISTRY("Chemistry");

    private final String SUBJECTNAME;

    Subjects(String SUBJECTNAME) {
        this.SUBJECTNAME = SUBJECTNAME;
    }

    public String getSUBJECTNAME() {
        return SUBJECTNAME;
    }

    public static Subjects selectSubject(String subjectName){
        switch (subjectName){
            case("Physics") :
                return Subjects.PHYSICS;
            case("Maths") :
                return Subjects.MATHS;
            case("English") :
                return Subjects.ENGLISH;
            case("Computer Science") :
                return Subjects.COMPUTERSCIENCE;
            case("Music") :
                return Subjects.MUSIC;
            case("Biology") :
                return Subjects.BIOLOGY;
            case("Chemistry") :
                return Subjects.CHEMISTRY;
        }
        return null;
    }
}
