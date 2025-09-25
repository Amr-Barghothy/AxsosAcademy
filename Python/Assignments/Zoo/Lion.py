from Animal import Animal


class Lion(Animal):
    def __init__(self, name, age, health, happiness, mane):
        super().__init__(name, age, health, happiness)
        self.mane = mane

    def feed(self, amount):
        if amount > 20:
            print("ROAR I'm Full")
        else:
            print("Still Hungry")
        super().feed()
        return self

    def display_info(self):
        super().display_info()
        print(f"Mane: {self.mane}")
