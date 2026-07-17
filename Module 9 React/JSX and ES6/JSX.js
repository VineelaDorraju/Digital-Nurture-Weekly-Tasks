import React from "react";

export default function JSXPatterns() {

    const user = {
        name: "Vineela",
        marks: 85
    };

    const subjects = ["Math", "Science", "Computer"];

    const getGrade = (marks) => {
        if (marks > 90) return "A+";
        if (marks > 75) return "A";
        return "B";
    };

    return (
        <div style={{ padding: "15px" }}>
            <h2>JSX Patterns Demo</h2>

            {/* expression inside JSX */}
            <p>Name: {user.name}</p>
            <p>Marks: {user.marks}</p>

            {/* function call inside JSX */}
            <p>Grade: {getGrade(user.marks)}</p>

            {/* inline styling */}
            <p style={{ color: user.marks > 80 ? "green" : "red" }}>
                Performance Status
            </p>

            {/* list rendering */}
            <h4>Subjects</h4>
            <ul>
                {subjects.map((sub, index) => (
                    <li key={index}>{sub}</li>
                ))}
            </ul>

            {/* conditional JSX */}
            {user.marks > 80 && <p>Eligible for Scholarship</p>}
        </div>
    );
}