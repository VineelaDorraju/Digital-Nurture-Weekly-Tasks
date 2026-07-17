import React from "react";

function StatusMessage({ msg }) {
    return (
        <div>     {msg && <p style={{ color: "green" }}>{msg}</p>}
        </div>
    );
}
export default StatusMessage;