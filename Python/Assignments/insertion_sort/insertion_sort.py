def insertion_sort(lst):
    for i in range(1,len(lst)):
        value = lst.pop(i)
        last_sorted_index = i
        for j in range(last_sorted_index -1, -1, -1):
            if value < lst[j]:
                last_sorted_index = j

        lst.insert(last_sorted_index, value)

    return lst

print(insertion_sort([8, 5, 1, 6, 3, 2, 4, 7, 9]))
