const Card = require("./Card.js");
class Units extends Card {
    constructor(name,cost,power,res) {
        super(name,cost)
        this.res = res
        this.power = power
    }
    attack(target) {
        target.res -= this.power
    }
}
module.exports = Units