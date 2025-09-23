import random


def rand_int(min_num=0, max_num=100):
    if max_num < 0 or (min_num == 0 and max_num == 0):
        return 0
    if min_num > max_num:
        return random.random() * (min_num - max_num) + max_num
    num = random.random() * (max_num - min_num) + min_num
    return num


print(rand_int())  # should print a random integer between 0 to 100
print(rand_int(max_num=50))  # should print a random integer between 0 to 50
print(rand_int(min_num=50))  # should print a random integer between 50 to 100
print(rand_int(min_num=50, max_num=500))  # should print a random integer between 50 and 500
