import React, { useState } from "react";

export default function CounterApp() {

    const [count, setCount] = useState(0);
    const [history, setHistory] = useState([]);
    const updateCount = (type) => {
        let newValue = count;
        if (type === "inc") newValue = count + 1;
        if (type === "dec") newValue = count - 1;
        if (type === "reset") newValue = 0;
        setCount(newValue);
        setHistory([...history, newValue]);
    };

    return (
        <div style={{ border: "1px solid #aaa", padding: "15px", margin: "10px" }}>
            <h2>Counter App</h2>

            <h3>{count}</h3>

            <button onClick={() => updateCount("inc")}>+</button>
            <button onClick={() => updateCount("dec")} style={{ margin: "0 5px" }}>-</button>
            <button onClick={() => updateCount("reset")}>Reset</button>

            <h4>History</h4>
            <ul>
                {history.map((h, i) => (
                    <li key={i}>{h}</li>
                ))}
            </ul>
        </div>
    );}