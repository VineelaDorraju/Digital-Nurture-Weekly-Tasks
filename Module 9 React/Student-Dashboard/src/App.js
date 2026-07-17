import React, { useState } from "react";
import Home from "./pages/Home";
import About from "./pages/About";
import Navbar from "./components/Navbar";

function App() {
    const [page, setPage] = useState("home");

    return (
        <div>
            <Navbar setPage={setPage} />

            {page === "home" ? <Home /> : <About />}
        </div>);
}

export default App;