import React, { useState } from "react";
import StudentList from "../components/StudentList";
import AddStudentForm from "../components/AddStudentForm";
import StatusMessage from "../components/StatusMessage";

function Home() {
    const [students, setStudents] = useState([]);
    const [msg, setMsg] = useState("");

    const addStudent = (name) => {
        setStudents([...students, { id: Date.now(), name }]);
        setMsg("Student Added!");
    };

    return (
        <div>
            <h2>Student Dashboard</h2>

            <AddStudentForm addStudent={addStudent} />
            <StatusMessage msg={msg} />
            <StudentList students={students} />
        </div>
    );
}

export default Home;