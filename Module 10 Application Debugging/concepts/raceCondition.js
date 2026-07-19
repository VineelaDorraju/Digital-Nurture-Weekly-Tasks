let balance = 100

function delay() {
    return new Promise(resolve => setTimeout(resolve, 100))
}

async function withdraw(amount) {
    let temp = balance
    await delay()
    balance = temp - amount
    console.log("withdraw", amount, "balance", balance)
}

async function run() {
    withdraw(50)
    withdraw(30)
}

run()