from Animal import Animal


class Monkey(Animal):
    def __init__(self, name, age, health, happiness, intelligence):
        super().__init__(name, age, health, happiness)
        self.intelligence = intelligence

    def feed(self, fruit):
        if fruit == "Banana":
            print("Jumping!")
        else:
            print("Make A Chaos")
        super().feed()
        return self

    def display_info(self):
        super().display_info()
        print(f"Intelligence: {self.intelligence}")
