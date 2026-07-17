import React, { useState } from "react";

export default function FormEvents() {

    const [form, setForm] = useState({
        name: "",
        email: ""
    });

    const [submittedData, setSubmittedData] = useState(null);

    const handleChange = (e) => {
        const { name, value } = e.target;

        setForm({
            ...form,
            [name]: value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        if (form.name === "" || form.email === "") return;

        setSubmittedData(form);
        setForm({ name: "", email: "" });
    };

    return (
        <div style={{ border: "1px solid #444", padding: "15px", margin: "10px" }}>
            <h2>Form Events</h2>

            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    name="name"
                    value={form.name}
                    onChange={handleChange}
                    placeholder="Enter name"
                />

                <input
                    type="email"
                    name="email"
                    value={form.email}
                    onChange={handleChange}
                    placeholder="Enter email"
                    style={{ marginLeft: "5px" }}
                />

                <button type="submit" style={{ marginLeft: "5px" }}>
                    Submit
                </button>
            </form>

            {submittedData && (
                <div style={{ marginTop: "10px" }}>
                    <h4>Submitted Data</h4>
                    <p>Name: {submittedData.name}</p>
                    <p>Email: {submittedData.email}</p>
                </div>
            )}
        </div>
    );
}