import React, { useState } from "react";
export default function LogicalAND() {

    const [notifications, setNotifications] = useState([
        "New message received",
        "Profile updated",
        "New friend request"
    ]);

    const [showPanel, setShowPanel] = useState(true);

    const clearNotifications = () => {
        setNotifications([]);
    };

    const togglePanel = () => {
        setShowPanel(!showPanel);
    };

    return (
        <div style={{ border: "1px solid #333", padding: "15px", margin: "10px" }}>
            <h2>Logical AND Rendering</h2>

            <button onClick={togglePanel}>
                {showPanel ? "Hide Panel" : "Show Panel"}
            </button>

            {showPanel && (
                <div style={{ marginTop: "10px" }}>
                    <h4>Notifications Panel</h4>

                    {notifications.length > 0 && (
                        <ul>
                            {notifications.map((note, index) => (
                                <li key={index}>{note}</li>
                            ))}
                        </ul>
                    )}

                    {notifications.length === 0 && (
                        <p>No new notifications</p>
                    )}

                    {notifications.length > 0 && (
                        <button onClick={clearNotifications}>
                            Clear All
                        </button>
                    )}
                </div>
            )}
        </div>
    );
}