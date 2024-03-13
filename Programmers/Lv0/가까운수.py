def solution(array, n):
    array.append(n)
    array.sort()
    if (max(array) == n):
        return array[len(array) - 2]
    elif (min(array) == n):
        return array[1]
    else:
        idx = array.index(n)
        if array[idx + 1] - array[idx] >= array[idx] - array[idx - 1]:
            return array[idx - 1]
        else:
            return array[idx + 1]