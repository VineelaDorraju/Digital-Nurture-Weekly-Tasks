import React, { useState } from "react";

function AddStudentForm({ addStudent }) {
    const [name, setName] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();
        if (name === "") return;
        addStudent(name);
        setName("");
    };
    return (
        <form onSubmit={handleSubmit}>
            <input
                value={name}
                onChange={(e) => setName(e.target.value)}
                placeholder="Enter name"
            />
            <button>Add</button>
        </form>
    );
}

export default AddStudentForm;