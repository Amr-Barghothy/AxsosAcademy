class Effects extends Card {
    constructor(name,cost,text,stat,mag) {
        super(name,cost);
        this.text=text;
        this.stat=stat;
        this.mag=mag;
    }

    play(target) {
        if (target instanceof Units) {
            if (this.stat === "resilience") {
                if (this.text === "Raise") {
                    target.res += this.mag;
                } else {
                    target.res -= this.mag;
                }
            } else {
                if (this.text === "Raise") {
                    target.power += this.mag;
                } else {
                    target.power -= this.mag;
                }
            }
        } else {

            throw new Error("Target must be a unit!")
        }
    }
}