import React, { useEffect, useState } from "react";

export default function FetchAPI() {

    const [users, setUsers] = useState([]);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState("");

    const fetchUsers = async () => {
        setLoading(true);
        setError("");

        try {
            const response = await fetch("https://jsonplaceholder.typicode.com/users");
            if (!response.ok) {
                throw new Error("Failed to fetch data");
            }

            const data = await response.json();
            setUsers(data);
        } catch (err) {
            setError(err.message);
        } finally {
            setLoading(false);
        }
    };

    useEffect(() => {
        fetchUsers();
    }, []);

    return (
        <div style={{ border: "1px solid #999", padding: "15px", margin: "10px" }}>
            <h2>Fetch API Integration</h2>

            {loading && <p>Loading data...</p>}
            {error && <p style={{ color: "red" }}>{error}</p>}

            <ul>
                {users.map(user => (
                    <li key={user.id}>
                        <strong>{user.name}</strong> — {user.email}
                    </li>
                ))}
            </ul>

            <button onClick={fetchUsers} style={{ marginTop: "10px" }}>
                Refresh Data
            </button>
        </div>
    );
}