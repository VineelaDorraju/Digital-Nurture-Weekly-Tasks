import React, { useEffect, useState } from "react";

export default function AsyncHandling() {

    const [data, setData] = useState([]);
    const [status, setStatus] = useState("idle");

    const fetchWithDelay = () => {
        setStatus("loading");

        return new Promise((resolve) => {
            setTimeout(async () => {
                try {
                    const res = await fetch("https://jsonplaceholder.typicode.com/todos");
                    const json = await res.json();
                    resolve(json.slice(0, 6));
                } catch {
                    resolve([]);
                }
            }, 1000);
        });
    };

    const loadData = async () => {
        const result = await fetchWithDelay();

        if (result.length === 0) {
            setStatus("error");
        } else {
            setData(result);
            setStatus("success");
        }
    };

    useEffect(() => {
        loadData();
    }, []);

    const renderContent = () => {
        if (status === "loading") return <p>Loading with delay...</p>;
        if (status === "error") return <p style={{ color: "red" }}>Failed to load data</p>;

        return (
            <ul>
                {data.map(item => (
                    <li key={item.id}>
                        {item.title} {item.completed ? "✔️" : "❌"}
                    </li>
                ))}
            </ul>
        );
    };

    return (
        <div style={{ border: "1px solid #555", padding: "15px", margin: "10px" }}>
            <h2>Advanced Async Handling</h2>

            {renderContent()}

            <button onClick={loadData} style={{ marginTop: "10px" }}>
                Retry
            </button>
        </div>
    );
}