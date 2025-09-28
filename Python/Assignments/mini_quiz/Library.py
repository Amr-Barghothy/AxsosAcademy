class Library:
    # defining the common attribute
    def __init__(self, borrowing, returning, checking_availability,price,title):
        self.borrowing = borrowing
        self.returning = returning
        self.checking_availability = checking_availability
        self.price = price
        self.title = title

    # define common methods
    def borrow(self):
        if self.checking_availability:
            self.borrowing = True
            self.checking_availability = False
            self.returning = False
        else:
            print("The item is not available")

    def return_it(self):
        if self.checking_availability is False:
            self.borrowing = False
            self.returning = True
            self.checking_availability = True
        else:
            print("You don't have enough This Item")

    def check_availability(self):
        if self.checking_availability is False:
            print("The item is not available")
            return False
        else:
            print("The item is available")
            return True

    # Declaring this method simply to use it later in the children to make use of it
    def late_fee_calculation(self):
        print("An additional late fee was added")

    def overdue(self):
        if self.returning is False:
            print("The Borrowed item is overdue please return it")
        else:
            print("You still have time")
