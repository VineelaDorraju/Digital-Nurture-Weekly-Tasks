import React from "react";
function Profile({ name, branch, skills }) {
    return (
        <div style={{ border: "1px solid #ddd", padding: "10px", margin: "10px" }}>
            <h3>{name}</h3>
            <p>Branch: {branch}</p>

            <h4>Skills</h4>
            <ul>
                {skills.map((skill, index) => (
                    <li key={index}>{skill}</li>
                ))}
            </ul>
        </div>
    );
}

export default function DestructuringProps() {

    const student = {
        name: "Vineela",
        branch: "CSE",
        skills: ["React", "JavaScript", "CSS"]
    };

    const { name, branch, skills } = student;

    return (
        <div style={{ padding: "15px" }}>
            <h2>Destructuring Props Demo</h2>

            <Profile name={name} branch={branch} skills={skills} />
        </div>
    );
}