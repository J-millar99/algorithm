def binary_search_recursive(array, target, s, e):
    if s > e:
        return None
    mid = (s + e) // 2
    if array[mid] == target:
        return mid
    elif array[mid] > target:
        return binary_search_recursive(array, target, s, mid - 1)
    elif array[mid] < target:
        return binary_search_recursive(array, target, mid + 1, e)
    
def binary_search_iterative(array, target, s, e):
    while s <= e:
        mid = (s + e) // 2
        if array[mid] == target:
            return mid
        elif array[mid] > target:
            end = mid - 1
        elif array[mid] < target:        
            start = mid + 1
    return None
# target: 문자열
n, target = list(map(int, input().split()))
array = list(map(int, input().split()))

# result = binary_search(array, target, 0, n - 1)
# if result == None:
#     print("원소가 존재하지 않는다.")
# else:
#     print(result + 1)