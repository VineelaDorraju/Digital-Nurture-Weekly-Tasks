import React from "react";
function Card({ title, value, color }) {
    return (
        <div
            style={{
                border: "1px solid #ccc",
                padding: "15px",
                margin: "10px",
                width: "180px",
                backgroundColor: color,
                borderRadius: "8px"
            }}
        >
            <h4>{title}</h4>
            <p style={{ fontSize: "20px", fontWeight: "bold" }}>{value}</p>
        </div>
    );
}
export default function ComponentReuse() {

    const dashboardData = [
        { id: 1, title: "Students", value: 120, color: "#f9f9f9" },
        { id: 2, title: "Courses", value: 8, color: "#eef7ff" },
        { id: 3, title: "Assignments", value: 15, color: "#fff5ee" }
    ];

    return (
        <div>
            <h2>Dashboard</h2>

            <div style={{ display: "flex" }}>
                {dashboardData.map((item) => (
                    <Card
                        key={item.id}
                        title={item.title}
                        value={item.value}
                        color={item.color}
                    />
                ))}
            </div>
        </div>
    );
}