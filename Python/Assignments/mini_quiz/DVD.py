from Library import Library


class DVD(Library):
    def __init__(self, borrowing, returning, checking_availability, price, title, video_type):
        super().__init__(borrowing, returning, checking_availability, price, title) # Inheriting the attribute from the parent
        self.video_type = video_type

    # using polymorphism specifically override for late fee calculation by calling the same name from the parent
    def late_fee_calculation(self):
        if self.returning is False:
            super().late_fee_calculation()
            self.price += round(self.price * 0.17)
        else:
            print("The DVD isn't overdue")

    def play(self):
        if self.borrowing is True:
            print("The Video is playing")
