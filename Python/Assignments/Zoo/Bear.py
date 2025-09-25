from Python.Assignments.Zoo.Animal import Animal


class Bear(Animal):
    def __init__(self, name, age, health, happiness, fur_type):
        super().__init__(name, age, health, happiness)
        self.fur_type = fur_type

    def feed(self, type):
        if type == "Honey":
            print("what I like best")
        else:
            print("I don't feel very much like Pooh today")
        super().feed()
        return self

    def display_info(self):
        super().display_info()
        print(f"Fur type: {self.fur_type}")
