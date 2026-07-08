package com.tdd.design;

public class StudentGrade {

    public String getResult(int marks) {

        if (marks >= 35) {
            return "Pass";
        }

        return "Fail";
    }

}