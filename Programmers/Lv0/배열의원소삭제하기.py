def solution(arr, delete_list):
    for delNum in delete_list:
        if delNum in arr:
            arr.remove(delNum)
    return arr