const Units = require("./Units.js");
const Effects = require("./Effects.js");

let redBelt = new Units("Red Belt Ninja",3,3,4)
let blackBelt = new Units("Black Belt Ninja",4,5,4)
let hardAlgo = new Effects("Hard Algorithm",2,"increase target's resilience by 3","resilience",3)
let unhandled = new Effects("Unhandled Promise Rejection",1,"reduce target's resilience by 2","resilience",2)
let pairProgramming = new Effects("Pair Programming",3,"increase target's resilience by 2","resilience",2)

redBelt.attack(blackBelt)
console.log(blackBelt.res)
hardAlgo.play(blackBelt)
console.log(blackBelt.res)
