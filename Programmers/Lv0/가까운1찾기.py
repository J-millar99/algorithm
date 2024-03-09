def solution(arr, idx):
    answer = arr[idx:]
    if 1 in answer:
        return answer.index(1) + idx
    return -1