import React, { useRef, useState } from "react";

export default function UncontrolledForm() {

    const nameRef = useRef();
    const emailRef = useRef();
    const roleRef = useRef();

    const [data, setData] = useState(null);

    const handleSubmit = (e) => {
        e.preventDefault();

        const formData = {
            name: nameRef.current.value,
            email: emailRef.current.value,
            role: roleRef.current.value
        };

        if (!formData.name || !formData.email) return;

        setData(formData);

        nameRef.current.value = "";
        emailRef.current.value = "";
        roleRef.current.value = "user";
    };

    return (
        <div style={{ border: "1px solid #444", padding: "15px", margin: "10px" }}>
            <h2>Uncontrolled Form</h2>

            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    ref={nameRef}
                    placeholder="Name"
                />

                <input
                    type="email"
                    ref={emailRef}
                    placeholder="Email"
                    style={{ marginLeft: "5px" }}
                />

                <select ref={roleRef} style={{ marginLeft: "5px" }}>
                    <option value="user">User</option>
                    <option value="admin">Admin</option>
                </select>

                <button type="submit" style={{ marginLeft: "5px" }}>
                    Submit
                </button>
            </form>

            {data && (
                <div style={{ marginTop: "10px" }}>
                    <h4>Captured Data</h4>
                    <p>Name: {data.name}</p>
                    <p>Email: {data.email}</p>
                    <p>Role: {data.role}</p>
                </div>
            )}
        </div>
    );
}