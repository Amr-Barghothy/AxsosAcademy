class User:
    def __init__(self, name):
        self.name = name
        self.balance = 0

    def make_withdrawal(self, amount):
        self.balance -= amount
        return self

    def make_deposit(self, amount):
        self.balance += amount
        return self

    def display_user_balance(self):
        print(f"User: {self.name}, Balance: ${self.balance}")
        return self

    def transfer_money(self, other_user, amount):
        self.balance -= amount
        other_user.make_deposit(amount)
        return self


user_two = User("Khaled").make_deposit(220).make_deposit(788).make_withdrawal(100).make_withdrawal(288).display_user_balance()
user_three = User("Christine").make_deposit(1000).make_withdrawal(500).make_withdrawal(100).make_withdrawal(150).display_user_balance()
user_one = User("Amr").make_deposit(500).make_deposit(100).make_deposit(200).make_withdrawal(300).display_user_balance().transfer_money(user_three, 50).display_user_balance()