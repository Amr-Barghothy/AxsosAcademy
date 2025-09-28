from Library import Library


class Book(Library):
    def __init__(self, borrowing, returning, checking_availability, price, title, author, pages):
        super().__init__(borrowing, returning, checking_availability, price, title)
        self.author = author
        self.pages = pages

    def late_fee_calculation(self):
        if self.returning is False:
            super().late_fee_calculation()
            self.price += round(self.price * 0.25)
        else:
            print("The Book isn't overdue")

    def switch_pages(self):
        if self.borrowing is True:
            print("Moving to the next page")
