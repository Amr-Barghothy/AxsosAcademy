function alertLike() {
    alert("ninja was liked")
}

function removeButton(el) {
    el.remove()
}

function changeLogin(el) {
    if (el.innerText == "Login") {
        el.innerText = "Logout"
    }
    else {
        el.innerText = "Login"
    }
}