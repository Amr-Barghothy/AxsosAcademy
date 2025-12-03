const Ninja = require("./Ninja.js");
class Sensei extends Ninja {
    constructor(name) {
        super(name,200,10,10);
        this.wisdom = 10;
    }

    speakWisdom() {
        console.log("What one programmer can do in one month, two programmers can do in two months.")
    }


}

const superSensei = new Sensei("Master Splinter");
superSensei.speakWisdom();
superSensei.showStats();
