from bank_account import BankAccount

class User:
    def __init__(self, name):
        self.name = name
        self.accounts = []

    def add_account(self, int_rate, balance):
        account = BankAccount(int_rate, balance)
        self.accounts.append(account)
        return self

    def make_deposit(self, index, amount):
        self.accounts[index].deposit(amount)
        return self

    def make_withdrawal(self, index, amount):
        self.accounts[index].withdraw(amount)
        return self

    def display_user_balances(self):
        print(f"User: {self.name}")
        for i, acc in enumerate(self.accounts):
            print(f"  Account {i+1}: Balance = ${acc.balance}")
        return self

    def transfer_money(self, from_account_index, other_user, to_account_index, amount):
        self.accounts[from_account_index].withdraw(amount)
        other_user.accounts[to_account_index].deposit(amount)
        return self


user1 = User("Amr")
user1.add_account(1, 100)
user1.make_deposit(0, 100)
user1.add_account(2,400)
user1.make_deposit(1,500)
user2 = User("Khaled")
user2.add_account(1,700)
user1.transfer_money(0,user2,0,100)
user1.display_user_balances()
user2.display_user_balances()