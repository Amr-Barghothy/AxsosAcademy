# Countdown
def countdown(num):
    lst = []

    for i in range(num, -1, -1):
        lst.append(i)
    return lst


print(countdown(5))


# Print and Return
def print_and_return(lst):
    print(lst[0])
    return lst[1]


print_and_return([1, 2])


# First Plus Length
def first_plus_length(lst):
    return lst[0] + len(lst)


print(first_plus_length([1, 2, 3, 4, 5]))


# Values Greater than Second
def values_greater_than_second(lst):
    if len(lst) <= 1:
        return False
    lst2 = []
    for num in lst:
        if num > lst[1]:
            lst2.append(num)

    if len(lst2) >= 2:
        return lst2
    else:
        return False


print(values_greater_than_second([3]))


# This Length, That Value
def this_length_that_value(size, value):
    return [value] * size


print(this_length_that_value(6, 2))
