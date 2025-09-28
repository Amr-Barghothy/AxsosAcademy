from Library import Library


class Book(Library):
    def __init__(self, borrowing, returning, checking_availability, price, title, author, pages):
        super().__init__(borrowing, returning, checking_availability, price, title) # Inheriting the attribute from the parent
        self.author = author
        self.pages = pages

    # using polymorphism specifically override for late fee calculation by calling the same name from the parent
    def late_fee_calculation(self):
        if self.returning is False:
            super().late_fee_calculation()
            self.price += round(self.price * 0.25)
        else:
            print("The Book isn't overdue")

    # A unique method for Book
    def switch_pages(self):
        if self.borrowing is True:
            print("Moving to the next page")
