# VS Code Debugging Guide

## Overview

Debugging in Visual Studio Code allows developers to inspect code execution, track variables, and identify issues efficiently. It supports multiple environments including browser-based apps and Node.js applications.

---

## Getting Started

1. Open your project in VS Code
2. Navigate to the **Run and Debug** panel
3. Click **Create a launch.json file**
4. Choose the appropriate environment (Chrome / Node)

---

## Launch Configuration

A typical configuration file:

```json
{
  "version": "0.2.0",
  "configurations": [
    {
      "type": "chrome",
      "request": "launch",
      "name": "Launch App",
      "url": "http://localhost:3000",
      "webRoot": "${workspaceFolder}"
    }
  ]
}
```

---

## Breakpoints

Breakpoints allow execution to pause at specific lines.

* Click beside the line number to set a breakpoint
* Conditional breakpoints can be added with expressions
* Logpoints help print values without stopping execution

---

## Debug Controls

* **Continue (F5)** → Resume execution
* **Step Over (F10)** → Move to next line
* **Step Into (F11)** → Enter function
* **Step Out (Shift + F11)** → Exit function

---

## Variables & Watch

* Inspect variables in the **Variables panel**
* Add expressions in the **Watch panel**
* Hover over variables in code for quick preview

---

## Call Stack

Displays the sequence of function calls leading to the current point.
Useful for tracing how execution reached a specific line.

---

## Debug Console

* Execute expressions during debugging
* View logs and errors
* Test quick fixes without restarting

---

## Node.js Debugging

Example configuration:

```json
{
  "type": "node",
  "request": "launch",
  "name": "Run Server",
  "program": "${workspaceFolder}/dist/index.js"
}
```

---

## Tips

* Use `debugger` keyword in code to force pause
* Keep breakpoints minimal for clarity
* Combine logs with breakpoints for better insight
* Restart debugger after major code changes

---

## Conclusion

VS Code debugging provides a powerful and flexible way to analyze application behavior. With breakpoints, variable tracking, and execution control, developers can quickly identify and fix issues in both frontend and backend applications.
