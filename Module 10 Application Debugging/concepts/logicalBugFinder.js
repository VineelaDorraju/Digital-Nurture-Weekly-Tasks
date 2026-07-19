function findMax(arr) {
    let max = arr[0]
    for (let i = 0; i < arr.length; i++) {
        let current = arr[i]
        if (current < max) {
            max = current
        }
    }
    return max
}

function test() {
    let sample = [3, 9, 2, 15, 6]
    let result = findMax(sample)
    console.log("result:", result)
}

test()