def solution(arr, queries):
    for querie in queries:
        arr[querie[0]], arr[querie[1]] = arr[querie[1]], arr[querie[0]]
    return arr