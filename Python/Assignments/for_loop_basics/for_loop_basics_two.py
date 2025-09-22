# Biggie Size
def biggie_size(lst):
    for item in lst:
        if item > 0:
            lst[lst.index(item)] = "big"
    return lst


print(biggie_size([-1, 3, 5, -5]))


# Count Positive
def count_positives(lst):
    count = 0
    for item in lst:
        if item > 0:
            count += 1
    lst[len(lst) - 1] = count
    return lst


print(count_positives([-1, 1, 1, 1]))


# Sum Total
def sum_total(lst):
    return sum(lst)


print(sum_total([1, 2, 3, 4]))


# Average
def average(lst):
    return sum(lst) / len(lst)


print(average([1, 2, 3, 4]))


# Length

def length(lst):
    return len(lst)


print(length([1, 2, 3, 4]))


# Minimum
def minimum(lst):
    return min(lst)


print(minimum([1, 2, 3, 4]))


# Maximum
def maximum(lst):
    return max(lst)


print(maximum([37, 2, 1, -9]))


# Ultimate Analysis
def ultimate_analysis(lst):
    return {"sumTotal": sum(lst), "average": sum(lst) / len(lst), "minimum": min(lst), "maximum": max(lst),
            "length": len(lst)}


print(ultimate_analysis([37, 2, 1, -9]))


# Reverse List
def reverse(lst):
    return lst[::-1]


print(reverse([37, 2, 1, -9]))
