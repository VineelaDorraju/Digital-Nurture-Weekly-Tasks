async function loadUsers() {
    try {
        const response = await fetch("https://jsonplaceholder.typicode.com/invalid-endpoint")
        if (!response.ok) {
            throw new Error("status code " + response.status)
        }
        const data = await response.json()
        console.log("data loaded", data)
    } catch (err) {
        console.error("error occurred:", err.message)
    }
}

async function run() {
    await loadUsers()
}

run()