array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort_origin(array, start, end):
    if start >= end:
        return
    pivot = start
    left = start + 1
    right = end
    while left <= right:
        while left <= end and array[left] <= array[pivot]:
            left += 1
        while right >= start and array[right] >= array[pivot]:
            right -= 1
        if left > right:
            array[right], array[pivot] = array[pivot], array[right]
        else:
            array[left], array[pivot] = array[pivot], array[left]
    quick_sort_origin(array, start, right - 1)
    quick_sort_origin(array, right + 1, end)

def quick_sort_python(array):
    if len(array) <= 1:
        return array
    pivot = array[0]
    tail = array[1:]
    left_side = [x for x in tail if x <= pivot]
    right_side = [y for y in tail if y > pivot]
    return quick_sort_python(left_side) + [pivot] + quick_sort_python(right_side)


quick_sort_origin(array, 0, len(array) - 1)
print(array)
print(quick_sort_python(array))