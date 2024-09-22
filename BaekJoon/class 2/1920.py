import sys

def binary_search(arr, target):
    left, right = 0, len(arr) - 1
    
    while left <= right:
        mid = (left + right) // 2
        
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
            
    return -1  # 요소가 존재하지 않으면 -1 반환

input = sys.stdin.readline

n1 = input()
d1 = list(input().rstrip().split())
d1.sort()
n2 = input()
d2 = list(input().rstrip().split())


for find in d2:
    if binary_search(d1, find) != -1:
        print(1)
    else:
        print(0)