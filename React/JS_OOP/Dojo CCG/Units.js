class Units extends Card {
    constructor(name,cost,res,power) {
        super(name,cost)
        this.res = res
        this.power = power
    }
    attack(target) {
        target.res -= this.power
    }
}