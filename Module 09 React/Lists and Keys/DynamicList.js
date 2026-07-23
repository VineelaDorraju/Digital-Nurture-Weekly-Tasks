import React, { useState } from "react";

export default function DynamicList() {

    const [tasks, setTasks] = useState([
        { id: 1, text: "Learn React", done: false },
        { id: 2, text: "Build Project", done: false }
    ]);

    const [input, setInput] = useState("");

    const handleAdd = () => {
        if (input.trim() === "") return;

        const newTask = {
            id: Date.now(),
            text: input,
            done: false
        };

        setTasks([...tasks, newTask]);
        setInput("");
    };

    const toggleTask = (id) => {
        const updated = tasks.map(task =>
            task.id === id ? { ...task, done: !task.done } : task
        );
        setTasks(updated);
    };

    const removeTask = (id) => {
        const filtered = tasks.filter(task => task.id !== id);
        setTasks(filtered);
    };

    return (
        <div style={{ border: "1px solid #555", padding: "15px", margin: "10px" }}>
            <h2>Dynamic List (Task Manager)</h2>

            <div>
                <input
                    value={input}
                    onChange={(e) => setInput(e.target.value)}
                    placeholder="Enter task"
                />
                <button onClick={handleAdd} style={{ marginLeft: "5px" }}>
                    Add
                </button>
            </div>

            <ul style={{ marginTop: "10px" }}>
                {tasks.map(task => (
                    <li key={task.id} style={{ marginBottom: "5px" }}>
                        <span
                            onClick={() => toggleTask(task.id)}
                            style={{
                                textDecoration: task.done ? "line-through" : "none",
                                cursor: "pointer",
                                marginRight: "10px"
                            }}
                        >
                            {task.text}
                        </span>

                        <button onClick={() => removeTask(task.id)}>
                            Delete
                        </button>
                    </li>
                ))}
            </ul>

            <p>Total Tasks: {tasks.length}</p>
        </div>
    );
}