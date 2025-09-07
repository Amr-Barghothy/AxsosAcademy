function pizzaOver(crustStyle,pizzaStyle,cheeses,toppings) {
    let pizza = {
        "crustStyle" : crustStyle,
        "pizzaStyle" : pizzaStyle,
        "cheeses" : cheeses ,
        "toppings" : toppings,
    }
    return pizza
}

let pizza1 = pizzaOver("deep dish","traditional",["mozzarella"],["pepperoni","sausage"])

let pizza2 = pizzaOver("hand tossed", "marinara" , ["mozzarella","feta"], ["pepperoni","sausage"])

let pizza3 = pizzaOver("stuffed", "chicago" , ["mozzarella","parmesan"], ["pepperoni","sausage"])

let pizza4 = pizzaOver("crispy", "neapolitan" , ["mozzarella"], ["oregano","sauce"])

let crustStyle = ["deep dish", "hand tossed", "stuffed", "crispy", "standard"]
let pizzaStyle = ["traditional","marinara", "chicago","neapolitan","mexican"]
let cheeses = [["mozzarella","parmesan","feta"],["cheeder","mozzarella"]]
let toppings = [["pepperoni","sausage"],["oregano","sauce"],["chicken","jalapeno","salami"]]

let randomPizza = pizzaOver(crustStyle[Math.trunc(Math.random()*5)],pizzaStyle[[Math.trunc(Math.random()*5)]],cheeses[Math.trunc(Math.random()*2)],toppings[Math.trunc(Math.random()*4)])

console.log(randomPizza);
