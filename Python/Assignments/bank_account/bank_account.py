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



acc1 = BankAccount(10, 100).deposit(100).deposit(300).deposit(50).withdraw(150).yield_interest().display_account_info()
acc2 = BankAccount(4.5, 400).deposit(100).deposit(130).withdraw(160).withdraw(122).withdraw(40).withdraw(20).yield_interest().display_account_info()

