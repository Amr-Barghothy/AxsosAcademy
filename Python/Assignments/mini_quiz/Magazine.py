from Library import Library


class Magazine(Library):
    def __init__(self, borrowing, returning, checking_availability, price, title,cover):
        super().__init__(borrowing, returning, checking_availability,price,title)
        self.cover = cover

    def late_fee_calculation(self):
        if self.returning is False:
            super().late_fee_calculation()
            self.price += round(self.price * 0.05)
        else:
            print("The Magazine isn't overdue")

    def change_cover(self):
        if self.cover is "":
            self.cover = "New Cover"