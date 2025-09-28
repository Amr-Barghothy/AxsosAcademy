from Library import Library


class Magazine(Library):
    def __init__(self, borrowing, returning, checking_availability, price, title,cover):
        super().__init__(borrowing, returning, checking_availability,price,title) # Inheriting the attribute from the parent
        self.cover = cover

    # using polymorphism specifically override for late fee calculation by calling the same name from the parent
    def late_fee_calculation(self):
        if self.returning is False:
            super().late_fee_calculation()
            self.price += round(self.price * 0.05)
        else:
            print("The Magazine isn't overdue")

    def change_cover(self):
        if self.cover is "":
            self.cover = "New Cover"