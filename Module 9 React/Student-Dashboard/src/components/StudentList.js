import React from "react";
import StudentCard from "./StudentCard";

function StudentList({ students }) {
    return (
        <div>
            {students.map((s) => (
                <StudentCard key={s.id} student={s} />
            ))}
        </div>
    );
}

export default StudentList;