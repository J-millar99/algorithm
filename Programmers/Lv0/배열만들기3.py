def solution(arr, intervals):
    answer = []
    for i in range(intervals[0][0], intervals[0][1] + 1):
        answer.append(arr[i])
    for j in range(intervals[1][0], intervals[1][1] + 1):
        answer.append(arr[j])
    return answer