import React, { useState } from "react";

export default function IfElseComponent() {

    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const [user, setUser] = useState("Vineela");

    const toggleLogin = () => {
        setIsLoggedIn(!isLoggedIn);
    };

    const renderContent = () => {
        if (isLoggedIn) {
            return (
                <div>
                    <h3>Welcome, {user}</h3>
                    <p>You have successfully logged in.</p>
                </div>
            );
        } else {
            return (
                <div>
                    <h3>Please Login</h3>
                    <p>Access is restricted.</p>
                </div>
            );
        }
    };

    return (
        <div style={{ border: "1px solid #999", padding: "15px", margin: "10px" }}>
            <h2>If-Else Conditional Rendering</h2>

            {renderContent()}

            <button onClick={toggleLogin} style={{ marginTop: "10px" }}>
                {isLoggedIn ? "Logout" : "Login"}
            </button>
        </div>
    );
}