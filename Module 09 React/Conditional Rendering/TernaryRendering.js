import React, { useState } from "react";

export default function TernaryRendering() {

    const [theme, setTheme] = useState("light");
    const [score, setScore] = useState(0);

    const toggleTheme = () => {
        setTheme(theme === "light" ? "dark" : "light");
    };

    const increaseScore = () => {
        setScore(score + 10);
    };

    const containerStyle = {
        padding: "15px",
        margin: "10px",
        border: "1px solid #666",
        backgroundColor: theme === "light" ? "#f9f9f9" : "#222",
        color: theme === "light" ? "#000" : "#fff"
    };

    return (
        <div style={containerStyle}>
            <h2>Ternary Conditional Rendering</h2>

            <h3>
                {score >= 50 ? "🎉 Level: Pro User" : "⚡ Level: Beginner"}
            </h3>

            <p>
                {theme === "light" ? "Light Mode Enabled" : "Dark Mode Enabled"}
            </p>

            <button onClick={increaseScore}>
                Increase Score
            </button>

            <button onClick={toggleTheme} style={{ marginLeft: "10px" }}>
                Switch Theme
            </button>
        </div>
    );
}