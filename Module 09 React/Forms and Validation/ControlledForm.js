import React, { useState } from "react";

export default function ControlledForm() {

    const [form, setForm] = useState({
        username: "",
        email: "",
        role: "user"
    });

    const [submitted, setSubmitted] = useState(null);

    const handleChange = (e) => {
        const { name, value } = e.target;

        setForm({
            ...form,
            [name]: value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        if (!form.username || !form.email) return;

        setSubmitted(form);
        setForm({
            username: "",
            email: "",
            role: "user"
        });
    };

    return (
        <div style={{ border: "1px solid #777", padding: "15px", margin: "10px" }}>
            <h2>Controlled Form</h2>

            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    name="username"
                    value={form.username}
                    onChange={handleChange}
                    placeholder="Username"
                />

                <input
                    type="email"
                    name="email"
                    value={form.email}
                    onChange={handleChange}
                    placeholder="Email"
                    style={{ marginLeft: "5px" }}
                />

                <select
                    name="role"
                    value={form.role}
                    onChange={handleChange}
                    style={{ marginLeft: "5px" }}
                >
                    <option value="user">User</option>
                    <option value="admin">Admin</option>
                </select>

                <button type="submit" style={{ marginLeft: "5px" }}>
                    Register
                </button>
            </form>

            {submitted && (
                <div style={{ marginTop: "10px" }}>
                    <h4>Submitted Data</h4>
                    <p>Name: {submitted.username}</p>
                    <p>Email: {submitted.email}</p>
                    <p>Role: {submitted.role}</p>
                </div>
            )}
        </div>
    );
}