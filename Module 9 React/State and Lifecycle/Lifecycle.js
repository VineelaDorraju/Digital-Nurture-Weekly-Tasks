import React, { useEffect, useState } from "react";
export default function LifecycleSimulation() {
    const [count, setCount] = useState(0);
    const [status, setStatus] = useState("Component Loaded");

    useEffect(() => {
        console.log("Component Mounted");

        return () => {
            console.log("Component Unmounted");
        };
    }, []);
    useEffect(() => {
        if (count > 0) {
            setStatus(`Updated Count: ${count}`);
        }
    }, [count]);
    return (
        <div style={{ border: "1px solid purple", padding: "15px", margin: "10px" }}>
            <h2>Lifecycle Simulation</h2>

            <p>Status: {status}</p>
            <p>Count: {count}</p>

            <button onClick={() => setCount(count + 1)}>
                Increase
            </button>
        </div>
    );
}