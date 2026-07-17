import React from "react";

function Navbar({ setPage }) {
    return (
        <div>
            <button onClick={() => setPage("home")}>Home</button>
            <button onClick={() => setPage("about")}>About</button>
        </div>
    );
}

export default Navbar;