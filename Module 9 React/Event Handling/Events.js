import React, { useState } from "react";

export default function BasicEvents() {

    const [message, setMessage] = useState("No action yet");
    const [clickCount, setClickCount] = useState(0);

    const handleClick = () => {
        setMessage("Button Clicked");
        setClickCount(clickCount + 1);
    };

    const handleMouseEnter = () => {
        setMessage("Mouse Entered Area");
    };

    const handleMouseLeave = () => {
        setMessage("Mouse Left Area");
    };

    return (
        <div
            style={{ border: "1px solid #ccc", padding: "15px", margin: "10px" }}
            onMouseEnter={handleMouseEnter}
            onMouseLeave={handleMouseLeave}
        >
            <h2>Basic Events Demo</h2>

            <p>Status: {message}</p>
            <p>Total Clicks: {clickCount}</p>

            <button onClick={handleClick}>
                Click Me
            </button>
        </div>
    );
}