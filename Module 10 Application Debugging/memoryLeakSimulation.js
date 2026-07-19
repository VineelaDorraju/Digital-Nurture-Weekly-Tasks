let storage = []

function createLargeObject() {
    let data = new Array(500000).fill("debug")
    return data
}

function simulateLeak() {
    setInterval(() => {
        let obj = createLargeObject()
        storage.push(obj)
        console.log("current size", storage.length)
    }, 200)
}

simulateLeak()