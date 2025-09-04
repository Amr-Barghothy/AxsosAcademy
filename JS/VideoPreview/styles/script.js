console.log("page loaded...");

function playVideo(el) {
    el.play()
    el.muted = true;
}

function stopVideo(el) {
    el.pause()
}