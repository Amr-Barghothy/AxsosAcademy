def selection_sort(lst):
    for i in range(len(lst)):
        min_index = i
        min_value = lst[i]
        for j in range(i + 1, len(lst)):
            if min_value > lst[j]:
                min_value = lst[j]
                min_index = j

        lst[i], lst[min_index] = lst[min_index], lst[i]
    return lst


print(selection_sort([8, 5, 1, 6, 3, 2, 4, 7, 9]))
