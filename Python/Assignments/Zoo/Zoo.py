from Lion import Lion
from Monkey import Monkey
from Bear import Bear
from Python.Assignments.Zoo.Animal import Animal


class Zoo:
    def __init__(self, zoo_name):
        self.animals = []
        self.name = zoo_name

    def add_animal(self, name, age, health, happiness, unique, animal_type):
        if animal_type == "lion":
            self.animals.append(Lion(name, age, health, happiness, unique))
        elif animal_type == "monkey":
            self.animals.append(Monkey(name, age, health, happiness, unique))
        else:
            self.animals.append(Bear(name, age, health, happiness, unique))

    def print_all_info(self):
        print("-" * 30, self.name, "-" * 30)
        for animal in self.animals:
            animal.display_info()
