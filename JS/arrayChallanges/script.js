
//always hungry
function alwaysHungry(arr) {
    let flag = false
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] === "food") {
            console.log("yummy");
            flag = true
        }
    }
    if (!flag) {
        console.log("I'm hungry");

    }
}


alwaysHungry([4, 1, 5, 7, 2])

//High Pass Filter
function highPass(arr, cutOff) {
    let newArr = []
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] > cutOff) {
            newArr.push(arr[i])
        }
    }
    return newArr
}

console.log(highPass([6, 8, 3, 10, -2, 5, 9], 5));

//Better than average

function betterThanAverage(arr) {
    let sum = 0
    for (let i = 0; i < arr.length; i++) {
        sum += arr[i]
    }
    let avg = sum / arr.length
    let count = 0
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] > avg) {
            count++
        }
    }

    return count;
}

console.log(betterThanAverage([6, 8, 3, 10, -2, 5, 9]));


//Array Reverse

function reverse(arr) {
    return arr.reverse()

    //or we can use this
    /*
    let reversed = []
    for(let i = arr.length -1; i>=0; i--) {
        reversed.push(arr[i])
    }
    return reversed
    */
}

console.log(reverse(["a", "b", "c", "d", "e"]));


//Fibonacci Array

function fibonacciArray(n) {
    let fibArray = []
    fibArray[0] = 0
    fibArray[1] = 1
    for (let i = 2; i < n; i++) {
        fibArray[i] = fibArray[i- 1] + fibArray[i - 2]
    }
    return fibArray
}

console.log(fibonacciArray(10));
