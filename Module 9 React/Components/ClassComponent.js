import React, { Component } from "react";

class StudentInfo extends Component {
    constructor(props) {
        super(props);
        this.state = {
            count: 0
        };
    }
    increaseCount = () => {
        this.setState({ count: this.state.count + 1 });
    };
    render() {
        const { name, branch } = this.props;

        return (
            <div style={{ border: "1px solid gray", padding: "10px", margin: "10px" }}>
                <h3>{name}</h3>
                <p>Branch: {branch}</p>
                <p>Clicks: {this.state.count}</p>
                <button onClick={this.increaseCount}>Increase</button>
            </div>
        );
    }}
export default function ClassComponentDemo() {
    return (
        <div>
            <h2>Class Component Demo</h2>
            <StudentInfo name="Tulasi" branch="CSE" />
            <StudentInfo name="Ananya" branch="IT" />
        </div>
    );
}