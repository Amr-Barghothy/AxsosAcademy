class BankAccount:
    def __init__(self, int_rate, balance):
        self.int_rate = int_rate
        self.balance = balance

    def deposit(self, amount):
        self.balance += amount
        return self

    def withdraw(self, amount):
        temp = self.balance - amount
        if temp < 0:
            return "Not enough money"
        self.balance -= temp
        return self

    def display_account_info(self):
        print(f"Balance: {self.balance}")
        return self

    def yield_interest(self):
        self.balance += self.balance * self.int_rate
        return self
