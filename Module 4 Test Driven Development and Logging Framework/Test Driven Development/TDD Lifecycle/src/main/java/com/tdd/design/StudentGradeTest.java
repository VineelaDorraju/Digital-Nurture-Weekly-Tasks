package com.tdd.design;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentGradeTest {

    @Test
    void testResult() {

        StudentGrade student = new StudentGrade();
        assertEquals("Pass", student.getResult(75));

    }

}