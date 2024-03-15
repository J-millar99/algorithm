def solution(arr, queries):
    for querie in queries:    
        for i in range(querie[0], querie[1] + 1):
            if i % querie[2] == 0:
                arr[i] += 1
    return arr