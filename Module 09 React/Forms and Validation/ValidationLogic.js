import React, { useState } from "react";

export default function ValidationLogic() {

    const [form, setForm] = useState({
        username: "",
        email: "",
        password: ""
    });

    const [errors, setErrors] = useState({});
    const [success, setSuccess] = useState(false);

    const validate = () => {
        let newErrors = {};

        if (form.username.trim().length < 3) {
            newErrors.username = "Username must be at least 3 characters";
        }

        if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(form.email)) {
            newErrors.email = "Invalid email format";
        }

        if (form.password.length < 6) {
            newErrors.password = "Password must be at least 6 characters";
        }

        return newErrors;
    };

    const handleChange = (e) => {
        const { name, value } = e.target;

        setForm({
            ...form,
            [name]: value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        const validationErrors = validate();

        if (Object.keys(validationErrors).length > 0) {
            setErrors(validationErrors);
            setSuccess(false);
        } else {
            setErrors({});
            setSuccess(true);
            setForm({
                username: "",
                email: "",
                password: ""
            });
        }
    };

    return (
        <div style={{ border: "1px solid #111", padding: "15px", margin: "10px" }}>
            <h2>Form Validation</h2>

            <form onSubmit={handleSubmit}>

                <div>
                    <input
                        type="text"
                        name="username"
                        value={form.username}
                        onChange={handleChange}
                        placeholder="Username"
                    />
                    {errors.username && <p style={{ color: "red" }}>{errors.username}</p>}
                </div>

                <div>
                    <input
                        type="email"
                        name="email"
                        value={form.email}
                        onChange={handleChange}
                        placeholder="Email"
                    />
                    {errors.email && <p style={{ color: "red" }}>{errors.email}</p>}
                </div>

                <div>
                    <input
                        type="password"
                        name="password"
                        value={form.password}
                        onChange={handleChange}
                        placeholder="Password"
                    />
                    {errors.password && <p style={{ color: "red" }}>{errors.password}</p>}
                </div>

                <button type="submit">Submit</button>
            </form>

            {success && (
                <p style={{ color: "green", marginTop: "10px" }}>
                    Form submitted successfully
                </p>
            )}
        </div>
    );
}