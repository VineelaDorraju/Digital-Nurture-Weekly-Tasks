function delay(value, time) {
    return new Promise(resolve => {
        setTimeout(() => {
            resolve(value)
        }, time)
    })
}

async function processFlow() {
    const step1 = await delay(5, 300)
    const step2 = await delay(step1 * 2, 300)
    const step3 = step2 + 10
    console.log("steps:", step1, step2, step3)
    return step3
}

processFlow()