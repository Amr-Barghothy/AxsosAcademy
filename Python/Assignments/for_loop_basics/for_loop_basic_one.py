# Basic
for i in range(0, 150, 1):
    print(i)

# Multiples of Five
for i in range(5, 1001, 5):
    print(i)

# Counting, the Dojo Way
for i in range(1, 101, 1):
    if i % 5 == 0:
        print("Coding")
    elif i % 10 == 0:
        print("Coding Dojo")
    else:
        print(i)

# Whoa. That Sucker's Huge
oddSum = 0
for i in range(0, 500001, 1):
    if i % 2 != 0:
        oddSum += i

print(oddSum)

# Countdown by Fours
for i in range(2018, -50, -4):
    if i > 0:
        print(i)

# Flexible Counter
lowNum = 0
highNum = 10
mul = 3
for i in range(lowNum, highNum, 1):
    if i % mul == 0:
        print(i)
