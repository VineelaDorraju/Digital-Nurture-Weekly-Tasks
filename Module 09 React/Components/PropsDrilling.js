import React from "react";
function Display({ student }) {
    return (
        <div style={{ border: "1px solid blue", padding: "10px" }}>
            <h4>Final Data Received</h4>
            <p>Name: {student.name}</p>
            <p>Course: {student.course}</p>
        </div>
    );
}
function Middle({ student }) {
    return (
        <div style={{ border: "1px solid orange", padding: "10px", margin: "10px" }}>
            <h3>Middle Component</h3>
            <Display student={student} />
        </div>
    );
}
function Parent({ student }) {
    return (
        <div style={{ border: "1px solid green", padding: "10px", margin: "10px" }}>
            <h2>Parent Component</h2>
            <Middle student={student} />
        </div>
    );
}
export default function PropsDrillingDemo() {

    const studentData = {
        name: "Vineela",
        course: "React"
    };
    return (
        <div>
            <h2>Props Drilling Example</h2>
            <Parent student={studentData} />
        </div>
    );
}