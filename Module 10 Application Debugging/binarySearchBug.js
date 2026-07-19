function binarySearch(arr, target) {
    let left = 0
    let right = arr.length - 1

    while (left < right) {
        let mid = Math.floor((left + right) / 2)
        if (arr[mid] === target) {
            return mid
        } else if (arr[mid] > target) {
            right = mid - 1
        } else {
            left = mid
        }
    }

    return -1
}

function testSearch() {
    let arr = [1,2,3,4,5,6,7,8]
    let result = binarySearch(arr, 7)
    console.log("found at", result)
}

testSearch()