import React, { useState } from "react";

export default function PassingArguments() {

    const [selected, setSelected] = useState("");
    const [log, setLog] = useState([]);

    const handleSelect = (course, level) => {
        const message = `${course} - ${level}`;
        setSelected(message);
        setLog([...log, message]);
    };

    const courses = [
        { id: 1, name: "React", level: "Advanced" },
        { id: 2, name: "JavaScript", level: "Intermediate" },
        { id: 3, name: "CSS", level: "Beginner" }
    ];

    return (
        <div style={{ border: "1px solid #aaa", padding: "15px", margin: "10px" }}>
            <h2>Passing Arguments in Events</h2>

            <h4>Selected: {selected || "None"}</h4>

            <div>
                {courses.map((c) => (
                    <button
                        key={c.id}
                        onClick={() => handleSelect(c.name, c.level)}
                        style={{ margin: "5px" }}
                    >
                        {c.name}
                    </button>
                ))}
            </div>

            <h4>Selection History</h4>
            <ul>
                {log.map((item, index) => (
                    <li key={index}>{item}</li>
                ))}
            </ul>
        </div>
    );
}