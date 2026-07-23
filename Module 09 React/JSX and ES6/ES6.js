import React from "react";

export default function ES6Features() {

    const course = "React";
    let level = "Intermediate";
    const greet = (name) => `Hello ${name}`;

    const baseMarks = [70, 80];
    const extraMarks = [85, 90];
    const allMarks = [...baseMarks, ...extraMarks];
    const student = { name: "Vineela", age: 20 };
    const updatedStudent = { ...student, course };

    const formattedMarks = allMarks.map((m, i) => `Test ${i + 1}: ${m}`);

    class Report {
        constructor(name) {
            this.name = name;
        }

        getSummary() {
            return `${this.name} enrolled in ${course}`;
        }
    }

    const report = new Report(student.name);

    return (
        <div style={{ padding: "15px" }}>
            <h2>ES6 Features Demo</h2>

            <p>{greet(student.name)}</p>
            <p>Level: {level}</p>

            <h4>Marks</h4>
            <ul>
                {formattedMarks.map((item, index) => (
                    <li key={index}>{item}</li>
                ))}
            </ul>

            <h4>Updated Student</h4>
            <p>{updatedStudent.name} - {updatedStudent.course}</p>

            <h4>Report</h4>
            <p>{report.getSummary()}</p>
        </div>
    );
}