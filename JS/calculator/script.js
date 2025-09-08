let stack = []

function press(num) {
    let display = document.querySelector("#display")
    console.log(display.value);

    if (display.innerText == "0" || display.value == "0") {
        display.innerText = num
        display.value = 1

    } else {
        display.innerText += num
    }
}

function setOP(op) {
    let display = document.querySelector("#display")
    if (Number(display.innerText) > 0) {
        stack.push(Number(display.innerText))
        if (op === "+") {
            stack.push("+")
            display.value = 0
        }
        else if (op === "-") {
            stack.push("-")
            display.value = 0
        }
        else if (op === "*") {
            stack.push("*")
            display.value = 0
        }
        else if (op === "/") {
            stack.push("/")
            display.value = 0
        }
    }
    console.log(stack);
}

function calculate() {
    let display = document.querySelector("#display")
    stack.push(Number(display.innerText))
    let num2 = stack.pop()
    let op = stack.pop()
    let num1 = stack.pop()
    if (num2 > 0 && op === "+" && num1 > 0) {
        display.innerText = num1 + num2
        display.value = 0
    } else if (num2 > 0 && op === "-" && num1 > 0) {
        display.innerText = num1 - num2
        display.value = 0
    } else if (num2 >= 0 && op === "*" && num1 > 0) {
        display.innerText = num1 * num2
        display.value = 0
    } else if (num2 >= 0 && op === "/" && num1 > 0) {
        display.innerText = (num1 / num2).toFixed(3)
        display.value = 0

    }
}

function clr() {
    stack = []
    let display = document.querySelector("#display")
    display.innerText = 0
}