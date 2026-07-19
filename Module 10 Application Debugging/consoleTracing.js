function calculateTotal(items) {
    let total = 0
    for (let i = 0; i <= items.length; i++) {
        console.trace("index:", i)
        let value = items[i]
        if (value === undefined) {
            console.log("undefined encountered at", i)
        } else {
            total += value
        }
    }
    console.log("final total", total)
    return total
}

function simulate() {
    const data = [10, 20, 30, 40]
    calculateTotal(data)
}

simulate()