import React, { useState } from "react";

export default function KeyBestPractice() {

    const [users, setUsers] = useState([
        { id: "u1", name: "Aarav", role: "Admin" },
        { id: "u2", name: "Meera", role: "Editor" },
        { id: "u3", name: "Rohan", role: "Viewer" }
    ]);

    const [reverse, setReverse] = useState(false);

    const toggleOrder = () => {
        setReverse(!reverse);
    };

    const displayedUsers = reverse ? [...users].reverse() : users;

    return (
        <div style={{ border: "1px solid #222", padding: "15px", margin: "10px" }}>
            <h2>Key Best Practices</h2>

            <button onClick={toggleOrder}>
                Toggle Order
            </button>

            <ul style={{ marginTop: "10px" }}>
                {displayedUsers.map(user => (
                    <li key={user.id} style={{ marginBottom: "5px" }}>
                        <strong>{user.name}</strong> — {user.role}
                    </li>
                ))}
            </ul>

            <p style={{ marginTop: "10px" }}>
                Stable keys prevent UI inconsistencies during reordering.
            </p>
        </div>
    );
}