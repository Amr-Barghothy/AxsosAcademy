import unittest


def is_palindrome(word):
    reversed_word = ""
    for i in range(len(word) - 1, -1, -1):
        reversed_word += word[i]
    return reversed_word == word


print(is_palindrome("aba"))


def reverse_list(lst):
    return lst[::-1]


def factorial(n):
    if n == 1:
        return 1
    fac = n * factorial(n - 1)
    return fac


def coins(num):
    if num == 0:
        return 0
    quarters = num // 25
    num -= quarters * 25
    dimes = num // 10
    num -= dimes * 10
    nickles = num // 5
    num -= nickles * 5
    pennies = num
    return [quarters, dimes, nickles, pennies]


def fibonacci(n):
    if n == 0:
        return 0
    if n == 1:
        return 1
    return fibonacci(n - 1) + fibonacci(n - 2)





print(coins(92))
print(factorial(10))


class Test(unittest.TestCase):
    def test_reverse_list(self):
        self.assertEqual(reverse_list([]), [])
        self.assertEqual(reverse_list([3, 2, 3]), [3, 2, 3])
        self.assertEqual(reverse_list([4, 8, 7, 9]), [9, 7, 8, 4])

    def test_palindrome(self):
        self.assertEqual(is_palindrome("aba"), True)
        self.assertEqual(is_palindrome("Word"), False)
        self.assertFalse(is_palindrome("Nizar"))
        self.assertTrue(is_palindrome("racecar"))
        self.assertEqual(is_palindrome("Suri"), False)

    def test_coins(self):
        self.assertEqual(coins(92), [3,1,1,2])
        self.assertEqual(coins(10), [0,1,0,0])
        self.assertEqual(coins(5), [0,0,1,0])
        self.assertEqual(coins(4), [0,0,0,4])
        self.assertEqual(coins(3), [0,0,0,3])

    def test_factorial(self):
        self.assertEqual(factorial(3), 6)
        self.assertEqual(factorial(5), 120)
        self.assertEqual(factorial(7), 240)


    def test_fibonacci(self):
        self.assertEqual(fibonacci(1), 1)
        self.assertEqual(fibonacci(4), 3)
        self.assertEqual(fibonacci(5), 5)


if __name__ == '__main__':
    unittest.main()
