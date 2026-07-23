import React from "react";

export default function SimpleList() {

    const skills = ["HTML", "CSS", "JavaScript", "React"];

    return (
        <div style={{ border: "1px solid #888", padding: "15px", margin: "10px" }}>
            <h2>Simple List Rendering</h2>

            <ul>
                {skills.map((skill, index) => (
                    <li key={index}>{skill}</li>
                ))}
            </ul>

            <p>Total Skills: {skills.length}</p>
        </div>
    );
}