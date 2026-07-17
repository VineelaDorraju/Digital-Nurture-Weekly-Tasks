import React from "react";
function Welcome({ name, course }) {
    return (
        <div style={{ border: "1px solid #ccc", margin: "10px", padding: "10px" }}>
            <h3>Hello, {name}</h3>
            <p>Course: {course}</p>
        </div>
    );
}
export default function FunctionalComponent() {

    const students = [
        { id: 1, name: "Vineela", course: "React" },
        { id: 2, name: "Sam", course: "JavaScript" }
    ];
    return (
        <div>
            <h2>Functional Component Demo</h2>
            {students.map((s) => (
                <Welcome key={s.id} name={s.name} course={s.course} />
            ))}
        </div>
    );
}