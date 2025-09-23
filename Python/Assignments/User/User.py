class User:
    def __init__(self, name):
        self.name = name
        self.balance = 0

    def make_withdrawal(self, amount):
        self.balance -= amount

    def make_deposit(self, amount):
        self.balance += amount

    def display_user_balance(self):
        print(f"User: {self.name}, Balance: ${self.balance}")

    def transfer_money(self, other_user, amount):
        self.balance -= amount
        other_user.make_deposit(amount)


user_one = User("Amr")
user_two = User("Khaled")
user_three = User("Christine")

user_one.make_deposit(500)
user_one.make_deposit(100)
user_one.make_deposit(200)
user_one.make_withdrawal(300)
user_one.display_user_balance()

user_two.make_deposit(220)
user_two.make_deposit(788)
user_two.make_withdrawal(100)
user_two.make_withdrawal(288)
user_two.display_user_balance()

user_three.make_deposit(1000)
user_three.make_withdrawal(500)
user_three.make_withdrawal(100)
user_three.make_withdrawal(150)
user_three.display_user_balance()

user_one.transfer_money(user_three, 50)
user_one.display_user_balance()
user_three.display_user_balance()