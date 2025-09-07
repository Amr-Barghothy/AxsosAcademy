function weatherLoading() {
    alert("Loading weather report...")
}

function dismissCookie(el) {
    let parent = el.parentElement
    parent.remove()
}

function tempConvert(el) {
    let degrees = document.querySelectorAll(".degree")
    for (let i = 0; i < degrees.length; i++) {
        if (el.value === "fehrenhite") {
            degrees[i].innerText = Math.round((Number(degrees[i].innerText) * (9 / 5)) + 32)
        } else {
            degrees[i].innerText = Math.round((Number(degrees[i].innerText) - (32)) * 5 / 9)
        }
    }
}