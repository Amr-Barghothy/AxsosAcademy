function likes(el) {
    let id = el.id;
    if (id === "nichole-btn") {
        let like = document.getElementById("nichole-like")
        like.innerText = Number(like.innerText) + 1
    } else if (id === "neil-btn") {
        let like = document.getElementById("neil-like")
        like.innerText = Number(like.innerText) + 1
    } else {
        let like = document.getElementById("jim-like")
        like.innerText = Number(like.innerText) + 1
    }
}