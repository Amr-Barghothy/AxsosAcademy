
function getAllTimeSinceStartOfDay() {
    let now = new Date();
    let seconds = now.getSeconds();
    let minutes = now.getMinutes();
    let hours = now.getHours();

    let secDeg = seconds * 6
    let minDeg = (minutes * 6) + (seconds / 10);
    let hourDeg = (hours % 12) * 30 + (minutes / 2);

    document.querySelector("#seconds").style.transform = `rotate(${secDeg - 180}deg)`;
    document.querySelector("#minutes").style.transform = `rotate(${minDeg - 180}deg)`;
    document.querySelector("#hour").style.transform = `rotate(${hourDeg - 180}deg)`;

}

setInterval(function () {
    getAllTimeSinceStartOfDay()
}, 1000)

getAllTimeSinceStartOfDay()