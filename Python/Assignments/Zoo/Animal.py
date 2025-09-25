class Animal:
    def __init__(self, name, age, health, happiness):
        self.name = name
        self.age = age
        self.health = health
        self.happiness = happiness

    def feed(self):
        self.health += 10
        self.happiness += 10
        if self.happiness > 26:
            print("I.m Happy")
        else:
            print("I.m sad")
        if self.health > 30:
            print("Everything is good")
        else:
            print("Not Feeling Well")

    def display_info(self):
        print(f"Name: {self.name}, Age: {self.age}, Health: {self.health}, Happiness: {self.happiness}" , end=" ")
