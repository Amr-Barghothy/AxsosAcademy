class Underscore:
    def map(self, iterable, callback):
        for i in range(len(iterable)):
            iterable[i] = callback(iterable[i])
        return iterable

    def find(self, iterable, callback):
        for i in range(len(iterable)):
            if callback(iterable[i]):
                return iterable[i]
        return None

    def filter(self, iterable, callback):
        i = 0
        while i != len(iterable):
            if callback(iterable[i]) is False:
                iterable.pop(i)
            else:
                i += 1
        return iterable

    def reject(self, iterable, callback):
        i = 0
        while i != len(iterable):
            if callback(iterable[i]) is True:
                iterable.pop(i)
            else:
                i += 1
        return iterable


_ = Underscore()
print(_.map([1, 2, 3], lambda x: x * 2))
print(_.find([1, 2, 3, 4, 5, 6], lambda x: x > 4))
print(_.filter([1, 2, 3, 4, 5, 6], lambda x: x % 2 == 0))
print(_.reject([1, 2, 3, 4, 5, 6], lambda x: x % 2 == 0))
