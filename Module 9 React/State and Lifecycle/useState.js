import React, { useState } from "react";

export default function UseStateExample() {

    const [name, setName] = useState("Vineela");
    const [age, setAge] = useState(20);
    const [isEditing, setIsEditing] = useState(false);
    const updateAge = () => {
        setAge(age + 1);
    };

    const toggleEdit = () => {
        setIsEditing(!isEditing);
    };
    return (
        <div style={{ border: "1px solid #ccc", padding: "15px", margin: "10px" }}>
            <h2>useState Example</h2>
            <p>Name: {name}</p>
            <p>Age: {age}</p>

            <button onClick={updateAge}>Increase Age</button>
            <button onClick={toggleEdit} style={{ marginLeft: "10px" }}>
                {isEditing ? "Stop Editing" : "Edit Mode"}
            </button>
            {}
            {isEditing && (
                <input
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                    placeholder="Update name"
                />
            )}
        </div>
    );
}